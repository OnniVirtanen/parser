package org.example.lexer;

import org.example.token.TokenType;
import org.junit.jupiter.api.Test;

public class LexerTest {

    private Lexer lexer;

    @Test
    public void canLexIdentifier() {
        String input = "sum";
        lexer = new LexerImpl(input);
        assert lexer.nextToken().getType() == TokenType.IDENTIFIER;
    }

    @Test
    public void canLexKeyword() {
        String input = "int";
        lexer = new LexerImpl(input);
        assert lexer.nextToken().getType() == TokenType.KEYWORD;
    }

    @Test
    public void canLexLiteral() {
        String input = "4";
        lexer = new LexerImpl(input);
        assert lexer.nextToken().getType() == TokenType.LITERAL;
    }

    @Test
    public void canLexOperator() {
        String input = "+";
        lexer = new LexerImpl(input);
        assert lexer.nextToken().getType() == TokenType.OPERATOR;
    }

    @Test
    public void canLexSeparator() {
        String input = "(";
        lexer = new LexerImpl(input);
        assert lexer.nextToken().getType() == TokenType.SEPARATOR;
    }

    @Test
    public void canLexEOF() {
        String input = "";
        lexer = new LexerImpl(input);
        assert lexer.peek().getType() == TokenType.EOF;
    }

}