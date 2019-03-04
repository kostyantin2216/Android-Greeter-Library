package com.kostya.testapplication;

import com.kostya.greeter.exposed.Greeting;
import com.kostya.greeter.exposed.GreetingsFormatter;

public class TestGreetingsFormatter implements GreetingsFormatter {
    @Override
    public String format(Greeting greeting) {
        return "testing - sender: " + greeting.getSender() + ", receiver: " + greeting.getReceiver() + ", text: " + greeting.getText();
    }
}
