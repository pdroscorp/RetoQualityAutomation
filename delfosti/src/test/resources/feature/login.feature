@TodaLaPrueba
Feature:  Login en SwagLabs
  Como usuario necesito poder loguearme con mi credenciales al portal de SwagLabs

  @FlujoAlternativo
  Scenario: Login Fallido por locked

    Given Ingresando a la pagina web
    And Escribo usuario "locked_out_user"
    And Escribo contrasena "secret_sauce"
    And Hago Click en boton login
    Then se muestra mensaje restrictivo "Epic sadface: Sorry, this user has been locked out."

  @FlujoExitoso
  Scenario: Login exitoso

    Given Ingresando a la pagina web
    And Escribo usuario "standard_user"
    And Escribo contrasena "secret_sauce"
    And Hago Click en boton login
    Then se muestra la pantalla "Products"
