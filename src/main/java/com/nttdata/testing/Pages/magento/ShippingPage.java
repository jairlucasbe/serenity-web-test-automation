package com.nttdata.testing.Pages.magento;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ShippingPage extends PageObject {
    public static final Target INPUT_NOMBRE = Target.the("Campo nombre")
            .located(By.name("firstname"));

    public static final Target TXT_LAST_NAME = Target.the("Campo apellido")
            .located(By.name("lastname"));

    public static final Target TXT_COMPANY = Target.the("Campo company")
            .located(By.name("company"));

    public static final Target TXT_STREET = Target.the("Campo de texto contraseña")
            .located(By.name("street[0]"));

    public static final Target TXT_CITY = Target.the("Campo de Repetir Contrasenia")
            .located(By.name("city"));

    public static final Target SELECT_REGION = Target.the("Dropdown de regiones")
            .located(By.name("region_id"));

    public static final Target TXT_ZIP = Target.the("Campo de postcode")
            .located(By.name("postcode"));

    public static final Target SELECT_COUNTRY = Target.the("Dropdown de país")
            .located(By.name("country_id"));

    public static final Target RADIO_METODO_ENVIO = Target.the("Método de envío por tarifa estándar")
            .located(By.cssSelector("input[type='radio'][value='flatrate_flatrate']"));

    public static final Target BTN_NEXT = Target.the("Botón Next del formulario de envío")
            .located(By.cssSelector("button.button.action.continue.primary"));

    public static final Target BTN_PLACE_ORDER = Target.the("Botón Place Order")
            .located(By.cssSelector("button.action.primary.checkout"));

    public static final Target LINK_ORDER_NUMBER = Target.the("Link con el número de orden")
            .located(By.cssSelector("a.order-number strong"));

    public static final Target TXT_TELEFONO = Target.the("Campo de teléfono")
            .located(By.name("telephone"));

    public static final Target PRODUCT_NAME_IN_ORDER = Target.the("Nombre del producto en la orden")
            .located(By.cssSelector("td.col.name strong.product.name.product-item-name"));




}
