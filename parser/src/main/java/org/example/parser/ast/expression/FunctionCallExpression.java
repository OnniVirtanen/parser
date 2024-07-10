package org.example.parser.ast.expression;

import java.util.List;

public final class FunctionCallExpression extends Expression {
    private final String identifier;
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

}
