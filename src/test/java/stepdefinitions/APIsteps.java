package stepdefinitions;

import io.restassured.http.ContentType;

import io.restassured.response.ValidatableResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import Models.Devices;
import Utilities.PropertiesCache;
import Models.Data;

import static io.restassured.RestAssured.given;

 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.testng.Assert;

public class APIsteps {
	

    private ValidatableResponse validatableResponse;
 
    public final static String endpoint = PropertiesCache.getInstance().getProperty("api.address");
    
    //Sample pay load for demonstration purposes
    String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
    
    //REST API Methods: GET, POST, DELETE, PUT
    @Given("I send a GET request to the URL to get user details")
    public void getRequest(){
        validatableResponse = 
        		given()
        			.contentType(ContentType.JSON)
                .when()
                	.get(endpoint)
                .then();   
         
        System.out.println("Response :"+validatableResponse.extract().asPrettyString());
    }
    
    @Given("I send a POST request to the URL to get user details")
    public void postRequest(){
        validatableResponse = 
        		given()
        			.contentType(ContentType.JSON)
        			.body(jsonString)
                .when()
                	.post(endpoint)
                .then();  
         
        validatableResponse.assertThat().statusCode(200);
    }
    
    @Given("I send a DELETE request to the URL to get user details")
    public void deleteRequest(){
        validatableResponse = 
        		given()
        			.contentType(ContentType.JSON)
                .when()
                	.delete(endpoint).
                then();   
         
        validatableResponse.assertThat().statusCode(200);
    }
    
    @Given("I send a PUT request to the URL to get user details")
    public void putRequest(){
        validatableResponse = 
        		given()
        			.contentType(ContentType.JSON)
        			.body(jsonString)
                .when()
                	.put(endpoint)
            	.then();   
         
        validatableResponse.assertThat().statusCode(200);
    }
  
  
    @Then("the response will return status {int}")
    public void verifyStatus(int statusCode){
        validatableResponse.assertThat().statusCode(statusCode); 
    }
    
    @Then("Validate ID is not null")
    public void verifyIDnotNULL() throws JsonMappingException, JsonProcessingException{
 
        String responseBodyString =
        		validatableResponse.extract().asPrettyString();
        
        ObjectMapper MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Devices> devices = MAPPER.readValue(responseBodyString, MAPPER.getTypeFactory().constructCollectionType(List.class, Devices.class));
        
        for (Devices device: devices) {
        	System.out.println("ID: " + device.getID());
        	Assert.assertNotNull(device.getID());
        } 
    }
    
    @Then("Fetch Phone names containing Apple")
    public void verifyPhoneNamesWithApple() throws JsonMappingException, JsonProcessingException{
         
        String responseBodyString =
        		validatableResponse.extract().asPrettyString();
        
        ObjectMapper MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Devices> devices = MAPPER.readValue(responseBodyString, MAPPER.getTypeFactory().constructCollectionType(List.class, Devices.class));
        List<String> appleDevices =new ArrayList<String>();
        
        
        for (Devices device: devices) {
        	if(device.getName().startsWith("Apple")) {
        		appleDevices.add(device.getName());
        	} 
        }
        System.out.println("List of apple devices: " + appleDevices);
        Assert.assertTrue(appleDevices.size() > 0);

    }
    
    @Then("Fetch Phone name of lowest price")
    public void verifyPhoneNameWithMinPrice() throws JsonMappingException, JsonProcessingException{
         
        String responseBodyString =
        		validatableResponse.extract().asPrettyString();
        
        ObjectMapper MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Devices> devices = MAPPER.readValue(responseBodyString, MAPPER.getTypeFactory().constructCollectionType(List.class, Devices.class));
        List<Double> prices = new ArrayList<Double>();	
        
        for (Devices device: devices) {
 
        	ObjectMapper mapper = new ObjectMapper();   
        	if(device.getData() != null) {
        		String json = mapper.writeValueAsString(device.getData());
	        	Data data = mapper.readValue(json, Data.class);

	        	
	        	if(data.getPrice() != null) {
	        		prices.add(Double.parseDouble(data.getPrice()));
	        	}
	        	
	        	if(data.getDataPrice() != null) {
	        		prices.add(data.getDataPrice());
	        		
	        	}
	        	         
        	}
        }
        
	 System.out.println("Non null Prices: " + prices);
	
     Double minPrice = Collections.min(prices);
     System.out.println("The lowest price is: " + minPrice);
        
     Assert.assertTrue(minPrice > 0);

    }
}

