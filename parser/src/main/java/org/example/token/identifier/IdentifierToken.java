package org.example.token.identifier;

import org.example.token.Token;
import org.example.token.TokenType;

public final class IdentifierToken extends Token {

    private final String value;

    public IdentifierToken(String value) {
        super(TokenType.IDENTIFIER);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
