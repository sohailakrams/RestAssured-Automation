package automation;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.restassured.response.Response;
import utilities.ExtentTestManager;

public class LoginTest extends BaseTest {
	private static final String LOGIN_ENDPOINT = "/login";
	private static final int SUCCESS_STATUS_CODE = 200;
	private static final long MAX_RESPONSE_TIME_MS = 5000L;

	@Test
	@Test(description = "Verify that the login endpoint returns a successful response with valid data")
	
	public void getAllLogins() {
		Response response = given().when().get(LOGIN_ENDPOINT);
// logResponse(response);
// logResponse(response);
// logResponse(response);
// logResponse(response);

// logResponse(response);
		logResponse(response);
		validateResponse(response);
	}

	private void validateResponse(Response response) {
		Assert.assertEquals(
				response.getStatusCode(),
				SUCCESS_STATUS_CODE,
				"Unexpected status code");
		Assert.assertTrue(
				response.getTime() < MAX_RESPONSE_TIME_MS,
				"Response time exceeded 5 seconds");
		Assert.assertNotNull(
				response.jsonPath().getString("[0].email"),
				"Email should not be null");
	}

	private void logResponse(Response response) {
		ExtentTest extentTest = ExtentTestManager.getTest();
		if (extentTest == null) {
			return;
		}

		extentTest.info("Endpoint: " + LOGIN_ENDPOINT);
		extentTest.info("Status Code: " + response.getStatusCode());
		extentTest.info("Response Time: " + response.getTime() + " ms");
		extentTest.info("Response Body: " + response.asPrettyString());
	}
}