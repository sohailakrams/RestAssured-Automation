package automation;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseTest {
	@BeforeClass
	public void setup() {

		RestAssured.baseURI = "https://6af7d0f49bdd097c326e6169.mockapi.io/api/v1";

	}
}
