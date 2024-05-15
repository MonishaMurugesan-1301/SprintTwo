package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registry {
	
	@FindBy(xpath="//input[@data-action-type='DISMISS']")
	WebElement delivery;
	
	@FindBy(xpath="//a[@href='/gp/browse.html?node=16115931011&ref_=nav_cs_registry']")
	WebElement Registry;
	
	//@FindBy(xpath="//input[@class='gr-text gr-text--sm gr-text--tertiary gr-find-stripe__name']")
	@FindBy(xpath="//input[@name='name']")
	WebElement Registrantname;
	
	@FindBy(xpath="//span[@class='a-dropdown-prompt']")
	WebElement giftlisttype;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	WebElement Search;
	
	public void enterdelivery()
    {
		delivery.click();
    }
	public void enterRegistry()
    {
		 Registry.click();
    }
	
	 public void enterRegistrantname()
    {
		 Registrantname.sendKeys("Monisha");
    }
    public void entergiftlisttype()
    {
    	 giftlisttype.click();
    }
    public void enterSearch()
    {
    	Search.click();
    }


}
