package org.example.parser;

import org.example.parser.ast.Program;
import org.example.parser.ast.statement.Statement;

public final class ParserDebugPrinter {

    private final Parser parser;

    public ParserDebugPrinter(Parser parser) {
        this.parser = parser;
    }

    public void run() {
        Program program = parser.parse();
        for (Statement statement : program.getStatementList()) {
            System.out.println(statement.toString());
        }
    }

}

