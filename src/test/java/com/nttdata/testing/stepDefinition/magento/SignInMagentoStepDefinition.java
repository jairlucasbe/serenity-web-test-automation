package com.nttdata.testing.stepDefinition.magento;

import com.nttdata.testing.Pages.MenClothesPage;
import com.nttdata.testing.Pages.magento.AccountPageMagento;
import com.nttdata.testing.Pages.magento.HomePageMagento;
import com.nttdata.testing.Pages.magento.RegisterPageMagento;
import com.nttdata.testing.Pages.magento.SignPageMagento;
import com.nttdata.testing.Tasks.NavigateTo;
import com.nttdata.testing.variables.SessionVariables;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

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
        seeThat(WebElementQuestion.the(SignPageMagento.MSG_LOGIN_INVALIDO), WebElementStateMatchers.isVisible());
    }

    @And("aparece en pantalla el mensaje de bienvenido")
    public void apareceEnPantallaElMensajeDeBienvenido() {
        seeThat(WebElementQuestion.the(SignPageMagento.SPAN_BIENVENIDA), WebElementStateMatchers.isVisible());
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
        seeThat(WebElementQuestion.the(RegisterPageMagento.MSG_REGISTRO_EXITOSO), WebElementStateMatchers.isVisible());
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
}
