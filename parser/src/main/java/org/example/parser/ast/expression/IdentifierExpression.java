package org.example.parser.ast.expression;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.parser.ast.ASTVisitor;

public final class IdentifierExpression extends Expression {
    @JsonProperty("identifier")
    private final String identifier;

    public IdentifierExpression(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
