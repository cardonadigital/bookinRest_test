package co.com.booker.stepdefinition.consultarreserva;

import co.com.booker.stepdefinition.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class ConsultarReservaStepDefinition extends BaseTest {
    private static final Logger LOGGER = Logger.getLogger(BaseTest.class);
    private static RequestSpecification request;
    private static Response response;
    private static Response response2;


    @Given("el usuario se encuentra en la pagina")
    public void elUsuarioEstaEnLaPagina() {
        try {
            setUpLog4j2();
            generalSetUp();
            request = given()
                    .contentType(ContentType.JSON);

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    @When("el usuario seleccione una reserva valida")
    public void elUsuarioSeleccioneUnaReservaValida() {
        try{
            response = request.get("/35");
        } catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }

    @Then("el usuario podra ver la iformacion de la reserva")
    public void elUsuarioPodraVerLaIformacionDeLaReserva() {
        try{
            response
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .body("firstname", notNullValue());
        }catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }



    @Given("el usuario ingresea a la pagina")
    public void elUsuarioIngreseaALaPagina() {
        try {
            request = given()
                    .contentType(ContentType.JSON);

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    @When("el usuario no ingrese una reserva no valida")
    public void elUsuarioNoIngreseUnaReservaNoValida() {
        try{
            response = request.get("/35445687657656");
        } catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }

    @Then("el sistema debera mostrar el siguiente mensaje: {string}")
    public void elSistemaDeberaMostrarElSiguienteMensaje(String message) {
        try{
            response
                    .then()
                    .statusCode(HttpStatus.SC_NOT_FOUND)
                    .body(equalTo(message));
        }catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }
}
