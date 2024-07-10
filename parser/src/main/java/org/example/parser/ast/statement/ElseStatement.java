package org.example.parser.ast.statement;

import java.util.List;

public final class ElseStatement extends Statement {
    private final List<Statement> body;

    public ElseStatement(List<Statement> body) {
        this.body = body;
    }

    public List<Statement> getBody() {
        return body;
    }

}
