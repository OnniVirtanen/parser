package org.example.parser.ast.expression.literal;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.parser.ast.expression.LiteralExpression;

public final class BooleanLiteral extends LiteralExpression {

    public BooleanLiteral(@JsonProperty("value") String value) {
        super(value);
    }

}
