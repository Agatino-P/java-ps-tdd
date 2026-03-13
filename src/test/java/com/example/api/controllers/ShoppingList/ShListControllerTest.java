package com.example.api.controllers.ShoppingList;

import com.example.api.repositories.ShListRepository;
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
        when(repository.getAllSummaries()).thenReturn(new ShListSummary[0]);

        mockMvc.perform(get("/api/shlist"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void shouldReturnExpectedSummariesWhenRepositoryIsNotEmpty() throws Exception {
        ShListSummary[] expectedSummaries = FakeDataGenerator.getSomeSummaries(); // Given: We have some expected data
        when(repository.getAllSummaries()).thenReturn(expectedSummaries); // When: The repository is called, it returns our data

        String expectedJson = objectMapper.writeValueAsString(expectedSummaries);

        mockMvc.perform(get("/api/shlist")) // Then: The controller should return that data as JSON
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    private static class FakeDataGenerator {
        static ShListSummary[] getSomeSummaries() {
            return new ShListSummary[]{
                    new ShListSummary(UUID.fromString("7b2b73c2-d4b9-4452-9706-96b618cfbe54"),
                            "Groceries", 5),
                    new ShListSummary(UUID.fromString("8f3c75d4-e5c8-5563-0817-07c729d0cf65"),
                            "Hardware", 2)
            };
        }
    }
}
