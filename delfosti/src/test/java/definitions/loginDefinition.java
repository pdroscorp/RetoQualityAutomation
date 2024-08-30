package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageobjects.loginPage;

import java.io.IOException;

import static support.screenShoot.evidencia;

public class loginDefinition {
    loginPage login;

    public loginDefinition(){
        login = new loginPage();
    }
    @Given("Ingresando a la pagina web")
    public void validoQueMiAplicacionEsteOperativa() throws IOException {
        hooks.driver.get("https://www.saucedemo.com/");
    }
    @And("Escribo usuario {string}")
    public void escriboUserName(String userName) throws IOException {
        login.escribirUserName(userName);
    }
    @And("Escribo contrasena {string}")
    public void escriboPassword(String txtPassword) throws IOException {
        login.escribirPassword(txtPassword);
    }
    @And("Hago Click en boton login")
    public void hagoClickEnIngresarPlataforma() throws IOException {
        login.clickBotonIngresar();
    }
    @Then("se muestra la pantalla {string}")
    public void seMuestraLaPantalla(String titulo) throws IOException {
        Assert.assertEquals("El mensaje esperado es: "+ titulo, true, login.validarTitulo(titulo));
        evidencia();
    }
    @Then("se muestra mensaje restrictivo {string}")
    public void validarMensajeRestrictivo(String mensaje) throws IOException {
        Assert.assertEquals("El mensaje esperado es: "+ mensaje, true, login.validarMensajeRestrictivo(mensaje));
        evidencia();
    }

}
