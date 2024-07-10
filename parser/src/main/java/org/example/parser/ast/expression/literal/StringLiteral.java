package org.example.parser.ast.expression.literal;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.parser.ast.expression.LiteralExpression;

public final class StringLiteral extends LiteralExpression {

    public StringLiteral(@JsonProperty("value") String value) {
        super(value);
    }

}
