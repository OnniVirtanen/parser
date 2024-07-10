package org.example.parser.ast.expression;

import org.example.parser.ast.ASTVisitor;

public abstract class Expression {

    public abstract void accept(ASTVisitor visitor);

}
