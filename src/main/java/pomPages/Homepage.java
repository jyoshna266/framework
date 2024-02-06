package pomPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
	//declaration
	@FindBy(xpath = "//a[text()=' home']")
	private WebElement pageheader;
	
	@FindBy(xpath = "//span[text()='users']")
	private WebElement usersTab;
	
	@FindBy(xpath = "//span[text()='couses']")
	private Webelement couserTab;
	
	
	

}
