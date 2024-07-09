# parser

## lexer

**example code in calculator.fin**

```c
fun sum(a: int, b: int): int {
    return a + b;
}

int value = sum(2, 4);
```

**Lexer produces the following**

```
KeywordToken{keywordType=FUNCTION}
IdentifierToken{value='sum'}
SeparatorToken{separatorType=LEFT_PARENTHESIS}
IdentifierToken{value='a'}
SeparatorToken{separatorType=COLON}
KeywordToken{keywordType=INT}
SeparatorToken{separatorType=COMMA}
IdentifierToken{value='b'}
SeparatorToken{separatorType=COLON}
KeywordToken{keywordType=INT}
SeparatorToken{separatorType=RIGHT_PARENTHESIS}
SeparatorToken{separatorType=COLON}
KeywordToken{keywordType=INT}
SeparatorToken{separatorType=LEFT_CURLY_BRACKET}
KeywordToken{keywordType=RETURN}
IdentifierToken{value='a'}
OperatorToken{operatorType=ADDITION}
IdentifierToken{value='b'}
SeparatorToken{separatorType=SEMICOLON}
SeparatorToken{separatorType=RIGHT_CURLY_BRACKET}
KeywordToken{keywordType=INT}
IdentifierToken{value='value'}
OperatorToken{operatorType=ASSIGNMENT}
IdentifierToken{value='sum'}
SeparatorToken{separatorType=LEFT_PARENTHESIS}
LiteralToken{value='2', literalType=INTEGER}
SeparatorToken{separatorType=COMMA}
LiteralToken{value='4', literalType=INTEGER}
SeparatorToken{separatorType=RIGHT_PARENTHESIS}
SeparatorToken{separatorType=SEMICOLON}
```
