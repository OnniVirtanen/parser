package org.example.parser.ast.statement;

import org.example.parser.ast.ASTVisitor;
import org.example.parser.ast.expression.Expression;

public final class ReturnStatement extends Statement {
    private final Expression expression;

    public ReturnStatement(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
