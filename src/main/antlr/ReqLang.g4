parser grammar ReqLang;
options {
    tokenVocab=ReqLexer;
}

doc: attrs?;
attrs: ATTRS OPEN attr+ CLOSE;
attr: ID TYPE_DELIM type (COMPOUND_DELIM ID COMPOUNDER ID (COMPOUNDER ID)*)?;
type: BOOL | TEXT | NUM;