package org.example.parser.ast.statement;

import org.example.parser.ast.ASTVisitor;
import org.example.parser.ast.expression.Expression;

import java.util.List;

public final class IfStatement extends Statement {
    private final Expression condition;
    private final List<Statement> ifBody;
    private final List<Statement> elseBody;

    public IfStatement(Expression condition, List<Statement> ifBody, List<Statement> elseBody) {
        this.condition = condition;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getIfBody() {
        return ifBody;
    }

    public List<Statement> getElseBody() {
        return elseBody;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
