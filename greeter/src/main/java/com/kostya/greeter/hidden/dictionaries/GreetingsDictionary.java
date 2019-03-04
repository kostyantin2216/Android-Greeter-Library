package com.kostya.greeter.hidden.dictionaries;

import com.kostya.greeter.exposed.Language;

public interface GreetingsDictionary {

    Language getLanguage();
    String getFormal();
    String getFriendly();
    String getEvil();
    String getLazy();
    String getExcited();

}
