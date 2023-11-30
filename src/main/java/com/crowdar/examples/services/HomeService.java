package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.List;

public class HomeService {

    public static void doClickAddButton() {
        MobileActionManager.waitVisibility(HomeConstants.ADD_BUTTON_LOCATOR);
        MobileActionManager.click(HomeConstants.ADD_BUTTON_LOCATOR);
    }

    public static void doClickMenuButton() {
        MobileActionManager.waitVisibility(HomeConstants.PANEL_NAVIGATION_LOCATOR);
        MobileActionManager.click(HomeConstants.PANEL_NAVIGATION_LOCATOR);
    }

    public static void doClickSettingButton() {
        MobileActionManager.waitVisibility(HomeConstants.SETTING_BUTTON_LOCATOR);
        MobileActionManager.click(HomeConstants.SETTING_BUTTON_LOCATOR);
    }

    public static void doClickLogoutButton() {
        MobileActionManager.waitVisibility(HomeConstants.LOGOUT_BUTTON_LOCATOR);
        MobileActionManager.click(HomeConstants.LOGOUT_BUTTON_LOCATOR);
        MobileActionManager.waitVisibility(HomeConstants.CONFIRMATION_LOGOUT_BUTTON_LOCATOR);
        MobileActionManager.click(HomeConstants.CONFIRMATION_LOGOUT_BUTTON_LOCATOR);
    }

    public static void doDeleteRegisterData(String workspaceId,String apiKey,String userId) {
        Response getResponse = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .get("https://api.clockify.me/api/v1/workspaces/" + workspaceId + "/user/" + userId + "/time-entries");

        if (getResponse.getStatusCode() == 200) {
            List<String> allIds = getResponse.jsonPath().getList("id");
            String lastId = allIds.get(allIds.size() - 1);
            System.out.println("CODIGO "+lastId);
            String deleteUrl = "https://api.clockify.me/api/v1/workspaces/" + workspaceId + "/time-entries/" + lastId;

            Response deleteResponse = RestAssured
                    .given()
                    .header("Content-Type", "application/json")
                    .header("x-api-key", apiKey)
                    .delete(deleteUrl);

            if (deleteResponse.getStatusCode() == 204) {
                System.out.println("La entrada de datos fue eliminada exitosamente.");
            } else {
                System.out.println("Error al eliminar la entrada de datos. Código de estado: " + deleteResponse.getStatusCode());
            }
        } else {
            System.out.println("Error al obtener la lista de horas registradas. Código de estado: " + getResponse.getStatusCode());
        }
    }
}
