package org.example.parser.ast.statement;

import org.example.parser.ast.ASTVisitor;
import org.example.parser.ast.expression.Expression;

public final class VariableStatement extends Statement {
    private final String type;
    private final String identifier;
    private final Expression expression;

    public VariableStatement(String type, String identifier, Expression expression) {
        this.type = type;
        this.identifier = identifier;
        this.expression = expression;
    }

    public String getType() {
        return type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
