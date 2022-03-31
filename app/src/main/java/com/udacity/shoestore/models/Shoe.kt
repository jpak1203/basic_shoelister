package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(private var name: String, private var company: String, private var size: Double, private var description: String,
                val images: List<String> = mutableListOf()) : Parcelable, BaseObservable() {
    @Bindable
    fun getName(): String {
        return name
    }
    fun setName(n: String) {
        name = n
    }

    @Bindable
    fun getCompany(): String {
        return company
    }
    fun setCompany(c: String) {
        company = c
    }

    @Bindable
    fun getSize(): Double {
        return size
    }
    fun setSize(s: Double) {
        size = s
    }

    @Bindable
    fun getDescription(): String {
        return description
    }
    fun setDescription(d: String) {
        description = d
    }
}