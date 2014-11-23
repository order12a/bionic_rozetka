package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log4Test;

import java.util.List;

public class ComparisonPage extends GeneralPage {

    /*
    This method is used to check that page title contains expected text
     */
    public boolean verifyTitleContains(String title){
        return webDriver.getTitle().contains(title);
    }

    /*
    This method is used to check that link "Добавить модель" is displayed
     */
    public boolean verifyAddModelLinkDisplayed(){
        Log4Test.info("Checking that link \'Добавить модель\' is displayed");
        return elementIsLocated(getLocator("comparePage.addProduct")).isDisplayed();
    }

    /*
    This method is used to that expected products are present at the comparison page
     */
    public boolean verifyProductsAtComparisonPage(List<String> itemsToCompare){
        Log4Test.info("Comparing products that should be at the comparison page");
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(webDriver.findElements(getLocator("comparePage.productName"))));
        boolean flag = false;
        List<WebElement> itemsAtThePage = webDriver.findElements(getLocator("comparePage.productName"));
        Log4Test.info("Items locator found!" + itemsAtThePage.toString());
        for (int i = 0; i < itemsAtThePage.size(); i++){
            WebElement element = itemsAtThePage.get(i);
            Log4Test.info(element.getText());
            Log4Test.info(element.toString());
            Log4Test.info("1) Product - " + itemsToCompare.get(i));
            if (element.getText().contains(itemsToCompare.get(i))){
                Log4Test.info("2) Product - " + itemsToCompare.get(i));
                flag = true;
            }
        }
        return flag;
    }
}
