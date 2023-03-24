package pages;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;




public class HomePage {

    private WebDriver driver;

    // Declaring used locators in this class
    private By shop = By.id("comp-iy4cwgmq1label");
    private By selectNthproduct;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to click on "Shop" in home page to go to shop area
    public void go_to_shop_area() {
        driver.findElement(shop).click();
    }

    // Method to select a product of a specific order from products list
    public ProductPage select_nth_product(int productOrder) {
        selectNthproduct = By.xpath("//ul[@data-hook='product-list-wrapper']//li["+productOrder+"]");
        driver.findElement(selectNthproduct).click();

        // Organizing structure to identify that this method will navigate to another page
        return new ProductPage(driver);
    }

    // Method to take screenshot
    public void takeScreenShot(String screenShotName) throws IOException, InterruptedException {
        //The following wait is to overcome slow internet connection until the page is loaded
        //we can use wait until element exists, but this will not make the method usable for all pages
        Thread.sleep(5000);
        //Convert web driver object to TakeScreenshot
        TakesScreenshot screenShot =((TakesScreenshot)driver);
        //Call getScreenshotAs method to create image file
        File sourceFile = screenShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File destinationFile=new File("resources/screenshots/"+ screenShotName +".png");
        //Copy file at destination
        Files.move(sourceFile, destinationFile);
    }

}
