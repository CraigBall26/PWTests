package testPackage;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class mainTest {

	@Test
	public void theTest() throws InterruptedException
	{
		System.setProperty(Utils.Browser, Utils.BrowserLocation);
		WebDriver driver=new ChromeDriver();
		driver.get(Utils.HomeURL);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		
		//Ensures IPC link is, accessible, checks Contact Us is available and enabled on that page and Book Demo Button
		driver.findElement(By.linkText(FlowLocators.IPCText)).click();
		Assert.assertEquals(driver.getCurrentUrl(), Utils.IPCURL);
		Assert.assertEquals(true, driver.findElement(By.linkText(FlowLocators.BookDemoText)).isEnabled());
		Assert.assertEquals(true, driver.findElement(By.linkText(FlowLocators.BookDemoText)).isDisplayed());
		
		//Ensures Features link is, accessible, checks Contact Us is available and enabled on that page and Book Demo Button
		driver.findElement(By.linkText(FlowLocators.FeaturesLinkText)).click();
	    Assert.assertEquals(driver.getCurrentUrl(), Utils.FeaturesURL);
	    Assert.assertEquals(true, driver.findElement(By.linkText(FlowLocators.BookDemoText)).isEnabled());
	    Assert.assertEquals(true, driver.findElement(By.linkText(FlowLocators.BookDemoText)).isDisplayed());
	    
	    //Ensures Solutions link is enabled, accessible, clicks link and checks URL and Book Demo Button
		driver.findElement(By.linkText(FlowLocators.OurSolutionText)).click();
	    Assert.assertEquals(driver.getCurrentUrl(), Utils.OurSolutionURL);
	    Assert.assertEquals(true, driver.findElement(By.linkText(FlowLocators.BookDemoText)).isEnabled());
	    Assert.assertEquals(true, driver.findElement(By.linkText(FlowLocators.BookDemoText)).isDisplayed());
	    
	    //Ensures Resources link is enabled, accessible, clicks link and checks URL and Book Demo Button
		driver.findElement(By.linkText(FlowLocators.ResourcesText)).click();
	    Assert.assertEquals(driver.getCurrentUrl(), Utils.ResourcesURL);
	    Assert.assertEquals(true, driver.findElement(By.linkText(FlowLocators.BookDemoText)).isEnabled());
	    Assert.assertEquals(true, driver.findElement(By.linkText(FlowLocators.BookDemoText)).isDisplayed());
	    
	    //Access Contact Us and fill out form
		driver.findElement(By.id(FlowLocators.AcceptCookiesButton)).click();
	    driver.findElement(By.linkText(FlowLocators.ContactText)).click();
	    driver.findElement(By.name(FlowLocators.FirstNameField)).sendKeys(Utils.FirstName);
	    driver.findElement(By.name(FlowLocators.LastNameField)).sendKeys(Utils.LastName);
	    driver.findElement(By.name(FlowLocators.EmailField)).sendKeys(Utils.Email);
	    driver.findElement(By.name(FlowLocators.TelephoneField)).sendKeys(Utils.Telephone);
	    new Select (driver.findElement(By.name(FlowLocators.RoleField))).selectByVisibleText(Utils.RoleDropdownSelection);
	    new Select (driver.findElement(By.name(FlowLocators.SectorField))).selectByVisibleText(Utils.SectorDropdownSelection);
	    driver.findElement(By.name(FlowLocators.OrganisationField)).sendKeys(Utils.OrganisationDropdownSelection);
	    new Select (driver.findElement(By.name(FlowLocators.HowDidYouField))).selectByVisibleText(Utils.HowDidYouDropdownSelection);
	    
	    // Scrolling down the submit buttons/checkmarks are found. Try submit form and find error message.
	    WebElement Element = driver.findElement(By.xpath(FlowLocators.PhoneNumber)); 
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(1000);
        driver.findElement(By.xpath(FlowLocators.ContactSubmitCheckMark)).click();
        driver.findElement(By.xpath(FlowLocators.ContactSubmitButton)).click();
        Thread.sleep(1000);
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-350)", "");
        Thread.sleep(500);
        driver.findElement(By.xpath(FlowLocators.ErrorMessage)).click();
        driver.quit();
	}
}
