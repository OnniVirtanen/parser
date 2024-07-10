package org.example.lexer.token.operator;

import org.example.lexer.token.Token;
import org.example.lexer.token.TokenType;

public final class OperatorToken extends Token {

    private final OperatorType operatorType;

    public OperatorToken(OperatorType operatorType) {
        super(TokenType.OPERATOR);
        this.operatorType = operatorType;
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }

    @Override
    public String toString() {
        return "OperatorToken{" +
                "operatorType=" + operatorType +
                '}';
    }

}