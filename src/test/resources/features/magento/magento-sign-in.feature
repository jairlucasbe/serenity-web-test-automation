Feature: Iniciar sesión en la plataforma de magento

  @magento-sign-in @UnhappyPath @magento
  Scenario Outline: Iniciar sesión con credenciales invalidas
    Given  el usuario se encuentra en la pagina de inicio de magento
    And el usuario le da click en la opcion Sign in de magento
    When inicia sesión con el correo "<email>" y la contraseña "<password>" en magento
    Then el inicio de sesión se realiza en magento
    And se muestra el mensaje de credenciales invalidas

    Examples:
      | email              | password |
      | usuario@test.com   | pass123  |

  @magento-sign-in @HappyPath @magento
  Scenario: Iniciar sesión con credenciales válidas
    Given el usuario se encuentra en la pagina de inicio de magento
    And el usuario le da click en la opcion Sign in de magento
    When inicia sesión con el correo "session" y la contraseña "session" en magento
    Then el inicio de sesión se realiza en magento
    And aparece en pantalla el mensaje de bienvenido

