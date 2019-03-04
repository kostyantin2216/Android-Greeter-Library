package com.kostya.greeter.exposed;

public enum Language {
    HEBREW, ENGLISH;

    public static String[] names() {
        return new String[] {
            HEBREW.name(),
            ENGLISH.name()
        };
    }

    public static Language fromName(String name) {
        if (HEBREW.name().equals(name)) return HEBREW;
        if (ENGLISH.name().equals(name)) return ENGLISH;
        return null;
    }
}
