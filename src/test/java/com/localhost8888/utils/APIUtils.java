package com.localhost8888.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.util.Map;
import org.json.JSONObject;

public class APIUtils {

  public Map<String, String> postCallGetCookies(JSONObject jsonPayload, String Uri) {
    return RestAssured.given()
        .baseUri(Uri)
        .accept(ContentType.JSON)
        .body(jsonPayload.toString())
        .when()
        .post()
        .getCookies();
  }
}
