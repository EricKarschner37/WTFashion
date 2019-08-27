package com.csh.erick.wtfashion


class Shirt(color: String,
            val isLongSleeve: Boolean,
            val isPolo: Boolean = false,
            name: String = "$color ${if (isLongSleeve) "long-sleeved " else ""}shirt"): Clothing(color, name) {

    override var drawable = R.drawable.shirt
}