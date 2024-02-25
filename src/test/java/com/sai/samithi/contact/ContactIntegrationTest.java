package com.sai.samithi.contact;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@ActiveProfiles("integration")
@ConfigurationPropertiesScan
public class ContactIntegrationTest {
	
	@Autowired
	private WebApplicationContext applicationContext;
	
	@Value("classpath:/jsonresponse/contact/create-success.json")
	private Resource createSuccessResponse;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}
	
	@Test
	public void whenValidContactIsGivenExpectCreateSuccess() throws Exception {
		//When
		ContactRequest  contactRequest = ContactRequest.builder()
				.message("When is next Bhajan Day ?")
				.name("Sai")
				.subject("Rg: Bhajan")
				.email("member@gmail.com")
				.phoneNumber("7832438265")
				.build();
		
		//Given
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
				.post("/contact")
				.content(objectMapper.writeValueAsString(contactRequest))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			.andReturn();
		String responseString = mvcResult.getResponse().getContentAsString();
		ContactResponse actualResponse = objectMapper.readValue(responseString, ContactResponse.class);
		JsonNode expectedResponseNode = objectMapper.readTree(createSuccessResponse.getContentAsByteArray()); 
		String expectedResString = expectedResponseNode.toString();
		ContactRequest expectedResponse = objectMapper.readValue(expectedResString, ContactRequest.class);
		
		//Then
		assertThat(expectedResponse.name().equals(actualResponse.getName()));
		assertThat(expectedResponse.email().equals(actualResponse.getEmail()));
		assertThat(expectedResponse.message().equals(actualResponse.getMessage()));
		assertThat(expectedResponse.subject().equals(actualResponse.getSubject()));

	}

	@Test
	public void whenInValidContactIsGivenExpectBadRequest() throws Exception {
		//When
		ContactRequest  contactDto = ContactRequest.builder()
				.message("When is next Bhajan Day ?")
				.name("Sai")
				.subject("Rg: Bhajan")
				.email("member@gmail.com")
				.phoneNumber("hello")
				.build();
		//Given and Then
		mockMvc.perform(MockMvcRequestBuilders
				.post("/contact")
				.content(objectMapper.writeValueAsString(contactDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isBadRequest())
			.andReturn();

	}

}
