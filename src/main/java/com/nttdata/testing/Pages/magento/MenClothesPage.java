package com.nttdata.testing.Pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class MenClothesPage extends PageObject {

    public static final Target TXT_BUSCAR = Target.the("Barra de busqueda")
            .located(By.id("search"));

    public static final Target ICN_BUSCAR = Target.the("Icono para buscar")
            .located(By.xpath("//button[contains(@class, 'search') and span[text()='Search']]"));

    public static final Target ITM_SHIRT = Target.the("Item Shirt")
            .located(By.xpath("//li[contains(@class, 'product-item') and .//a[contains(text(), 'Proteus Fitness Jackshirt')]]"));

    public static final Target ITM_TALLA = Target.the("Item Talla de ropa")
            .located(By.xpath("//div[@option-label='L']"));

    public static final Target ITM_COLOR_PRENDA = Target.the("Color de la prenda")
            .located(By.xpath("//div[@option-label='Blue']"));

    public static final Target BTN_AGREGAR_CARRITO = Target.the("Boton Agregar producto al carrito")
            .located(By.xpath("//button[span[text()='Add to Cart']]"));

    public static final Target ITM_CARRITO = Target.the("Items agregados al carrito")
            .located(By.xpath("//div[@data-block='minicart']//span[@class='counter qty']//span[@class='counter-number']"));

    public static final Target SECOND_PRODUCT_ITEM = Target.the("segundo producto de la lista")
            .located(By.cssSelector("ol.products.list.items.product-items > li.item.product.product-item:nth-of-type(2) div.product-item-info"));

    public static final Target BTN_TALLA_XS = Target.the("Escoger Talla XS")
            .located(By.id("option-label-size-143-item-166"));

    public static final Target BTN_COLOR = Target.the("Escoger Color Verde")
            .located(By.id("option-label-color-93-item-53"));

    public static final Target BTN_QTY = Target.the("Caja de elementos de la cantidad")
            .located(By.id("qty"));

    public static final Target BTN_CART = Target.the("Boton de Agregar a Carrito")
            .located(By.id("product-addtocart-button"));

    public static final Target BTN_VER_CARRITO = Target.the("Botón para ir al carrito")
            .located(By.cssSelector("a.action.showcart.active"));

    public static final Target LOGO_HEADER = Target.the("Logo del encabezado")
            .located(By.cssSelector("a.logo"));

    public static final Target BTN_CART_PROCEDER = Target.the("Botón de proceder con la compra")
            .located(By.cssSelector("button#top-cart-btn-checkout"));

    public static final Target MSG_PRODUCT_ADDED = Target.the("mensaje de producto agregado al carrito")
            .locatedBy("//div[contains(text(),'You added') and contains(text(),'to your')]");

}
