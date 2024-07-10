package org.example.lexer;

import org.example.lexer.token.CharUtil;
import org.example.lexer.token.Token;
import org.example.lexer.token.EndOfFileToken;
import org.example.lexer.token.UnknownToken;
import org.example.lexer.token.identifier.IdentifierToken;
import org.example.lexer.token.keyword.KeywordToken;
import org.example.lexer.token.keyword.KeywordType;
import org.example.lexer.token.literal.LiteralToken;
import org.example.lexer.token.literal.LiteralType;
import org.example.lexer.token.operator.OperatorToken;
import org.example.lexer.token.operator.OperatorType;
import org.example.lexer.token.separator.SeparatorToken;
import org.example.lexer.token.separator.SeparatorType;

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
        if (CharUtil.isWhitespace(currentChar)) {
            skipWhitespace();
            return nextToken();
        }
        if (CharUtil.charactersEqual('"', currentChar)) {
            return consumeString();
        }
        if (CharUtil.charactersEqual('\'', currentChar)) {
            return consumeChar();
        }
        if (CharUtil.isDigit(currentChar)) {
            return consumeNumber();
        }
        if (CharUtil.isLetter(currentChar)) {
            return inferTokenTypeAndConsume();
        }
        if (CharUtil.isOperator(currentChar)) {
            return consumeOperator();
        }
        if (CharUtil.isSeparator(currentChar)) {
            return consumeSeparator();
        }
        return new UnknownToken();
    }

    @Override
    public Token peek() {
        int savedPosition = position;
        Token token = nextToken();
        position = savedPosition;
        return token;
    }

    private void skipWhitespace() {
        while (position < length && CharUtil.isWhitespace(text.charAt(position))) {
            position++;
        }
    }

    private Token consumeNumber() {
        int start = position;
        while (position < length && (CharUtil.isDigit(text.charAt(position)) || Character.valueOf(text.charAt(position)).equals('.'))) {
            position++;
        }
        String t = createSubstring(start, position);
        return new LiteralToken(t, LiteralType.isNumberInteger(t) ? LiteralType.INTEGER : LiteralType.FLOATING);
    }

    private Token consumeOperator() {
        int start = position;
        while (position < length && CharUtil.isOperator(text.charAt(position))) {
            position++;
        }
        return new OperatorToken(OperatorType.getOperatorType(createSubstring(start, position)));
    }

    private Token consumeSeparator() {
        int start = position;
        position++;
        return new SeparatorToken(SeparatorType.getSeparatorType(createSubstring(start, start + 1)));
    }

    private Token consumeString() {
        int start = position;
        while (position < length && (CharUtil.isLetter(text.charAt(position)) || CharUtil.charactersEqual(text.charAt(position), '"'))) {
            if (CharUtil.charactersEqual('\\', text.charAt(position))) {
                position++; // skip the escape character
            }
            position++;
        }
        position++; // skip the closing quote
        return new LiteralToken(createSubstring(start, position - 1), LiteralType.STRING);
    }

    private Token consumeChar() {
        int start = position;
        while (position < length && (CharUtil.isLetter(text.charAt(position)) || CharUtil.charactersEqual(text.charAt(position), '\''))) {
            if (CharUtil.charactersEqual('\\', text.charAt(position))) {
                position++; // skip the escape character
            }
            position++;
        }
        position++; // skip the closing quote
        return new LiteralToken(createSubstring(start, position - 1), LiteralType.CHARACTER);
    }

    private Token inferTokenTypeAndConsume() {
        int start = position;
        while (position < length && CharUtil.isLetterOrDigit(text.charAt(position))) {
            position++;
        }
        String t = createSubstring(start, position);
        if (KeywordType.isKeyword(t)) {
            return new KeywordToken(KeywordType.getType(t));
        }
        if (LiteralType.isNullLiteral(t)) {
            return new LiteralToken("null", LiteralType.NULL);
        }
        if (LiteralType.isBooleanLiteral(t)) {
            return new LiteralToken(t, LiteralType.BOOLEAN);
        }
        return new IdentifierToken(t);
    }

    private String createSubstring(int start, int position) {
        return text.substring(start, position);
    }

}
