package com.agatino.shoppinglist.infrastructure.repository;

import com.agatino.shoppinglist.controller.ShoppingList.ShListSummaryView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@Import(MongoShListRepository.class)
public class MongoShListRepositoryTest {

    @Autowired
    private MongoShListRepository sut;

    @Autowired
    private MongoShListDocumentRepository documentRepository;

    @AfterEach
    void cleanUp() {
        documentRepository.deleteAll();
    }

    @Test
    void shouldReturnEmptySummariesWhenNoListsExist() {
        List<ShListSummaryView> summaries = sut.getAllSummaries();
        assertThat(summaries).isEmpty();
    }

    @Test
    void shouldReturnSummariesWhenListsExist() {
        ShListDocument firstShListDocument = TestData.BuildShListDocument("First", 2);
        ShListDocument secondShListDocument = TestData.BuildShListDocument("Second", 3);
        documentRepository.saveAll(List.of(firstShListDocument, secondShListDocument));

        var actual = sut.getAllSummaries();
        assertThat(actual).hasSize(2)
                .anySatisfy(summary -> {
                    assertThat(summary.uuid()).isEqualTo(firstShListDocument.id());
                    assertThat(summary.name()).isEqualTo(firstShListDocument.name());
                    assertThat(summary.itemsCount()).isEqualTo(2);
                })
                .anySatisfy(summary -> {
                    assertThat(summary.uuid()).isEqualTo(secondShListDocument.id());
                    assertThat(summary.name()).isEqualTo(secondShListDocument.name());
                    assertThat(summary.itemsCount()).isEqualTo(3);
                });
    }

    private static class TestData {
        static ShListDocument BuildShListDocument(String shListName, int numItems) {
            List<ShItemDocument> items = new ArrayList<>();

            for (int i = 0; i < numItems; i++) {
                ShItemDocument shItemDocument = new ShItemDocument(UUID.randomUUID(), "List.%s-Item.%d".formatted(shListName, i));
                items.add(shItemDocument);
            }
            ShListDocument shList = new ShListDocument(UUID.randomUUID(), shListName, items);

            return shList;
        }
    }
}