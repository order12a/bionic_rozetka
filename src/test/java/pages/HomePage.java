package pages;

import utils.Log4Test;

public class HomePage extends GeneralPage {

    public void open(String URL) {

        webDriver.get(URL);

        Log4Test.info("Open WebUrl " + URL);

    }

    public boolean isOpened(String URL) {
        return webDriver.getCurrentUrl().equals(URL);
    }

    public void searchProduct(String productName) {
        Log4Test.info("Search product " + productName);
        waitForPageLoaded(webDriver);
        elementIsLocated(getLocator("searchField")).clear();
        elementIsLocated(getLocator("searchField")).sendKeys(productName);
        elementIsLocated(getLocator("searchButton")).click();
    }

    public void goToLaptopsSection(){
        Log4Test.info("Navigating to laptops section");
        elementIsLocated(getLocator("laptopsLink")).click();
    }
}



