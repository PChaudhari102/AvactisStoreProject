package com.avactisstore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.avactisstore.actiondriver.Action;
import com.avactisstore.utility.ExtentManager;




public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	@BeforeSuite
	public void loadconfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void launchApp() {
		//WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");
		if (browserName.contains("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*"); 
	 
	driver = new ChromeDriver(options);
			// Set Browser to ThreadLocalMap
			//driver.set(new ChromeDriver());
		} else if (browserName.contains("FireFox")) {
			driver=new FirefoxDriver();
			//WebDriverManager.firefoxdriver().setup();
			//driver.set(new FirefoxDriver());
		} else if (browserName.contains("Edge")) {
		//	driver=new EdgeDriver();
			//WebDriverManager.iedriver().setup();
			//driver.set(new InternetExplorerDriver());
		}
		//Maximize the screen
		driver.manage().window().maximize();
		//Delete all the cookies
		driver.manage().deleteAllCookies();
		//Implicit TimeOuts
		//driver.manage().timeouts().implicitlyWait
		//(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
		//PageLoad TimeOuts
		Action.pageLoadTimeOut(driver, 30);
		//getDriver().manage().timeouts().pageLoadTimeout
		//(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		//Launching the URL
		
		//driver.get(prop.getProperty("url"));
		//driver.get(prop.getProperty("AdminUrl"));
	}
	
	public static void adminLaunchApp() {
	//	WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");
		if (browserName.contains("Chrome")) {
			driver=new ChromeDriver();
			// Set Browser to ThreadLocalMap
			//driver.set(new ChromeDriver());
		} else if (browserName.contains("FireFox")) {
			driver=new FirefoxDriver();
			//WebDriverManager.firefoxdriver().setup();
			//driver.set(new FirefoxDriver());
		} else if (browserName.contains("Edge")) {
			//driver=new EdgeDriver();
			//WebDriverManager.iedriver().setup();
			//driver.set(new InternetExplorerDriver());
		}
		//Maximize the screen
		driver.manage().window().maximize();
		//Delete all the cookies
		driver.manage().deleteAllCookies();
		//Implicit TimeOuts
		//driver.manage().timeouts().implicitlyWait
		//(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
		//PageLoad TimeOuts
		Action.pageLoadTimeOut(driver, 30);
		//getDriver().manage().timeouts().pageLoadTimeout
		//(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		
		
		//Launching the URL
		//driver.get(prop.getProperty("AdminUrl"));
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
