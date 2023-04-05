package rahulshettyacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {

	ExtentReports extentReport;

	@BeforeTest
	public void config() {
//		ExtentReports,ExtentSparkReporter 
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter setupReport = new ExtentSparkReporter(path);

		setupReport.config().setDocumentTitle("Test Results");
		setupReport.config().setReportName("Web Automation results");

		extentReport = new ExtentReports();
		extentReport.attachReporter(setupReport);
		extentReport.setSystemInfo("Tester", "Raghuvaran");
	}

	@Test
	public void initialDemo() {
		
		ExtentTest test=extentReport.createTest("Initial demo");
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/");
		
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Results do not match");
		extentReport.flush();
	}
}
