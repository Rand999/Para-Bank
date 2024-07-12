package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver getNewInstance(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome-headless":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("--disable-web-security");
                chromeOptions.addArguments("--no-proxy-server");
                chromeOptions.addArguments("--remote-allow-origins=*");

               // chromeOptions.addExtensions(new File("C:\\Users\\windows\\Desktop\\AdBlock.crx"));
                return new ChromeDriver(chromeOptions);
            case "firefox":
                return new FirefoxDriver();
            case "firefox-headless":
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");
                firefoxBinary.addCommandLineOptions("--window-size=1280x720");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                return new FirefoxDriver(firefoxOptions);
            case "edge":
                return new EdgeDriver();
            default:
                ChromeOptions defaultOptions = new ChromeOptions();
                defaultOptions.addArguments("start-maximized");
              //  defaultOptions.addArguments("--incognito");
                defaultOptions.addArguments("--disable-web-security");
                defaultOptions.addArguments("--no-proxy-server");
                defaultOptions.addArguments("--remote-allow-origins=*");
                defaultOptions.addArguments("--disable-notifications");
               // defaultOptions.addExtensions(new File("C:\\Users\\windows\\Desktop\\AdBlock — block ads across the web 6.3.0.0.crx"));

                return new ChromeDriver(defaultOptions);
        }
    }
}
