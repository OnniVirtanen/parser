package org.example.parser.ast.parameter;

import org.example.parser.ast.ASTVisitor;

public final class Parameter {
    private final String type;
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
