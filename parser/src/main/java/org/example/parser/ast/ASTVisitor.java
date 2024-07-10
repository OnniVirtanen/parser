package org.example.parser.ast;

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

public interface ASTVisitor {
    void visit(Program program);
    void visit(FunctionStatement functionStatement);
    void visit(ReturnStatement returnStatement);
    void visit(IfStatement ifStatement);
    void visit(ElseStatement elseStatement);
    void visit(WhileStatement whileStatement);
    void visit(VariableStatement variableStatement);
    void visit(ExpressionStatement expressionStatement);
    void visit(IdentifierExpression identifierExpression);
    void visit(LiteralExpression literalExpression);
    void visit(BinaryExpression binaryExpression);
    void visit(FunctionCallExpression functionCallExpression);
    void visit(Parameter parameter);
}