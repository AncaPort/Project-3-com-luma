package testsuite;
/**
 * 6.Write down the following test into ‘GearTest’ class
 * 1. userShouldAddProductSuccessFullyTo
 * ShoppinCart()
 * * Mouse Hover on Gear Menu
 * * Click on Bags
 * * Click on Product Name ‘Overnight Duffle’
 * * Verify the text ‘Overnight Duffle’
 * * Change Qty 3
 * * Click on ‘Add to Cart’ Button.
 * * Verify the text
 * ‘You added Overnight Duffle to your shopping cart.’
 * * Click on ‘shopping cart’ Link into
 * message
 * * Verify the product name ‘Cronus Yoga Pant’
 * * Verify the Qty is ‘3’
 * * Verify the product price ‘$135.00’
 * * Change Qty to ‘5’
 * * Click on ‘Update Shopping Cart’ button
 * * Verify the product price ‘$225.00
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {

    @Before
    public void setUp() {
        multiBrowser(baseUrl);
    }

    /**
     * 1. userShouldAddProductSuccessFullyToShoppinCart()
     * * * Mouse Hover on Gear Menu
     * * * Click on Bags
     * * * Click on Product Name ‘Overnight Duffle’
     * * * Verify the text ‘Overnight Duffle’
     * * * Change Qty 3
     * * * Click on ‘Add to Cart’ Button.
     * * * Verify the text
     * * ‘You added Overnight Duffle to your shopping cart.’
     * * * Click on ‘shopping cart’ Link into message
     * * * Verify the product name ‘Overnight Duffle’
     * * * Verify the Qty is ‘3’
     * * * Verify the product price ‘$135.00’
     * * * Change Qty to ‘5’
     * * * Click on ‘Update Shopping Cart’ button
     * * * Verify the product price ‘$225.00
     */
    @Test
    //1. userShouldAddProductSuccessFullyToShoppinCart()
    public void userShouldAddProductSuccessFullyToShoppinCart() {
        // Mouse Hover on Gear Menu
        mouseHoverToElement(By.xpath("//span[contains(text(),'Gear')]"));
        //Click on Bags
        mouseHoverAndClickToElement(By.xpath("//span[contains(text(),'Bags')]"));
        //Click on Product Name ‘Overnight Duffle’
        mouseHoverAndClickToElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));
        //Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        //Click on ‘Add to Cart’ Button.
        mouseHoverAndClickToElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
        //Verify the text
        // ‘You added Overnight Duffle to your shopping cart.’
        String expectedText = "You added Overnight Duffle to your shopping cart.";
        String actualText = getTextFromElement(By.xpath("//body/div[2]/main[1]/div[1]/div[2]/div[1]"));
        Assert.assertEquals("Your item is not added into Shopping cart", expectedText, actualText);
        //Click on ‘shopping cart’ Link into message
        mouseHoverAndClickToElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //Verify the product name ‘Overnight Duffle’
        String expectedItem = "Overnight Duffle";
        String actualItem = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        Assert.assertEquals("Wrong product in shoping cart", expectedItem, actualItem);
        //Verify the Qty is ‘3’
        String expectedQuantity = "3";
        String actualQuantity = driver.findElement(By.xpath("//input[@class='input-text qty']")).getAttribute("value");
        Assert.assertEquals("Wrong quantity in shopping cart", expectedQuantity, actualQuantity);
        //Verify the product price ‘$135.00’
        Assert.assertEquals("$135.00", getTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']")));
        //Change Qty to ‘5’
        driver.findElement(By.xpath("//input[@class='input-text qty']")).clear();
        sendTextToElement(By.xpath("//input[@class='input-text qty']"), "5");
        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
        //Verify the product price ‘$225.00
        Assert.assertEquals("$225.00", getTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']")));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
