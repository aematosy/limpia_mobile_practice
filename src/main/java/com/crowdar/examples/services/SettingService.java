package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.SettingConstants;
import org.testng.Assert;

/**
 * This class contains the business logic.
 * We can have querys, requests or steps to do certain things (how to log into the app).
 * If we need to only complete a field or click a button, we can put it in the steps.
 */
public class SettingService {

    static Boolean darkModeValue;
    static Boolean showNotificationValue;
    static Boolean validador;

    public static void validateSettingScreen() {
        MobileActionManager.waitVisibility(SettingConstants.SETTING_TITLE_LOCATOR);
        MobileActionManager.click(SettingConstants.SETTING_TITLE_LOCATOR);
    }

    public static void doClickDarkModeSetting(String darkMode) {
        MobileActionManager.waitVisibility(SettingConstants.DARK_MODE_OPTION_LOCATOR);
        String atribuEnable = MobileActionManager.getAttribute(SettingConstants.DARK_MODE_OPTION_LOCATOR,"checked");

        if (darkMode.equals("habilitarlo") && atribuEnable.equals("false")) {
            MobileActionManager.click(SettingConstants.DARK_MODE_OPTION_LOCATOR);
            darkModeValue = true;
            System.out.println("Opción Dark mode habilitado");
        }else if (darkMode.equals("deshabilitarlo") && atribuEnable.equals("true")) {
            MobileActionManager.click(SettingConstants.DARK_MODE_OPTION_LOCATOR);
            darkModeValue = false;
            System.out.println("Opción Dark mode deshabilitado");
        }else {
            validador = true;
            System.out.println("No se realizó ninguna acción");
        }
    }

    public static void doClickShowNotificationSetting(String showNotification) {
        MobileActionManager.waitVisibility(SettingConstants.SHOW_NOTIFICATION_OPTION_LOCATOR);
        String atribuEnable = MobileActionManager.getAttribute(SettingConstants.SHOW_NOTIFICATION_OPTION_LOCATOR,"checked");

        if (showNotification.equals("habilitarlo") && atribuEnable.equals("false")) {
            MobileActionManager.click(SettingConstants.SHOW_NOTIFICATION_OPTION_LOCATOR);
            showNotificationValue = true;
            System.out.println("Opción Show notification habilitado");
        }else if (showNotification.equals("deshabilitarlo") && atribuEnable.equals("true")) {
            MobileActionManager.click(SettingConstants.SHOW_NOTIFICATION_OPTION_LOCATOR);
            showNotificationValue = false;
            System.out.println("Opción Show notification deshabilitado");
        }else {
            validador = true;
            System.out.println("No se realizó ninguna acción");
        }
    }

    public static void validateStatuscheckedDarkMode() {
        MobileActionManager.waitVisibility(SettingConstants.DARK_MODE_OPTION_LOCATOR);
        if(validador=false) {
            Boolean atributoDarkMode = Boolean.valueOf(MobileActionManager.getAttribute(SettingConstants.DARK_MODE_OPTION_LOCATOR, "checked"));
            Assert.assertTrue(darkModeValue.equals(atributoDarkMode), "La condición enviada no se cumplió");
        }
    }

    public static void validateStatuscheckedShowNotification() {
        MobileActionManager.waitVisibility(SettingConstants.SHOW_NOTIFICATION_OPTION_LOCATOR);
        if(validador=false){
            Boolean atributoNotification = Boolean.valueOf(MobileActionManager.getAttribute(SettingConstants.SHOW_NOTIFICATION_OPTION_LOCATOR,"checked"));
            Assert.assertTrue(showNotificationValue.equals(atributoNotification), "La condición enviada no se cumplió");
        }
    }
}
