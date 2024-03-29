package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageElements.CategoryProducts;
import pageElements.ContactForm;
import pageElements.LoginUser;
import pageElements.PlaceOrderPage;
import pageElements.ProductDelete;
import pageElements.Productpage;
import pageElements.Recommendeditems;
import pageElements.RegisterUser;
import pageElements.Scrollupdown_funtionality;
import pageElements.Subscription;
import pageElements.TestCasePage;
import pageElements.VerifyProducts;

public class AutomationTestCase {

	WebDriver driver;
	RegisterUser ru;
	LoginUser lu;
	ContactForm cf;
	TestCasePage tc;
	Productpage pp;
	Subscription sc;
	PlaceOrderPage pc;
	ProductDelete pd;
	CategoryProducts cp;
	VerifyProducts vp;
	Recommendeditems rt;
	Scrollupdown_funtionality sf;

	@BeforeTest
	public void setup() throws IOException {
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);

		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File("./Extensions/AdBlock.crx"));
			
			driver = new ChromeDriver(options); // intializing
		} 
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void resgistrationpage_testcase() throws IOException {
		System.out.println("Excuting Test Case 1");
		ru = new RegisterUser(driver);
		ru.homepagevisibiblity();
		ru.userregister();
		System.out.println("Test case 1 executed successfully.");
	}


	@Test(priority = 2) 
	public void loginuser_with_correct_crendials() throws IOException {
		System.out.println("Excuting Test Case 2"); 
		lu = new LoginUser(driver); 
		lu.loginWithCorrectCred(); 
	}

	@Test(priority = 3) 
	public void loginuser_with_incorrect_crendials() throws IOException { 
		System.out.println("Excuting Test Case 3"); 
		lu = new LoginUser(driver); 
		lu.loginWithInCorrectCred(); 
	}

	@Test(priority = 4) 
	public void logout_user() throws IOException {
		System.out.println("Excuting Test Case 4"); 
		lu = new LoginUser(driver);
		lu.logoutUser(); 
	}

	@Test(priority = 5) 
	public void registeruser_with_existingmail() throws IOException { 
		System.out.println("Excuting Test Case 5"); 
		ru = new RegisterUser(driver); 
		ru.existinguser(); 
	}

	@Test(priority = 6) 
	public void contactus_form() throws IOException {
		System.out.println("Excuting Test Case 6"); 
		cf = new ContactForm(driver);
		cf.contactform(); 
	}

	@Test(priority = 7) 
	public void verify_testcases_page() throws IOException {
		System.out.println("Excuting Test Case 7"); 
		tc = new TestCasePage(driver);
		tc.TestCasestest(); 
	}

	@Test(priority = 8) 
	public void verify_allproducts_productdetailspage() throws IOException { 
		System.out.println("Excuting Test Case 8"); 
		pp = new Productpage(driver); 
		pp.productdetailspage(); 
	}

	@Test(priority = 9) 
	public void search_product() throws IOException {
		System.out.println("Excuting Test Case 9"); 
		pp = new Productpage(driver);
		pp.searchproduct(); 
	}

	@Test(priority = 10) 
	public void verify_subscription_in_homepage() throws IOException { 
		System.out.println("Excuting Test Case 10"); 
		sc = new Subscription(driver); 
		sc.homepage_subscription(); 
	}

	@Test(priority = 11) 
	public void verify_subscription_in_cartpage() throws IOException { 
		System.out.println("Excuting Test Case 11"); 
		sc = new Subscription(driver); 
		sc.cartpage_subscription(); 
	}

	@Test(priority = 12) 
	public void add_products_incart() throws IOException {
		System.out.println("Excuting Test Case 12"); 
		pp = new Productpage(driver);
		pp.addproducts(); 
	}

	@Test(priority = 13) 
	public void verify_product_quantity_in_cart() throws IOException { 
		System.out.println("Excuting Test Case 13"); 
		vp = new VerifyProducts(driver);
		vp.verifyProdQuantity(); 
	}

	@Test(priority = 14) 
	public void Place_Order_Register_while_Checkout() throws IOException { 
		System.out.println("Excuting Test Case 14"); 
		pc = new PlaceOrderPage(driver); 
		pc.register_whilecheckout(); 
	}

	@Test(priority = 15) 
	public void Place_Order_Register_before_Checkout() throws IOException { 
		System.out.println("Excuting Test Case 15"); 
		pc = new PlaceOrderPage(driver); 
		pc.register_beforecheckout(); 
	}

	@Test(priority = 16) 
	public void Place_Order_login_before_Checkout() throws IOException { 
		System.out.println("Excuting Test Case 16"); 
		pc = new PlaceOrderPage(driver); 
		pc.login_beforecheckout(); 
	}

	@Test(priority = 17) 
	public void remove_product_from_cart() throws IOException { 
		System.out.println("Excuting Test Case 17"); 
		pd = new ProductDelete(driver); 
		pd.productdelete(); 
	}

	@Test(priority = 18) 
	public void view_category_products() throws IOException { 
		System.out.println("Excuting Test Case 18"); 
		cp = new CategoryProducts(driver); 
		cp.categoryproduct(); 
	}

	@Test(priority = 19) 
	public void view_and_cart_brand_products() throws IOException { 
		System.out.println("Excuting Test Case 19"); 
		cp = new CategoryProducts(driver); 
		cp.view_and_cartproducts(); 
	}

	@Test(priority = 20) 
	public void prod_search_verify_cart_afterlogin() throws IOException { 
		System.out.println("Excuting Test Case 20"); 
		vp = new VerifyProducts(driver); 
		vp.prodsearch_verify_cartafterlogin(); 
	}

	@Test(priority = 21) 
	public void add_review_in_product() throws IOException {
		System.out.println("Excuting Test Case 21"); 
		vp = new VerifyProducts(driver);
		vp.addreview(); 
	}

	@Test(priority = 22) 
	public void add_tocart_from_recommandeditems() throws IOException { 
		System.out.println("Excuting Test Case 22"); 
		rt = new Recommendeditems(driver); 
		rt.add_recommeneditems(); 
	}

	@Test(priority = 23) 
	public void verify_address_details_in_checkoutpage() throws IOException { 
		System.out.println("Excuting Test Case 23"); 
		pc = new PlaceOrderPage(driver); 
		pc.addressdetails_verify(); 
	}


	@Test(priority = 24) 
	public void download_invoice_after_purchase_order() throws IOException { 
		System.out.println("Excuting Test Case 24"); 
		pc = new PlaceOrderPage(driver); 
		pc.downloadinvoice(); 
	}

	@Test(priority = 25) 
	public void scroll_up_and_down_using_arrowbutton() throws IOException { 
		System.out.println("Excuting Test Case 25"); 
		sf = new Scrollupdown_funtionality(driver); 
		sf.scrollupdown_usingarrow(); 
	}

	@Test(priority = 26) 
	public void scroll_up_and_down_withour_using_arrowbutton() throws IOException {
		System.out.println("Excuting Test Case 26"); 
		sf = new Scrollupdown_funtionality(driver); 
		sf.scrollupdown_withoutusingarrow(); 
	}

	@AfterSuite
	public void closeBrowser() throws IOException {
		driver.quit();
	}
}



