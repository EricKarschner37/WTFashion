package com.csh.erick.wtfashion

abstract class Clothing(val color: String, var name: String) {
    lateinit var onWearListener: (Clothing) -> (Unit)
    lateinit var onWashListener: (Clothing) -> (Unit)
    open var drawable = R.drawable.shirt
    var isClean = false

    fun wear(){
        isClean = false
        onWearListener(this)
    }

    fun wash(){
        isClean = true
        onWashListener(this)
    }

    fun colorsMatch(c1: String, c2: String): Boolean{
        if (c1 == c2) return false
        if (c1 == "khaki") return true
        return true
    }

    override fun toString(): String {
        return name
    }
}
