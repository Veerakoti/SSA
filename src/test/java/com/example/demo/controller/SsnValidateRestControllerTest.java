package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.service.SsnService;

//@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest(value = SsnValidateRestController.class)
public class SsnValidateRestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private SsnService service;
	@Test
	public void validateSsnTest() throws Exception {
		when(service.checkEnrollment("26", "ap")).thenReturn("in-valid");

		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/validateSsn/26/ap");
		MvcResult andReturn = mockMvc.perform(mockHttpServletRequestBuilder).andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		String status = response.getContentAsString();
		System.out.println("packaging of  "+status);
		assertEquals("in-valid", status);

	}
}
