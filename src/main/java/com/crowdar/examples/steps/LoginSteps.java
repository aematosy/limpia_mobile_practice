package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.LoginConstants;
import com.crowdar.examples.services.LoginService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * This class handles the steps in the features files and connects with the service in case of having business logic.
 * Otherwise, if it is a simple action, like clicking a button and it has nothing related to business logic, is correct to put here.
 */
public class LoginSteps extends PageSteps {

    @Given("La aplicacion se carga correctamente")
    public void isLoginPageVisible() {
        LoginService.isViewLoaded();
    }

    @Then("El usuario retorna a la pantalla de loguin")
    @When("El usuario se encuentra en la pantalla de loguin")
    public void goToSignUp() {
        MobileActionManager.waitVisibility(LoginConstants.EMAIL_INPUT_LOCATOR);
    }

    @When("El usuario inicia sesion con: (.*), (.*)")
    public void doLoginProcess(String email, String password) {
        LoginService.doLogin(email, password);
    }
}
