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

    public static final Target TXT_SEARCH = Target.the("Caja de busqueda").located(By.id("search"));
    public static final Target NO_SEARCH_RESULTS_MESSAGE = Target.the("Mensaje de búsqueda sin resultados")
            .located(By.cssSelector("div.message.notice > div"));

    public static final Target ACCOUNT_INFORMATION_OPTION = Target.the("Opción Account Information (posición 7)")
            .located(By.xpath("(//ul[@class='nav items']/li[@class='nav item'])[6]"));

    public static final Target FIRST_NAME_INPUT = Target.the("Caja de texto del nombre")
            .located(By.id("firstname"));

    public static final Target SAVE_BUTTON = Target.the("Botón Save")
            .located(By.cssSelector("button[title='Save']"));

    public static final Target ACCOUNT_INFO_SUCCESS_MESSAGE = Target.the("Mensaje de éxito al guardar la información de cuenta")
            .located(By.xpath("//div[contains(text(), 'You saved the account information.')]"));


}

