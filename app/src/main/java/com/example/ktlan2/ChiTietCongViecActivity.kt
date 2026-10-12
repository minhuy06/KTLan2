package com.example.ktlan2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktlan2.databinding.ActivityChiTietCongViecBinding

class ChiTietCongViecActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChiTietCongViecBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiTietCongViecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tenCV = intent.getStringExtra("TEN_CONG_VIEC")
        val moTaCV = intent.getStringExtra("MO_TA_CONG_VIEC")

        binding.tvChiTietTen.text = "Tên công việc: $tenCV"
        binding.tvChiTietMoTa.text = "Mô tả: $moTaCV"
    }
}