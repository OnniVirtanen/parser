package org.example.parser.ast.statement;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.parser.ast.ASTVisitor;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FunctionStatement.class, name = "FunctionStatement"),
        @JsonSubTypes.Type(value = ReturnStatement.class, name = "ReturnStatement"),
        @JsonSubTypes.Type(value = VariableStatement.class, name = "VariableStatement"),
        @JsonSubTypes.Type(value = ExpressionStatement.class, name = "ExpressionStatement"),
        @JsonSubTypes.Type(value = WhileStatement.class, name = "WhileStatement"),
        @JsonSubTypes.Type(value = IfStatement.class, name = "IfStatement"),
        @JsonSubTypes.Type(value = ElseStatement.class, name = "ElseStatement")
})
public abstract class Statement {

    public abstract void accept(ASTVisitor visitor);

}
