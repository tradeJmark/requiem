package ca.tradejmark.requiem

data class Attributes(
    val simpleAttributes: Set<Attribute>,
    val compoundAttributes: Map<Attribute, List<Attribute>>
): ReqVisitorReturnable {
    init {
        val all = simpleAttributes union compoundAttributes.keys
        var offender: Attribute? = null
        require(compoundAttributes.all { (key, attrs) ->
            val check = all.containsAll(attrs)
            if (!check) offender = key
            check
        }) {
            val offenders = compoundAttributes[offender]?.subtract(all)
            "Compound attribute '${offender?.name}' is attempting to use non-existing attributes '${offenders?.joinToString("', '") { "${it.name}: ${it.type}" }} '."
        }
    }
}