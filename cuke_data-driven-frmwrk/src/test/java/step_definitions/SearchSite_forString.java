package step_definitions;
import cucumber.api.PendingException;
import helpers.DataHelper;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SearchSite_forString {
    public WebDriver driver;

	public SearchSite_forString()
    {
    	driver = Hooks.driver;
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	Actions builder = new Actions(driver);

     	//datamap = DataHelper.data(System.getProperty("user.dir")+"//src//test//resources//testData/default.xlsx","Sheet1");
    }
	
//	@Given("^\\^I have navigated to \"(.*?)\"  for test case \"(.*?)\" Search \"(.*?)\" for \"(.*?)\"$")
	@Given("^\\^I have navigated to (.*?)  for test case (.*?) Search (.*?) for (.*?)$")
		public void i_have_navigated_to_for_test_case_Search_for(String arg1, String arg2, String arg3, String arg4) throws Throwable {
	    System.out.println(arg1+" "+arg2+" "+arg3+" "+arg4+"\n" );
	    //String site_url=arg3.toString();
	    driver.get(arg3);
	    //driver.get(site_url);
	    System.out.println(driver.getCurrentUrl());
	    System.out.println("end of test searches Given");

	    Thread.sleep(500);
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
	@And("^I am on search site \"(.*?)\"$")
	public void i_am_on_search_site(String arg1) throws Throwable {
		System.out.println("Search site is "+arg1+"\n" );
	    System.out.println("Site URL is "+driver.getCurrentUrl());
		// Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	    System.out.println("end of test searches And \n\n");
	}
	
	
	@When("^I have entered a search for \"(.*?)\"$")
	public void i_have_entered_a_search_for(String arg1) throws Throwable {
		//driver.manage().deleteAllCookies();
		System.out.println("Searched for is "+arg1);
		driver.findElement(By.name("q")).sendKeys(arg1+"\n");
		// .//*[@name='q']   Bing #sb_form_q
	    System.out.println("end of test searches When \n");
	    Thread.sleep(500);
	}

	@Then("^Verify ICD portal is the first result using locator \"(.*?)\"$")
	public void verify_ICD_portal_is_the_first_result_using_locator(String arg1) throws Throwable {
	    Thread.sleep(3000);
		//String hrefURL = driver.findElement(By.xpath(arg1)).getAttribute("href");
		// #b_results h2 > a
	    //(//*[@id="b_results"]/*//h2/a[1])[1]
		WebElement webElem = driver.findElement(By.xpath(arg1));
		String hrefURL= webElem.getAttribute("href");
        Point point = webElem.getLocation();
        int xcord = point.getX();
        int ycord = point.getY();

		System.out.println("locator string is "+arg1);
	    System.out.println("href found is "+hrefURL);
        System.out.println("positon of web element is  "+xcord+", "+ycord);

        // https://icdportal.info/about-icd
	    //Assert.assertEquals("https://icdportal.info/about-icd", hrefURL);
	    //Assert.assertSame("https://icdportal.info/about-icd", hrefURL);
	    assertThat(hrefURL, containsString("https://icdportal.info"));
	    Thread.sleep(5000);
	    webElem = driver.findElement(By.xpath(arg1));
    	//WebElement web_Element_To_Be_Hovered = webDriver.findElement(By.cssSelector(selector_For_Web_Element_To_Be_Hovered));
    	Actions builder = new Actions(driver);
    	builder.moveToElement(webElem).build().perform();
	    Thread.sleep(4000);

	    webElem.click();
	    System.out.println("Site URL is "+driver.getCurrentUrl());
	    String pageTitle = driver.getTitle();
	    System.out.println("Page Title is "+pageTitle);
	    assertThat(pageTitle, containsString("Home | ICD (Institutional Cash Distributors)"));
	    
	    System.out.println("end of test searches Then \n\n");
	    Thread.sleep(2000);
	}

	@And("^I click News Tab having searched \"(.*?)\"$")
	public void i_click_News_Tab_having_searched(String arg1) throws Throwable {
		System.out.println("Searched for "+arg1+" Clicking News Tab" );
		//Thread.sleep(10000); // needed a slight delay to allow render
		//driver.findElement(By.xpath(".//*/span[contains(@class,'spell_orig')]/a")).click();
		// .//*/span[contains(text(),'Search only for')]/a
		// .//*/span[contains(@class,'spell_orig')]/a
		// first cliking the Search Only For

		System.out.println("end of test searches Then \n\n");
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
}
