package org.example.parser.ast.statement;

import org.example.parser.ast.expression.Expression;

public final class ExpressionStatement extends Statement {
    private final Expression expression;

    public ExpressionStatement(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

}
