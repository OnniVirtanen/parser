package org.example.parser.ast;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.example.parser.ast.statement.Statement;

import java.util.List;

@JsonRootName("program")
public final class Program {
    @JsonProperty("statementList")
    private final List<Statement> statementList;

    public Program(List<Statement> statementList) {
        this.statementList = statementList;
    }

    public List<Statement> getStatementList() {
        return statementList;
    }

    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
