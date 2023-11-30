#Author: Adrian Matos
@TPFinal_mobile @AddTimeEntry
Feature: Como usuario quiero iniciar sesion en la aplicacion y agregar una entrada de datos

  Background:
    Given La aplicacion se carga correctamente
    When El usuario se encuentra en la pantalla de loguin

  @AddTimeEntry_hour
  Scenario Outline: El usuario inicia la aplicacion clockify y agrega una entrada de datos - hora
    And El usuario inicia sesion con: <email>, <password>
    And El usuario se encuentra en la pantalla principal
    And El usuario hace clic al boton con icono +
    And El usuario se encuentra en la pantalla de nuevas entradas
    And El usuario selecciona un proyecto: <proyecto>
    And El usuario agrega una nueva entrada manualmente
    And El usuario ingresa una nueva hora: <horaInicio> de inicio
    And El usuario ingresa una nueva hora: <horaFin> de fin
    And El usuario hace clic al boton SAVE
    And El usuario regresa la pantalla de entrada de datos
    And El usuario hace clic al boton SAVE
    And El usuario elimina el registro de la entrada de datos con workspaceID: <workspaceID>, apiKey: <apiKey> y userID: <userID>
    Then El usuario retorna a la la pantalla principal

    Examples:
      | email             | password        | proyecto      | horaInicio | horaFin | workspaceID              | apiKey                                           | userID                   |
      | amatos3@gmail.com | sXB*XBD8yPu!E%7 | test - adrian | 14:30      | 17:30   | 6525bdd143528600a423cca6 | MDkxYzFlYmEtNGQ4Ni00ZDA2LTlhYmYtMjJkNjgzYzVmMWUx | 6525bdd143528600a423cca5 |

  @AddTimeEntry_date
  Scenario Outline: El usuario inicia la aplicacion clockify y agrega una informacion de datos - fecha

    And El usuario inicia sesion con: <email>, <password>
    And El usuario se encuentra en la pantalla principal
    And El usuario hace clic al boton con icono +
    And El usuario se encuentra en la pantalla de nuevas entradas
    And El usuario selecciona un proyecto: <proyecto>
    And El usuario agrega una nueva entrada manualmente
    And El usuario ingresa una nueva fecha: <fecha>
    And El usuario hace clic al boton SAVE
    And El usuario regresa la pantalla de entrada de datos
    And El usuario hace clic al boton SAVE
    And El usuario elimina el registro de la entrada de datos con workspaceID: <workspaceID>, apiKey: <apiKey> y userID: <userID>
    Then El usuario retorna a la la pantalla principal

    Examples:
      | email             | password        | proyecto      | fecha         | workspaceID              | apiKey                                           | userID                   |
      | amatos3@gmail.com | sXB*XBD8yPu!E%7 | test - adrian | 20 junio 2023 | 6525bdd143528600a423cca6 | MDkxYzFlYmEtNGQ4Ni00ZDA2LTlhYmYtMjJkNjgzYzVmMWUx | 6525bdd143528600a423cca5 |

  @AddTimeEntry_date
  Scenario Outline: El usuario inicia la aplicacion clockify y agrega una informacion de datos - No guardar

    And El usuario inicia sesion con: <email>, <password>
    And El usuario se encuentra en la pantalla principal
    And El usuario hace clic al boton con icono +
    And El usuario se encuentra en la pantalla de nuevas entradas
    And El usuario selecciona un proyecto: <proyecto>
    And El usuario agrega una nueva entrada manualmente
    And El usuario ingresa una nueva fecha: <fecha>
    And El usuario hace clic al boton DISCARD
    Then El usuario retorna a la la pantalla de nuevas entradas

    Examples:
      | email             | password        | proyecto      | fecha             |
      | amatos3@gmail.com | sXB*XBD8yPu!E%7 | test - adrian | 02 diciembre 2023 |
