Feature: Como usuario quiero iniciar session en la aplicacion y agregar una entrada de datos

  Background:
    Given La aplicacion se carga correctamente
    When El usuario se encuentra en la pantalla de loguin

  Scenario Outline: El usuario inicia la aplicacion clockify y agrega una informacion de datos
    And El usuario inicia sesion con: <email>, <password>
    And El usuario se encuentra en la pantalla principal
    And El usuario hace clic al boton con icono +
    And El usuario se encuentra en la pantalla de nuevas entradas
    And El usuario agrega una nueva entrada manualmente
    And El usuario ingresa una nueva <horaInicio> y <minutoInicio> de inicio
    And El usuario ingresa una nueva <horaFin> y <minutoFin> de fin
    And El usuario hace clic al boton SAVE
    Then El usuario retorna a la la pantalla principal

    @Demo_clockify
    Examples:
      | email             | password        | horaInicio | minutoInicio | horaFin | minutoFin |
      | amatos3@gmail.com | sXB*XBD8yPu!E%7 | 14         | 30           | 17      | 30        |
