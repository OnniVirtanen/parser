package org.example.token.separator;

import org.example.token.InnerTokenType;

public enum SeparatorType implements InnerTokenType<SeparatorType> {
    SEMICOLON(0),
    COMMA(1),
    LEFT_PARENTHESIS(2), // (
    RIGHT_PARENTHESIS(3),
    LEFT_BRACKET(4), // [
    RIGHT_BRACKET(5),
    PERIOD(6),
    COLON(7);

    private final int value;

    SeparatorType(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public SeparatorType[] getValues() {
        return SeparatorType.values();
    }

}
