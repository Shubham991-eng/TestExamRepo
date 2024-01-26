package RegressionTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class SDSWebsiteAutomation {
	
	
	public static void main(String[] args) {
      
        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
        	
        	
            // 1. Homepage Verification (Here I am launching the browser and accepting the cookies warning
        	
            driver.get("https://www.s-d-s.co.uk");
            driver.manage().window().maximize();
            verifyTitleAndURL(driver, "SDS Website", "https://www.s-d-s.co.uk");
        	clickOnGotItButton(driver, "GOT IT");
            
          

            // 2. Navigation Test
        	
            navigateToSection(driver, "menu-item-77085");
            verifyTitleAndURL(driver, "Products - SDS Website", "https://www.s-d-s.co.uk/products");
            
            navigateToSection(driver, "menu-item-76684");
            verifyTitleAndURL(driver, "Consultancy - SDS Website", "https://www.s-d-s.co.uk/consultancy");
            
            navigateToSection(driver, "menu-item-77146");
            verifyTitleAndURL(driver, "Consultancy - SDS Website", "https://www.s-d-s.co.uk/consultancy");
            
            navigateToSection(driver, "menu-item-77155");
            verifyTitleAndURL(driver, "Consultancy - SDS Website", "https://www.s-d-s.co.uk/consultancy");
            
            navigateToSection(driver, "menu-item-78438");
            verifyTitleAndURL(driver, "Consultancy - SDS Website", "https://www.s-d-s.co.uk/consultancy");
            clickOnGotItButton(driver, "GOT IT");
            
            navigateToSection(driver, "menu-item-83988");
            verifyTitleAndURL(driver, "Consultancy - SDS Website", "https://www.s-d-s.co.uk/consultancy");
            
            navigateToSection(driver, "menu-item-75311");
            verifyTitleAndURL(driver, "Consultancy - SDS Website", "https://www.s-d-s.co.uk/consultancy");
            

            // 3. Product Information Test
            
            //Selecting Landval option from dropdown and validating text on the page
            
            selectProduct(driver, "menu-item-77085", "menu-item-76509");
            //Verifying that the content displayed on this page is matching with expected one.
            verifyProductInformation(driver, "Consultancy - SDS Website", "Competitive Land Valuation");

            // 4. Contact Form Test
            
            // Here I am entering text in the contact form fields
            navigateToSection(driver, "menu-item-75311");
            fillContactForm(driver, "Shubham", "Sonwane", "TestCompany", "1234567890", "Shubham@gmail.com");

            
        } finally {
            // Close the browser -> I have uncommented below line so that you can see the automation smoothly else it will close the browser fast
           // driver.quit();
        }
    }

	// This method is created to verify title and URL on every page.
    private static void verifyTitleAndURL(WebDriver driver, String expectedTitle, String expectedURL) {
        String actualTitle = driver.getTitle();
        String actualURL = driver.getCurrentUrl();

        assert actualTitle.equals(expectedTitle) : "Title mismatch: Expected - " + expectedTitle + ", Actual - " + actualTitle;
        assert actualURL.equals(expectedURL) : "URL mismatch: Expected - " + expectedURL + ", Actual - " + actualURL;
    }

    //This is common method created to navigate on every page.
    private static void navigateToSection(WebDriver driver, String section) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        WebElement sectionLink = wait.until(ExpectedConditions.elementToBeClickable(By.id(section)));
       // WebElement sectionLink = driver.findElement(By.id(section));
        sectionLink.click();
    	
 
    }
    
    //This method is created to handle to cookies request on every page
    private static void clickOnGotItButton(WebDriver driver, String element) {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement gotItButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(element)));
        gotItButton.click();
    
    }

    //This method is used to select the product from dropdown
    private static void selectProduct(WebDriver driver, String dropdown, String product) {
    	WebElement sectionLink = driver.findElement(By.id("menu-item-77085"));    	
    	Actions act = new Actions(driver);
    	act.moveToElement(sectionLink).perform();
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.id(product)));
        productLink.click();
    }

    //This methos is created to verify the product details like product text and also verifying the page title
    private static void verifyProductInformation(WebDriver driver, String expectedTitle, String expectedText) {
    	String actualTitle = driver.getTitle();
    	String actualText = driver.findElement(By.xpath("//h1[text()='Competitive Land Valuation']")).getText();
    	assert actualTitle.equals(expectedTitle) : "Title mismatch: Expected - " + expectedTitle + ", Actual - " + actualTitle;
    	assert actualText.equals(expectedText) : "Title mismatch: Expected - " + actualText + ", Actual - " + expectedText;
    }

    
    //This method is created for entering contact details of the user on contact page.
    private static void fillContactForm(WebDriver driver, String fname, String lname, String company, String Number, String emailId) {
    	 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight / 1.5)");

    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"First name*\"]")));
    	 element.sendKeys(fname);

        WebElement lastname = driver.findElement(By.xpath("//input[@placeholder=\"Last name*\"]"));
        lastname.sendKeys(lname);

        WebElement companyName = driver.findElement(By.xpath("//input[@placeholder=\"Company name*\"]"));
        companyName.sendKeys(company);
        
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@placeholder=\"phonenumber*\"]"));
        companyName.sendKeys(Number);
        
        WebElement email = driver.findElement(By.xpath("//input[@placeholder=\"email-address*\"]"));
        companyName.sendKeys(emailId);
        
        
    }
	
}
