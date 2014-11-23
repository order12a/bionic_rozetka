package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Log4Test;

import java.util.List;

/**
 * Created by order on 11/16/14.
 */
public class LaptopsPage extends GeneralPage{
    private List<WebElement> listOfManufactures;

     /*
     This method is used to check that tab "Ноутбуки, планшеты и компьютеры" is active
      */
     public boolean checkLaptopsTabActive(){
        Log4Test.info("Verifying laptops tab is active");
        waitForPageLoaded(webDriver);
        boolean isTabActive = false;
         WebElement laptopsTab = elementIsLocated(getLocator("laptopsTab"));
         String activeAttribute = laptopsTab.getAttribute("name");
         Log4Test.info("Current state of tab LAPTOPS is - " + activeAttribute);
         return activeAttribute.equals("active-elem");
     }

    /*
    This method is used to check that 9 manufactures are present
     */
    public boolean getManufactures(){
        boolean flag = true;
        Log4Test.info("Start finding laptop manufactures");
        listOfManufactures = webDriver.findElements(getLocator("manufacturesLocator"));

        if (listOfManufactures.size() == 9){
            flag = flag & true;
            Log4Test.info("All 9 manufactures present at the page");
        }else {
            flag = flag & false;
            Log4Test.error("Expected number of manufacture not found, current number - " + listOfManufactures.size());
        }

        return flag;
    }

    /*
    This method is used loop throw all available manufactures and select Apple
     */
     public void verifyAppleInList(String manufactor){

         for (WebElement element: listOfManufactures){
             Log4Test.info("Looking for  Apple manufactor");
             if(element.getText().contains(manufactor)){
                 Log4Test.info("Apple manufactor is in the manufactures list");
                 break;
             }
         }
     }

    /*
    Using this method to navigate to the Apple Page because previous method don't click at the expected manufactor
     */
    public void navigateToApple(){
        WebElement element = webDriver.findElement(By.partialLinkText("Apple"));
        Log4Test.info("Go to Apple manufactor");
        element.click();
    }

}
