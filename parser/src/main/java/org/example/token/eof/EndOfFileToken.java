package org.example.token.eof;

import org.example.token.Token;
import org.example.token.TokenType;

public final class EndOfFileToken extends Token {

    public EndOfFileToken() {
        super(TokenType.EOF);
    }

}
