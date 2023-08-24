package starter.stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import swaglabs.model.SwaglabsUser;
import swaglabs.tasks.athentication.Login;
import swaglabs.tasks.navigation.Navigate;


public class AuthenticationStepDefinition {
    @Given("{actor} is on the login page")
    public void on_the_login_page(Actor actor){
        actor.attemptsTo(Navigate.toTheLoginPage());

    }

    @Given("{actor} logged onto the application")
    public void logged_onto_the_application(Actor actor) {
        actor.attemptsTo(Navigate.toTheLoginPage(),Login.asA(SwaglabsUser.STANDARD_USER));

    }

    @When("{actor} logs in with valid credentials")
    public void logs_in_with_valid_credentials(Actor actor) {
        actor.attemptsTo(
                Login.asA(SwaglabsUser.STANDARD_USER)

        );
    }

    @Then("{actor} should be presented with the product catalog")
    public void should_be_presented_with_product_catalog(Actor actor) {
        actor.attemptsTo(
                Ensure.that(Text.of(".title")).isEqualToIgnoringCase("Products"));
    }



}
