package org.example.lexer.token.literal;

import org.example.lexer.token.InnerTokenType;

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

    public static boolean isNumberInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNullLiteral(String text) {
        return text.equals("null");
    }

    public static boolean isBooleanLiteral(String text) {
        return "true".equals(text) || "false".equals(text);
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
