package org.example.lexer;

import org.example.lexer.token.Token;
import org.example.lexer.token.TokenType;
import org.example.lexer.token.literal.LiteralToken;
import org.example.lexer.token.literal.LiteralType;
import org.junit.jupiter.api.Test;

public class LexerLiteralTest {

    private Lexer lexer;

    @Test
    public void canLexInteger() {
        String input = "1";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.LITERAL;
        LiteralToken literalToken = (LiteralToken) token;
        assert literalToken.getLiteralType() == LiteralType.INTEGER;
        assert literalToken.getValue() == "1";
    }

    @Test
    public void canLexFloating() {
        String input = "2.3";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.LITERAL;
        LiteralToken literalToken = (LiteralToken) token;
        assert literalToken.getLiteralType() == LiteralType.FLOATING;
        assert literalToken.getValue() == "2.3";
    }

    @Test
    public void canLexBoolean() {
        String input = "true";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.LITERAL;
        LiteralToken literalToken = (LiteralToken) token;
        assert literalToken.getLiteralType() == LiteralType.BOOLEAN;
        assert literalToken.getValue() == "true";
    }

    @Test
    public void canLexCharacter() {
        String input = "'A'";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.LITERAL;
        LiteralToken literalToken = (LiteralToken) token;
        assert literalToken.getLiteralType() == LiteralType.CHARACTER;
        assert literalToken.getValue() == "'A'";
    }

    @Test
    public void canLexString() {
        String input = "\"hello\"";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.LITERAL;
        LiteralToken literalToken = (LiteralToken) token;
        assert literalToken.getLiteralType() == LiteralType.STRING;
        assert literalToken.getValue().equals("\"hello\"");
    }

    @Test
    public void canLexNull() {
        String input = "null";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.LITERAL;
        LiteralToken literalToken = (LiteralToken) token;
        assert literalToken.getLiteralType() == LiteralType.NULL;
        assert literalToken.getValue().equals("null");
    }

}
