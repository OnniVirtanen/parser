package org.example.parser.ast.statement;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.parser.ast.ASTVisitor;
import org.example.parser.ast.expression.Expression;

import java.util.List;

public final class IfStatement extends Statement {
    @JsonProperty("condition")
    private final Expression condition;
    @JsonProperty("ifBody")
    private final List<Statement> ifBody;
    @JsonProperty("elseBody")
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
