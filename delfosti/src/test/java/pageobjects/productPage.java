package pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

import java.nio.DoubleBuffer;
import java.util.HashMap;

public class productPage extends util {
    public productPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    private WebElement txtUser;
    @FindBy(xpath = "//div[@id=\"header_container\"]/div[2]/div/span/select")
    private WebElement cboOrdenar;

    @FindBy(xpath = "//a[@id=\"item_4_title_link\"]/div")
    private WebElement producto;
    @FindBy(css = ".inventory_item:nth-child(1) .inventory_item_price")
    private WebElement Price1;
    @FindBy(css = ".inventory_item:nth-child(2) .inventory_item_price")
    private WebElement Price2;
    @FindBy(css = ".inventory_item:nth-child(3) .inventory_item_price")
    private WebElement Price3;
    @FindBy(css = ".inventory_item:nth-child(4) .inventory_item_price")
    private WebElement Price4;
    @FindBy(css = ".inventory_item:nth-child(5) .inventory_item_price")
    private WebElement Price5;
    @FindBy(css = ".inventory_item:nth-child(5) .inventory_item_price")
    private WebElement Price6;

    @FindBy(xpath = "//div[2]/div/div/div[2]/div")
    private WebElement lblDetTitulo;
    @FindBy(id = "add-to-cart")
    private WebElement btnAddToCar;
    @FindBy(xpath = "//div[@id=\"shopping_cart_container\"]/a")
    private WebElement btncarSHOP;


    public void escribirUserName(String userName)
    {
        txtUser.sendKeys(userName);
    }
    public void detalleDeProducto()
    {
        producto.click();
    }
    public void seleccionarTipoOrdenamiento(String cadena)
    {
        new Select(cboOrdenar).selectByVisibleText(cadena);
        cboOrdenar.click();
    }
    public boolean verificarReordenamientoHighToLow(){

        double p1 = convertCurrencyToDouble(Price1.getText());

        HashMap<String, Double> hashPrices = new HashMap<>();
        hashPrices.put("1", convertCurrencyToDouble(Price1.getText()));
        hashPrices.put("2", convertCurrencyToDouble(Price2.getText()));
        hashPrices.put("3", convertCurrencyToDouble(Price3.getText()));
        hashPrices.put("4", convertCurrencyToDouble(Price4.getText()));
        hashPrices.put("5", convertCurrencyToDouble(Price5.getText()));
        hashPrices.put("6", convertCurrencyToDouble(Price6.getText()));
        double maxValue = findMaxValue(hashPrices);

        if (p1==maxValue){
            return true;
        }else {
            return false;
        }
    }
    public boolean validarTitulo(String titulo)
    {
        wait.until(ExpectedConditions.visibilityOf(lblDetTitulo));
        if (titulo.equals(lblDetTitulo.getText()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void clickBotonAgregarACArro()
    {
        btnAddToCar.click();
    }
    public void clickVisualizarCarro()
    {
        btncarSHOP.click();
    }
}



