package pageElements;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class LoginUser extends AbstractMethods{

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public LoginUser(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-lock']/parent::a")WebElement login;
	
	@FindBy(xpath = "//*[contains(text(),'Login to your account')]")WebElement loginaccount;
	
	@FindBy(xpath = "//i[@class='fa fa-lock']/parent::a")WebElement logout;
	
	@FindBy(xpath = "//*[contains(text(),' Logged in as ')]")WebElement loogedinas;
	
	@FindBy(xpath = "//i[@class='fa fa-trash-o']/parent::a")WebElement deleteaccount;
	
	@FindBy(xpath = "//*[contains(text(),'Account Deleted!')]")WebElement accountdeletedinfo;	

	@FindBy(xpath = "//*[contains(text(),'Continue')]")	WebElement Continuebutton;

	@FindBy(xpath = "//*[contains(text(),'Your email or password is incorrect!')]")WebElement errormsg;
	
	public void loginWithCorrectCred() {
		implicitlywaitmethod();
		try {
			Reusableclass rc= new Reusableclass (driver);
			//rc.urlEquals("https://automationexercise.com/");
			
			waitTillLinkIsClickable(login);
			login.click();
			
			ReusableMethods rs = new ReusableMethods(driver);
			rs.signup();
			rs.registrationpage();

			waitTillLinkIsClickable(login);
			login.click();
			waitTillLinkIsClickable(logout);
			logout.click();

			rc.innerTextEquals(loginaccount, "Login to your account");

			rs.login();
			rc.innerTextEquals(loogedinas, loogedinas.getText());
			waitTillLinkIsClickable(deleteaccount);
			deleteaccount.click();

			rc.innerTextEquals(accountdeletedinfo, "ACCOUNT DELETED!");
			
			waitTillLinkIsClickable(Continuebutton);
			Continuebutton.click();
			System.out.println("Testcase2--> executed succesfully");
		} catch (Exception e) {
			System.out.println("Exception occured in testcase 2 execution");
			e.printStackTrace();
			Assert.fail();
		}

	}

	public void loginWithInCorrectCred() {
		implicitlywaitmethod();
		try {
			Reusableclass rc= new Reusableclass (driver);
			//rc.urlEquals("https://automationexercise.com/");
			waitTillLinkIsClickable(login);
			login.click();

			rc.innerTextEquals(loginaccount, "Login to your account");

			ReusableMethods rs = new ReusableMethods(driver);
			rs.login();

			rc.innerTextEquals(errormsg, "Your email or password is incorrect!");

			System.out.println("Testcase3--> executed succesfully");
		} catch (Exception e) {
			System.out.println("Exception occured in testcase 3 execution");
			e.printStackTrace();
			Assert.fail();
		}

	}

	public void logoutUser() {
		implicitlywaitmethod();
		try {
			
			waitTillLinkIsClickable(login);
			login.click();
			ReusableMethods rs = new ReusableMethods(driver);
			rs.signup();
			rs.registrationpage();
			
			waitTillLinkIsClickable(login);
			login.click();
			waitTillLinkIsClickable(logout);
			logout.click();

			Reusableclass rc = new Reusableclass(driver);
			rc.innerTextEquals(loginaccount, "Login to your account");

			rs.login();
			rc.innerTextEquals(loogedinas, loogedinas.getText());

			waitTillLinkIsClickable(logout);
			logout.click();

			Assert.assertEquals(loginaccount.getText(), "Login to your account");

			System.out.println("Testcase4--> executed succesfully");
		} catch (Exception e) {
			System.out.println("Exception occured in testcase 4 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
}

