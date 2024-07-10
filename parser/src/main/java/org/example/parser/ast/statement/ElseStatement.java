package org.example.parser.ast.statement;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.parser.ast.ASTVisitor;

import java.util.List;

public final class ElseStatement extends Statement {
    @JsonProperty("body")
    private final List<Statement> body;

    public ElseStatement(List<Statement> body) {
        this.body = body;
    }

    public List<Statement> getBody() {
        return body;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
