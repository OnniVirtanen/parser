package org.example.lexer;

import org.example.lexer.token.Token;
import org.example.lexer.token.TokenType;
import org.example.lexer.token.literal.LiteralToken;
import org.example.lexer.token.literal.LiteralType;
import org.example.lexer.token.separator.SeparatorToken;
import org.example.lexer.token.separator.SeparatorType;
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
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.LITERAL;
        LiteralToken literalToken = (LiteralToken) token;
        assert literalToken.getLiteralType() == LiteralType.INTEGER;
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
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.SEPARATOR;
        SeparatorToken separatorToken = (SeparatorToken) token;
        assert separatorToken.getSeparatorType() == SeparatorType.LEFT_PARENTHESIS;
    }

    @Test
    public void canLexEOF() {
        String input = "";
        lexer = new LexerImpl(input);
        assert lexer.peek().getType() == TokenType.EOF;
    }

}