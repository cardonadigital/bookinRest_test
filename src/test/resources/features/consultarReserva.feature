Feature: Consultar reserva
  Como usuario de la pagina
  requiero consultar la reserva
  para obtener informacion

  @reTest @regresion
  Scenario: Consulta de reserva exitosa
    Given el usuario se encuentra en la pagina
    When el usuario seleccione una reserva valida
    Then el usuario podra ver la iformacion de la reserva

  @reTest
  Scenario: Consulta de reserva no exitosa
    Given el usuario ingresea a la pagina
    When el usuario no ingrese una reserva no valida
    Then el sistema debera mostrar el siguiente mensaje: "Not Found"