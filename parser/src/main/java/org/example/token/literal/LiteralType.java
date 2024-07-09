package org.example.token.literal;

import org.example.token.InnerTokenType;

public enum LiteralType implements InnerTokenType<LiteralType> {
    INTEGER(0),
    FLOATING(1),
    BOOLEAN(2),
    CHARACTER(3),
    STRING(4),
    NULL(5);

    private final int value;

    private LiteralType(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public LiteralType[] getValues() {
        return LiteralType.values();
    }

}
