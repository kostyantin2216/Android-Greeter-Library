package com.kostya.greeter.hidden.dictionaries;

import com.kostya.greeter.exposed.Language;

public class EnglishGreetingsDictionary implements GreetingsDictionary {
    @Override
    public Language getLanguage() {
        return Language.ENGLISH;
    }

    @Override
    public String getFormal() {
        return "Hello";
    }

    @Override
    public String getFriendly() {
        return "Hello friend";
    }

    @Override
    public String getEvil() {
        return "Hello... muahaha";
    }

    @Override
    public String getLazy() {
        return "ummmm.... hi";
    }

    @Override
    public String getExcited() {
        return "HELLO!!!!!";
    }
}
