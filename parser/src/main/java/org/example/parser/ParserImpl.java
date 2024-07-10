package org.example.parser;

import org.example.lexer.token.Token;
import org.example.parser.ast.Program;

import java.util.List;

public class ParserImpl implements Parser {

    private final List<Token> tokens;

    public ParserImpl(List<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public Program parse(List<Token> tokens) {
        return null;
    }

}
