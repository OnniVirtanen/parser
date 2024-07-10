package org.example.lexer.token;

public class UnknownToken extends Token {

    public UnknownToken() {
        super(TokenType.UNKNOWN);
    }

    @Override
    public String toString() {
        return "UnknownToken{}";
    }

}
