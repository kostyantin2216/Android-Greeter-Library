package com.kostya.greeter.exposed;

import com.kostya.greeter.hidden.GreetingFactory;
import com.kostya.greeter.hidden.formaters.DetailedGreetingsFormatter;
import com.kostya.greeter.hidden.formaters.SimpleGreetingsFormatter;

public class Greeter {

    private final Language mLanguage;
    private final String mSender;
    private final String mReceiver;

    private final GreetingFactory mFactory;
    private GreetingsFormatter mFormatter;

    Greeter(Language language, String sender, String receiver) {
        this(language, sender, receiver, new SimpleGreetingsFormatter());
    }

    Greeter(Language language, String sender, String receiver, GreetingsFormatter formatter) {
        mLanguage = language;
        mSender = sender;
        mReceiver = receiver;
        mFactory = GreetingFactory.getInstance(language);
        mFormatter = formatter;
    }

    public void setFormatter(GreetingsFormatter formatter) {
        mFormatter = formatter;
    }

    public Language getLanguage() {
        return mLanguage;
    }

    public Greeting getFormalGreeting() {
        return mFactory.formalGreeting(mSender, mReceiver);
    }

    public Greeting getFriendlyGreeting() {
        return mFactory.friendlyGreeting(mSender, mReceiver);
    }

    public Greeting getEvilGreeting() {
        return mFactory.evilGreeting(mSender, mReceiver);
    }

    public Greeting getLazyGreeting() {
        return mFactory.lazyGreeting(mSender, mReceiver);
    }

    public Greeting getExcitedGreeting() {
        return mFactory.excitedGreeting(mSender, mReceiver);
    }

    public String format(Greeting greeting) {
        return mFormatter.format(greeting);
    }

    public String formatFormalGreeting() {
        return format(getFormalGreeting());
    }

    public String formatFriendlylGreeting() {
        return format(getFriendlyGreeting());
    }

    public String formatEvilGreeting() {
        return format(getEvilGreeting());
    }

    public String formatLazyGreeting() {
        return format(getLazyGreeting());
    }

    public String formatExcitedGreeting() {
        return format(getExcitedGreeting());
    }

}
