package org.example.lexer.token.keyword;

import org.example.lexer.token.Token;
import org.example.lexer.token.TokenType;

public final class KeywordToken extends Token {

    private final KeywordType keywordType;

    public KeywordToken(KeywordType keywordType) {
        super(TokenType.KEYWORD);
        this.keywordType = keywordType;
    }

    public KeywordType getKeywordType() {
        return keywordType;
    }

    @Override
    public String toString() {
        return "KeywordToken{" +
                "keywordType=" + keywordType +
                '}';
    }

}