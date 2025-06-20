package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.demoblaze.HomePage;
import com.nttdata.testing.Pages.magento.CarPageMagento;
import com.nttdata.testing.Pages.magento.HomePageMagento;
import com.nttdata.testing.Pages.magento.RegisterPageMagento;
import com.nttdata.testing.Pages.magento.SignPageMagento;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theHomePage() {
        return Task.where("{0} opens the Home page",
                Open.browserOn().the(HomePage.class));
    }

    public static Performable theSignPageMagento() {
        return Task.where("{0} opens the Sign page magento",
                Open.browserOn().the(SignPageMagento.class));
    }

    public static Performable theHomePageMagento() {
        return Task.where("{0} opens the Home page magento",
                Open.browserOn().the(HomePageMagento.class));
    }

    public static Performable theRegisterPageMagento() {
        return Task.where("{0} opens the Register page magento",
                Open.browserOn().the(RegisterPageMagento.class));
    }

    public static Performable theCarPageMagento() {
        return Task.where("{0} opens the Car page magento",
                Open.browserOn().the(CarPageMagento.class));
    }
}
