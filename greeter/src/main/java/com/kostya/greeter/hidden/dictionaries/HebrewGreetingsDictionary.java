package com.kostya.greeter.hidden.dictionaries;

import com.kostya.greeter.exposed.Language;

public class HebrewGreetingsDictionary implements GreetingsDictionary {
    @Override
    public Language getLanguage() {
        return Language.HEBREW;
    }

    @Override
    public String getFormal() {
        return "shalom";
    }

    @Override
    public String getFriendly() {
        return "ahlan haver";
    }

    @Override
    public String getEvil() {
        return "ma ata rotze";
    }

    @Override
    public String getLazy() {
        return "hi";
    }

    @Override
    public String getExcited() {
        return "SHALOOOMMMM!!!!!!";
    }
}
