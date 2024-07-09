package org.example.token.operator;

import org.example.token.InnerTokenType;

public enum OperatorType implements InnerTokenType<OperatorType> {
    ADDITION(0),
    SUBTRACTION(1),
    MULTIPLICATION(2),
    DIVISION(3),
    MODULUS(4),
    LOGICAL_AND(5),
    LOGICAL_OR(6),
    LOGICAL_NOT(7),
    EQUAL_TO(8),
    NOT_EQUAL_TO(9),
    LESS_THAN(10),
    GREATER_THAN(11),
    LESS_THAN_OR_EQUAL_TO(12),
    GREATER_THAN_OR_EQUAL_TO(13),
    ASSIGNMENT(14),
    ADD_AND_ASSIGN(15),
    SUBTRACT_AND_ASSIGN(16),
    MULTIPLY_AND_ASSIGN(17),
    DIVIDE_AND_ASSIGN(18),
    MODULUS_AND_ASSIGN(19);

    private final int value;

    OperatorType(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public OperatorType[] getValues() {
        return OperatorType.values();
    }

}