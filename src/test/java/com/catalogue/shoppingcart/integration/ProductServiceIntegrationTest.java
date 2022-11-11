package com.catalogue.shoppingcart.integration;

import com.catalogue.shoppingcart.repository.ProductRepository;
import com.catalogue.shoppingcart.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    final void setUp() {
        productRepository.deleteAll();
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    @Sql({"/data.sql"})
    public void getAllProductsTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/product/all")
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());

        String content = mvcResult.getResponse().getContentAsString();

        System.out.println(content);
    }
}
