package com.csh.erick.wtfashion

class Pants(color: String,
            val isShorts: Boolean,
            val isJeans: Boolean = false,
            name: String = "$color ${if (isShorts) "shorts" else "trousers"}"): Clothing(color, name) {

    fun matchShirt(shirt: Shirt): Boolean{
        return when{
            this.isJeans -> true
            this.isShorts && shirt.isLongSleeve -> false
            !colorsMatch(this.color, shirt.color) -> false
            else -> true
        }
    }
}