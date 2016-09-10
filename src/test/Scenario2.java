package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Scenario2 {
	static WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void initDriver() {
		driver = new FirefoxDriver();
		baseUrl = "http://www.sysco.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void ScenarioTwo() {
		driver.get(baseUrl);
		driver.findElement(By.xpath(".//*[@id='item5']/a")).click();
		// String careersTitle = driver.getTitle();
		// System.out.println(careersTitle);

		// searching and clicking for lead automation test developer
		driver.findElement(By.className("search-keyword")).sendKeys("Lead Performance Test- QA");
		// driver.findElement(By.id("search-keyword-1a4b353967")).sendKeys("Lead
		// Automation Test Developer");
		driver.findElement(By.xpath("//div[@class='search-form-fields']/button")).click();

		// click lead automation test developer job
		driver.findElement(By.xpath(".//*[@id='search-results-list']//li[1]/a/h2")).click();
		// clicking apply now
		driver.findElement(By.xpath(".//*[@id='content']//section[1]/div[1]/a[1]")).click();

		driver.findElement(By.name("FirstName")).sendKeys("Susan");
		driver.findElement(By.name("LastName")).sendKeys("Doe");
		driver.findElement(By.name("EmailAddress")).sendKeys("SusanDoe@doesnotexist.com");
		driver.findElement(By.name("Region")).sendKeys("TX");
		driver.findElement(By.name("PostalCode")).sendKeys("77077");
		driver.findElement(By.name("HomePhone")).sendKeys("8329999999");

		WebElement TextMessageOptInButtonNo = driver.findElement(By.xpath("//div//fieldset[2]/p[2]/input"));
		TextMessageOptInButtonNo.click();

		driver.findElement(By.name("Skills")).sendKeys("Verizon");

		WebElement AreYouCurrently21YearsOfAgeYes = driver.findElement(By.xpath("//div//fieldset[3]/p[1]/input"));
		AreYouCurrently21YearsOfAgeYes.click();

		Select LicenseTypeHeldDropDown = new Select(driver.findElement(By.cssSelector(".form-field>select")));
		List<WebElement> options = LicenseTypeHeldDropDown.getOptions();
		int size = options.size();

		for (int i = 0; i < size; i++) {
			String optionsName = LicenseTypeHeldDropDown.getOptions().get(i).getText();
			System.out.println(optionsName);
		}

		LicenseTypeHeldDropDown.selectByValue("Regular Driver’s License");

		driver.findElement(By.xpath("//label[text()='Total Months of Driving Experience']")).sendKeys("120");

		driver.findElement(By.xpath("//div/div[2]/p[2]/input")).click();

	}

	@AfterClass
	public void quitDriver() {
		driver.quit();
	}

}
