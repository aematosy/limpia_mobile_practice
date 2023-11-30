#Author: Adrian Matos
@TPFinal_mobile @Logout
Feature: Como usuario quiero salir de la aplicación haciendo logout

  Background:
    Given La aplicacion se carga correctamente
    When El usuario se encuentra en la pantalla de loguin

    Scenario Outline: Logout exitoso en el aplicativo clockify
    And El usuario inicia sesion con: <email>, <password>
    And El usuario se encuentra en la pantalla principal
    And El usuario hace clic en el panel lateral de navegacion
    And El usuario hace clic en el boton de logout
    Then El usuario retorna a la pantalla de loguin

    Examples:
      | email             | password        |
      | amatos3@gmail.com | sXB*XBD8yPu!E%7 |

