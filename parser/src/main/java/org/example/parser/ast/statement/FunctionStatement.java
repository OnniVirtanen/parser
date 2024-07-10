package org.example.parser.ast.statement;

import org.example.parser.ast.parameter.Parameter;

import java.util.List;

public final class FunctionStatement extends Statement {
    private final String identifier;
    private final List<Parameter> parameters;
    private final String returnType;
    private final List<Statement> body;

    public FunctionStatement(String identifier, List<Parameter> parameters, String returnType, List<Statement> body) {
        this.identifier = identifier;
        this.parameters = parameters;
        this.returnType = returnType;
        this.body = body;
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public String getReturnType() {
        return returnType;
    }

    public List<Statement> getBody() {
        return body;
    }

}
