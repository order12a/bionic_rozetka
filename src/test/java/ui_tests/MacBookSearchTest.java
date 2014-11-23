package ui_tests;

import core.TestBase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ApplePage;
import pages.ComparisonPage;
import pages.HomePage;
import pages.LaptopsPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class MacBookSearchTest extends TestBase {
    TestData testData;
    HomePage homePage;
    LaptopsPage laptopsPage;
    ApplePage applePage;
    ComparisonPage comparisonPage;
    List<String> productsList;

    @BeforeTest
    public void setUpPage(){
        testData = new TestData();
        homePage = new HomePage();
        laptopsPage = new LaptopsPage();
        applePage = new ApplePage();
        comparisonPage = new ComparisonPage();
        productsList = new ArrayList<String>();
        productsList.add(TestData.APPLE_MACBOOK_PRO_RETINA);
        productsList.add(TestData.APPLE_MACBOOK_AIR);
    }


    @Test
    public void setUpPreconditions(){
        homePage.open(TestData.ROZETKA_URL);

        assertTrue(homePage.isOpened(TestData.ROZETKA_URL));
    }


    @Test(dependsOnMethods = {"setUpPreconditions"}, enabled = true)
    public void testMacBookSearchAndVerifyCharacteristics(){
        assertTrue(homePage.isOpened(TestData.ROZETKA_URL));

        homePage.goToLaptopsSection();
        assertTrue(laptopsPage.checkLaptopsTabActive());

        laptopsPage.getManufactures();
        laptopsPage.verifyAppleInList(testData.APPLE);
        laptopsPage.navigateToApple();
        applePage.showExpensiveFirst(testData.FILTER_FROM_EXPENSIVE_TO_CHEAP);
        assertTrue(applePage.verifyProductIsDisplayed(testData.APPLE_MACBOOK_PRO_RETINA));

        applePage.addMacBookRetinaPro();
        assertTrue(applePage.isCompareListDisplayed());
        assertTrue(applePage.verifyItemToCompareInCompareList(testData.MACBOOK_PRO_IN_COMPARE_LIST));

        assertTrue(applePage.verifyProductIsDisplayed(testData.APPLE_MACBOOK_AIR));
        applePage.addMacBookAir();
//        assertTrue(applePage.verifyItemToCompareInCompareList(testData.MACBOOK_AIR_IN_COMPARE_LIST));
        applePage.verifyItemToCompareInCompareList(testData.MACBOOK_AIR_IN_COMPARE_LIST);
        applePage.clickInCompareLink();

        assertTrue(comparisonPage.verifyTitleContains(TestData.COMPARISON_PAGE_TITLE));
        assertTrue(comparisonPage.verifyAddModelLinkDisplayed());
        assertTrue(comparisonPage.verifyProductsAtComparisonPage(productsList));
    }

    @AfterTest
    public void afterTest(){
        webDriver.quit();
    }
}
