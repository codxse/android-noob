package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.*

val SHOE1 = Shoe(name = "Adidas Runner 300", size = 42.0, company = "Adidas", description = "Running shoes for 300M",
    images = listOf(
        "https://static.shop.adidas.co.id/media/catalog/product/cache/2/thumbnail/1200x/9df78eab33525d08d6e5fb8d27136e95/E/G/EG5401_SL_eCom.jpg",
        "https://static.shop.adidas.co.id/media/catalog/product/cache/2/thumbnail/1200x/9df78eab33525d08d6e5fb8d27136e95/E/G/EG5401_FLT_eCom.jpg",
        "https://static.shop.adidas.co.id/media/catalog/product/cache/2/thumbnail/1200x/9df78eab33525d08d6e5fb8d27136e95/E/G/EG5401_FR_eCom.jpg"
    )
)
val SHOE2 = Shoe(name = "Ultraboost SUMMER.RDY", size = 42.0, company = "Adidas", description = "HIGH-PERFORMANCE SHOES FOR RUNNING IN THE HEAT",
    images = listOf(
        "https://static.shop.adidas.co.id/media/catalog/product/cache/2/thumbnail/1200x/9df78eab33525d08d6e5fb8d27136e95/E/G/EG0748_SL_eCom.jpg",
        "https://static.shop.adidas.co.id/media/catalog/product/cache/2/thumbnail/1200x/9df78eab33525d08d6e5fb8d27136e95/E/G/EG0748_FLT_eCom.jpg",
        "https://static.shop.adidas.co.id/media/catalog/product/cache/2/thumbnail/1200x/9df78eab33525d08d6e5fb8d27136e95/E/G/EG0748_FR_eCom.jpg"
    )
)
val SHOE3 = Shoe(name = "Nike Adapt BB", size = 42.0, company = "Nike", description = "Breaking Down the Nike Adapt BB",
    images = listOf(
        "https://s3.amazonaws.com/nikeinc/assets/84920/Sp19_BB_Nike_Adapt_20181218_NIKE0538_Detail2_square_1600.jpg?1547068089",
        "https://s3.amazonaws.com/nikeinc/assets/84922/Sp19_BB_Nike_Adapt_20181218_NIKE0538_Detail3_square_1600.jpg?1547068089",
        "https://s3.amazonaws.com/nikeinc/assets/84923/Sp19_BB_Nike_Adapt_20181218_NIKE0538_Detail4_square_1600.jpg?1547068091"
    )
)

class ShoeListingViewModel : ViewModel() {
    private val _shoes = MutableLiveData<MutableList<Shoe>>()

    init {
        Log.i("ShoeListingViewModel", "ShoeListingViewModel created")
        val initShoes: MutableList<Shoe> = mutableListOf()
        initShoes.add(SHOE1)
        initShoes.add(SHOE2)
        initShoes.add(SHOE3)
        _shoes.value = initShoes
    }

    val shoes: MutableLiveData<MutableList<Shoe>>
        get() = _shoes

    fun addShoe(shoe: Shoe) = _shoes.value?.add(shoe)

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeListingViewModel", "ShoeListingViewModel destroyed")
    }
}