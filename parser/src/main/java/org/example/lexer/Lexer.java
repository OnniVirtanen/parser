package org.example.lexer;

import org.example.lexer.token.Token;

public interface Lexer {

    Token nextToken();
    Token peek();

}
