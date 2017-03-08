package integration.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers=ContractController.class)
public class ContractControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test() throws Exception{
		String getContractNumber = 	"/contract/{contractNumber}";
		int contractNumber = 1;
		mockMvc.perform(get(getContractNumber, contractNumber))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(content().json("{\"name\":\"Andre\",\"number\":1}", true))
		.andDo(print())
		.andReturn();
		
	}
	
}
