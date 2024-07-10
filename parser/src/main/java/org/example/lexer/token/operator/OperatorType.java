package org.example.lexer.token.operator;

import org.example.lexer.token.InnerTokenType;

public enum OperatorType implements InnerTokenType<OperatorType> {
    ADDITION(0, "+"),
    SUBTRACTION(1, "-"),
    MULTIPLICATION(2, "*"),
    DIVISION(3, "/"),
    MODULUS(4, "%"),
    LOGICAL_AND(5, "&&"),
    LOGICAL_OR(6, "||"),
    LOGICAL_NOT(7, "!"),
    EQUAL_TO(8, "=="),
    NOT_EQUAL_TO(9, "!="),
    LESS_THAN(10, "<"),
    GREATER_THAN(11, ">"),
    LESS_THAN_OR_EQUAL_TO(12, "<="),
    GREATER_THAN_OR_EQUAL_TO(13, ">="),
    ASSIGNMENT(14, "="),
    ADD_AND_ASSIGN(15, "+="),
    SUBTRACT_AND_ASSIGN(16, "-="),
    MULTIPLY_AND_ASSIGN(17, "*="),
    DIVIDE_AND_ASSIGN(18, "/="),
    MODULUS_AND_ASSIGN(19, "%=");

    private final int value;
    private final String symbol;

    OperatorType(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    @Override
    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public static OperatorType getOperatorType(String text) {
        for (OperatorType type : OperatorType.values()) {
            if (type.symbol.equals(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + text);
    }

    @Override
    public OperatorType[] getValues() {
        return OperatorType.values();
    }

}