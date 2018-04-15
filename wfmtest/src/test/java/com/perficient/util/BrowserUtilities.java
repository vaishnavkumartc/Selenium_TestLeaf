package com.perficient.util;

import java.io.File;
import java.util.logging.Level;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.perficient.core.TestDriver;

public class BrowserUtilities {

	private static File path = new File(TestDriver.props.getProperty("driverfilepath"));

	public static void getDriver(String browser) {
		if (browser.equals("FF")) {
			try {

				new DesiredCapabilities();
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				LoggingPreferences logs = new LoggingPreferences();
				logs.enable(LogType.BROWSER, Level.ALL);
				logs.enable(LogType.CLIENT, Level.ALL);
				logs.enable(LogType.DRIVER, Level.INFO);
				logs.enable(LogType.PERFORMANCE, Level.ALL);
				logs.enable(LogType.PROFILER, Level.ALL);
				logs.enable(LogType.SERVER, Level.ALL);
				capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
				System.setProperty("webdriver.gecko.driver", path.getAbsolutePath() + "\\geckodriver.exe");
				TestDriver.driver = new FirefoxDriver(capabilities);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (browser.equalsIgnoreCase("chrome")) {
			try{

				new DesiredCapabilities();
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--test-type");
				options.addArguments("--no-sandbox");
				options.addArguments("disable-infobars");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				LoggingPreferences logs = new LoggingPreferences();
				logs.enable(LogType.BROWSER, Level.ALL);
				logs.enable(LogType.CLIENT, Level.ALL);
				logs.enable(LogType.DRIVER, Level.INFO);
				logs.enable(LogType.PERFORMANCE, Level.ALL);
				logs.enable(LogType.PROFILER, Level.ALL);
				logs.enable(LogType.SERVER, Level.ALL);
				capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
				System.setProperty("webdriver.chrome.driver", path.getAbsolutePath() + "\\chromedriver.exe");
				TestDriver.driver = new ChromeDriver(capabilities);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (browser.equalsIgnoreCase("internetexplorer") || browser.equalsIgnoreCase("IE")) {
			try {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
				capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				LoggingPreferences logs = new LoggingPreferences();
				logs.enable(LogType.BROWSER, Level.ALL);
				logs.enable(LogType.CLIENT, Level.ALL);
				logs.enable(LogType.DRIVER, Level.INFO);
				logs.enable(LogType.PERFORMANCE, Level.ALL);
				logs.enable(LogType.PROFILER, Level.ALL);
				logs.enable(LogType.SERVER, Level.ALL);
				capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
				capabilities.setJavascriptEnabled(true);
				System.setProperty("webdriver.ie.driver", path.getAbsolutePath() + "\\IEDriverServer.exe");
				TestDriver.driver = new InternetExplorerDriver(capabilities);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
