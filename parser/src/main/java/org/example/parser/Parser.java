package org.example.parser;

import org.example.lexer.token.Token;
import org.example.parser.ast.Program;

import java.util.List;

public interface Parser {

    Program parse(List<Token> tokens);

}
