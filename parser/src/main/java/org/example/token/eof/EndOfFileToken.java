package org.example.token.eof;

import org.example.token.Token;
import org.example.token.TokenType;

public class EndOfFileToken extends Token {

    public EndOfFileToken() {
        super(TokenType.EOF);
    }

}
