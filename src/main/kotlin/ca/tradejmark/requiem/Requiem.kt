package ca.tradejmark.requiem

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun main(argv: Array<String>) {
    val inputStream = CharStreams.fromFileName(argv[0])
    val lexer = ReqLexer(inputStream)
    val parser = ReqLang(CommonTokenStream(lexer))
    val doc = parser.doc()
    val reqiement = Requiement.fromContext(doc)
    println(reqiement)
}