package ui_tests;

import core.BrowserTypes;
import utils.PropertyLoader;


public class TestData {

    public static final String SAMSUNG_G900H_GALAXY_S5 = "Samsung Galaxy S5 G900H Black";

    public static final BrowserTypes BROWSER_NAME = BrowserTypes.valueOf(PropertyLoader.loadProperty("browser.name"));

    public static final String SAMSUNG_PROCESSOR = "Exynos 5422 (Quad 1.9 ГГц + Quad 1.3 ГГц)";

    public static final String ROZETKA_URL = "http://rozetka.com.ua/";

    public static final String APPLE = "Apple";

    public static final String APPLE_MACBOOK_PRO_RETINA = "Apple MacBook Pro Retina 15\" (Z0PU002JE)";

    public static final String MACBOOK_PRO_IN_COMPARE_LIST = "Apple MacBook Pro Retina 15\" (Z0PU002JE) Официальная гарантия!";

    public static final String APPLE_MACBOOK_AIR = "Apple MacBook Air 11\" (MD712UA/A)";

    public static final String MACBOOK_AIR_IN_COMPARE_LIST = "Apple MacBook Air 11\" (MD712UA/A) Официальная гарантия!";

    public static final String FILTER_FROM_EXPENSIVE_TO_CHEAP = "от дорогих к дешевым";

    public static final String COMPARISON_PAGE_TITLE = "Сравнение товаров";
}
