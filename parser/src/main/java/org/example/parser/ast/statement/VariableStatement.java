package org.example.parser.ast.statement;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.parser.ast.ASTVisitor;
import org.example.parser.ast.expression.Expression;

public final class VariableStatement extends Statement {
    @JsonProperty("type")
    private final String type;
    @JsonProperty("identifier")
    private final String identifier;
    @JsonProperty("expression")
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
