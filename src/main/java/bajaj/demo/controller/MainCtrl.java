package bajaj.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bajaj.demo.model.RequestModel;
import bajaj.demo.response.ResponseModel;
import bajaj.demo.service.BFHLService;

@RestController
@RequestMapping("/bfhl")
public class MainCtrl 
{
	public class BFHLController 
	{
	    private final BFHLService service;

	    public BFHLController(BFHLService service) 
	    {
	        this.service = service;
	    }

	    @GetMapping
	    public ResponseEntity<Object> getOperationCode() 
	    {
	        return new ResponseEntity<>(service.getOperationCode(), HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<Object> processData(@RequestBody RequestModel request) 
	    {
	        try {
	            ResponseModel response = service.processRequest(request);
	            return new ResponseEntity<>(response, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Error processing request: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	    }
  }
}
