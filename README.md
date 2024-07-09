# parser

## lexer

**example code in calculator.fin**

fun sumInt(a, b) {
    return a + b;
}

fun sumFloat(a, b) {
    return a + b;
}

int value1 = sumInt(2, 4);
float value2 = sumFloat(3.72, 3.41);

**Lexer produces the following**

KeywordToken{keywordType=FUNCTION}
IdentifierToken{value='sumInt'}
SeparatorToken{separatorType=LEFT_PARENTHESIS}
IdentifierToken{value='a'}
SeparatorToken{separatorType=COMMA}
IdentifierToken{value='b'}
SeparatorToken{separatorType=RIGHT_PARENTHESIS}
SeparatorToken{separatorType=LEFT_CURLY_BRACKET}
KeywordToken{keywordType=RETURN}
IdentifierToken{value='a'}
OperatorToken{operatorType=ADDITION}
IdentifierToken{value='b'}
SeparatorToken{separatorType=SEMICOLON}
SeparatorToken{separatorType=RIGHT_CURLY_BRACKET}
KeywordToken{keywordType=FUNCTION}
IdentifierToken{value='sumFloat'}
SeparatorToken{separatorType=LEFT_PARENTHESIS}
IdentifierToken{value='a'}
SeparatorToken{separatorType=COMMA}
IdentifierToken{value='b'}
SeparatorToken{separatorType=RIGHT_PARENTHESIS}
SeparatorToken{separatorType=LEFT_CURLY_BRACKET}
KeywordToken{keywordType=RETURN}
IdentifierToken{value='a'}
OperatorToken{operatorType=ADDITION}
IdentifierToken{value='b'}
SeparatorToken{separatorType=SEMICOLON}
SeparatorToken{separatorType=RIGHT_CURLY_BRACKET}
KeywordToken{keywordType=INT}
IdentifierToken{value='value1'}
OperatorToken{operatorType=ASSIGNMENT}
IdentifierToken{value='sumInt'}
SeparatorToken{separatorType=LEFT_PARENTHESIS}
LiteralToken{value='2', literalType=INTEGER}
SeparatorToken{separatorType=COMMA}
LiteralToken{value='4', literalType=INTEGER}
SeparatorToken{separatorType=RIGHT_PARENTHESIS}
SeparatorToken{separatorType=SEMICOLON}
KeywordToken{keywordType=FLOAT}
IdentifierToken{value='value2'}
OperatorToken{operatorType=ASSIGNMENT}
IdentifierToken{value='sumFloat'}
SeparatorToken{separatorType=LEFT_PARENTHESIS}
LiteralToken{value='3.72', literalType=FLOATING}
SeparatorToken{separatorType=COMMA}
LiteralToken{value='3.41', literalType=FLOATING}
SeparatorToken{separatorType=RIGHT_PARENTHESIS}
SeparatorToken{separatorType=SEMICOLON}
