package org.example.lexer.token.literal;

import org.example.lexer.token.Token;
import org.example.lexer.token.TokenType;

public final class LiteralToken extends Token {

    private final String value;
    private final LiteralType literalType;

    public LiteralToken(String value, LiteralType literalType) {
        super(TokenType.LITERAL);
        this.value = value;
        this.literalType = literalType;
    }

    public String getValue() {
        return value;
    }

    public LiteralType getLiteralType() {
        return literalType;
    }

    @Override
    public String toString() {
        return "LiteralToken{" +
                "value='" + value + '\'' +
                ", literalType=" + literalType +
                '}';
    }

}