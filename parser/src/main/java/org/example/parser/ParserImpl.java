package org.example.parser;

import org.example.lexer.token.Token;
import org.example.lexer.token.TokenType;
import org.example.lexer.token.identifier.IdentifierToken;
import org.example.lexer.token.keyword.KeywordToken;
import org.example.lexer.token.keyword.KeywordType;
import org.example.lexer.token.literal.LiteralToken;
import org.example.lexer.token.operator.OperatorToken;
import org.example.lexer.token.operator.OperatorType;
import org.example.lexer.token.separator.SeparatorToken;
import org.example.lexer.token.separator.SeparatorType;
import org.example.parser.ast.Program;
import org.example.parser.ast.expression.Expression;
import org.example.parser.ast.expression.FunctionCallExpression;
import org.example.parser.ast.expression.IdentifierExpression;
import org.example.parser.ast.expression.LiteralExpression;
import org.example.parser.ast.expression.BinaryExpression;
import org.example.parser.ast.parameter.Parameter;
import org.example.parser.ast.statement.FunctionStatement;
import org.example.parser.ast.statement.*;
import org.example.parser.ast.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {

    private final List<Token> tokens;
    private int pos;

    public ParserImpl(List<Token> tokens) {
        this.tokens = tokens;
        this.pos = 0;
    }

    @Override
    public Program parse() {
        return parseProgram();
    }

    private Program parseProgram() {
        List<Statement> statements = parseStatementList();
        return new Program(statements);
    }

    private List<Statement> parseStatementList() {
        List<Statement> statements = new ArrayList<>();
        while (pos < tokens.size() && !(tokens.get(pos) instanceof SeparatorToken && ((SeparatorToken) tokens.get(pos)).getSeparatorType() == SeparatorType.RIGHT_CURLY_BRACKET)) {
            statements.add(parseStatement());
        }
        return statements;
    }

    private Statement parseStatement() {
        Token token = tokens.get(pos);
        if (token instanceof KeywordToken) {
            switch (((KeywordToken) token).getKeywordType()) {
                case FUNCTION:
                    return parseFunctionStatement();
                case RETURN:
                    return parseReturnStatement();
                case IF:
                    return parseIfStatement();
                case ELSE:
                    return parseElseStatement();
                case WHILE:
                    return parseWhileStatement();
                case INT:
                case FLOAT:
                case STRING:
                case CHARACTER:
                case BOOLEAN:
                case VOID:
                    return parseVariableStatement();
                default:
                    throw new RuntimeException("Unexpected keyword: " + ((KeywordToken) token).getKeywordType());
            }
        } else {
            return parseExpressionStatement();
        }
    }

    private FunctionStatement parseFunctionStatement() {
        match(KeywordType.FUNCTION);
        String identifier = matchIdentifier().getValue();
        match(SeparatorType.LEFT_PARENTHESIS);
        List<Parameter> parameters = parseParameterList();
        match(SeparatorType.RIGHT_PARENTHESIS);
        match(SeparatorType.COLON);
        String returnType = matchKeywordType().toString().toLowerCase();
        match(SeparatorType.LEFT_CURLY_BRACKET);
        List<Statement> body = parseStatementList();
        match(SeparatorType.RIGHT_CURLY_BRACKET);
        return new FunctionStatement(identifier, parameters, returnType, body);
    }

    private List<Parameter> parseParameterList() {
        List<Parameter> parameters = new ArrayList<>();
        if (!(tokens.get(pos) instanceof SeparatorToken && ((SeparatorToken) tokens.get(pos)).getSeparatorType() == SeparatorType.RIGHT_PARENTHESIS)) {
            parameters.add(parseParameter());
            while (tokens.get(pos) instanceof SeparatorToken && ((SeparatorToken) tokens.get(pos)).getSeparatorType() == SeparatorType.COMMA) {
                match(SeparatorType.COMMA);
                parameters.add(parseParameter());
            }
        }
        return parameters;
    }

    private Parameter parseParameter() {
        String identifier = matchIdentifier().getValue();
        match(SeparatorType.COLON);
        String type = matchKeywordType().toString().toLowerCase();
        return new Parameter(type, identifier);
    }

    private VariableStatement parseVariableStatement() {
        String type = matchKeywordType().toString().toLowerCase();
        String identifier = matchIdentifier().getValue();
        match(OperatorType.ASSIGNMENT);
        Expression expression = parseExpression();
        match(SeparatorType.SEMICOLON);
        return new VariableStatement(type, identifier, expression);
    }

    private ReturnStatement parseReturnStatement() {
        match(KeywordType.RETURN);
        Expression expression = parseExpression();
        match(SeparatorType.SEMICOLON);
        return new ReturnStatement(expression);
    }

    private IfStatement parseIfStatement() {
        match(KeywordType.IF);
        match(SeparatorType.LEFT_PARENTHESIS);
        Expression condition = parseExpression();
        match(SeparatorType.RIGHT_PARENTHESIS);
        match(SeparatorType.LEFT_CURLY_BRACKET);
        List<Statement> ifBody = parseStatementList();
        match(SeparatorType.RIGHT_CURLY_BRACKET);
        List<Statement> elseBody = null;
        if (tokens.get(pos) instanceof KeywordToken && ((KeywordToken) tokens.get(pos)).getKeywordType() == KeywordType.ELSE) {
            elseBody = parseElseStatement().getBody();
        }
        return new IfStatement(condition, ifBody, elseBody);
    }

    private ElseStatement parseElseStatement() {
        match(KeywordType.ELSE);
        match(SeparatorType.LEFT_CURLY_BRACKET);
        List<Statement> body = parseStatementList();
        match(SeparatorType.RIGHT_CURLY_BRACKET);
        return new ElseStatement(body);
    }

    private WhileStatement parseWhileStatement() {
        match(KeywordType.WHILE);
        match(SeparatorType.LEFT_PARENTHESIS);
        Expression condition = parseExpression();
        match(SeparatorType.RIGHT_PARENTHESIS);
        match(SeparatorType.LEFT_CURLY_BRACKET);
        List<Statement> body = parseStatementList();
        match(SeparatorType.RIGHT_CURLY_BRACKET);
        return new WhileStatement(condition, body);
    }

    private ExpressionStatement parseExpressionStatement() {
        Expression expression = parseExpression();
        match(SeparatorType.SEMICOLON);
        return new ExpressionStatement(expression);
    }

    private Expression parseExpression() {
        return parseBinaryExpression(0); // Start with the lowest precedence
    }

    private Expression parseBinaryExpression(int precedence) {
        Expression left = parsePrimaryExpression();

        while (true) {
            Token token = tokens.get(pos);
            if (!(token instanceof OperatorToken)) break;

            OperatorToken operatorToken = (OperatorToken) token;
            int tokenPrecedence = getPrecedence(operatorToken);
            if (tokenPrecedence < precedence) break;

            pos++; // Consume the operator
            Expression right = parseBinaryExpression(tokenPrecedence + 1);
            left = new BinaryExpression(left, operatorToken.getOperatorType().toString().toLowerCase(), right);
        }

        return left;
    }

    private int getPrecedence(OperatorToken operatorToken) {
        // Define precedence values for operators
        switch (operatorToken.getOperatorType()) {
            case ADDITION:
            case SUBTRACTION:
                return 1;
            case MULTIPLICATION:
            case DIVISION:
                return 2;
            default:
                return 0;
        }
    }

    private Expression parsePrimaryExpression() {
        Token token = tokens.get(pos);
        if (token instanceof LiteralToken) {
            return parseLiteral();
        } else if (token instanceof IdentifierToken) {
            String identifier = matchIdentifier().getValue();
            if (tokens.get(pos) instanceof SeparatorToken && ((SeparatorToken) tokens.get(pos)).getSeparatorType() == SeparatorType.LEFT_PARENTHESIS) {
                match(SeparatorType.LEFT_PARENTHESIS);
                List<Expression> arguments = parseArgumentList();
                match(SeparatorType.RIGHT_PARENTHESIS);
                return new FunctionCallExpression(identifier, arguments);
            } else {
                return new IdentifierExpression(identifier);
            }
        } else {
            throw new RuntimeException("Unexpected token: " + token);
        }
    }

    private Expression parseLiteral() {
        Token token = tokens.get(pos);
        match(token);
        return new LiteralExpression(((LiteralToken) token).getValue());
    }

    private List<Expression> parseArgumentList() {
        List<Expression> arguments = new ArrayList<>();
        if (!(tokens.get(pos) instanceof SeparatorToken && ((SeparatorToken) tokens.get(pos)).getSeparatorType() == SeparatorType.RIGHT_PARENTHESIS)) {
            arguments.add(parseExpression());
            while (tokens.get(pos) instanceof SeparatorToken && ((SeparatorToken) tokens.get(pos)).getSeparatorType() == SeparatorType.COMMA) {
                match(SeparatorType.COMMA);
                arguments.add(parseExpression());
            }
        }
        return arguments;
    }

    private Token match(TokenType expectedType) {
        Token token = tokens.get(pos);
        if (token.getType() == expectedType) {
            pos++;
            return token;
        } else {
            throw new RuntimeException("Expected token of type " + expectedType + " but found " + token.getType());
        }
    }

    private KeywordType matchKeywordType() {
        Token token = tokens.get(pos);
        if (token instanceof KeywordToken) {
            pos++;
            return ((KeywordToken) token).getKeywordType();
        } else {
            throw new RuntimeException("Expected keyword but found " + token);
        }
    }

    private IdentifierToken matchIdentifier() {
        Token token = tokens.get(pos);
        if (token instanceof IdentifierToken) {
            pos++;
            return (IdentifierToken) token;
        } else {
            throw new RuntimeException("Expected identifier but found " + token);
        }
    }

    private OperatorType matchOperatorType() {
        Token token = tokens.get(pos);
        if (token instanceof OperatorToken) {
            pos++;
            return ((OperatorToken) token).getOperatorType();
        } else {
            throw new RuntimeException("Expected identifier but found " + token);
        }
    }

    private void match(SeparatorType expectedType) {
        Token token = tokens.get(pos);
        if (token instanceof SeparatorToken && ((SeparatorToken) token).getSeparatorType() == expectedType) {
            pos++;
        } else {
            throw new RuntimeException("Expected separator of type " + expectedType + " but found " + token);
        }
    }

    private void match(OperatorType expectedType) {
        Token token = tokens.get(pos);
        if (token instanceof OperatorToken && ((OperatorToken) token).getOperatorType() == expectedType) {
            pos++;
        } else {
            throw new RuntimeException("Expected operator of type " + expectedType + " but found " + token);
        }
    }

    private void match(Token token) {
        if (tokens.get(pos).equals(token)) {
            pos++;
        } else {
            throw new RuntimeException("Expected token " + token + " but found " + tokens.get(pos));
        }
    }

    private void match(KeywordType expectedType) {
        Token token = tokens.get(pos);
        if (token instanceof KeywordToken && ((KeywordToken) token).getKeywordType() == expectedType) {
            pos++;
        } else {
            throw new RuntimeException("Expected operator of type " + expectedType + " but found " + token);
        }
    }

}