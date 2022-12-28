package co.com.booker.stepdefinition.crearreserva;

import co.com.booker.stepdefinition.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CrearReservaStepDefinition extends BaseTest {
    private static final Logger LOGGER = Logger.getLogger(BaseTest.class);
    private static RequestSpecification request;
    private static Response response;
    private static Response response2;

    @Given("el usuario esta en la pagina")
    public void elUsuarioEstaEnLaPagina() {
        try {
            setUpLog4j2();
            generalSetUp();
            request =   given().body("{\n" +
                    "    \"firstname\" : \"Jim\",\n" +
                    "    \"lastname\" : \"Brown\",\n" +
                    "    \"totalprice\" : 111,\n" +
                    "    \"depositpaid\" : true,\n" +
                    "    \"bookingdates\" : {\n" +
                    "        \"checkin\" : \"2018-01-01\",\n" +
                    "        \"checkout\" : \"2019-01-01\"\n" +
                    "    },\n" +
                    "    \"additionalneeds\" : \"Breakfast\"\n" +
                    "}");

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    @When("el usuario ingrese todos los datos requeridos correctamente")
    public void elUsuarioIngreseTodosLosDatosRequeridosCorrectamente() {
        try{
            response = request.post();
        } catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }

    @Then("el usuario podra crear una nueva reserva")
    public void elUsuarioPodraCrearUnaNuevaReserva() {
        try{
            response
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .body("bookingid",notNullValue());
        }catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }




    @Given("el usuario ingresea a la pagina")
    public void elUsuarioIngreseaALaPagina() {
        try {
            setUpLog4j2();
            generalSetUp();
            request =   given().body("{\n" +
                    "    \"lastname\" : \"Brown\",\n" +
                    "    \"totalprice\" : 111,\n" +
                    "    \"depositpaid\" : true,\n" +
                    "    \"bookingdates\" : {\n" +
                    "        \"checkin\" : \"2018-01-01\",\n" +
                    "        \"checkout\" : \"2019-01-01\"\n" +
                    "    },\n" +
                    "    \"additionalneeds\" : \"Breakfast\"\n" +
                    "}");

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    @When("el usuario no ingrese el campo de firstName")
    public void elUsuarioNoIngreseElCampoDeFirstName() {
        try{
            response2 = request.post();
        } catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }

    @Then("el sistema debera mostrar un mensaje de error")
    public void elSistemaDeberaMostrarUnMensajeDeError() {
        try{
            response2
                    .then()
                    .assertThat()
                    .statusCode(500)
                    .body(equalTo("Internal Server Error"));
        }catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }
}
