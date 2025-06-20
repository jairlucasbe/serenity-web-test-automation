Feature: Comprar un producto

  @magento-register-login @HappyPath @magento @magento-task
  Scenario Outline: Registrar un nuevo usuario y luego iniciar sesión con las credenciales recién creadas
    Given el usuario se encuentra en la pagina de inicio de magento
    And el usuario le da click en la opcion Create an account de magento
    And ingresa nombre "<nombre>" apellido "<apellido>" contrasenia "<contrasenia>"
    When selecciona el boton registrar de magento
    Then se realiza el registro en magento de manera exitosa

    # Logout
    And el usuario cierra sesión en magento si es necesario

    # Login
    And el usuario le da click en la opcion Sign in de magento
    When inicia sesión con el correo "<email>" y la contraseña "<contrasenia>" en magento
    Then el inicio de sesión se realiza en magento
    And aparece en pantalla el mensaje de bienvenido

    # Comprar
    And el usuario navega hasta la seccion de Jackets
    And el usuario selecciona un producto

    Examples:
      | nombre | apellido | email           | contrasenia  |
      | Romulo | Leon     | session         | Password123& |

  @magento-register-login @HappyPath @magento @magento-test
  Scenario: Registrar un nuevo usuario y luego iniciar sesión con las credenciales recién creadas
    Given el usuario se encuentra en la pagina de inicio de magento
    When el usuario navega hasta la seccion de Jackets
    And el usuario selecciona un producto
