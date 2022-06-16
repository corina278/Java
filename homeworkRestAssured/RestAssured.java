package homeworkRestAssured;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssured {

    private static final String baseURL = "https://petstore.swagger.io/v2/";

    private static final String token = "pseudoToken";

    public void assureGet(String status){

        Pet[] response =
                given()
                    .basePath(baseURL)
                    .header("Authorization", token)
                    .header("Content-Type", ContentType.ANY)
                .when()
                .get(baseURL + "pet/findByStatus?status=" + status)
                .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .extract().as(Pet[].class);
        for(Pet pet : response){
            System.out.println(pet);
        }
    }

    public void assurePost(){
        Pet response =
                given()
                    .basePath(baseURL)
                    .header("Content-Type", ContentType.JSON)
                    .body("{\n" +
                            "  \"id\": 1354,\n" +
                            "  \"category\": {\n" +
                            "    \"id\": 1354,\n" +
                            "    \"name\": \"Kittyk\"\n" +
                            "  },\n" +
                            "  \"photoUrls\": [\n" +
                            "    \"string\"\n" +
                            "  ],\n" +
                            "  \"tags\": [\n" +
                            "    {\n" +
                            "      \"id\": 1345,\n" +
                            "      \"name\": \"string\"\n" +
                            "    }\n" +
                            "  ],\n" +
                            "  \"status\": \"available\"\n" +
                            "}")
                .when()
                .post(baseURL + "pet")
                .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .extract().as(Pet.class);
        System.out.println(response);
    }

    public void assurePut(){
        Pet response =
                given()
                        .basePath(baseURL)
                        .header("Content-Type", ContentType.JSON)
                        .body("{\n" +
                                "  \"id\": 1354,\n" +
                                "  \"category\": {\n" +
                                "    \"id\": 1354,\n" +
                                "    \"name\": \"Kittyk\"\n" +
                                "  },\n" +
                                "  \"photoUrls\": [\n" +
                                "    \"string\"\n" +
                                "  ],\n" +
                                "  \"tags\": [\n" +
                                "    {\n" +
                                "      \"id\": 1345,\n" +
                                "      \"name\": \"string\"\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"status\": \"sold\"\n" +
                                "}")
                        .when()
                        .put(baseURL + "pet")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .body("status", equalTo("sold"))
                        .contentType(ContentType.JSON)
                        .extract().as(Pet.class);
        System.out.println("The updated pet: " +response);
    }

    public void assureDelete(String status) {

        Pet[] response =
                given()
                        .basePath(baseURL)
                        .header("Authorization", token)
                        .header("Content-Type", ContentType.ANY)
                        .when()
                        .delete(baseURL + "pet/" + status)
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .extract().as(Pet[].class);
        for(Pet pet : response){
          System.out.println(pet);
        }

    }
}
