package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.driver.DriverManager;
import com.crowdar.examples.constants.NewEntryConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Objects;

public class AddEntryService {

    static WebDriverWait wait = new WebDriverWait(DriverManager.getDriverInstance().getWrappedDriver(), 10);

    public static void clickEntry(){
        MobileActionManager.waitVisibility(NewEntryConstants.ENTRY_LOCATOR);
        MobileActionManager.click(NewEntryConstants.ENTRY_LOCATOR);
    }

    public static void doAddInitialHour(String horaInicio, String minutoInicio) {
        MobileActionManager.waitVisibility(NewEntryConstants.PESTANA_STAR_LOCATOR);
        MobileActionManager.click(NewEntryConstants.PESTANA_STAR_LOCATOR);
        setHour(horaInicio);
        setMinutes(minutoInicio);
    }

    public static void doAddEndHour(String horaFin, String minutoFin){
        MobileActionManager.waitVisibility(NewEntryConstants.PESTANA_END_LOCATOR);
        MobileActionManager.click(NewEntryConstants.PESTANA_END_LOCATOR);
        setHour(horaFin);
        setMinutes(minutoFin);
    }

    public static void doClickSaveButton(){
        MobileActionManager.waitVisibility(NewEntryConstants.SAVE_BUTTON_LOCATOR);
        MobileActionManager.click(NewEntryConstants.SAVE_BUTTON_LOCATOR);
    }

   private static void setHour(String hora){
        String horaMarcada = MobileActionManager.getText(NewEntryConstants.HORA_CENTER_INPUT_LOCATOR);

        int hoursInt = Integer.parseInt(hora);
        int mitadHora = 12;

        if((hoursInt>=00) && (hoursInt <24)){
            while (!Objects.equals(hora, horaMarcada)) {
                if (hoursInt < mitadHora){
                    MobileActionManager.click(NewEntryConstants.HORA_DOWN_BUTTON_LOCATOR);
                }
                if(hoursInt > mitadHora){
                    MobileActionManager.click(NewEntryConstants.HORA_UP_BUTTON_LOCATOR);
                }
                horaMarcada = MobileActionManager.getText(NewEntryConstants.HORA_CENTER_INPUT_LOCATOR);
            }
        } else{
            System.out.println("formato de horas incorrecta: " + hoursInt);
        }
    }

    private static void setMinutes(String minutos) {

        if ((Integer.parseInt(minutos) >= 00) && (Integer.parseInt(minutos) < 60)) {
            MobileActionManager.waitVisibility(NewEntryConstants.MINUTOS_CENTER_INPUT_LOCATOR);
            By xpathMinutos = By.xpath("//android.widget.NumberPicker[2]/android.widget.EditText");
            WebElement elementoMinutos = wait.until(ExpectedConditions.elementToBeClickable(xpathMinutos));
            elementoMinutos.clear();
            elementoMinutos.click();
            elementoMinutos.sendKeys(minutos);
        } else {
            System.out.println("formato de minutos incorrecta: " + minutos);
        }
    }
}
