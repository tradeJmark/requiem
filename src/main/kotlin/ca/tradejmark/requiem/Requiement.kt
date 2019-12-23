package ca.tradejmark.requiem

data class Requiement(val attributes: Attributes): ReqVisitorReturnable {
    companion object {
        fun fromContext(ctx: ReqLang.DocContext): Requiement = Requiement(
            attributes = getAttributes(ctx.attrs())
        )

        private fun getAttributes(ctx: ReqLang.AttrsContext): Attributes {
            val simple = ctx.attr()
                .filter { it.COMPOUND_DELIM() == null }
                .map(::getAttribute)
                .toSet()
            val compound = ctx.attr()
                .filter { it.COMPOUND_DELIM() != null }
                // TODO : Better error message.
                // TODO : Ensure compatible types.
                .associate { attr -> getAttribute(attr) to attr.ID().drop(1).map { id -> simple.first { it.name == id.text } } }
            return  Attributes(simple, compound)
        }

        private fun getAttribute(ctx: ReqLang.AttrContext): Attribute = ctx.type().run {
            when {
                BOOL() != null -> Attribute(ctx.ID(0).text, Attribute.Type.BOOLEAN)
                TEXT() != null -> Attribute(ctx.ID(0).text, Attribute.Type.TEXT)
                else -> Attribute(ctx.ID(0).text, Attribute.Type.NUMBER)
            }
        }
    }
}