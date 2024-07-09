package org.example.token;

public final class EndOfFileToken extends Token {

    public EndOfFileToken() {
        super(TokenType.EOF);
    }

    @Override
    public String toString() {
        return "EndOfFileToken{}";
    }

}
