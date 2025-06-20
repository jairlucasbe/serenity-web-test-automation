package com.nttdata.testing.Pages.magento;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://magento.softwaretestingboard.com")
public class HomePageMagento extends PageObject {

    public static final Target NAV_SIGN = Target.the("La opción Sign in")
            .located(By.xpath("//li[@class='authorization-link']/a"));

    public static final Target NAV_REGISTER = Target.the("La opción Create an Account")
            .located(By.xpath("//ul[@class='header links']/li/a[text()='Create an Account']"));

    public static final Target MENU_MEN = Target.the("Men menu")
            .located(By.id("ui-id-5"));

    public static final Target MENU_TOPS_MEN = Target.the("Tops submenu under Men")
            .located(By.id("ui-id-17"));

    public static final Target MENU_JACKETS_MEN = Target.the("Jackets submenu under Tops/Men")
            .located(By.id("ui-id-19"));


}
