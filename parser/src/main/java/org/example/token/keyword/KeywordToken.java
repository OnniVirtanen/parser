package org.example.token.keyword;

import org.example.token.Token;
import org.example.token.TokenType;

public final class KeywordToken extends Token {

    private final KeywordType keywordType;

    public KeywordToken(KeywordType keywordType) {
        super(TokenType.KEYWORD);
        this.keywordType = keywordType;
    }

    public KeywordType getKeywordType() {
        return keywordType;
    }

}