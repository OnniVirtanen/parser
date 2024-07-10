package org.example.parser.ast;

import org.example.parser.ast.statement.Statement;

import java.util.List;

public final class Program {

    private final List<Statement> statementList;

    public Program(List<Statement> statementList) {
        this.statementList = statementList;
    }

}
