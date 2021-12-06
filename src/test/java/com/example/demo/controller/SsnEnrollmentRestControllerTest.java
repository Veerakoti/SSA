package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.SsnAuthenticationFormModel;
import com.example.demo.service.SsnService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SsnEnrollmentRestController.class)
public class SsnEnrollmentRestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private SsnService service;
	@Test
	public void enrollTest() throws Exception {
		
		when(service.ssnEnrollment(Mockito.any(SsnAuthenticationFormModel.class))).thenReturn("3655455");
		SsnAuthenticationFormModel model=new SsnAuthenticationFormModel();
		model.setDob(new Date());
		model.setFirstName("veera");
		model.setLastName("v");
		model.setGender("male");
		model.setStateName("ap");
		ObjectMapper mapper=new ObjectMapper();
		String writeValue = mapper.writeValueAsString(model);

		MockHttpServletRequestBuilder reqbuilder = MockMvcRequestBuilders.post("/enrollSsn")
																	.contentType(MediaType.APPLICATION_JSON)
																	.content(writeValue);
		MvcResult postValue = mockMvc.perform(reqbuilder).andReturn();
		MockHttpServletResponse response = postValue.getResponse();
		System.out.println("response enrollment  "+response.getContentAsString().toString());
		int status = response.getStatus();
		assertEquals(201, status);

	}

}
