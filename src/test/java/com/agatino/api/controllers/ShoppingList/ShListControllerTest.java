package com.agatino.api.controllers.ShoppingList;

import com.agatino.shoppinglist.controllers.ShoppingList.ShListController;
import com.agatino.shoppinglist.controllers.ShoppingList.ShListSummaryView;
import com.agatino.shoppinglist.infrastructure.repositories.ShListRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShListController.class)
class ShListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ShListRepository repository;

    @Test
    void shouldReturnEmptyArrayWhenRepositoryIsEmpty() throws Exception {
        ShListSummaryView[] expectedSummaries = new ShListSummaryView[0];

        when(repository.getAllSummaries()).thenReturn(expectedSummaries);

        mockMvc.perform(get("/api/shlist"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void shouldReturnExpectedSummariesWhenRepositoryIsNotEmpty() throws Exception {
        ShListSummaryView[] expectedSummaries = FakeDataGenerator.getSomeSummaries(); // Given: We have some expected data

        when(repository.getAllSummaries()).thenReturn(expectedSummaries); // When: The repository is called, it returns our data

        String expectedJson = objectMapper.writeValueAsString(expectedSummaries);

        mockMvc.perform(get("/api/shlist"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    private static class FakeDataGenerator {
        static ShListSummaryView[] getSomeSummaries() {
            return new ShListSummaryView[]{
                    new ShListSummaryView(UUID.fromString("7b2b73c2-d4b9-4452-9706-96b618cfbe54"),
                            "Groceries", 5),
                    new ShListSummaryView(UUID.fromString("8f3c75d4-e5c8-5563-0817-07c729d0cf65"),
                            "Hardware", 2)
            };
        }
    }
}
