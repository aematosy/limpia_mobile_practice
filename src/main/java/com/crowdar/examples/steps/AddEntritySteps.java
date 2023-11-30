package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.NewEntryConstants;
import com.crowdar.examples.services.AddEntryService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AddEntritySteps extends PageSteps {

    @Then("El usuario retorna a la la pantalla de nuevas entradas")
    @Given("El usuario se encuentra en la pantalla de nuevas entradas")
    public void isHomePageVisible() {
        MobileActionManager.waitVisibility(NewEntryConstants.ADD_ENTRY_TITLE_LOCATOR);
    }

    @And("El usuario agrega una nueva entrada manualmente")
    public void addNewEntry() {
        AddEntryService.clickEntry();
    }

    @And("El usuario selecciona un proyecto: (.*)")
    public void selectProject(String project) {
        AddEntryService.doSelectProject(project);
    }

    @And("El usuario ingresa una nueva hora: (.*) de inicio")
    public void addInitialHour(String horaInicio) {
        AddEntryService.doAddInitialHour(horaInicio);
    }

    @And("El usuario ingresa una nueva hora: (.*) de fin")
    public void addEndHour(String horaFin) {
        AddEntryService.doAddEndHour(horaFin);
    }

    @And("El usuario ingresa una nueva fecha: (.*)")
    public void addNewDate(String date){
        AddEntryService.doAddNewDate(date);
    }

    @And("El usuario hace clic al boton SAVE")
    public void clickSaveButton() throws InterruptedException {
        AddEntryService.doClickSaveButton();
    }

    @And("El usuario regresa la pantalla de entrada de datos")
    public void returnScreenData() {
        AddEntryService.doReturnEntryData();
    }

    @And("El usuario hace clic al boton DISCARD")
    public void clickDiscardButton() {
        AddEntryService.doClickDiscardButton();
    }
}

