package com.example.ktlan2

import java.io.Serializable

data class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false
) : Serializable {

    fun layThongTin(): String {
        val txtTrangThai = if (trangThai) "Đã hoàn thành" else "Chưa hoàn thành"
        return "Tên công việc: $tenCongViec\nMô tả: $moTa\nTrạng thái: $txtTrangThai"
    }
}