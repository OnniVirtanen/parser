package org.example.lexer;

import org.example.lexer.token.Token;
import org.example.lexer.token.TokenType;

import java.util.ArrayList;
import java.util.List;

public final class LexerDebugPrinter {

    private final Lexer lexer;

    public LexerDebugPrinter(Lexer lexer) {
        this.lexer = lexer;
    }

    public void run() {
        List<Token> tokens = new ArrayList<>();
        while (lexer.peek().getType() != TokenType.EOF) {
            tokens.add(lexer.nextToken());
        }
        for (Token token : tokens) {
            System.out.println(token.toString());
        }
    }

}
