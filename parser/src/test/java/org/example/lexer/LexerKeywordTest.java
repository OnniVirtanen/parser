package org.example.lexer;

import org.example.lexer.token.Token;
import org.example.lexer.token.TokenType;
import org.example.lexer.token.keyword.KeywordToken;
import org.example.lexer.token.keyword.KeywordType;
import org.junit.jupiter.api.Test;

public class LexerKeywordTest {

    private Lexer lexer;

    @Test
    public void canLexIf() {
        String input = "if";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.KEYWORD;
        KeywordToken keywordToken = (KeywordToken) token;
        assert keywordToken.getKeywordType() == KeywordType.IF;
    }

    @Test
    public void canLexElse() {
        String input = "else";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.KEYWORD;
        KeywordToken keywordToken = (KeywordToken) token;
        assert keywordToken.getKeywordType() == KeywordType.ELSE;
    }

    @Test
    public void canLexWhile() {
        String input = "while";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.KEYWORD;
        KeywordToken keywordToken = (KeywordToken) token;
        assert keywordToken.getKeywordType() == KeywordType.WHILE;
    }

    @Test
    public void canLexInt() {
        String input = "int";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.KEYWORD;
        KeywordToken keywordToken = (KeywordToken) token;
        assert keywordToken.getKeywordType() == KeywordType.INT;
    }

    @Test
    public void canLexFloat() {
        String input = "float";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.KEYWORD;
        KeywordToken keywordToken = (KeywordToken) token;
        assert keywordToken.getKeywordType() == KeywordType.FLOAT;
    }

    @Test
    public void canLexBoolean() {
        String input = "bool";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.KEYWORD;
        KeywordToken keywordToken = (KeywordToken) token;
        assert keywordToken.getKeywordType() == KeywordType.BOOLEAN;
    }

    @Test
    public void canLexChar() {
        String input = "char";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.KEYWORD;
        KeywordToken keywordToken = (KeywordToken) token;
        assert keywordToken.getKeywordType() == KeywordType.CHARACTER;
    }

    @Test
    public void canLexString() {
        String input = "string";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.KEYWORD;
        KeywordToken keywordToken = (KeywordToken) token;
        assert keywordToken.getKeywordType() == KeywordType.STRING;
    }

    @Test
    public void canLexFunction() {
        String input = "fun";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.KEYWORD;
        KeywordToken keywordToken = (KeywordToken) token;
        assert keywordToken.getKeywordType() == KeywordType.FUNCTION;
    }

    @Test
    public void canLexReturn() {
        String input = "return";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.KEYWORD;
        KeywordToken keywordToken = (KeywordToken) token;
        assert keywordToken.getKeywordType() == KeywordType.RETURN;
    }

    @Test
    public void canLexVoid() {
        String input = "void";
        lexer = new LexerImpl(input);
        Token token = lexer.nextToken();
        assert token.getType() == TokenType.KEYWORD;
        KeywordToken keywordToken = (KeywordToken) token;
        assert keywordToken.getKeywordType() == KeywordType.VOID;
    }

}
