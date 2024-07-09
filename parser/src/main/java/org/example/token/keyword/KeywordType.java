package org.example.token.keyword;

import org.example.token.InnerTokenType;

public enum KeywordType implements InnerTokenType<KeywordType> {
    IF(0, "if"),
    ELSE(1, "else"),
    WHILE(2, "while"),
    INT(3, "int"),
    FLOAT(4, "float"),
    BOOLEAN(5, "bool"),
    CHARACTER(6, "char"),
    STRING(7, "string"),
    FUNCTION(8, "fun"),
    RETURN(9, "return");

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