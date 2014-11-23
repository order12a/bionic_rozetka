package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log4Test;

import java.util.List;

public class ApplePage extends GeneralPage{

    /*
    This method is used to reorder view to show models from expensive to cheap
     */
    public void showExpensiveFirst(String sortType){
        Log4Test.info("Show expensive models first method");
        waitForPageLoaded(webDriver);
        WebElement sortBy = elementIsLocated(getLocator("selectShowByElement"));
        sortBy.click();
        webDriver.findElement(By.partialLinkText(sortType)).click();
    }

    /*
    This method is used to check that expected product is present at the page
     */
    public boolean verifyProductIsDisplayed(String productName){
        boolean flag = false;
        List<WebElement> listOfProducts = webDriver.findElements(getLocator("blockWithProduct"));
        for (WebElement element: listOfProducts){
             if (element.getText().contains(productName)){
                 flag = true;
                 Log4Test.info("Found " + productName);
             }
        }
        return flag;
    }

    /*
      This method is used to add item into compare list
     */
    public void addItemToCompare(String itemLocator){
        waitForPageLoaded(webDriver);
        Log4Test.info(itemLocator);
        WebElement addCheckbox = elementIsLocated(getLocator(itemLocator));
        addCheckbox.click();
        Log4Test.info("Click add to compare list, item - " + itemLocator);
        waitForPageLoaded(webDriver);
    }

    /*
    This method is used to check that compare list is displayed
     */
    public boolean isCompareListDisplayed(){
        return elementIsLocated(getLocator("compareListHeader")).isDisplayed();
    }

    /*
    This method is used that item to compare displayes in compare list
     */
    public boolean verifyItemToCompareInCompareList(String itemToCompare){
        waitForPageLoaded(webDriver);
        Log4Test.info("Started verification presence of: " + itemToCompare);
        List<WebElement> itemsInCompareList;
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(webDriver.findElements(getLocator("elementFromCompareList"))));
        itemsInCompareList = webDriver.findElements(getLocator("elementFromCompareList"));

        for (WebElement element: itemsInCompareList){
           if (element.getText().startsWith(itemToCompare)){
               Log4Test.info("Comparison found!");
               return true;
           }
        }
        return false;
    }


    /*
    This method is used to proceed to comparison page by click "in compare" link
     */
    public void clickInCompareLink(){
        WebElement inCompare = elementIsLocated(getLocator("inCompareLink"));
        inCompare.click();
        Log4Test.info("Navigating to comparison list");
    }

    public void addMacBookRetinaPro(){
        addItemToCompare("addToCompareListMacBookPro");
        Log4Test.info("MacBook Pro is added to comparison list");
        waitForPageLoaded(webDriver);
    }

    public void addMacBookAir(){
        addItemToCompare("addToCompareListMacBookAir");
        Log4Test.info("MacBook Air is added to comparison list");
        waitForPageLoaded(webDriver);
    }


    //Alternative addToCompare method
    public void addToComp(String text){
        WebElement item = webDriver.findElement(By.partialLinkText(text));
        item.click();
    }

}
