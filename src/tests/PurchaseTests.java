package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class PurchaseTests extends BaseTest {

    @BeforeMethod
    public void beforePurchaseTestMethods() {
        page.GetInstance(MainPage.class).goToLoginPage();
        page.GetInstance(LoginPage.class).loginToAccount("testmail@mymail.com", "12345qw");
        page.GetInstance(MyAccountPage.class).goToMainPage();
        page.GetInstance(MainPage.class).goToProductPage();
    }

    @Test
    public void validPurchase() {
        //Pages order in placing an order:
        //ProductPage -> CartPage -> OrderAddressPage -> OrderShippingPage -> OrderPaymentPage -> OrderSummaryPage -> OrderConfirmationPage
        page.GetInstance(ProductPage.class).addToCart("2", "2");
        page.GetInstance(CartPage.class).clickProceedToCheckoutButton();
        page.GetInstance(OrderAddressPage.class).clickProceedToCheckoutButton();
        page.GetInstance(OrderShippingPage.class).acceptTermsAndProceedToCheckout();
        page.GetInstance(OrderPaymentPage.class).clickPayByBankWireButton();
        page.GetInstance(OrderSummaryPage.class).clickIConfirmMyOrderButton();

        //**********Assertions**********
        page.GetInstance(OrderConfirmationPage.class).confirmValidOrder("Your order on My Store is complete.");
    }

    @Test
    public void removeFromCart() {
        page.GetInstance(ProductPage.class).addToCart("2", "2");
        page.GetInstance(CartPage.class).clickRemoveItemButton();

        //**********Assertions**********
        page.GetInstance(CartPage.class).removeFromCartConfirmation("Your shopping cart is empty.");
    }

    @Test
    public void decreaseItemQuantityInCart() {
        page.GetInstance(ProductPage.class).addToCart("2", "2");
        page.GetInstance(CartPage.class).clickReduceQuantityButton();

        //**********Assertions**********
        page.GetInstance(CartPage.class).changeQuantityInCartValidation("1");
    }

    @Test
    public void increaseItemQuantityInCart() {
        page.GetInstance(ProductPage.class).addToCart("2", "2");
        page.GetInstance(CartPage.class).clickIncreaseQuantityButton();

        //**********Assertions**********
        page.GetInstance(CartPage.class).changeQuantityInCartValidation("3");
    }

    @Test
    public void invalidPurchase_TermsNotAccepted() {
        page.GetInstance(ProductPage.class).addToCart("2", "2");
        page.GetInstance(CartPage.class).clickProceedToCheckoutButton();
        page.GetInstance(OrderAddressPage.class).clickProceedToCheckoutButton();
        page.GetInstance(OrderShippingPage.class).clickProceedToCheckout();

        //**********Assertions**********
        page.GetInstance(OrderShippingPage.class).verifyInvalidPurchase_TermsNotAccepted();
    }

}
