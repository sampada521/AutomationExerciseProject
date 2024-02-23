package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class CategoryProducts extends AbstractMethods{

	WebDriver driver;	
	public CategoryProducts(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath = "//i[@class='fa fa-home']/parent::a")WebElement homepage;
	
	@FindBy(xpath="//div[@class='panel-group category-products']")WebElement categories;
	
	@FindBy(xpath="//*[contains(text(),'Category')]")WebElement categorytext;
	
	@FindBy(xpath="(//span[@class='badge pull-right'])[1]")WebElement women_category;
	
	@FindBy(xpath="//*[@id=\"Women\"]/div/ul/li[1]/a")WebElement dress_categorylink;
	
	@FindBy(xpath="//*[contains(text(),'Women - Dress Products')]")WebElement productlisttext;
	
	@FindBy(xpath="(//span[@class='badge pull-right'])[2]")WebElement men_category;
	
	@FindBy(xpath="//*[@id=\"Men\"]/div/ul/li[1]/a")WebElement Tshirt_categorylink;
	
	@FindBy(xpath="//*[contains(text(),'Men - Tshirts Products')]")WebElement Tshirtlisttext;
	
	@FindBy(xpath = "//i[@class='material-icons card_travel']/parent::a")WebElement product;
	
	@FindBy(xpath="//*[contains(text(),'Brands')]")WebElement brandtext;
	
	@FindBy(xpath="//div[@class='brands-name']")WebElement brands;
	
	@FindBy(xpath="//a[@href='/brand_products/Polo']")WebElement polo;
	
	@FindBy(xpath="//*[contains(text(),'Brand - Polo Products')]")WebElement pololisttext;
	
	@FindBy(xpath="//a[@href='/brand_products/Madame']")WebElement madame;
	
	@FindBy(xpath="//*[contains(text(),'Brand - Madame Products')]")WebElement madamelisttext;
	
	public void categoryproduct() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);

		try {
			Reusableclass rc = new Reusableclass(driver);
			waitTillLinkIsClickable(homepage);
			homepage.click();

			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", categorytext);
			
			rc.elementAvailable(categorytext, true);
			rc.elementAvailable(categories, true);
			waitTillLinkIsClickable(women_category);
			women_category.click();
			waitTillLinkIsClickable(dress_categorylink);
			dress_categorylink.click();
			rc.innerTextEquals(productlisttext,"WOMEN - DRESS PRODUCTS");
			
			waitTillLinkIsClickable(men_category);
			men_category.click();
			waitTillLinkIsClickable(Tshirt_categorylink);
			Tshirt_categorylink.click();
			rc.innerTextEquals(Tshirtlisttext,"MEN - TSHIRTS PRODUCTS");
			
			System.out.println("Testcase18--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase 18 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void view_and_cartproducts() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);

		try {
			Reusableclass rc = new Reusableclass(driver);
			waitTillLinkIsClickable(homepage);
			homepage.click();

			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
			waitTillLinkIsClickable(product);
			product.click();
			
			rc.elementAvailable(brandtext, true);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", brandtext);
			visibilityOfElement(brandtext);
			rc.elementAvailable(brands, true);
			
			waitTillLinkIsClickable(polo);
			polo.click();
			rc.innerTextEquals(pololisttext,"BRAND - POLO PRODUCTS");
			
			waitTillLinkIsClickable(madame);
			madame.click();
			rc.innerTextEquals(madamelisttext,"BRAND - MADAME PRODUCTS");
			
			System.out.println("Testcase19--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase 19 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
}


