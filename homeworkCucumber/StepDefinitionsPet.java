package homeworkCucumber;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import models.Pet;
import org.apache.commons.lang3.NotImplementedException;
import testConfig.TestContext;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class StepDefinitionsPet {

    private TestContext testContext;

    public StepDefinitionsPet(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void executeBeforeEachScenario() {
        System.out.println("####### This is executed before each scenario#######");
    }

    @After
    public void executeAfterEachScenario() {
        System.out.println("!!!!!! EXECUTED AFTER SCENARIO!!!!!!!!");
    }

    @Given("a new user is created having id:{int} name:{string} status:{string}")
    public void newUserCreated(int id, String name, String status) {
        Pet pet = new Pet(id, name, status);

        testContext.getScenarioContext().setContext("validPet", pet);
        testContext.getScenarioContext().setContext("petId", id);
    }

    @Given("use regex(?: (.*))?$")
    public void useRegex(String option) {

        if (null == option)
            option = "";

        switch (option) {
            case "": {
                System.out.println("Regex was not used");
                break;
            }
            case "here": {
                System.out.println("Regex was used here");
                break;
            }
            default: {
                throw new NotImplementedException("Invalid option");
            }
        }
    }

    @Given("the following animals:")
    public void followingAnimals(List<String> animals) {
        System.out.println(animals);
    }

    @Given("print {string} from examples")
    public void printWord(String word) {
        System.out.println(word);
    }

    @Given("this background step")
    public void backgroundStep() {
        System.out.println("@@@@ This is a background step@@@@@");
    }

    @When("add new user API is called")
    public void newUserApiCalled() {
        Pet user = (Pet) testContext.getScenarioContext().getContext("validUser");
        RequestSpecification requestSpecification;

        requestSpecification = given()
                .baseUri("https://petstore.swagger.io/v2/pet/")
                .contentType(ContentType.JSON)
                .body(user);

        Response response = requestSpecification.post();

        testContext.getScenarioContext().setContext("apiResponse", response);
    }

    @Then("request status code is {int}")
    public void verifyStatusCode(Integer statusCode) {
        Response response = (Response) testContext.getScenarioContext().getContext("apiResponse");

        assertThat(response.getStatusCode(), is(statusCode));
    }

    @When("get pet by id api is called")
    public void getPetById() {
        int id = (Integer) testContext.getScenarioContext().getContext("petId");
        RequestSpecification requestSpecification;

        requestSpecification = given()
                .baseUri("https://petstore.swagger.io/v2/pet/" + id)
                .contentType(ContentType.JSON);

        Response response = requestSpecification.get();
        testContext.getScenarioContext().setContext("apiResponse", response);
    }

    @Then("correct user is retrieved")
    public void correctUserRetrieved() throws JsonProcessingException {
        Response response = (Response) testContext.getScenarioContext().getContext("apiResponse");
        Pet sentPet = (Pet) testContext.getScenarioContext().getContext("validPet");

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        Pet pet = mapper.readValue(response.getBody().asString(), Pet.class);

        System.out.println(sentPet);
        System.out.println(pet);

        assertThat(pet, is(sentPet));
    }
}
