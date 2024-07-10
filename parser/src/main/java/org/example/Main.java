package org.example;

import org.example.lexer.InputReader;
import org.example.lexer.Lexer;
import org.example.lexer.LexerImpl;
import org.example.lexer.token.Token;
import org.example.parser.Parser;
import org.example.parser.ParserDebugPrinter;
import org.example.parser.ParserImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String input = InputReader.readFile("example/calculator.fin");
        Lexer lexer = new LexerImpl(input);
        //LexerDebugPrinter printer = new LexerDebugPrinter(lexer);
        //printer.run();
        List<Token> tokens = lexer.run();
        Parser parser = new ParserImpl(tokens);
        ParserDebugPrinter parserPrinter = new ParserDebugPrinter(parser);
        parserPrinter.run();
    }
}