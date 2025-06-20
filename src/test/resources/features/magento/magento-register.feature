Feature: Registrar en la plataforma de magento

  @magento-register @HappyPath @magento
  Scenario Outline: Registrar de manera existosa a un usuario con credenciales validas
    Given  el usuario se encuentra en la pagina de inicio de magento
    And el usuario le da click en la opcion Create an account de magento
    And ingresa nombre "<nombre>" apellido "<apellido>" contrasenia "<contrasenia>"
    When selecciona el boton registrar de magento
    Then se realiza el registro en magento de manera exitosa

    Examples:
      | nombre | apellido | contrasenia  |
      | Romulo | Leon     | Password123& |

