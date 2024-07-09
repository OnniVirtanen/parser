package org.example.token.keyword;

import org.example.token.InnerTokenType;

public enum KeywordType implements InnerTokenType<KeywordType> {
    IF(0, "if"),
    ELSE(1, "else"),
    SWITCH(2, "switch"),
    WHILE(3, "while"),
    DO(4, "do"),
    FOR(5, "for"),
    INT(6, "int"),
    FLOAT(7, "float"),
    BOOLEAN(8, "boolean"),
    CHAR(9, "char");

    private final int value;
    private final String symbol;

    KeywordType(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public static boolean isKeyword(String text) {
        for (KeywordType type : KeywordType.values()) {
            if (type.symbol.equals(text)) {
                return true;
            }
        }
        return false;
    }

    public static KeywordType getType(String text) {
        for (KeywordType type : KeywordType.values()) {
            if (type.symbol.equals(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + text);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public KeywordType[] getValues() {
        return KeywordType.values();
    }

}