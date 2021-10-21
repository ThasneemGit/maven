package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	
	public void posLogin()
	{
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver,5);
		
		driver.get("http://magento.com");
		driver.findElement(By.cssSelector("li[id='gnav_557_1'] a[id='gnav_565']")).click();
		driver.findElement(By.id("register")).click();
		//driver.findElement(By.xpath("//input[starts-with(@id,'register')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname"))).click();
		//driver.findElement(By.id("firstname")).click();
		driver.findElement(By.id("firstname")).sendKeys("thasneem");
		driver.findElement(By.id("lastname")).sendKeys("soofie");
		driver.findElement(By.id("email_address")).sendKeys("itsmeneem@gmail.com");
		driver.findElement(By.id("self_defined_company")).sendKeys("YesM");
		driver.findElement(By.id("password")).sendKeys("welcome");
		driver.findElement(By.id("password-confirmation")).sendKeys("welcome");
		Select s=new Select(driver.findElement(By.id("company_type")));
		s.selectByIndex(3);
		Select s1=new Select(driver.findElement(By.id("individual_role")));
		s1.selectByValue("technical/developer");
		Select s3= new Select(driver.findElement(By.id("country")));
		s3.selectByVisibleText("United Arab Emirates");
		
		//System.out.println(w.isDisplayed());
		driver.switchTo().frame(driver.findElement(By.cssSelector("[title='reCAPTCHA']")));
		driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click();
		//driver.navigate().back();
		driver.switchTo().defaultContent();
		
		WebElement w=driver.findElement(By.id("agree_terms"));
	driver.findElement(By.id("agree_terms")).click();
		
	}
	}
