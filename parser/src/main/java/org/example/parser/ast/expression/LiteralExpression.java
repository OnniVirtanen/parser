package org.example.parser.ast.expression;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.parser.ast.ASTVisitor;
import org.example.parser.ast.expression.literal.BooleanLiteral;
import org.example.parser.ast.expression.literal.CharacterLiteral;
import org.example.parser.ast.expression.literal.FloatLiteral;
import org.example.parser.ast.expression.literal.IntegerLiteral;
import org.example.parser.ast.expression.literal.NullLiteral;
import org.example.parser.ast.expression.literal.StringLiteral;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BooleanLiteral.class, name = "BooleanLiteral"),
        @JsonSubTypes.Type(value = CharacterLiteral.class, name = "CharacterLiteral"),
        @JsonSubTypes.Type(value = FloatLiteral.class, name = "FloatLiteral"),
        @JsonSubTypes.Type(value = IntegerLiteral.class, name = "IntegerLiteral"),
        @JsonSubTypes.Type(value = NullLiteral.class, name = "NullLiteral"),
        @JsonSubTypes.Type(value = StringLiteral.class, name = "StringLiteral")
})
public class LiteralExpression extends Expression {
    private final String value;

    public LiteralExpression(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
