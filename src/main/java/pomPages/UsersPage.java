package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage {
	//Declaration
	@FindBy(xpath = "//h1[normalize-space(text(())='users']")
	private WebElement pageHeader1;
		@FindBy(xpath = "//[text()='new,]")
	private WebElement newButton;
		
	//Intiatialization
	public Userspage(WebDriver driver ) {
		pageFactor.intiElements(driver,this);
	}
	//utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	public String getPageHeader() {
		return pageHeader1.getText();
	}
	public void clicknewButton()
	{
		newButton.click();
	}

}
