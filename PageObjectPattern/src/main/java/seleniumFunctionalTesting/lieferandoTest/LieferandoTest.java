package seleniumFunctionalTesting.lieferandoTest;

import org.junit.Test;
import seleniumFunctionalTesting.FunctionalTest;
import seleniumFunctionalTesting.lieferandoTest.pages.MainPage;
import seleniumFunctionalTesting.lieferandoTest.pages.MenuPage;
import seleniumFunctionalTesting.lieferandoTest.pages.OrderPage;
import seleniumFunctionalTesting.lieferandoTest.pages.RestListPage;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class LieferandoTest extends FunctionalTest {

    final String url =  "https://www.lieferando.de";
    final String index = "10787";
    final String restName = "Shawarma One";
    final String dishName = "Shawarma-Rind-Sandwich";
    final String extras = "mit Hummus";
    final String address = "Belziger Str. 28";
    final String surname = "John Smith";
    final String email = "12345@mail.ru";
    final String phonenumber = "1818181818";



    MainPage mainPage = new MainPage(driver);

    @Test
    public void signUp() throws InterruptedException {
        driver.get(url);

        RestListPage restListPage = mainPage.enterAddress(index);

        Thread.sleep(2000);

       assertTrue(restListPage.checkSearch());

        String lab = restListPage.checkIndexLabel();
        assertTrue(restListPage.checkIndexLabel().contains(index));

        MenuPage menuPage = restListPage.selectRest(restName);
       //assertTrue(restName.equals(menuPage.checkLabel()));

       menuPage.selectDish(dishName);

       menuPage.selectExtras(extras);

       menuPage.selectPlusDishes();

       menuPage.checkOut();

       menuPage.orderButton();

        OrderPage orderPage = new OrderPage(driver);
        assertTrue(orderPage.headerOrderPage());

        orderPage.enterData(address, surname, email, phonenumber);
        orderPage.orderMethod();

        orderPage.submitOrder();
        assertEquals("Willkommen.", orderPage.headerKlarna());



    }
}
