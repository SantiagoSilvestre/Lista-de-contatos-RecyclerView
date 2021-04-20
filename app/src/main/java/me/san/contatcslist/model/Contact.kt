package me.san.contatcslist.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Contact(
    var name: String,
    var phone: String,
    var photografh: String
) : Parcelable