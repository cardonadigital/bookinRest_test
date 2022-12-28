Feature: Crear reserva
  Como usuario de la pagina
  requiero crear una reserva
  para poder viajar

  @reTest @regresion
  Scenario: Reserva exitosa
    Given el usuario esta en la pagina
    When el usuario ingrese todos los datos requeridos correctamente
    Then el usuario podra crear una nueva reserva

  @reTest
  Scenario: Reserva erronea
    Given el usuario ingresea a la pagina
    When el usuario no ingrese el campo de firstName
    Then el sistema debera mostrar un mensaje de error