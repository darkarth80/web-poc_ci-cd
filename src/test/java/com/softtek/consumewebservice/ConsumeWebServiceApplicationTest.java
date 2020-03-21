package com.softtek.consumewebservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@WebMvcTest(controllers = ConsumedController.class)
public class ConsumeWebServiceApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void homePage() throws Exception {
		mockMvc.perform(get("/index.html"));
    }
    
    @Test
    public void testConsumer() throws Exception {
        MockHttpServletRequestBuilder createMessage = get("/");
        //.param("summary", "Spring Rocks")
        //.param("text", "In case you didn't know, Spring Rocks!");

        mockMvc.perform(createMessage)
        .andExpect(status().is2xxSuccessful())
        .andExpect(redirectedUrl("/"));
    }

}
