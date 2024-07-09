package org.example.token.keyword;

import org.example.token.InnerTokenType;

public enum KeywordType implements InnerTokenType<KeywordType> {
    IF(0),
    ELSE(1),
    SWITCH(2),
    WHILE(3),
    DO(4),
    FOR(5),
    INT(6),
    FLOAT(7),
    BOOLEAN(8),
    CHAR(9);

    private final int value;

    KeywordType(int value) {
        this.value = value;
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