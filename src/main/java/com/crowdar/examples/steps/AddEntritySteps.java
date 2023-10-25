package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.NewEntryConstants;
import com.crowdar.examples.services.AddEntryService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * This class handles the steps in the features files and connects with the service in case of having business logic.
 * Otherwise, if it is a simple action, like clicking a button and it has nothing related to business logic, is correct to put here.
 */
public class AddEntritySteps extends PageSteps {

    @Given("El usuario se encuentra en la pantalla de nuevas entradas")
    public void isHomePageVisible() {
        MobileActionManager.waitVisibility(NewEntryConstants.ADD_ENTRY_TITLE_LOCATOR);
    }

    @And("El usuario agrega una nueva entrada manualmente")
    public void addNewEntry() {
        AddEntryService.clickEntry();
    }

    @And("El usuario ingresa una nueva (.*) y (.*) de inicio")
    public void addInitialHour(String horaInicio, String minutoInicio) {
        AddEntryService.doAddInitialHour(horaInicio,minutoInicio);
    }

    @And("El usuario ingresa una nueva (.*) y (.*) de fin")
    public void addEndHour(String horaFin, String minutoFin) {
        AddEntryService.doAddEndHour(horaFin,minutoFin);
    }

    @And("El usuario hace clic al boton SAVE")
    public void clickSaveButton() {
        AddEntryService.doClickSaveButton();
    }

}

