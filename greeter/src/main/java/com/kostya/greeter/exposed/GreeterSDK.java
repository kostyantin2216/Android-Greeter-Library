package com.kostya.greeter.exposed;

import com.kostya.greeter.hidden.formaters.DetailedGreetingsFormatter;
import com.kostya.greeter.hidden.formaters.SimpleGreetingsFormatter;

public class GreeterSDK {

    public final static GreetingsFormatter SIMPLE_FORMATTER = new SimpleGreetingsFormatter();
    public final static GreetingsFormatter DETAILED_FORMATTER = new DetailedGreetingsFormatter();
    public final static Language DEFAULT_LANGUAGE = Language.ENGLISH;

    private static Language mLanguage = DEFAULT_LANGUAGE;

    public static Greeter getGreeter(String sender, String receiver) {
        return new Greeter(mLanguage, sender, receiver);
    }

    public static void setLanguage(Language language) {
        mLanguage = language;
    }

    public static Language getLanguage() {
        return mLanguage;
    }

}
