package com.nttdata.testing.Pages.magento;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://magento.softwaretestingboard.com/customer/account/login")
public class SignPageMagento extends PageObject {
    public static final Target INP_EMAIL = Target.the("Campo de correo electrónico")
            .located(By.id("email"));

    public static final Target INP_PASS = Target.the("Campo de contraseña")
            .located(By.id("pass"));

    public static final Target BTN_SUBMIT = Target.the("Botón para enviar login")
            .located(By.id("send2"));

    public static final Target MSG_LOGIN_INVALIDO = Target.the("Mensaje de error al iniciar sesión")
            .located(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));

    public static final Target SPAN_BIENVENIDA = Target.the("Mensaje de bienvenida tras login")
            .located(By.xpath("//span[@class='logged-in' and contains(text(), 'Welcome,')]"));

}
