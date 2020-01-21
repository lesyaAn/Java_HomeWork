package seleniumFunctionalTesting.lieferandoTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumFunctionalTesting.PageObject;

public class OrderPage extends PageObject {
    public OrderPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(name="address")
    private WebElement address;

    @FindBy(name="surname")
    private WebElement surname;

    @FindBy(name="email")
    private WebElement email;

    @FindBy(name="phonenumber")
    private WebElement phonenumber;

    @FindBy(xpath="//*[@id=\'ipaymentmethods\']/div[2]/label/div/label[2]")
    private WebElement klarna;

    @FindBy(xpath = "//*[@id=\'main\']/div/div/div/div[2]/div[2]/input")
    private WebElement submitOrderButton;

    @FindBy(xpath = "//*[@id=\"checkoutform\"]/h1")
    private WebElement headerOrderPage;

    @FindBy(xpath = "//*[@id=\"WizardForm\"]/div[2]/div[2]/h1")
    private WebElement headerKlarna;

    public boolean headerOrderPage(){
        return headerOrderPage.isDisplayed();
    }

    public void  enterData(String address, String surname, String email, String phonenumber){
        this.address.clear();
        this.address.sendKeys(address);

        this.surname.clear();
        this.surname.sendKeys(surname);

        this.email.clear();
        this.email.sendKeys(email);

        this.phonenumber.clear();
        this.phonenumber.sendKeys(phonenumber);

    }

    public void orderMethod(){
       klarna.click();

    }


    public void submitOrder(){
        submitOrderButton.click();
    }
    public  String headerKlarna(){
       return headerKlarna.getText();
    }


}
