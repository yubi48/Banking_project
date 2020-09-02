package com.rab3tech.customer.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rab3tech.customer.service.impl.CustomerEnquiryService;
import com.rab3tech.test.TestUtil;
import com.rab3tech.vo.CustomerSavingVO;
public class CustomerAccountEnquiryControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private CustomerEnquiryService customerEnquiryService;
	
	@InjectMocks
	private CustomerAccountEnquiryController customerAccountEnquiryController;
	
	@Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(customerAccountEnquiryController)
              //  .addFilters(new CorsFilter())
                .build();
    }
	

	@Test
	public 	void testGetAllEnquiryWhenEnquiryNoEmpty() throws Exception {
		 List<CustomerSavingVO> customerSavingVOs=new ArrayList<>();
		 CustomerSavingVO customerSavingVO1=new CustomerSavingVO(122,"nagendra","nagen@gmail.com","02390","NA","Saving","Appoved","C9393",null,"A435");
		 CustomerSavingVO customerSavingVO2=new CustomerSavingVO(123,"ashish","ashish@gmail.com","92882","NT","Current","Pending","S9393",null,"B435");
		 customerSavingVOs.add(customerSavingVO1);
		 customerSavingVOs.add(customerSavingVO2);
		 when(customerEnquiryService.findAll()).thenReturn(customerSavingVOs);
		 mockMvc.perform(get("/v3/customers/enquiry"))
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
         .andExpect(jsonPath("$", hasSize(2)))
         .andExpect(jsonPath("$[0].csaid", is(122)))
         .andExpect(jsonPath("$[0].name", is("nagendra")))
         .andExpect(jsonPath("$[0].email", is("nagen@gmail.com")))
         .andExpect(jsonPath("$[1].csaid", is(123)))
         .andExpect(jsonPath("$[1].email", is("ashish@gmail.com")))
         .andExpect(jsonPath("$[1].name", is("ashish")));		 
		 verify(customerEnquiryService, times(1)).findAll();
	     verifyNoMoreInteractions(customerEnquiryService);
	}
	
	@Test
	public 	void testGetAllEnquiryWhenEnquiryIsEmpty() throws Exception {
		 List<CustomerSavingVO> customerSavingVOs=new ArrayList<>();
		 when(customerEnquiryService.findAll()).thenReturn(customerSavingVOs);
		 mockMvc.perform(get("/v3/customers/enquiry"))
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
         .andExpect(jsonPath("$", hasSize(0)));
		 verify(customerEnquiryService, times(1)).findAll();
	     verifyNoMoreInteractions(customerEnquiryService);
	}
	
	@Test
	public	void testSaveEnquiryWhenSuccess2() throws Exception {
		  CustomerSavingVO customerSavingVO=new CustomerSavingVO(0,"nagendra","nagen@gmail.com","02390","NA","Saving","Appoved","C9393",null,"A435");
		  when(customerEnquiryService.emailNotExist("nagen@gmail.com")).thenReturn(true);
	 	  when(customerEnquiryService.save(customerSavingVO)).thenReturn(customerSavingVO);
	 	 mockMvc.perform(MockMvcRequestBuilders.post("/v3/customers/enquiry")
	 	        .contentType(MediaType.APPLICATION_JSON)
	 	        .content(TestUtil.convertObjectToJsonBytes(customerSavingVO))
	 			.accept(MediaType.APPLICATION_JSON))
	 			.andExpect(jsonPath("$.name").exists())
	 			.andExpect(jsonPath("$.email").exists())
	 			.andExpect(jsonPath("$.name").value("nagendra"))
	 			.andExpect(jsonPath("$.email").value("nagen@gmail.com"))
	 			.andDo(print());
	 	 
	 	verify(customerEnquiryService, times(1)).save(customerSavingVO);
 	    verify(customerEnquiryService, times(1)).emailNotExist("nagen@gmail.com");
        verifyNoMoreInteractions(customerEnquiryService);
	}
	
	@Test
	public	void testGetEnquiryByIdWhenExist() throws Exception {
		CustomerSavingVO customerSavingVO=new CustomerSavingVO(122,"nagendra","nagen@gmail.com","02390","NA",
				"Saving","Appoved","C9393",null,"A435");
		 when(customerEnquiryService.findById(122)).thenReturn(customerSavingVO);
		 mockMvc.perform(MockMvcRequestBuilders.get("/v3/customers/enquiry/"+122)
     	 			 .accept(MediaType.APPLICATION_JSON))
		 			.andExpect(jsonPath("$.name").exists())
		 			.andExpect(jsonPath("$.email").exists())
		 			.andExpect(jsonPath("$.name").value("nagendra"))
		 			.andExpect(jsonPath("$.email").value("nagen@gmail.com"))
		 			.andDo(print());
		 verify(customerEnquiryService, times(1)).findById(122);
	     verifyNoMoreInteractions(customerEnquiryService);
	}
	
}
