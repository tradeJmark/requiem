lexer grammar ReqLexer;

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
fragment ALPHANUM: LETTER | DIGIT;

OPEN: '{';
CLOSE: '}';

//Section keywords:
ATTRS: 'attributes';

//Types:
BOOL: 'boolean';
NUM: 'number';
TEXT: 'text';

TYPE_DELIM: ':';
COMPOUND_DELIM: '=';
COMPOUNDER: '+';

ID: LETTER ALPHANUM*;

WS: [ \t\r\n] -> skip;