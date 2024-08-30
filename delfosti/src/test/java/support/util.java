package support;

import definitions.hooks;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class util extends hooks {

    public static WebDriverWait wait;

    public util() {
        if (driver == null) { setUp();}
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
    }
    public void ventanaActiva(){
        Set<String> identificadores = driver.getWindowHandles();
        for(String identificador: identificadores)
        {
            driver.switchTo().window(identificador);
        }
    }

    //Cuando hay mas de dos ventanas
    /*public void navegacionDeVentanas()
    {
        hooks.driver.close();
        ventanaActiva();
    }*/

    public void ventanaInicial(){
        driver.close(); //Cerramos la ventana de tarjeta
        //ventanaActiva();
        driver.switchTo().window("");
    }

    public void validarPopUp(){
        Alert alerta = driver.switchTo().alert();
        alerta.accept();
    }
    public static double findMaxValue(HashMap<String, Double> map) {
        // Verificar que el mapa no esté vacío
        System.out.println(map.toString());
        if (map.isEmpty()) {
            throw new IllegalArgumentException("El HashMap está vacío");
        }

        // Inicializar el valor máximo con el valor del primer elemento
        double maxValue = Double.NEGATIVE_INFINITY;
        String maxKey = null;
        // Iterar sobre los valores del HashMap
        for (double value : map.values()) {
            // Actualizar el valor máximo si se encuentra un valor mayor
            if (value > maxValue) {
                maxValue = value;
            }
        }

        return maxValue;
    }
    public static double convertCurrencyToDouble(String currencyString) {
        // Eliminar el símbolo de moneda (e.g., "$")
        String numericString = currencyString.replaceAll("[^0-9.]", "");

        // Convertir la cadena numérica a double
        return Double.parseDouble(numericString);
    }

}
