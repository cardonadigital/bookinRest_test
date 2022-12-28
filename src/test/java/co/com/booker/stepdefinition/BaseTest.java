package co.com.booker.stepdefinition;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import static co.com.booker.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;


public class BaseTest {
    protected static final String BASE_URL = "https://restful-booker.herokuapp.com";
    protected static final String BASE_PATH = "/booking";
    private static final Logger LOGGER = Logger.getLogger(BaseTest.class);

    protected void generalSetUp(){
        configurationForRestAssured();
    }

    public void configurationForRestAssured(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    protected void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
