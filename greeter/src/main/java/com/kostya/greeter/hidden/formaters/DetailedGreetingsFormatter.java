package com.kostya.greeter.hidden.formaters;

import com.kostya.greeter.exposed.Greeting;
import com.kostya.greeter.exposed.GreetingsFormatter;

public class DetailedGreetingsFormatter implements GreetingsFormatter {
    @Override
    public String format(Greeting greeting) {
        return greeting.getSender() + " says in " + greeting.getLanguage() + " \"" + greeting.getText() + "\" to " + greeting.getReceiver();
    }
}
