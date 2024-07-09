package org.example.lexer;

import org.example.token.operator.OperatorType;

public final class CharUtil {

    public static boolean isOperator(Character character) {
        for (OperatorType type : OperatorType.values()) {
            if (character.equals((type.getSymbol().charAt(0)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWhitespace(Character character) {
        return Character.isWhitespace(character);
    }

    public static boolean isDigit(Character character) {
        return Character.isDigit(character);
    }

    public static boolean isLetter(Character character) {
        return Character.isLetter(character);
    }

}
