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
        // Given
        String loginEmail = "testmail@mymail.com";
        String loginPassword = "12345qw";
        String itemQuantity = "2";
        String itemSizeValue = "2";

        // When
        page.GetInstance(MainPage.class)
                .goToLoginPage() //to LoginPage
                .loginToAccount(loginEmail, loginPassword) //to MyAccountPage
                .goToMainPage() //to MainPage
                .goToProductPage() //to ProductPage
                .addToCart(itemQuantity, itemSizeValue); //to CartPage
    }

    @Test(groups = {"smoke tests"})
    public void validPurchase() {
        //Pages order in placing an order:
        //ProductPage -> CartPage -> OrderAddressPage -> OrderShippingPage -> OrderPaymentPage -> OrderSummaryPage -> OrderConfirmationPage

        // When
        page.GetInstance(CartPage.class)
                .clickProceedToCheckoutButton() //to OrderAddressPage
                .clickProceedToCheckoutButton() //to OrderShippingPage
                .acceptTermsAndProceedToCheckout() //to OrderPaymentPage
                .clickPayByBankWireButton() //to OrderSummaryPage
                .clickIConfirmMyOrderButton(); //to OrderConfirmationPage

        // Then
        page.GetInstance(OrderConfirmationPage.class).confirmValidOrder("Your order on My Store is complete.");
    }

    @Test
    public void removeFromCart() {
        // When
        page.GetInstance(CartPage.class).clickRemoveItemButton();

        // Then
        page.GetInstance(CartPage.class).removeFromCartConfirmation("Your shopping cart is empty.");
    }

    @Test
    public void decreaseItemQuantityInCart() {
        // When
        page.GetInstance(CartPage.class).clickReduceQuantityButton();

        // Then
        page.GetInstance(CartPage.class).changeQuantityInCartValidation("1");
    }

    @Test
    public void increaseItemQuantityInCart() {
        // When
        page.GetInstance(CartPage.class).clickIncreaseQuantityButton();

        // Then
        page.GetInstance(CartPage.class).changeQuantityInCartValidation("3");
    }

    @Test
    public void invalidPurchase_TermsNotAccepted() {
        // When
        page.GetInstance(CartPage.class)
                .clickProceedToCheckoutButton() //to OrderAddressPage
                .clickProceedToCheckoutButton() //to OrderShippingPage
                .clickProceedToCheckout(); //to OrderPaymentPage

        // Then
        page.GetInstance(OrderShippingPage.class).verifyInvalidPurchase_TermsNotAccepted();
    }

}
