package com.info.demoqa.test.api;

import com.maxsoft.testngtestresultsanalyzer.annotations.Category;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static com.info.demoqa.api.ApiSpec.requestSpec;
import static com.info.demoqa.api.ApiSpec.responseSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PostTest {

    @Test
    @Category("Posts")
    public void testPostRetrieval() {
        given()
                .spec(requestSpec())
                .when()
                .get("posts/1")
                .then()
                .spec(responseSpec())
                .statusCode(200);
    }

    @Test
    @Category("Posts")
    public void testPostModification() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("userId", 100);
        requestBody.put("title", "Test Data");
        requestBody.put("body", "Test one");

        given()
                .spec(requestSpec())
                .body(requestBody.toString())
                .when()
                .put("posts/1")
                .then()
                .spec(responseSpec())
                .statusCode(200)
                .body("userId", equalTo(100))
                .body("id", notNullValue());
    }

    @Test
    @Category("Posts")
    public void testPostCreation() {
        JSONObject requstBody = new JSONObject();
        requstBody.put("userId", 100);
        requstBody.put("title", "Test Data");
        requstBody.put("body", "Test one");

        given()
                .spec(requestSpec())
                .body(requstBody.toString())
                .when()
                .post("posts")
                .then()
                .spec(responseSpec())
                .statusCode(201)
                .body("userId", equalTo(100))
                .body("id", notNullValue());
    }

    @Test
    @Category("Posts")
    public void testPostDeletion() {
        given()
                .spec(requestSpec())
                .when()
                .delete("posts/1")
                .then()
                .statusCode(200);
    }
}
