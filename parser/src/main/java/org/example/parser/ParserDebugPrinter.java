package org.example.parser;

import org.example.parser.ast.ASTJsonVisitor;
import org.example.parser.ast.Program;

import java.io.IOException;

public final class ParserDebugPrinter {

    private final Parser parser;

    public ParserDebugPrinter(Parser parser) {
        this.parser = parser;
    }

    public void run() {
        Program program = parser.parse();
        ASTJsonVisitor jsonVisitor = new ASTJsonVisitor();
        program.accept(jsonVisitor);
        try {
            String jsonOutput = jsonVisitor.getJson();
            System.out.println(jsonOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

