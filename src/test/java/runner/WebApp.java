package runner;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.mindtree.manager.PageObjectManager;
import com.mindtree.reusable.BaseTest;

import pageobject.AboutUsPage;
import pageobject.AirportPage;
import pageobject.ContactUsPage;
import pageobject.CorporateCarRentalPage;
import pageobject.Homepage;
import pageobject.LocalPage;
import pageobject.OneWayPage;
import pageobject.OutstationPage;
import utility.ExcelSheetRead;
import utility.ExtentReporterNG;
import utility.Logs;


public class WebApp extends BaseTest {
	static PageObjectManager pageManager;
	static Homepage homepage;
	static ContactUsPage contactpage;
	static AboutUsPage aboutpage;
	static CorporateCarRentalPage corporatepage;
	static OneWayPage onewaypage;
	static AirportPage airportpage;
	static OutstationPage outstationpage;
	static LocalPage localpage;
	static Logs loggerUtil;
	static Logger log;
	static ExcelSheetRead ex;
	static ExtentReports extent = ExtentReporterNG.extentReportGenerator();
	static String screenshotPath = null;

	@BeforeMethod
	public void Before() throws IOException {
		startUp();
		ex = new ExcelSheetRead(); 
	}

	@Test(priority = 1)
	public static void HomePage() throws IOException, InterruptedException {
		try {
			test = extent.createTest("HomePage");
			test.log(Status.PASS, "TestCase Execution Started");
			loggerUtil = new Logs();
			loggerUtil = new Logs();
			log = loggerUtil.createLog("HomePage");
			pageManager = new PageObjectManager();
			homepage = pageManager.getHomePage();
			String ExpectedTitle = ex.read("HomepageTitle");
			homepage.ValidateTitle(ExpectedTitle);
			test.log(Status.PASS, "Successful");
			screenshotPath = getscreenshotpath("HomePage");
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("HomePage");
			test.fail("HomePage test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.log(Status.FAIL, "UnSuccessful");
		}
	}

	@Test(priority = 2)
	public static void SignUp() throws IOException, InterruptedException {
		try {
			test = extent.createTest("SignUp");//df
			test.log(Status.PASS, "TestCase Execution Started");//ff
			loggerUtil = new Logs();
			log = loggerUtil.createLog("SignUp");
			pageManager = new PageObjectManager();
			String Name = ex.read("Name");
			String Phone = ex.read("Phone");
			String Email = ex.read("Email");
			String Password = ex.read("Password");
			String RePassword = ex.read("RePassword");
			homepage.SignUp(Name, Phone, Email, Password, RePassword);
			test.log(Status.PASS, "Successful");//df
			screenshotPath = getscreenshotpath("SignUp");//df
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("SignUp");//df
			test.fail("SignUp test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "UnSuccessful");//df
		}
	}

	@Test(priority = 3)
	public static void HomepageLogin() throws IOException, InterruptedException {
		try {
			test = extent.createTest("HomepageLogin");//df
			test.log(Status.PASS, "TestCase Execution Started");//ff
			loggerUtil = new Logs();
			log = loggerUtil.createLog("HomepageLogin");
			pageManager = new PageObjectManager();
			String Email = ex.read("Email");
			String Password = ex.read("Password");
			homepage.Login(Email, Password);
			test.log(Status.PASS, "Successful");//df
			screenshotPath = getscreenshotpath("HomepageLogin");//df
			
		} catch (Exception e) {
		
		screenshotPath = getscreenshotpath("HomepageLogin");//df
			test.fail("HomepageLogin test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "UnSuccessful");//df
			
		}
	}

	@Test(priority = 4)
	public static void AboutPage() throws IOException, InterruptedException {
		try {
		     
		     test = extent.createTest("AboutPage");//df
			test.log(Status.PASS, "TestCase Execution Started");//ff
			loggerUtil = new Logs();
			log = loggerUtil.createLog("AboutPage");
			pageManager = new PageObjectManager();
			aboutpage = pageManager.getAboutUsPage();
			aboutpage.ClickOnAbout();
			aboutpage.Switchtab(1);
			String Expected = ex.read("CEO");
			aboutpage.Validate(Expected);
			test.log(Status.PASS, "Successful");//df
			screenshotPath = getscreenshotpath("AboutPage");//df
		} catch (Exception e) {
		
		screenshotPath = getscreenshotpath("AboutPage");//df
			test.fail("AboutPage test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "UnSuccessful");//df
			
		}
	}

	@Test(priority = 5)
	public static void ContactPage() throws IOException, InterruptedException {
		try {
			
			test = extent.createTest("ContactPage");//df
			test.log(Status.PASS, "TestCase Execution Started");//ff
			loggerUtil = new Logs();
			log = loggerUtil.createLog("ContactPage");
			pageManager = new PageObjectManager();
			contactpage = pageManager.getContactUsPage();
			contactpage.ClickOnContactUs();
			contactpage.Switchtab(1);
			String Contact = ex.read("Contact");
			contactpage.Validate(Contact);
			test.log(Status.PASS, "Successful");//df
			screenshotPath = getscreenshotpath("ContactPage");//df
			
		} catch (Exception e) {
		
		screenshotPath = getscreenshotpath("ContactPage");//df
			test.fail("ContactPage test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "UnSuccessful");//df
			
		}

	}

	@Test(priority = 6)
	public static void OnewayPage() throws IOException, InterruptedException {
		try {
			
				test = extent.createTest("OnewayPage");//df
			test.log(Status.PASS, "TestCase Execution Started");//ff
			loggerUtil = new Logs();
			log = loggerUtil.createLog("OnewayPage");
			pageManager = new PageObjectManager();
			onewaypage = pageManager.getOneWayPage();
			onewaypage.ClickOnOneWay();
			onewaypage.Switchtab(1);
			onewaypage.SelectAgra();
			onewaypage.SelectPlace();
			onewaypage.Switchtab(2);
			String Expected = ex.read("OneWay");
			onewaypage.ValidatePage(Expected);
			test.log(Status.PASS, "Successful");//df
			screenshotPath = getscreenshotpath("OnewayPage");//df
			
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("OnewayPage");//df
			test.fail("OnewayPage test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "UnSuccessful");//df
		}
	}

	@Test(priority = 7)
	public static void LocalPage() throws IOException, InterruptedException {
		try {
			test = extent.createTest("LocalPage");//df
			test.log(Status.PASS, "TestCase Execution Started");//ff
			loggerUtil = new Logs();
			log = loggerUtil.createLog("LocalPage");
			pageManager = new PageObjectManager();
			localpage = pageManager.getLocalPage();

			localpage.ClickOnLocal();
			localpage.Switchtab(1);

			String Source = ex.read("Source");
			String Month = ex.read("Month");
			String Date = ex.read("Date").replace(".0", "");
			String Time = ex.read("Time");
			String CarType = ex.read("CarType");

			localpage.SelectSrc(Source);
			localpage.SelectDate(Month, Date);
			localpage.SelectPickuptime(Time);
			localpage.ClickOnSearchCar();
			localpage.SelectFirstCar();
			localpage.ValidateCarDetails(CarType);
			test.log(Status.PASS, "Successful");//df
			screenshotPath = getscreenshotpath("LocalPage");//df
			
		} catch (Exception e) {
		screenshotPath = getscreenshotpath("LocalPage");//df
			test.fail("LocalPage test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "UnSuccessful");//df
			
		}
	}

	@Test(priority = 8)
	public static void OutstationPage() throws IOException, InterruptedException {
		try {
			test = extent.createTest("OutstationPage");//df
			test.log(Status.PASS, "TestCase Execution Started");//ff
			loggerUtil = new Logs();
			log = loggerUtil.createLog("OutstationPage");
			pageManager = new PageObjectManager();
			String Source = ex.read("Source");
			String Destination = ex.read("Destination");
			String Month = ex.read("Month");
			String Date = ex.read("Date").replace(".0", "");
			String Time = ex.read("Time");
			String Outprice = ex.read("Outprice");

			outstationpage = pageManager.getOutstationPage();
			outstationpage.SelectSrc(Source);
			outstationpage.SelectDest(Destination);
			outstationpage.SelectDate(Month, Date);
			outstationpage.SelectPickuptime(Time);
			outstationpage.ClickOnSearchCar();
			outstationpage.SelectFirstCar();
			outstationpage.ValidateCarDetails(Outprice);
			test.log(Status.PASS, "Successful");//df
			screenshotPath = getscreenshotpath("OutstationPage");//df
			
			} catch (Exception e) {
			screenshotPath = getscreenshotpath("OutstationPage");//df
			test.fail("OutstationPage test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "UnSuccessful");//df
			
		}

	}

	@Test(priority = 9)
	public static void AirportPage() throws IOException, InterruptedException {
		try {
			test = extent.createTest("AirportPage");//df
			test.log(Status.PASS, "TestCase Execution Started");//ff
			loggerUtil = new Logs();
			log = loggerUtil.createLog("AirportPage");
			pageManager = new PageObjectManager();

			String Source = ex.read("Source");
			String AirportDest = ex.read("AirportDest");
			String Month = ex.read("Month");
			String Date = ex.read("Date").replace(".0", "");
			String Time = ex.read("Time");
			String Outprice = ex.read("Outprice");

			airportpage = pageManager.getAirportPage();
			airportpage.ClickOnAirport();
			airportpage.Switchtab(1);
			airportpage.SelectSrc(Source);
			airportpage.SelectTripType();
			airportpage.SelectDest(AirportDest);
			airportpage.SelectDate(Month, Date);
			airportpage.SelectPickuptime(Time);
			airportpage.ClickOnSearchCar();
			airportpage.SelectFirstCar();
			airportpage.ValidateCarDetails(Outprice);
			test.log(Status.PASS, "Successful");//df
			screenshotPath = getscreenshotpath("AirportPage");//df
			
		} catch (Exception e) {
		screenshotPath = getscreenshotpath("AirportPage");//df
			test.fail("AirportPage test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "UnSuccessful");//df
		
		}

	}

	@Test(priority = 10)
	public static void CorporatePage() throws IOException, InterruptedException {
		try {
			test = extent.createTest("CorporatePage");//df
			test.log(Status.PASS, "TestCase Execution Started");//ff
			loggerUtil = new Logs();
			log = loggerUtil.createLog("CorporatePage");
			pageManager = new PageObjectManager();

			String Name = ex.read("Name");
			String Phone = ex.read("Phone");
			String Email = ex.read("Email");
			String Company = ex.read("Company");
			String Req = ex.read("Req");

			corporatepage = pageManager.getCorporateCarRentalPage();
			corporatepage.ClickOnCorporateCarRental();
			corporatepage.Switchtab(1);
			corporatepage.EnterName(Name);
			corporatepage.EnterCompany(Company);
			corporatepage.EnterEmail(Email);
			corporatepage.EnterPhoneNo(Phone);
			corporatepage.SelectRentalReq(Req);
			corporatepage.ClickSubmit();
			corporatepage.ValidateMSG();
			test.log(Status.PASS, "Successful");//df
			screenshotPath = getscreenshotpath("CorporatePage");//df
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("CorporatePage");//df
			test.fail("CorporatePage test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "UnSuccessful");//df
		}
	}

	@AfterMethod
	public void After() {
		tearDown();
	}
	@AfterSuite()
	public void flush() {
		extent.flush();
	}
	

}
