package org.example.token.separator;

import org.example.token.Token;
import org.example.token.TokenType;

public final class SeparatorToken extends Token {

    private final SeparatorType separatorType;

    public SeparatorToken(SeparatorType separatorType) {
        super(TokenType.SEPARATOR);
        this.separatorType = separatorType;
    }

    public SeparatorType getSeparatorType() {
        return separatorType;
    }

    @Override
    public String toString() {
        return "SeparatorToken{" +
                "separatorType=" + separatorType +
                '}';
    }

}
