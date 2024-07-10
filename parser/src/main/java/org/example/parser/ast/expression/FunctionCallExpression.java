package org.example.parser.ast.expression;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.parser.ast.ASTVisitor;

import java.util.List;

public final class FunctionCallExpression extends Expression {
    @JsonProperty("identifier")
    private final String identifier;
    @JsonProperty("arguments")
    private final List<Expression> arguments;

    public FunctionCallExpression(String identifier, List<Expression> arguments) {
        this.identifier = identifier;
        this.arguments = arguments;
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
