package com.nttdata.testing.stepDefinition.magento;

import com.nttdata.testing.Pages.MenClothesPage;
import com.nttdata.testing.Pages.magento.*;
import com.nttdata.testing.Tasks.NavigateTo;
import com.nttdata.testing.variables.SessionVariables;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.containsString;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class SignInMagentoStepDefinition {
    @Given("el {actor} se encuentra en la pagina de inicio de magento")
    public void elUsuarioSeEncuentraEnLaPaginaDeInicioDeMagento(Actor actor) {
        OnStage.theActorCalled(actor.getName()).attemptsTo(NavigateTo.theHomePageMagento());
    }

    @And("el usuario le da click en la opcion Sign in de magento")
    public void elUsuarioLeDaClickEnLaOpcionSignInDeMagento() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePageMagento.NAV_SIGN));
    }

    @And("el {actor} se dirige a la página de login de magento")
    public void elUsuarioSeDirigeALaPáginaDeLoginDeMagento(Actor actor) {
        actor.attemptsTo(NavigateTo.theSignPageMagento());
    }

    @When("^inicia sesión con el correo \"([^\"]*)\" y la contraseña \"([^\"]*)\" en magento")
    public void iniciaSesiónConElCorreoEmailYLaContraseñaPasswordEnMagento(String emailParam, String passwordParam) {
        String username = "session".equals(emailParam)
                ? theActorInTheSpotlight().recall(SessionVariables.username.toString())
                : emailParam;

        String password = "session".equals(passwordParam)
                ? theActorInTheSpotlight().recall(SessionVariables.password.toString())
                : passwordParam;

        theActorInTheSpotlight().attemptsTo(
                Enter.theValue(username).into(SignPageMagento.INP_EMAIL),
                Enter.theValue(password).into(SignPageMagento.INP_PASS)
        );
    }

    @Then("el inicio de sesión se realiza en magento")
    public void elInicioDeSesiónSeRealizaEnMagento() {
        theActorInTheSpotlight().attemptsTo(Click.on(SignPageMagento.BTN_SUBMIT));
    }

    @And("se muestra el mensaje de credenciales invalidas")
    public void seMuestraElMensajeDeCredencialesInvalidas() {
        seeThat(the(SignPageMagento.MSG_LOGIN_INVALIDO), isVisible());
    }

    @And("aparece en pantalla el mensaje de bienvenido")
    public void apareceEnPantallaElMensajeDeBienvenido() {
        seeThat(the(SignPageMagento.SPAN_BIENVENIDA), isVisible());
    }

    /**
     * Register
     */

    @And("el {actor} le da click en la opcion Create an account de magento")
    public void elUsuarioLeDaClickEnLaOpcionCreateAnAccountDeMagento(Actor actor) {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePageMagento.NAV_REGISTER));
    }

    @And("ingresa nombre {string} apellido {string} contrasenia {string}")
    public void ingresaNombreApellidoContrasenia(String firstname, String lastname, String password) {
        String email = "user" + System.currentTimeMillis() + "@mailinator.com";

        theActorInTheSpotlight().remember(SessionVariables.username.toString(), email);
        theActorInTheSpotlight().remember(SessionVariables.password.toString(), password);

        // Imprimir lo recordado
        String savedEmail = theActorInTheSpotlight().recall(SessionVariables.username.toString());
        String savedPassword = theActorInTheSpotlight().recall(SessionVariables.password.toString());

        System.out.println("Email guardado en sesión: " + savedEmail);
        System.out.println("Password guardado en sesión: " + savedPassword);

        theActorInTheSpotlight().attemptsTo(
                Enter.theValue(firstname).into(RegisterPageMagento.TXT_FIRST_NAME),
                Enter.theValue(lastname).into(RegisterPageMagento.TXT_LAST_NAME),
                Enter.theValue(email).into(RegisterPageMagento.TXT_EMAIL),
                Enter.theValue(password).into(RegisterPageMagento.TXT_PASSWORD),
                Enter.theValue(password).into(RegisterPageMagento.TXT_PASSWORD_CONFIRMATION)
        );
    }


    @When("selecciona el boton registrar de magento")
    public void seleccionaElBotonRegistrarDeMagento() {
        theActorInTheSpotlight().attemptsTo(Click.on(RegisterPageMagento.BTN_CREATE));
    }

    @Then("se realiza el registro en magento de manera exitosa")
    public void seRealizaElRegistroEnMagentoDeManeraExitosa() {
        seeThat(the(RegisterPageMagento.MSG_REGISTRO_EXITOSO), isVisible());
    }

    /**
     * Logout
     */

    @And("el usuario cierra sesión en magento si es necesario")
    public void elUsuarioCierraSesiónEnMagentoSiEsNecesario() {
        theActorInTheSpotlight().attemptsTo(Click.on(AccountPageMagento.BTN_DROP_DOWN));
        theActorInTheSpotlight().attemptsTo(Click.on(AccountPageMagento.BTN_SIGN_OUT));
    }

    /**
     * Comprar un producto
     */

    @And("el usuario navega hasta la seccion de Jackets")
    public void elUsuarioNavegaHastaLaSeccionDeJackets() {
        theActorInTheSpotlight().attemptsTo(
                MoveMouse.to(HomePageMagento.MENU_MEN),
                MoveMouse.to(HomePageMagento.MENU_TOPS_MEN),
                Click.on(HomePageMagento.MENU_JACKETS_MEN)
        );
    }


    @And("el usuario selecciona un producto")
    public void elUsuarioSeleccionaUnProducto() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(MenClothesPage.SECOND_PRODUCT_ITEM)
        );
    }

    @And("escoge opciones de la compra con talla XS, color Green y cantidad {string}")
    public void escogeOpcionesDeLaCompraConTallaXSColorGreenYCantidad(String cantidad) {
        theActorInTheSpotlight().attemptsTo(
                Click.on(MenClothesPage.BTN_TALLA_XS),
                Click.on(MenClothesPage.BTN_COLOR),
                Scroll.to(MenClothesPage.BTN_QTY),
                WaitUntil.the(MenClothesPage.BTN_QTY, isVisible()).forNoMoreThan(10).seconds(),
                Clear.field(MenClothesPage.BTN_QTY),
                Enter.theValue(cantidad).into(MenClothesPage.BTN_QTY)
        );
    }

    @And("agregar al carrito de compras")
    public void agregarAlCarritoDeCompras() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(MenClothesPage.BTN_CART),
                WaitUntil.the(MenClothesPage.MSG_PRODUCT_ADDED, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    @And("El {actor} se encuentra en la pagina de carrito de compras")
    public void elUsuarioSeEncuentraEnLaPaginaDeCarritoDeCompras(Actor actor) {
        OnStage.theActorCalled(actor.getName()).attemptsTo(NavigateTo.theCarPageMagento());
    }


    @And("el usuario procede con la compra")
    public void elUsuarioProcedeConLaCompra() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CarPageMagento.PRODUCT_NAME_IN_CART, isVisible()).forNoMoreThan(10).seconds()
        );
        String productName = theActorInTheSpotlight().asksFor(Text.of(CarPageMagento.PRODUCT_NAME_IN_CART));
        theActorInTheSpotlight().remember("nombreProducto", productName);
        System.out.println("El nombre del producto es : " + productName);
        theActorInTheSpotlight().attemptsTo(
                Click.on(CarPageMagento.BTN_PROCEED_TO_CHECKOUT)
        );
    }

    @And("selecciona el método de envío")
    public void seleccionaElMétodoDeEnvío() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ShippingPage.RADIO_METODO_ENVIO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ShippingPage.RADIO_METODO_ENVIO),
                WaitUntil.the(ShippingPage.BTN_NEXT, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ShippingPage.BTN_NEXT)
        );
    }


    @Then("debería ver el resumen de compra y confirmarlo")
    public void deberíaVerElResumenDeCompraYConfirmarlo() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ShippingPage.BTN_PLACE_ORDER, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ShippingPage.BTN_PLACE_ORDER));
    }


    @And("deberia ver el numero de orden de compra")
    public void deberiaVerElNumeroDeOrdenDeCompra() {
        String numeroOrden = Text.of(ShippingPage.LINK_ORDER_NUMBER)
                .answeredBy(theActorInTheSpotlight());
        System.out.println("Número de orden: " + numeroOrden);
        //uso : String ordenGuardada = theActorInTheSpotlight().recall("numero_orden");
        theActorInTheSpotlight().remember("numero_orden", numeroOrden);
    }

    @And("deberia ir a la orden de compra haciendo click sobre la orden de compra")
    public void deberiaIrALaOrdenDeCompraHaciendoClickSobreLaOrdenDeCompra() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ShippingPage.LINK_ORDER_NUMBER, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ShippingPage.LINK_ORDER_NUMBER));
    }

    @And("el usuario llena el formulario con nombre {string}, apellido {string}, empresa {string}, direccion {string}, ciudad {string}, region_id {string}, zip {string}, country_id {string} y telefono {string}")
    public void llenarFormulario(String nombre, String apellido, String empresa, String direccion, String ciudad, String region_id, String zip, String country_id, String telephone) {
        theActorInTheSpotlight().attemptsTo(
                Enter.theValue(nombre).into(ShippingPage.INPUT_NOMBRE),
                Enter.theValue(apellido).into(ShippingPage.TXT_LAST_NAME),
                Enter.theValue(empresa).into(ShippingPage.TXT_COMPANY),
                Enter.theValue(direccion).into(ShippingPage.TXT_STREET),
                Enter.theValue(ciudad).into(ShippingPage.TXT_CITY),
                WaitUntil.the(ShippingPage.SELECT_REGION, isVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byValue(region_id).from(ShippingPage.SELECT_REGION),
                Enter.theValue(zip).into(ShippingPage.TXT_ZIP),
                SelectFromOptions.byValue(country_id).from(ShippingPage.SELECT_COUNTRY),
                Enter.theValue(telephone).into(ShippingPage.TXT_TELEFONO)
        );
    }


    @And("se valida que se haya comprado el producto correcto")
    public void seValidaQueSeHayaCompradoElProductoCorrecto() {
        String nombreEsperado = theActorInTheSpotlight().recall("nombreProducto");
        if (nombreEsperado == null || nombreEsperado.isBlank()) {
            throw new AssertionError("No se guardó el nombre del producto desde el carrito (nombreProducto es null o vacío)");
        }
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ShippingPage.PRODUCT_NAME_IN_ORDER, isVisible()).forNoMoreThan(10).seconds()
        );
        String nombreEnOrden = theActorInTheSpotlight().asksFor(Text.of(ShippingPage.PRODUCT_NAME_IN_ORDER)).trim();
        System.out.println("Producto esperado: " + nombreEsperado);
        System.out.println("Producto en orden: " + nombreEnOrden);
        theActorInTheSpotlight().should(
                seeThat("el producto comprado es el correcto",
                        actor -> nombreEsperado.equalsIgnoreCase(nombreEnOrden)
                )
        );
    }

    /**
     * Verificar la busqueda de un producto que no existe
     */

    @When("el usuario le da click en la caja de busqueda")
    public void elUsuarioLeDaClickEnLaCajaDeBusqueda() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(HomePageMagento.TXT_SEARCH)
        );
    }

    @And("el usuario ingresa el nombre de un producto {string} que no existe")
    public void elUsuarioIngresaElNombreDeUnProductoQueNoExiste(String producto) {
        theActorInTheSpotlight().attemptsTo(
                Enter.theValue(producto)
                        .into(HomePageMagento.TXT_SEARCH)
                        .thenHit(Keys.ENTER)
        );
    }

    @Then("Se muestra el aviso de que no se han retornado resultados")
    public void seMuestraElAvisoDeQueNoSeHanRetornadoResultados() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomePageMagento.NO_SEARCH_RESULTS_MESSAGE, isVisible()).forNoMoreThan(10).seconds()
        );

        theActorInTheSpotlight().should(
                seeThat(the(HomePageMagento.NO_SEARCH_RESULTS_MESSAGE), isVisible())
        );
    }

    @And("el usuario navega hasta la seccion de Account Information")
    public void elUsuarioNavegaHastaLaSeccionDeAccountInformation() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(HomePageMagento.ACCOUNT_INFORMATION_OPTION)
        );
    }

    @And("el usuario cambia el nombre {string} en la caja de firstname")
    public void elUsuarioCambiaElNombreEnLaCajaDeFirstname(String nombre_cambiado) {
        theActorInTheSpotlight().attemptsTo(
                Enter.theValue(nombre_cambiado)
                        .into(HomePageMagento.FIRST_NAME_INPUT)
        );
    }


    @And("el usuario presiona el boton save")
    public void elUsuarioPresionaElBotonSave() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(HomePageMagento.SAVE_BUTTON)
        );
    }


    @And("se verifica que el nombre haya cambiado en el icono del usuario")
    public void seVerificaQueElNombreHayaCambiadoEnElIconoDelUsuario() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomePageMagento.ACCOUNT_INFO_SUCCESS_MESSAGE, isVisible()).forNoMoreThan(10).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat(the(HomePageMagento.ACCOUNT_INFO_SUCCESS_MESSAGE), isVisible())
        );
    }




}
