package org.example.parser.ast.parameter;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.parser.ast.ASTVisitor;

public final class Parameter {
    @JsonProperty("type")
    private final String type;
    @JsonProperty("identifier")
    private final String identifier;

    public Parameter(String type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public String getType() {
        return type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
