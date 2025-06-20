package com.nttdata.testing.Pages.magento;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://magento.softwaretestingboard.com/checkout/cart/")
public class CarPageMagento extends PageObject {
    public static final Target BTN_PROCEED_TO_CHECKOUT = Target.the("Botón Proceed to Checkout")
            .located(By.cssSelector("button[data-role='proceed-to-checkout']"));

    public static final Target PRODUCT_NAME_IN_CART =
            Target.the("Nombre del producto en el carrito")
                    .located(By.cssSelector("td.col.item .product-item-details strong.product-item-name > a"));





}
