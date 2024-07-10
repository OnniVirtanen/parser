package org.example.parser.ast.expression;

public class LiteralExpression extends Expression {
    private final String value;

    public LiteralExpression(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
