package com.sirkaue.calculatorservice.integration.infra.adapters.in.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sirkaue.calculatorservice.domain.enums.TaxType;
import com.sirkaue.calculatorservice.infra.adapters.in.dto.TaxRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TaxControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCalculateTaxAndReturnResponse() throws Exception {
        // Arrange
        TaxRequest request = new TaxRequest(TaxType.ICMS, 100.0);
        String requestJson = objectMapper.writeValueAsString(request);

        // Act & Assert
        mockMvc.perform(post("/api/v1/tax/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.taxType").value("ICMS"))
                .andExpect(jsonPath("$.amount").value(100.0))
                .andExpect(jsonPath("$.totalTaxes").value(17.0));
    }

    @Test
    void shouldReturn400_whenTaxTypeIsInvalid() throws Exception {
        // Arrange
        String invalidRequestJson = """
        {
            "taxType": "INVALID",
            "amount": 100.0
        }
        """;

        // Act & Assert
        mockMvc.perform(post("/api/v1/tax/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidRequestJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.path").value("/api/v1/tax/calculate"))
                .andExpect(jsonPath("$.method").value("POST"));
    }
}
