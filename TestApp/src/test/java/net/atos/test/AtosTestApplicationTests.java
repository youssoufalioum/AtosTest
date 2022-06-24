package net.atos.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.atos.test.entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
class AtosTestApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void saveUserTest() throws Exception {
		Date date = new Date(1992, 05, 19);
		User user = new User(1, "Youssouf", date, "France", "+33695415450", "M");
		String produitJson = objectToStringJson(user);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/atostest/api/saveUser")
				.contentType(MediaType.APPLICATION_JSON)
				.content(produitJson)).andReturn();
		
			assertEquals(201, result.getResponse().getStatus());
		
	}
	
	@Test
	void getUserByIdTest() throws Exception {

		   mockMvc.perform(MockMvcRequestBuilders.get("/atostest/api/getUserDetails/1"))
		  .andExpect(status().isOk())
		  .andExpect(content() 
	      .contentType(MediaType.APPLICATION_JSON))
		  .andExpect(jsonPath("$.name", is("Youssouf")));

	}
	
	
	
	static String objectToStringJson(final Object object) throws Exception {
		return new ObjectMapper().writeValueAsString(object);
	}

}
