package com.nttdata.testing.Pages.magento;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RegisterPageMagento extends PageObject {
    public static final Target TXT_FIRST_NAME = Target.the("Campo de texto primer nombre")
            .located(By.id("firstname"));

    public static final Target TXT_LAST_NAME = Target.the("Campo de texto segundo nombre")
            .located(By.id("lastname"));

    public static final Target TXT_EMAIL = Target.the("Campo de texto email")
            .located(By.id("email_address"));

    public static final Target TXT_PASSWORD = Target.the("Campo de texto contraseña")
            .located(By.id("password"));

    public static final Target TXT_PASSWORD_CONFIRMATION = Target.the("Campo de Repetir Contrasenia")
            .located(By.id("password-confirmation"));

    public static final Target BTN_CREATE = Target.the("create account button")
            .locatedBy("//button[@title='Create an Account']");

    public static final Target MSG_REGISTRO_EXITOSO = Target.the("Mensaje de registro exitoso")
            .located(By.xpath("//div[@data-bind=\"html: $parent.prepareMessageForHtml(message.text)\" and contains(text(), 'Thank you for registering')]"));

}
