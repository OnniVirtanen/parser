package org.example.token;

public abstract class Token {

    private final TokenType type;

    protected Token(TokenType type) {
        this.type = type;
    }

    public TokenType getType() {
        return this.type;
    }

}
