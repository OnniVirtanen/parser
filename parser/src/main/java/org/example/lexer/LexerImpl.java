package org.example.lexer;

import org.example.token.Token;
import org.example.token.eof.EndOfFileToken;
import org.example.token.identifier.IdentifierToken;
import org.example.token.keyword.KeywordToken;
import org.example.token.keyword.KeywordType;
import org.example.token.literal.LiteralToken;
import org.example.token.literal.LiteralType;
import org.example.token.operator.OperatorToken;
import org.example.token.operator.OperatorType;

public final class LexerImpl implements Lexer {

    private final String text;
    private int position;
    private final int length;

    public LexerImpl(String text) {
        this.text = text;
        this.position = 0;
        this.length = text.length();
    }

    @Override
    public Token nextToken() {
        if (position >= length) {
            return new EndOfFileToken();
        }
        char currentChar = text.charAt(position);
        if (Character.isWhitespace(currentChar)) {
            skipWhitespace();
            return nextToken();
        }
        if (Character.isDigit(currentChar)) {
            return consumeNumber();
        }
        if (Character.isLetter(currentChar)) {
            return consumeIdentifier();
        }
        if (CharUtil.isOperator(currentChar)) {
            return consumeOperator();
        }
        return null;
    }

    @Override
    public Token peek() {
        int savedPosition = position;
        Token token = nextToken();
        position = savedPosition;
        return token;
    }

    private void skipWhitespace() {
        while (position < length && Character.isWhitespace(text.charAt(position))) {
            position++;
        }
    }

    private Token consumeNumber() {
        int start = position;
        while (position < length && Character.isDigit(text.charAt(position))) {
            position++;
        }
        return new LiteralToken(text.substring(start, position), LiteralType.INTEGER);
    }

    private Token consumeIdentifier() {
        int start = position;
        while (position < length && Character.isLetterOrDigit(text.charAt(position))) {
            position++;
        }
        String t = text.substring(start, position);
        if (KeywordType.isKeyword(t)) {
            return new KeywordToken(KeywordType.getType(t));
        }
        return new IdentifierToken(t);
    }

    private Token consumeOperator() {
        int start = position;
        while (position < length && CharUtil.isOperator(text.charAt(position))) {
            position++;
        }
        String operator = text.substring(start, position);
        return new OperatorToken(OperatorType.getOperatorType(operator));
    }

}
