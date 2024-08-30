package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class loginPage extends util {

    public loginPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    private WebElement txtUser;
    @FindBy(id = "password")
    private WebElement txtPassword;
    @FindBy(id = "login-button")
    private WebElement btnLogin;
    @FindBy(xpath = "//div[@id=\"header_container\"]/div[2]/span")
    private WebElement lbltitulo;
    @FindBy(xpath = "//div[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement lblMensajeRestric;
    public void escribirUserName(String userName)
    {
        txtUser.sendKeys(userName);
    }
    public void escribirPassword(String Password)
    {
        txtPassword.sendKeys(Password);
    }
    public void clickBotonIngresar()
    {
        btnLogin.click();
    }
    public boolean validarTitulo(String titulo)
    {
        wait.until(ExpectedConditions.visibilityOf(lbltitulo));
        if (titulo.equals(lbltitulo.getText()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean validarMensajeRestrictivo(String mensaje)
    {
        wait.until(ExpectedConditions.visibilityOf(lblMensajeRestric));
        if (mensaje.equals(lblMensajeRestric.getText()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
