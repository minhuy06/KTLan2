package com.example.ktlan2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktlan2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTaoCongViec.setOnClickListener {
            val tenCV = binding.edtTenCongViec.text.toString()
            val moTaCV = binding.edtMoTaCongViec.text.toString()

            val congViecMoi = CongViec(tenCV, moTaCV)

            val intent = android.content.Intent(this, ChiTietCongViecActivity::class.java).apply {
                putExtra("OBJ_CONG_VIEC", congViecMoi)
            }
            startActivity(intent)
        }


    }
}