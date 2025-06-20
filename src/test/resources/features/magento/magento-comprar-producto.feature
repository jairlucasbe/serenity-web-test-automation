Feature: Comprar un producto

  @magento-register-login @HappyPath @magento @magento-task
  Scenario Outline: Registrar, iniciar sesión y comprar un producto con datos de envío
    Given el usuario se encuentra en la pagina de inicio de magento
    And el usuario le da click en la opcion Create an account de magento
    And ingresa nombre "<nombre>" apellido "<apellido>" contrasenia "<contrasenia>"
    When selecciona el boton registrar de magento
    Then se realiza el registro en magento de manera exitosa

    And el usuario navega hasta la seccion de Jackets
    And el usuario selecciona un producto
    And escoge opciones de la compra con talla XS, color Green y cantidad "<cantidad>"
    And agregar al carrito de compras
    And El usuario se encuentra en la pagina de carrito de compras
    And el usuario procede con la compra
    And el usuario llena el formulario con nombre "<nombre>", apellido "<apellido>", empresa "<empresa>", direccion "<direccion>", ciudad "<ciudad>", region_id "<region_id>", zip "<zip>", country_id "<country_id>" y telefono "<telephone>"
    And selecciona el método de envío
    Then debería ver el resumen de compra y confirmarlo
    And deberia ver el numero de orden de compra
    And deberia ir a la orden de compra haciendo click sobre la orden de compra
    And se valida que se haya comprado el producto correcto

    Examples:
      | nombre | apellido | contrasenia  | empresa   | direccion            | ciudad | region_id | zip    | country_id | cantidad | telephone |
      | Romulo | Leon     | Password123& | NTT Data  | Av. Siempre Viva 123 | Lima   | 1         | 15001  | AL         | 2        | 99999999 |



  @HappyPath @magento @magento-task
  Scenario Outline: Buscar un producto que no existe
    Given el usuario se encuentra en la pagina de inicio de magento
    When el usuario le da click en la caja de busqueda
    And el usuario ingresa el nombre de un producto "hola" que no existe
    Then Se muestra el aviso de que no se han retornado resultados

  @magento-register-login @HappyPath @magento @magento-task
  Scenario Outline: Editar el nombre de mi cuenta
    Given el usuario se encuentra en la pagina de inicio de magento
    And el usuario le da click en la opcion Create an account de magento
    And ingresa nombre "<nombre>" apellido "<apellido>" contrasenia "<contrasenia>"
    When selecciona el boton registrar de magento
    Then se realiza el registro en magento de manera exitosa

    And el usuario navega hasta la seccion de Account Information
    And el usuario cambia el nombre "<nombre_cambiado>" en la caja de firstname
    And el usuario presiona el boton save
    And se verifica que el nombre haya cambiado en el icono del usuario

    Examples:
      | nombre | apellido | contrasenia  | nombre_cambiado |
      | Romulo | Leon     | Password123& | NTT Data        |