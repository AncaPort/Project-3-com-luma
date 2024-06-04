package testsuite;
/**
 * 3. Create the package ‘testsuite’ and create the
 * following classes inside the ‘testsuite’ package.
 * 1. WomenTest
 * 2. MenTest
 * 3. GearTest
 * 4. Write down the following test into WomenTestclass
 */


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {

    @Before
    public void setUp() {
        multiBrowser(baseUrl);
    }

    /**
     * 1. verifyTheSortByProductNameFilter
     * * Mouse Hover on Women Menu
     * * Mouse Hover on Tops
     * * Click on Jackets
     * * Select Sort By filter “Product Name”
     * * Verify the products name display in
     * alphabetical order
     */

    @Test
    //1. verifyTheSortByProductNameFilter
    public void verifyTheSortByProductNameFilter() {
        //Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//span[contains(text(),'Women')]"));
        //Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));
        // Click on Jackets
        mouseHoverAndClickToElement(By.xpath("//a[@id='ui-id-11']"));
        //Select Sort By filter “Product Name”
        driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]")).click();
        selectByVisibleTextFromDropDown(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"), "Product Name ");
        //Verify the products name display in alphabetical order
        List<WebElement> product = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement order : product) {
            System.out.println(order.getText());
        }
    }

    /**
     * 2. verifyTheSortByPriceFilter
     * * Mouse Hover on Women Menu
     * * Mouse Hover on Tops
     * * Click on Jackets
     * * Select Sort By filter “Price”
     * * Verify the products price display in
     * Low to High
     */
    @Test
    public void verifyTheSortByPriceFilter() {
        //Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//span[contains(text(),'Women')]"));
        //Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));
        // Click on Jackets
        mouseHoverAndClickToElement(By.xpath("//a[@id='ui-id-11']"));
        //Select Sort By filter “Price”
        driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]")).click();
        selectByValueFromDropDown(By.xpath("//body/div[2]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"), "price");
        //Verify the products price display in Low to High
        List<WebElement> price = driver.findElements(By.xpath("//span[@data-price-type='finalPrice']"));
        for (WebElement display : price) {
            System.out.println(display.getText());
        }
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
