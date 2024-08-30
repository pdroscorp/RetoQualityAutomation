package definitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class hooks {
    private static String navegador = "chrome";
    public static WebDriver driver;

    //@Test
    public static void setUp(){
        if(navegador.equals("chrome"))
        {
            //System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            //driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
        else if (navegador.equals("firefox"))
        {
            //System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
        else
        {
            System.out.println("El navegador no existe en la lista de browser: " + navegador);
        }
    }

    // @After
    public static void tearDown()
    {
        driver.manage().deleteAllCookies();
        driver.close();
    }

}


