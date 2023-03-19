package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyCartPage;

import java.io.IOException;

public class Tests extends BaseTests {

    @Test
    public void verify_added_price_to_cart() throws InterruptedException, IOException {
        homePage.takeScreenShot("sitePage");

        homePage.go_to_shop_area();
        homePage.takeScreenShot("goToShop");

        homePage.select_nth_product(4);
        homePage.takeScreenShot("productPage");

        productPage.increase_quantity_by_click_up_arrow(2);
        productPage.pick_color();
        homePage.takeScreenShot("quantityAndColorSelected");

        productPage.click_add_to_cart();
        homePage.takeScreenShot("miniCartDisplayed");

        productPage.click_on_view_cart();
        homePage.takeScreenShot("myCartPage");

        Assert.assertEquals(myCartPage.get_total_sum(),"C$75.00");

        myCartPage.click_checkOut();
        homePage.takeScreenShot("checkOutClicked");
    }
}
