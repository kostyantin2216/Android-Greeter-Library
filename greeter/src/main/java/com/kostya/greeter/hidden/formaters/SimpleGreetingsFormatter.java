package com.kostya.greeter.hidden.formaters;

import com.kostya.greeter.exposed.Greeting;
import com.kostya.greeter.exposed.GreetingsFormatter;

public class SimpleGreetingsFormatter implements GreetingsFormatter {
    @Override
    public String format(Greeting greeting) {
        return greeting.getSender() + ": " + greeting.getText();
    }
}
