package org.example.parser.ast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.example.parser.ast.expression.BinaryExpression;
import org.example.parser.ast.expression.FunctionCallExpression;
import org.example.parser.ast.expression.IdentifierExpression;
import org.example.parser.ast.expression.LiteralExpression;
import org.example.parser.ast.parameter.Parameter;
import org.example.parser.ast.statement.ElseStatement;
import org.example.parser.ast.statement.ExpressionStatement;
import org.example.parser.ast.statement.FunctionStatement;
import org.example.parser.ast.statement.IfStatement;
import org.example.parser.ast.statement.ReturnStatement;
import org.example.parser.ast.statement.VariableStatement;
import org.example.parser.ast.statement.WhileStatement;

import java.io.IOException;

public class ASTJsonVisitor implements ASTVisitor {
    private final ObjectMapper objectMapper;
    private Object currentNode;

    public ASTJsonVisitor() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        this.objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    }

    public String getJson() throws IOException {
        return objectMapper.writeValueAsString(currentNode);
    }

    @Override
    public void visit(Program program) {
        currentNode = program;
    }

    @Override
    public void visit(FunctionStatement functionStatement) {
        currentNode = functionStatement;
    }

    @Override
    public void visit(ReturnStatement returnStatement) {
        currentNode = returnStatement;
    }

    @Override
    public void visit(IfStatement ifStatement) {
        currentNode = ifStatement;
    }

    @Override
    public void visit(ElseStatement elseStatement) {
        currentNode = elseStatement;
    }

    @Override
    public void visit(WhileStatement whileStatement) {
        currentNode = whileStatement;
    }

    @Override
    public void visit(VariableStatement variableStatement) {
        currentNode = variableStatement;
    }

    @Override
    public void visit(ExpressionStatement expressionStatement) {
        currentNode = expressionStatement;
    }

    @Override
    public void visit(IdentifierExpression identifierExpression) {
        currentNode = identifierExpression;
    }

    @Override
    public void visit(LiteralExpression literalExpression) {
        currentNode = literalExpression;
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        currentNode = binaryExpression;
    }

    @Override
    public void visit(FunctionCallExpression functionCallExpression) {
        currentNode = functionCallExpression;
    }

    @Override
    public void visit(Parameter parameter) {
        currentNode = parameter;
    }

}