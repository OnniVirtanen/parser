package org.example.token.separator;

import org.example.token.InnerTokenType;
import org.example.token.operator.OperatorType;

public enum SeparatorType implements InnerTokenType<SeparatorType> {
    SEMICOLON(0, ";"),
    COMMA(1, ","),
    LEFT_PARENTHESIS(2, "("), // (
    RIGHT_PARENTHESIS(3, ")"),
    LEFT_BRACKET(4, "["), // [
    RIGHT_BRACKET(5, "]"),
    PERIOD(6, "."),
    COLON(7, ":");

    private final int value;
    private final String symbol;

    SeparatorType(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public static SeparatorType getSeparatorType(String text) {
        for (SeparatorType type : SeparatorType.values()) {
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
    public SeparatorType[] getValues() {
        return SeparatorType.values();
    }

    public String getSymbol() {
        return symbol;
    }

}
