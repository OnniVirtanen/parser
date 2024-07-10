package org.example.lexer;

import org.example.lexer.token.Token;

import java.util.List;

public final class LexerDebugPrinter {

    private final Lexer lexer;

    public LexerDebugPrinter(Lexer lexer) {
        this.lexer = lexer;
    }

    public void run() {
        List<Token> tokens = lexer.run();
        for (Token token : tokens) {
            System.out.println(token.toString());
        }
    }

}
