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
            // Thêm .trim() để xóa khoảng trắng thừa ở đầu và cuối
            val tenCV = binding.edtTenCongViec.text.toString().trim()
            val moTaCV = binding.edtMoTaCongViec.text.toString().trim()

            // KIỂM TRA DỮ LIỆU TRỐNG
            if (tenCV.isEmpty()) {
                binding.edtTenCongViec.error = "Tên công việc không được để trống!"
                binding.edtTenCongViec.requestFocus()
                return@setOnClickListener
            }

            val congViecMoi = CongViec(tenCV, moTaCV)

            val intent = android.content.Intent(this, ChiTietCongViecActivity::class.java).apply {
                putExtra("KEY_CONG_VIEC", congViecMoi)
            }
            startActivity(intent)
        }


    }
}