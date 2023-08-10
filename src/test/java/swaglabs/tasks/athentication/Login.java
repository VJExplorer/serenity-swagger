package swaglabs.tasks.athentication;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.Button;
import swaglabs.model.SwaglabsUser;

import java.awt.*;


public class Login {
    public static Performable asA(SwaglabsUser standardUser){
        return Task.where("{0} logs in as a " +standardUser,
                Enter.theValue(standardUser.username).into("#user-name"),
                Enter.theValue(standardUser.password).into("#password"),
                Click.on(Button.called("Login"))

        );

    }

}
