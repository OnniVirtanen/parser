package org.example.parser.ast.statement;

import org.example.parser.ast.expression.Expression;

import java.util.List;

public final class WhileStatement extends Statement {
    private final Expression condition;
    private final List<Statement> body;

    public WhileStatement(Expression condition, List<Statement> body) {
        this.condition = condition;
        this.body = body;
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getBody() {
        return body;
    }

}
