package org.example.lexer;

import org.example.lexer.token.Token;

import java.util.List;

public interface Lexer {

    Token nextToken();
    Token peek();
    List<Token> run();

}
