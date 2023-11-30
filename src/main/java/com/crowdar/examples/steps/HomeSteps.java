package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import com.crowdar.examples.services.HomeService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

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

    @And("El usuario hace clic en el panel lateral de navegacion")
    public void clickMenuNavigationButton() {
        HomeService.doClickMenuButton();
    }

    @And("El usuario hace clic en la opcion setting")
    public void clickSettingButton() {
        HomeService.doClickSettingButton();
    }

    @And("El usuario hace clic en el boton de logout")
    public void clickLogoutButton() {
        HomeService.doClickLogoutButton();
    }

    @And("El usuario elimina el registro de la entrada de datos con workspaceID: (.*), apiKey: (.*) y userID: (.*)")
    public void deleteRegisterData(String workspace, String apiKey, String userId) {
        HomeService.doDeleteRegisterData(workspace,apiKey,userId);
    }
}
