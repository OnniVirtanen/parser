package org.example.token;

import org.example.token.operator.OperatorType;
import org.example.token.separator.SeparatorType;

public final class CharUtil {

    public static boolean isOperator(char character) {
        for (OperatorType type : OperatorType.values()) {
            if (Character.valueOf(character).equals((type.getSymbol().charAt(0)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWhitespace(char character) {
        return Character.isWhitespace(character);
    }

    public static boolean isDigit(char character) {
        return Character.isDigit(character);
    }

    public static boolean isLetter(char character) {
        return Character.isLetter(character);
    }

    public static boolean isSeparator(char character) {
        for (SeparatorType type : SeparatorType.values()) {
            if (Character.valueOf(character).equals((type.getSymbol().charAt(0)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLetterOrDigit(char character) {
        return Character.isLetterOrDigit(character);
    }

    public static boolean charactersEqual(char character1, char character2) {
        return character1 == character2;
    }

}
