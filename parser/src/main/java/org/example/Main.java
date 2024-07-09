package org.example;

import org.example.lexer.Lexer;
import org.example.lexer.LexerDebugPrinter;
import org.example.lexer.LexerImpl;

public class Main {

    public static void main(String[] args) {
        String input = InputReader.readFile("example/calculator.fin");
        Lexer lexer = new LexerImpl(input);
        LexerDebugPrinter printer = new LexerDebugPrinter(lexer);
        printer.run();
    }
}