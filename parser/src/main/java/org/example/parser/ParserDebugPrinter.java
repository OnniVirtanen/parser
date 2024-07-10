package org.example.parser;

import org.example.parser.ast.ASTPrinterVisitor;
import org.example.parser.ast.Program;

public final class ParserDebugPrinter {

    private final Parser parser;

    public ParserDebugPrinter(Parser parser) {
        this.parser = parser;
    }

    public void run() {
        Program program = parser.parse();
        ASTPrinterVisitor printerVisitor = new ASTPrinterVisitor();
        program.accept(printerVisitor);
    }

}

