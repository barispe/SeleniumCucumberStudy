package com.automatedtest.sample.infrastructure.driver;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class Setup {

    public static WebDriver driver;

    @Before
    public void setWebDriver() throws Exception {

        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = "chrome";
        }
        switch (browser) {
            case "chrome":
                System.setProperty ("webdriver.chrome.driver", "src/test/resources/com/driversforwin/chromedriverLast.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("use-fake-device-for-media-stream");
                chromeOptions.addArguments("use-fake-ui-for-media-stream");

                 //Auto-Allow Camera & Mic Access if fake ui not used
                // prefs.put("profile.content_settings.exceptions.media_stream_camera.'https://<https://demos.openvidu.io/basic-videoconference/>:443,'.setting","1");
               // prefs.put("profile.content_settings.exceptions.media_stream_mic.'https://<https://demos.openvidu.io/basic-videoconference/>:443,'.setting","1");

                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }
}
