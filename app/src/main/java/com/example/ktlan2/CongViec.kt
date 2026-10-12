package com.example.ktlan2

import android.os.Parcel
import android.os.Parcelable

data class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte()
    )

    fun layThongTin(): String {
        val txtTrangThai = if (trangThai) "Đã hoàn thành" else "Chưa hoàn thành"
        return "Tên công việc: $tenCongViec\nMô tả: $moTa\nTrạng thái: $txtTrangThai"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tenCongViec)
        parcel.writeString(moTa)
        parcel.writeByte(if (trangThai) 1 else 0)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<CongViec> {
        override fun createFromParcel(parcel: Parcel): CongViec = CongViec(parcel)
        override fun newArray(size: Int): Array<CongViec?> = arrayOfNulls(size)
    }
}