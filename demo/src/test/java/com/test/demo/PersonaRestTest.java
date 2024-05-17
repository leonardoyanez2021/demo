package com.test.demo;


import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.test.demo.controller.PersonaController;
import com.test.demo.services.PersonaService;

@WebMvcTest(PersonaController.class)
class PersonaRestTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonaService service;

	@Test
	void testOK() throws Exception {
		this.mockMvc.perform(get("/api/personas")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testNotFound() throws Exception {
		this.mockMvc.perform(get("/api/persona")).andDo(print()).andExpect(status().isNotFound());
	}

}