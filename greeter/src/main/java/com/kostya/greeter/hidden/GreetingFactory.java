package com.kostya.greeter.hidden;

import com.kostya.greeter.exposed.Greeting;
import com.kostya.greeter.exposed.Language;
import com.kostya.greeter.hidden.dictionaries.GreetingsDictionary;
import com.kostya.greeter.hidden.dictionaries.GreetingsDictionaryFactory;

import java.util.HashMap;
import java.util.Map;

public class GreetingFactory {

    private final static Map<String, GreetingFactory> mInstances = new HashMap<>();

    public static GreetingFactory getInstance(Language language) {
        GreetingFactory instance = mInstances.get(language.name());

        if (instance == null) {
            synchronized (mInstances) {
                instance = new GreetingFactory(language);
                mInstances.put(language.name(), instance);
            }
        }

        return instance;
    }

    private final GreetingsDictionary mDictionary;

    private GreetingFactory(Language language) {
        mDictionary = GreetingsDictionaryFactory.getDictionary(language);
    }

    public Greeting formalGreeting(String sender, String receiver) {
        String text = mDictionary.getFormal();
        String id = createKey(sender, receiver, text);
        return new Greeting(id, text, sender, receiver, mDictionary.getLanguage());
    }

    public Greeting friendlyGreeting(String sender, String receiver) {
        String text = mDictionary.getFriendly();
        String id = createKey(sender, receiver, text);
        return new Greeting(id, text, sender, receiver, mDictionary.getLanguage());
    }

    public Greeting evilGreeting(String sender, String receiver) {
        String text = mDictionary.getEvil();
        String id = createKey(sender, receiver, text);
        return new Greeting(id, text, sender, receiver, mDictionary.getLanguage());
    }

    public Greeting lazyGreeting(String sender, String receiver) {
        String text = mDictionary.getLazy();
        String id = createKey(sender, receiver, text);
        return new Greeting(id, text, sender, receiver, mDictionary.getLanguage());
    }

    public Greeting excitedGreeting(String sender, String receiver) {
        String text = mDictionary.getExcited();
        String id = createKey(sender, receiver, text);
        return new Greeting(id, text, sender, receiver, mDictionary.getLanguage());
    }

    private String createKey(String sender, String receiver, String text) {
        return sender + "_" + receiver + "_" + text;
    }

}
