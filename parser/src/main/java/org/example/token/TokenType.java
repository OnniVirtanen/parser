package org.example.token;

public enum TokenType {
    KEYWORD(0),
    IDENTIFIER(1),
    OPERATOR(2),
    SEPARATOR(3),
    LITERAL(4);

    private final int value;

    TokenType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TokenType getType(int value) {
        for (TokenType type : TokenType.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }

}
