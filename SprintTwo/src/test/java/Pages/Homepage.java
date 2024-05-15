package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
	
	@FindBy(xpath="//input[@data-action-type='DISMISS']")
	WebElement delivery;
	
	@FindBy(xpath="//a[@href='/gp/goldbox?ref_=nav_cs_gb']")
    WebElement Deals;
	
	@FindBy(xpath="//img[@src='https://m.media-amazon.com/images/G/01/goldbox/images/faceout/Electronics_white._CB468586680_.png']")
    WebElement Electronics;
	
	public void enterdelivery()
    {
		delivery.click();
    }
	
	 public void enterDeals()
    {
    	Deals.click();
    }
    public void enterElectronics()
    {
    	Electronics.click();
    }


}
