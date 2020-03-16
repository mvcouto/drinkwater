package br.com.tamanduasoft.drinkwater.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cup(val volume: Int) : Parcelable