package integration.test;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contract")
public class ContractController {

	@RequestMapping(value="{contractNumber}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Contract getContract(@PathVariable final int contractNumber){
		Contract contract = new Contract(1,"Andre");
		return contract;
	}
	
}
