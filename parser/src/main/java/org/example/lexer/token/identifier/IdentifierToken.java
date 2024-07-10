package org.example.lexer.token.identifier;

import org.example.lexer.token.Token;
import org.example.lexer.token.TokenType;

public final class IdentifierToken extends Token {

    private final String value;

    public IdentifierToken(String value) {
        super(TokenType.IDENTIFIER);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "IdentifierToken{" +
                "value='" + value + '\'' +
                '}';
    }
    
}
