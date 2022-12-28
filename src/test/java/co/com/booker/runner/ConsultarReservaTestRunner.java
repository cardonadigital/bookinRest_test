package co.com.booker.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/consultarReserva.feature",
        glue = "co.com.booker.stepdefinition.consultarreserva",
        publish = true
)
public class ConsultarReservaTestRunner {
}
