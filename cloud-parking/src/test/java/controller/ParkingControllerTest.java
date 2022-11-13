package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTest extends AbstractContainerBase {
	
	@LocalServerPort
	private int randomPort;
	
	@BeforeEach
	public void setUpTest() {
		RestAssured.port = randomPort;
	}

	@Test
	void whenFindAllTheCheckResult() {
		RestAssured.given()
			.header("Authorization, "Basic code" )
			.basic("user", "dio@123")
			.when()
			.get("/parking")
			.then()
			.statusCode(HttpStatus.OK.value())
		
	}

	@Test
	void whenCreateThenCheckIsCreated() {
		
		var createDTO = new ParkingCreateDTO();
		createDTO.setColor("AMARELO");
		createDTO.setLicense("WRT-5555");
		createDTO.setModel("BRASILIA");
		createDTO.setState("SP");		
		
		RestAssured.given()
			.auth()
			.basic("user","dio@123")
			.when()
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.get("/parking")
			.then()
			.statusCode(HttpStatus.OK.value())
			.body("license", Matchers.equalTo("WRT-5555"))
			.body("color", Matchers.equalTo("AMARELO"));
	}

}
