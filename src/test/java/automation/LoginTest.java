package automation;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import utilities.ExtentTestManager;

public class LoginTest extends BaseTest {
	@Test
	public void getAllLogins() {
		
		// Response response = given().when().get("/login");
		// Response response = given().when().get("/login");

		Response response = given().when().get("/login");

		Assert.assertEquals(response.getStatusCode(), 200, "Unexpected status code");

		Assert.assertTrue(response.getTime() < 5000, "Response time exceeded 5 seconds");

		Assert.assertNotNull(response.jsonPath().getString("[0].email"), "Email should not be null");

		// Extent Report Logging
		if (ExtentTestManager.getTest() != null) {

			ExtentTestManager.getTest().info("Status Code : " + response.getStatusCode());

			ExtentTestManager.getTest().info("Response Time : " + response.getTime() + " ms");

			ExtentTestManager.getTest().info("Response Body : " + response.asPrettyString());
		}
		System.out.println("Endpoint = /login");
		System.out.println("Status Code = " + response.getStatusCode());
		System.out.println("Body = ");
		System.out.println(response.asPrettyString());
	}
}
// public void getAllLogins() {

// given().log().all()

// .when().get("https://6af7d0f49bdd097c326e6169.mockapi.io/api/v1/login")
// .get("/login")

// .then().log().all().statusCode(200).body("[0].email", notNullValue());
//		Response response = given().when().get("/login");
//		.time(lessThan(5000L));
//		System.out.println("Response Body:");
//		System.out.println(response.asPrettyString());
//
//		System.out.println("Status Code: " + response.getStatusCode());
//		System.out.println("Response Time: " + response.getTime() + " ms");

// }
/*
 * public void getAllLogins() {
 * 
 * Response response = given().when().get("/login");
 * 
 * Assert.assertEquals(response.getStatusCode(), 200, "Unexpected status code");
 * 
 * Assert.assertTrue(response.getTime() < 5000,
 * "Response time exceeded 5 seconds");
 * 
 * Assert.assertNotNull(response.jsonPath().getString("[0].email"),
 * "Email should not be null");
 * 
 * // ExtentLogger.info("Status Code : " + response.getStatusCode()); //
 * ExtentLogger.info("Response Time : " + response.getTime() + " ms"); //
 * ExtentLogger.info("Response Body : " + response.asPrettyString());
 * ExtentTestManager.getTest().info("Status Code : " +
 * response.getStatusCode());
 * 
 * ExtentLogger.info("Status Code : " + response.getStatusCode());
 * ExtentLogger.info("Response Time : " + response.getTime() + " ms");
 * ExtentLogger.info("Response Body : " + response.asPrettyString());
 * 
 * }
 * 
 * @Test public void createLogin() {
 * 
 * }
 * 
 * @Test public void updateLogin() {
 * 
 * }
 * 
 * @Test public void deleteLogin() {
 * 
 * } }
 */