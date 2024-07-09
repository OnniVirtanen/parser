package org.example;

import org.example.lexer.Lexer;
import org.example.lexer.LexerImpl;
import org.example.token.Token;
import org.example.token.TokenType;
import org.example.token.operator.OperatorToken;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text = "if x == 100";
        Lexer lexer = new LexerImpl(text);
        List<Token> tokens = new ArrayList<>();
        while (lexer.peek().getType() != TokenType.EOF) {
            tokens.add(lexer.nextToken());
        }
        for (Token token : tokens) {
            if (token.getType() == TokenType.OPERATOR) {
                OperatorToken oToken = (OperatorToken) token;
                System.out.print(oToken.getOperatorType() + ":");
            }
            System.out.println(token.getType());
        }
    }
}