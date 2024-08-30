@TodaLaPrueba
Feature:  Revisión de productos y uso del carrito de compras
  Como usuario necesito poder ordenarr productos, y agregar al carrito de compras


  @FlujoExitoso
  Scenario: Ordenando Productos
    Given Inicio sesion en la pagina con el usuario "standard_user" y clave "secret_sauce"
    And Cargo la pagina principal de "Products"
    When Presiono en el combo de ordenar y selecciono "Price (high to low)"
    Then se muestra que los productos se reordenaron "Price (high to low)"

  Scenario: Visualizando Detalle de producto y agregando a carrito
    Given Inicio sesion en la pagina con el usuario "standard_user" y clave "secret_sauce"
    And Cargo la pagina principal de "Products"
    When Hago clic en el producto "Sauce Labs Backpack"
    Then Verifico pantalla de detalle de producto "Sauce Labs Backpack"
    When Hago Clic en agregar al carro
    Then se muestra el carrito con el item agregado

