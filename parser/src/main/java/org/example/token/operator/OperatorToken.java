package org.example.token.operator;

import org.example.token.Token;
import org.example.token.TokenType;

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
