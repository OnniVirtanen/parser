package org.example.parser.ast.expression;

import org.example.parser.ast.ASTVisitor;

public class LiteralExpression extends Expression {
    private final String value;

    public LiteralExpression(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
