package com.kostya.greeter.hidden.dictionaries;

import com.kostya.greeter.exposed.Language;

public class GreetingsDictionaryFactory {

    public static GreetingsDictionary getDictionary(Language language) {
        switch (language) {
            case HEBREW:
                return getHebrewDictionary();
            case ENGLISH:
            default:
                return getEnglishDictionary();
        }
    }

    public static EnglishGreetingsDictionary getEnglishDictionary() {
        return new EnglishGreetingsDictionary();
    }

    public static HebrewGreetingsDictionary getHebrewDictionary() {
        return new HebrewGreetingsDictionary();
    }

}
