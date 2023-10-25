package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import com.crowdar.examples.services.HomeService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeSteps extends PageSteps {

    @Given("El usuario se encuentra en la pantalla principal")
    @Then("El usuario retorna a la la pantalla principal")
    public void isHomePageVisible() {
        MobileActionManager.waitPresence(HomeConstants.TIME_ENTRIE_TITLE_LOCATOR);
    }

    @Given("El usuario hace clic al boton con icono +")
    public void clickAddButton() {
        HomeService.doClickAddButton();
    }
}
