package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var _size: Double, var company: String, var description: String,
                var images: List<String> = mutableListOf()) : Parcelable {

    var size: String
        get() = _size.toString()
        set(value) {
            _size = value.toDouble()
        }

    val isValid: Boolean
        get() {
            return (name != "") || (_size != 0.0) || (company != "") || (description != "")
        }
}