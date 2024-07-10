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
import org.example.parser.ast.statement.Statement;
import org.example.parser.ast.statement.VariableStatement;
import org.example.parser.ast.statement.WhileStatement;

public class ASTPrinterVisitor implements ASTVisitor {

    @Override
    public void visit(Program program) {
        System.out.println("Program:");
        for (Statement statement : program.getStatementList()) {
            statement.accept(this);
        }
    }

    @Override
    public void visit(FunctionStatement functionStatement) {
        System.out.print("Function: " + functionStatement.getIdentifier() + "(");
        for (int i = 0; i < functionStatement.getParameters().size(); i++) {
            functionStatement.getParameters().get(i).accept(this);
            if (i < functionStatement.getParameters().size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(") -> " + functionStatement.getReturnType());
        for (Statement stmt : functionStatement.getBody()) {
            stmt.accept(this);
        }
    }

    @Override
    public void visit(ReturnStatement returnStatement) {
        System.out.print("Return: ");
        returnStatement.getExpression().accept(this);
        System.out.println();
    }

    @Override
    public void visit(IfStatement ifStatement) {
        System.out.print("If: ");
        ifStatement.getCondition().accept(this);
        System.out.println();
        for (Statement stmt : ifStatement.getIfBody()) {
            stmt.accept(this);
        }
        if (ifStatement.getElseBody() != null) {
            for (Statement stmt : ifStatement.getElseBody()) {
                stmt.accept(this);
            }
        }
    }

    @Override
    public void visit(ElseStatement elseStatement) {
        System.out.println("Else:");
        for (Statement stmt : elseStatement.getBody()) {
            stmt.accept(this);
        }
    }

    @Override
    public void visit(WhileStatement whileStatement) {
        System.out.print("While: ");
        whileStatement.getCondition().accept(this);
        System.out.println();
        for (Statement stmt : whileStatement.getBody()) {
            stmt.accept(this);
        }
    }

    @Override
    public void visit(VariableStatement variableStatement) {
        System.out.print("Variable: " + variableStatement.getType() + " " + variableStatement.getIdentifier() + " = ");
        variableStatement.getExpression().accept(this);
        System.out.println();
    }

    @Override
    public void visit(ExpressionStatement expressionStatement) {
        expressionStatement.getExpression().accept(this);
        System.out.println(";");
    }

    @Override
    public void visit(IdentifierExpression identifierExpression) {
        System.out.print(identifierExpression.getIdentifier());
    }

    @Override
    public void visit(LiteralExpression literalExpression) {
        System.out.print(literalExpression.getValue());
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        binaryExpression.getLeft().accept(this);
        System.out.print(" " + binaryExpression.getOperator() + " ");
        binaryExpression.getRight().accept(this);
    }

    @Override
    public void visit(FunctionCallExpression functionCallExpression) {
        System.out.print(functionCallExpression.getIdentifier() + "(");
        for (int i = 0; i < functionCallExpression.getArguments().size(); i++) {
            functionCallExpression.getArguments().get(i).accept(this);
            if (i < functionCallExpression.getArguments().size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(")");
    }

    @Override
    public void visit(Parameter parameter) {
        System.out.print(parameter.getType() + " " + parameter.getIdentifier());
    }

}
