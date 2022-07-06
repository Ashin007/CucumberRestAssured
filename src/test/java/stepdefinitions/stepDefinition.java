package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class stepDefinition extends utils {
    RequestSpecification rSpecification;
    Response response;
    @Given("pet payload are ready")
    public void pet_payload_are_ready() throws IOException {
        TestDataBuild payload = new TestDataBuild();
        rSpecification = given().spec(requestSpecification()).body(payload.addPetPayload());
    }
    @When("User call {string} call to {string}")
    public void userCallCallTo(String httpRequest,String resource) {
        APIResources apiResources = APIResources.valueOf(resource);
        if(httpRequest.equalsIgnoreCase("POST"))
        response = rSpecification.when().post(apiResources.getResource());
        else if (httpRequest.equalsIgnoreCase("GET"))
            response = rSpecification.when().get(apiResources.getResource());
        response.then().spec(responseSpecification()).extract().response();
    }
    @Then("API call is success pet is added")
    public void api_call_is_success_pet_is_added() {
        System.out.println(response.asString());
    }
    @And("Status is {int}")
    public void status_is(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Response code from server "+response.getStatusCode()+" Expected "+int1);
    }

}
