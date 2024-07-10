package org.example.parser.ast.statement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.example.parser.ast.ASTVisitor;
import org.example.parser.ast.parameter.Parameter;

import java.util.List;

public final class FunctionStatement extends Statement {
    @JsonProperty("identifier")
    private final String identifier;
    @JsonProperty("parameters")
    private final List<Parameter> parameters;
    @JsonProperty("returnType")
    private final String returnType;
    @JsonProperty("body")
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

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
