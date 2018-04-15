/**
 * TestNG class which gets called for every test case. 
 * This is the driver class which runs for each test case. 
 * It reads the corresponding testdata from the input sheet and runs the actual test method 
 * and writes back the test results to the output sheet.
 * 
 */

package com.perficient.core;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.perficient.util.BrowserUtilities;
import com.perficient.util.CommonUtilities;
import com.perficient.util.EmbeddingImageInExcel;
import com.perficient.util.ExtentManager;
import com.perficient.util.IOUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class TestDriver extends CommonUtilities {

	public static LinkedHashMap<String, String> parameters;
	public static String outputExcelFileName;
	public static LinkedList<LinkedHashMap<String, String>> results = new LinkedList<LinkedHashMap<String, String>>();
	public static LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Properties props;
	public static int intIterationSize;
	public static Capabilities cap;
	public static String ClassName;

	// BeforeSuite sets up the configuration file and sets up the excel & html
	// output files
	@BeforeSuite(alwaysRun = true)
	public void suiteSetup(ITestContext ctr) throws IOException {
		File configFile = new File("src/test/java/com/perficient/core/user_config.properties");
		FileReader reader = new FileReader(configFile);
		props = new Properties();
		// load the properties file:
		props.load(reader);
		// Setup Excel Output file
		outputExcelFileName = IOUtil.setupExcelOutput();
		// Setup Extent HTML report
		extent = ExtentManager.Instance();
	}

	@BeforeTest(alwaysRun = true)
	@Parameters({ "browsers" })
	public void setup(String browser) {
		BrowserUtilities.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeMethod(alwaysRun = true)
	public void InitializeTestIteration(Method result) {
		ClassName = this.getClass().getSimpleName();
		Capabilities cap = ((RemoteWebDriver) TestDriver.driver).getCapabilities();
		parameters = IOUtil.getInputData(result.getName());
		parameters.put("browser_version", cap.getBrowserName().toString() + " " + cap.getVersion().toString());
		test = extent.startTest(parameters.get("TC_Name") + " [" + cap.getBrowserName().toString() + "]",
				parameters.get("TC_Description"));

	}

	@AfterMethod(alwaysRun = true)
	public void closeExtent() {
		extent.endTest(test);
		parameters.clear();
	}

	@AfterClass(alwaysRun = true)
	public void excelPrint() throws InterruptedException {
		IOUtil.writeExcelOutput(outputExcelFileName, parameters, results, ClassName);
		results.clear();
	}

	@AfterTest(alwaysRun = true)
	public void teardown() {

		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void flush() {
		// ****For pasting screenshot as Image
		//PasteImageInExcel.ImageInExcel(outputExcelFileName);
		// ****For pasting screenshot as Embedded Image
		EmbeddingImageInExcel.embeddingImage(outputExcelFileName);
		extent.flush();
		extent.close();
	}
}
