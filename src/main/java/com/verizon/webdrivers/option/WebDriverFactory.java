package com.verizon.webdrivers.option;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * Created by vjean on 8/29/2017.
 */
public class WebDriverFactory {

    public WebDriver CreateInstance(Browsers browser) {
        if (Browsers.CHROME == browser) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\vjean\\IdeaProjects\\NetAssist.eNPCT.HealtCheck\\webDrivers\\chromedriver.exe");
            return new ChromeDriver();
        } else if (Browsers.FIREFOX == browser) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\vjean\\IdeaProjects\\NetAssist.eNPCT.HealtCheck\\webDrivers\\geckodriver.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            return new FirefoxDriver(capabilities);
        } else if (Browsers.PHANTOMJS == browser) {
            File src = new File("C:\\Users\\vjean\\IdeaProjects\\NetAssist.eNPCT.HealtCheck\\webDrivers\\phantomjs.exe");
            System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
            DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
            capabilities.setCapability("phantomjs", true);
            return new PhantomJSDriver(capabilities);
        } else {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\vjean\\IdeaProjects\\NetAssist.eNPCT.HealtCheck\\webDrivers\\IEDriverServer.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
            capabilities.setCapability("requireWindowFocus", true);
            return new InternetExplorerDriver(capabilities);
        }
    }
}
