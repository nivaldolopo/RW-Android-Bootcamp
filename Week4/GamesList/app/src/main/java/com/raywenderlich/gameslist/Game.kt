package com.raywenderlich.gameslist

import android.os.Parcel
import android.os.Parcelable
import android.os.WorkSource

class Game(val title: String,
           val releaseDate: String,
           val developer: String,
           val publisher: String,
           val plot: String,
           val plataform: String,
           val poster: Int) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    )

    companion object CREATOR: Parcelable.Creator<Game> {
        override fun createFromParcel(source: Parcel): Game = Game(source)

        override fun newArray(size: Int): Array<Game?> = arrayOfNulls(size)

    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(title)
        dest.writeString(releaseDate)
        dest.writeString(developer)
        dest.writeString(publisher)
        dest.writeString(plot)
        dest.writeString(plataform)
        dest.writeInt(poster)
    }

    override fun describeContents() = 0
}