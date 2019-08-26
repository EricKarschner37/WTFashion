package com.csh.erick.wtfashion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wardrobe = Wardrobe()
        wardrobe.addPants(Pants("khaki", true))
        wardrobe.addPants(Pants("khaki", true))
        wardrobe.addPants(Pants("blue", isShorts = false, isJeans = true))
        wardrobe.addPants(Pants("khaki", false))
        wardrobe.addPants(Pants("red", true))
        wardrobe.addPants(Pants("black", true))

        wardrobe.addShirt(Shirt("blue", isLongSleeve = true, isPolo = true))
        wardrobe.addShirt(Shirt("grey", isLongSleeve = false, isPolo = true))
        wardrobe.addShirt(Shirt("blue", false))
        wardrobe.addShirt(Shirt("blue", false))
        wardrobe.addShirt(Shirt("burgundy", false))
        wardrobe.addShirt(Shirt("orange", false))

        val adapter = ClothingRVAdapter(this, wardrobe.cleanShirts)
        shirtsRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        shirtsRV.adapter = adapter
    }
}

data class Outfit(val pants: Pants, val shirt: Shirt){
    fun wear(){
        pants.wear()
        shirt.wear()
    }
}