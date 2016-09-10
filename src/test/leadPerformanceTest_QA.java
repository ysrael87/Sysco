package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectClass.CandidateInformationInput;
import objectClass.HomePage;
import objectClass.candidateCardPage;
import objectClass.careersPage;
import objectClass.leadAutomationTestDeveloperJobDescriptionPage;
import objectClass.searchJobsPage;

public class leadPerformanceTest_QA {
	static WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void initDriver() {
		driver = new FirefoxDriver();
		baseUrl = "http://www.sysco.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	
	@Test
	public void test() {
			driver.get(baseUrl);
			
			HomePage homepage = new HomePage();
			homepage.careersButton(driver);
			careersPage careerspage = new careersPage();
			careerspage.textJobSearch(driver, "Lead Performance Test- QA");
			careerspage.clickSeachButton(driver);
			searchJobsPage searchjobspage= new searchJobsPage();
			searchjobspage.clickLeadAutomationTestDeveloper(driver);
			leadAutomationTestDeveloperJobDescriptionPage leadautomationtestdeveloper = new leadAutomationTestDeveloperJobDescriptionPage();
			leadautomationtestdeveloper.applyNowdleadAutomationTestDeveloper(driver);
			CandidateInformationInput candidateinformationinput = new CandidateInformationInput();
			candidateinformationinput.firstName(driver, "Susan");
			candidateinformationinput.lastName(driver, "Doe");
			candidateinformationinput.email(driver, "SusanDoe@doesnotexist.com");
			candidateinformationinput.state(driver, "TX");
			candidateinformationinput.zipcode(driver, "77077");
			candidateinformationinput.primaryTelephoneNumber(driver, "8329999999");
			candidateinformationinput.TextMessageOptInButtonNo(driver);
			candidateinformationinput.mobileCarrier(driver, "Verizon");
			candidateinformationinput.AreYouCurrently21YearsOfAgeYes(driver);
			candidateinformationinput.LicenseTypeHeldDropDown(driver);
			candidateinformationinput.totalMonthsOfDrivingExperience(driver, "120");
			candidateinformationinput.NextButton(driver);
			candidateCardPage candidatecardpage = new candidateCardPage();
			candidatecardpage.pageCheck(driver);
			System.out.println("Scenario2 testcase successful");
	}
}


