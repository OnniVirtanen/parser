package org.example.parser.ast.statement;

import org.example.parser.ast.ASTVisitor;

public abstract class Statement {

    public abstract void accept(ASTVisitor visitor);

}
