package com.csh.erick.wtfashion

import kotlin.collections.ArrayList
import kotlin.random.Random

class Wardrobe {
    val cleanPants = ArrayList<Pants>()
    val cleanShirts = ArrayList<Shirt>()

    private val dirtyPants = ArrayList<Pants>()
    private val dirtyShirts = ArrayList<Shirt>()

    fun addPants(pants: Pants){
        cleanPants.add(pants)
        pants.onWearListener = { _ -> cleanPants.remove(pants); dirtyPants.add(pants) }
        pants.onWashListener = { cleanPants.add(pants); dirtyPants.remove(pants) }
    }

    fun addShirt(shirt: Shirt){
        cleanShirts.add(shirt)
        shirt.onWearListener = { cleanShirts.remove(shirt); dirtyShirts.add(shirt) }
        shirt.onWashListener = { cleanShirts.add(shirt); dirtyShirts.remove(shirt) }
    }

    fun getOutfit(isCold: Boolean = false, isRaining: Boolean = false): Outfit {
        val shirt = getRandomShirt()
        val pants = getPantsToMatchShirt(shirt)
        return Outfit(pants, shirt)
    }

    fun doLaundry(){
        for (i in 0 until dirtyPants.size){
            dirtyPants[0].wash()
        }

        for (i in 0 until dirtyShirts.size){
            dirtyShirts[0].wash()
        }
    }

    private fun getRandomShirt(): Shirt {
        val random = Random.nextInt(cleanShirts.size)
        return cleanShirts[random]
    }

    private fun getPantsToMatchShirt(shirt: Shirt): Pants {
        var matchingPants = cleanPants[0]
        for (pants in cleanPants){
            println("$pants $shirt")
            if (pants.matchShirt(shirt)) {
                matchingPants = pants
                break
            }
        }
        println(matchingPants)
        return matchingPants
    }
}