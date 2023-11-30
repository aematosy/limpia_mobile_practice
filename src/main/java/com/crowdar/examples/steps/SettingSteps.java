package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.SettingService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SettingSteps extends PageSteps {

    @And("El usuario valida que se encuentra en la pantalla de setting")
    public void clickLogoutButton() {
        SettingService.validateSettingScreen();
    }

    @And("El usuario hace clic en la opcion dark mode para habilitarlo-deshablitarlo: (.*)")
    public void clickDarkModeSetting(String darkMode) {
        SettingService.doClickDarkModeSetting(darkMode);
    }

    @And("El usuario hace clic en la opcion show notifications para habilitarlo-deshablitarlo: (.*)")
    public void clickShowNotificationSetting(String showNotification) {
        SettingService.doClickShowNotificationSetting(showNotification);
    }

    @Then("El usuario valida el estado de la habilitacion de la opcion dark mode")
    public void validateStatuscheckedDarkMode() {
        SettingService.validateStatuscheckedDarkMode();
    }

    @Then("El usuario valida el estado de la habilitacion de la opcion show notification")
    public void validateStatuscheckedShowNotificatio() {
        SettingService.validateStatuscheckedShowNotification();
    }



}
