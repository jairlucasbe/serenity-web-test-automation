package com.nttdata.testing.Pages.magento;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://magento.softwaretestingboard.com/customer/account")
public class AccountPageMagento extends PageObject {
    public static final Target MSG_REGISTRO_EXITOSO = Target.the("Mensaje de registro exitoso")
            .located(By.xpath("//div[@data-bind=\"html: $parent.prepareMessageForHtml(message.text)\" and contains(text(), 'Thank you for registering')]"));

    public static final Target BTN_DROP_DOWN = Target.the("Boton Drop Down Seleccionado")
            .located(By.xpath("//button[@data-action='customer-menu-toggle']"));

    public static final Target BTN_SIGN_OUT = Target.the("Botón de cierre de sesión")
            .located(By.xpath("//li[@class='authorization-link']//a[normalize-space(text())='Sign Out']"));

}
