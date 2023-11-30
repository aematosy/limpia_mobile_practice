#Author: Adrian Matos
@TPFinal_mobile @Login
Feature: Como usuario quiero iniciar sesion en la aplicacion

  Background:
    Given La aplicacion se carga correctamente
    When El usuario se encuentra en la pantalla de loguin

    Scenario Outline: Loguin exitoso en el aplicativo clockify
    And El usuario inicia sesion con: <email>, <password>
    And El usuario se encuentra en la pantalla principal

    Examples:
      | email             | password        |
      | amatos3@gmail.com | sXB*XBD8yPu!E%7 |

