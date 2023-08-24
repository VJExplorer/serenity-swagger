package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import swaglabs.tasks.cart.AddToCart;
import swaglabs.tasks.navigation.Navigate;
import java.util.List;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CatalogStepDefinitions {
    List<String> cartItems;

    @And("{actor} is browsing product catalog")
    public void heIsBrowsingProductCatalog(Actor actor) {
        actor.attemptsTo(Navigate.toTheCatalogPage());
    }

    @When("{actor} adds following items to the cart:")
    public void heAddsFollowingItemsToTheCart(Actor actor, List<String> items) {
        cartItems = items;
        cartItems.forEach(
                itemName -> actor.attemptsTo(AddToCart.item(itemName))
        );
    }

    @Then("the shopping cart item count should be {int}")
    public void theShoppingCartItemCountShouldBe(int expectedCount) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(Text.of(".shopping_cart_badge")).asAnInteger().isEqualTo(expectedCount)
        );

    }

    @And("the item should appear in the cart")
    public void theItemShouldAppearInTheCart() {
        theActorInTheSpotlight().attemptsTo(
                Navigate.toTheShoppingCart(),
                Ensure.that(Text.ofEach(".inventory_item_name")).containsElementsFrom(cartItems)
        );
    }



}
