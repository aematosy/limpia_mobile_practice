#Author: Adrian Matos
@TPFinal_mobile @Setting
Feature: Como usuario quiero entrar a configuraciones y cambiar una de las configuraciones (modo oscuro, notificaciones)

  Background:
    Given La aplicacion se carga correctamente
    When El usuario se encuentra en la pantalla de loguin

  @Darkmode_setting
  Scenario Outline: Habilitar/Deshabilitar modo oscuro en la aplicación
    And El usuario inicia sesion con: <email>, <password>
    And El usuario se encuentra en la pantalla principal
    And El usuario hace clic en el panel lateral de navegacion
    And El usuario hace clic en la opcion setting
    And El usuario valida que se encuentra en la pantalla de setting
    And El usuario hace clic en la opcion dark mode para habilitarlo-deshablitarlo: <dark_mode>
    Then El usuario valida el estado de la habilitacion de la opcion dark mode

    Examples:
      | email             | password        | dark_mode     |
      | amatos3@gmail.com | sXB*XBD8yPu!E%7 | habilitarlo   |
      | amatos3@gmail.com | sXB*XBD8yPu!E%7 | deshablitarlo |

  @Notification_setting
  Scenario Outline: Habilitar/Deshabilitar notificaciones en la aplicación
    And El usuario inicia sesion con: <email>, <password>
    And El usuario se encuentra en la pantalla principal
    And El usuario hace clic en el panel lateral de navegacion
    And El usuario hace clic en la opcion setting
    And El usuario valida que se encuentra en la pantalla de setting
    And El usuario hace clic en la opcion show notifications para habilitarlo-deshablitarlo: <show_notifications>
    Then El usuario valida el estado de la habilitacion de la opcion show notification

    Examples:
      | email             | password        | show_notifications |
      | amatos3@gmail.com | sXB*XBD8yPu!E%7 | habilitarlo        |
      | amatos3@gmail.com | sXB*XBD8yPu!E%7 | deshablitarlo      |

