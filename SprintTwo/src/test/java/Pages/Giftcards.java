package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Giftcards {

	
	@FindBy(xpath="//input[@data-action-type='DISMISS']")
	WebElement delivery;
	
	@FindBy(xpath="//a[@href='/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc']")
	WebElement Giftcards;
	
//	@FindBy(xpath="//img[@src='https://images-na.ssl-images-amazon.com/images/G/01/gift-certificates/consumer/2021/GCLP/Support/2x/Occ_VD_346x130.png']")
//	WebElement ValentinesDay;
//	
//	@FindBy(xpath="//img[@src='https://m.media-amazon.com/images/G/01/DiscoTec/2023/ValentinesDay/LandingPage/Bubbler/bubber_kids._SS640_QL85_.jpg']")
//	WebElement LoveForKids;
//	
	@FindBy(xpath="//a[text()='Specialty Gift Cards'] ")
	WebElement SpecialtyGiftCards;
	
	@FindBy(xpath="(//span[text()='Sephora eGift Card'])[2]")
	WebElement SEPHORA;
	
	public void enterdelivery()
    {
		delivery.click();
    }
	public void enterGiftcards()
    {
		Giftcards.click();
    }
	
//	 public void enterValentinesDay()
//    {
//		 ValentinesDay.click();
//    }
//    public void enterLoveForKids()
//    {
//    	LoveForKids.click();
//    }
     public void enterSpecialtyGiftCards()
     {
    	 SpecialtyGiftCards.click();
     }
     public void enterSEPHORA()
     {
    	 SEPHORA.click();
     }
}
