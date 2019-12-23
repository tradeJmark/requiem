package ca.tradejmark.requiem

data class Attribute(val name: String, val type: Type) {
    enum class Type {
        NUMBER,
        TEXT,
        BOOLEAN
    }
}