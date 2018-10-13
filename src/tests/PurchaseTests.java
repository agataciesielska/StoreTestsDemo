package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.MainPage;
import pages.OrderConfirmationPage;
import pages.OrderShippingPage;

public class PurchaseTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforePurchaseTestMethods() {
        page.GetInstance(MainPage.class)
                .goToLoginPage() //to LoginPage
                .loginToAccount("testmail@mymail.com", "12345qw") //to MyAccountPage
                .goToMainPage() //to MainPage
                .goToProductPage() //to ProductPage
                .addToCart("2", "2"); //to CartPage
    }

    @Test(groups = {"smoke tests"})
    public void validPurchase() {
        //Pages order in placing an order:
        //ProductPage -> CartPage -> OrderAddressPage -> OrderShippingPage -> OrderPaymentPage -> OrderSummaryPage -> OrderConfirmationPage
        page.GetInstance(CartPage.class)
                .clickProceedToCheckoutButton() //to OrderAddressPage
                .clickProceedToCheckoutButton() //to OrderShippingPage
                .acceptTermsAndProceedToCheckout() //to OrderPaymentPage
                .clickPayByBankWireButton() //to OrderSummaryPage
                .clickIConfirmMyOrderButton(); //to OrderConfirmationPage

        //**********Assertions**********
        page.GetInstance(OrderConfirmationPage.class).confirmValidOrder("Your order on My Store is complete.");
    }

    @Test
    public void removeFromCart() {
        page.GetInstance(CartPage.class).clickRemoveItemButton();

        //**********Assertions**********
        page.GetInstance(CartPage.class).removeFromCartConfirmation("Your shopping cart is empty.");
    }

    @Test
    public void decreaseItemQuantityInCart() {
        page.GetInstance(CartPage.class).clickReduceQuantityButton();

        //**********Assertions**********
        page.GetInstance(CartPage.class).changeQuantityInCartValidation("1");
    }

    @Test
    public void increaseItemQuantityInCart() {
        page.GetInstance(CartPage.class).clickIncreaseQuantityButton();

        //**********Assertions**********
        page.GetInstance(CartPage.class).changeQuantityInCartValidation("3");
    }

    @Test
    public void invalidPurchase_TermsNotAccepted() {
        page.GetInstance(CartPage.class)
                .clickProceedToCheckoutButton() //to OrderAddressPage
                .clickProceedToCheckoutButton() //to OrderShippingPage
                .clickProceedToCheckout(); //to OrderPaymentPage

        //**********Assertions**********
        page.GetInstance(OrderShippingPage.class).verifyInvalidPurchase_TermsNotAccepted();
    }

}
