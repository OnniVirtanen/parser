package org.example.parser.ast.statement;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.parser.ast.ASTVisitor;
import org.example.parser.ast.expression.Expression;

import java.util.List;

public final class WhileStatement extends Statement {
    @JsonProperty("condition")
    private final Expression condition;
    @JsonProperty("body")
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

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
