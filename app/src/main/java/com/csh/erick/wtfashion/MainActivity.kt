package com.csh.erick.wtfashion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ViewListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.clothing_frame.view.*

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

        shirts_cv.pageCount = wardrobe.cleanShirts.size
        shirts_cv.setViewListener { position ->
            inflateFocusedClothingView(wardrobe.cleanShirts[position])}

        pants_cv.pageCount = wardrobe.cleanPants.size
        pants_cv.setViewListener { position ->
            inflateFocusedClothingView(wardrobe.cleanPants[position])
        }
    }
    private fun inflateFocusedClothingView(clothing: Clothing): View{
        val view = layoutInflater.inflate(R.layout.clothing_frame, null)
        view.desc_text.text = clothing.name
        view.clothing_iv.setImageDrawable(getDrawable(clothing.drawable)) //TODO: figure out images
        return view
    }
}

data class Outfit(val pants: Pants, val shirt: Shirt){
    fun wear(){
        pants.wear()
        shirt.wear()
    }
}