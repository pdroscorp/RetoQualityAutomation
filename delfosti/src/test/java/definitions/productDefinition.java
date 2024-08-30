package definitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageobjects.productPage;
import pageobjects.loginPage;
import java.io.IOException;
import static support.screenShoot.evidencia;
public class productDefinition {
    productPage product;
    loginPage login;
    public productDefinition() {
        product = new productPage();
        login = new loginPage();
    }
    @Given("Inicio sesion en la pagina con el usuario {string} y clave {string}")
    public void iniciarSesion(String userName, String clave) throws IOException {
        hooks.driver.get("https://www.saucedemo.com/");
        login.escribirUserName(userName);
        login.escribirPassword(clave);
        login.clickBotonIngresar();
    }
    @And("Cargo la pagina principal de {string}")
    public void seMuestraLaPantalla(String titulo) throws IOException {
        Assert.assertEquals("El mensaje esperado es: "+ titulo, true, login.validarTitulo(titulo));
    }
    @When("Presiono en el combo de ordenar y selecciono {string}")
    public void seleccionoComboOrdenamiento(String cadena) throws IOException {
       product.seleccionarTipoOrdenamiento(cadena);
    }
    @Then("se muestra que los productos se reordenaron {string}")
    public void verificarReordenamiento (String cadena) throws IOException {
        product.seleccionarTipoOrdenamiento(cadena);
        if (cadena.equalsIgnoreCase("Price (high to low)")){
            Assert.assertTrue(product.verificarReordenamientoHighToLow());
        }
    }
    @When("Hago clic en el producto {string}")
    public void seleccionoProducto (String cadena) throws IOException {
        product.detalleDeProducto();
    }
    @Then("Verifico pantalla de detalle de producto {string}")
    public void seMuestraLaPantallaDetalleProducto(String titulo) throws IOException {
        Assert.assertEquals("El mensaje esperado es: "+ titulo, true, product.validarTitulo(titulo));
    }

    @When("Hago Clic en agregar al carro")
    public void hagoClickEnIngresarPlataforma() throws IOException {
        product.clickBotonAgregarACArro();
    }
    @Then("se muestra el carrito con el item agregado")
    public void visualizarCarrito() throws IOException {
        product.clickVisualizarCarro();
    }
}
