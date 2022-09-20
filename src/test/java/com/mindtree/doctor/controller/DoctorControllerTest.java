package com.mindtree.doctor.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.doctor.entity.Doctor;
import com.mindtree.doctor.service.DoctorService;




@RunWith(SpringRunner.class)
@WebMvcTest(value=DoctorController.class)
public class DoctorControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DoctorService doctorService;
	
	@Test
	public void testCreateDoctor() throws Exception{
		
		Doctor mockDoctor = new Doctor();
		mockDoctor.setDoctorId(1L);
		mockDoctor.setDoctorName("saxena");
		mockDoctor.setGender("Male");
		mockDoctor.setAge(35);
		mockDoctor.setNumberOfPatientattended(1);
		mockDoctor.setSpecialization("Nerosurgion");
		
		String inputInJson = this.mapToJson(mockDoctor);
		
		String URI = "/doctor/get";
		
		Mockito.when(doctorService.createDoctor(Mockito.any(Doctor.class))).thenReturn(mockDoctor);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		
		
		
				
	}
	@Test
	public void testGetAllDoctor() throws Exception {
		Doctor mockDoctor1 = new Doctor();
		mockDoctor1.setDoctorId(2L);
		mockDoctor1.setDoctorName("dharamveer");
		mockDoctor1.setGender("Male");
		mockDoctor1.setAge(36);
		mockDoctor1.setNumberOfPatientattended(2);
		mockDoctor1.setSpecialization("heart specialist");
		
		Doctor mockDoctor2 = new Doctor();
		mockDoctor2.setDoctorId(13L);
		mockDoctor2.setDoctorName("anil");
		mockDoctor2.setGender("Male");
		mockDoctor2.setAge(39);
		mockDoctor2.setNumberOfPatientattended(3);
		mockDoctor2.setSpecialization("Lung specialist");
		
		List<Doctor> doctorList = new ArrayList<>();
		doctorList.add(mockDoctor1);
		doctorList.add(mockDoctor2);
		
		Mockito.when(doctorService.getAllDoctor()).thenReturn(doctorList);
		
		String URI = "/doctor/get";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(doctorList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);

		
		
	}
	
	@Test
	public void getAllDoctorById() throws Exception{
		
	}
	
	
	private  String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	

}
