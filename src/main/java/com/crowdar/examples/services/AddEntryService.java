package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.driver.DriverManager;
import com.crowdar.examples.constants.NewEntryConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.DateFormatSymbols;
import java.time.Duration;
import java.util.Objects;

public class AddEntryService {

    private static final String[] NOMBRES_MESES = new DateFormatSymbols().getMonths();

    static WebDriverWait wait = new WebDriverWait(DriverManager.getDriverInstance().getWrappedDriver(), 20);

    public static void clickEntry(){
        MobileActionManager.waitVisibility(NewEntryConstants.ENTRY_LOCATOR);
        MobileActionManager.click(NewEntryConstants.ENTRY_LOCATOR);
    }

    public static void doSelectProject(String proyecto) {
        MobileActionManager.waitVisibility(NewEntryConstants.PROJECT_OPTION_LOCATOR);
        MobileActionManager.click(NewEntryConstants.PROJECT_OPTION_LOCATOR);
        FluentWait waitElement = new FluentWait(DriverManager.getDriverInstance().getWrappedDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);

        WebElement elementoProject = (WebElement) waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[contains(@text, '" + proyecto + "')]")));
        elementoProject.click();
    }

    public static void doAddInitialHour(String horaInicio) {
        MobileActionManager.waitClickable(NewEntryConstants.PESTANA_STAR_LOCATOR);
        MobileActionManager.click(NewEntryConstants.PESTANA_STAR_LOCATOR);
        String[] partesHora = horaInicio.split(":");
        String horas = partesHora[0];
        String minutos = partesHora[1];
        setHour(horas);
        setMinutes(minutos);
    }

    public static void doAddEndHour(String horaFin){
        MobileActionManager.waitVisibility(NewEntryConstants.PESTANA_END_LOCATOR);
        MobileActionManager.click(NewEntryConstants.PESTANA_END_LOCATOR);
        String[] partesHora = horaFin.split(":");
        String horas = partesHora[0];
        String minutos = partesHora[1];
        setHour(horas);
        setMinutes(minutos);
    }

    public static void doAddNewDate(String date){
        MobileActionManager.waitVisibility(NewEntryConstants.INICIO_MES_LOCATOR);
        String atributoMes = MobileActionManager.getAttribute(NewEntryConstants.INICIO_MES_LOCATOR,"content-desc");
        String[] partesMesActual = atributoMes.split("\\s+");
        String[] partesMesDeseado = date.split("\\s+");
        String diaMesDeseado = partesMesDeseado[0]+" ";
        String diaMesaCTUAL = partesMesActual[0];
        String nombreMesActual = partesMesActual[1];
        String nombreMesDeseado = partesMesDeseado[1];

        int numeroMes1 = obtenerNumeroMes(nombreMesActual);
        int numeroMes2 = obtenerNumeroMes(nombreMesDeseado);

        int diferenciaMeses = numeroMes1 - numeroMes2;

        if (diferenciaMeses != 0) {
            if (diferenciaMeses > 0) {
                for (int i = 0; i < diferenciaMeses; i++) {
                    MobileActionManager.waitClickable(NewEntryConstants.MES_ANTERIOR_LOCATOR);
                    MobileActionManager.click(NewEntryConstants.MES_ANTERIOR_LOCATOR);
                }
            } else {
                for (int i = 0; i > diferenciaMeses; i--) {
                    MobileActionManager.waitClickable(NewEntryConstants.MES_SIGUIENTE_LOCATOR);
                    MobileActionManager.click(NewEntryConstants.MES_SIGUIENTE_LOCATOR);
                }
            }
        } else {
            System.out.println("Los meses son iguales, no se realizan ninguna acción.");
        }
        String xpathExpression = "//android.view.View[contains(@content-desc, '" + diaMesDeseado + "')]";
        WebElement elementoDia = DriverManager.getDriverInstance().getWrappedDriver().findElement(By.xpath(xpathExpression));
        elementoDia.click();
    }

    public static void doClickSaveButton() throws InterruptedException {
        MobileActionManager.waitVisibility(NewEntryConstants.SAVE_BUTTON_LOCATOR);
        MobileActionManager.click(NewEntryConstants.SAVE_BUTTON_LOCATOR);
        Thread.sleep(2000);
    }

    public static void doReturnEntryData(){
        MobileActionManager.waitVisibility(NewEntryConstants.MANUAL_TITLE_LOCATOR);
    }

    public static void doClickDiscardButton(){
        MobileActionManager.waitVisibility(NewEntryConstants.DISCARD_OPCION_LOCATOR);
        MobileActionManager.click(NewEntryConstants.DISCARD_OPCION_LOCATOR);
        MobileActionManager.waitVisibility(NewEntryConstants.TITLE_DISCARD_LOCATOR);
        MobileActionManager.click(NewEntryConstants.DISCARD_BUTTON_LOCATOR);
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

    private static int obtenerNumeroMes(String nombreMes) {
        for (int i = 0; i < NOMBRES_MESES.length; i++) {
            if (NOMBRES_MESES[i].equalsIgnoreCase(nombreMes)) {
                return i + 1;
            }
        }
        return 0;
    }
}
