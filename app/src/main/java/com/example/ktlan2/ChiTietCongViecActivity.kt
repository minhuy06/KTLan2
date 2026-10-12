package com.example.ktlan2

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ktlan2.databinding.ActivityChiTietCongViecBinding

class ChiTietCongViecActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChiTietCongViecBinding
    private var tenHienTai: String? = ""
    private var moTaHienTai: String? = ""

    private val moChinhSuaLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            tenHienTai = data?.getStringExtra("TEN_MOI")
            moTaHienTai = data?.getStringExtra("MO_TA_MOI")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiTietCongViecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tenHienTai = intent.getStringExtra("TEN_CONG_VIEC")
        moTaHienTai = intent.getStringExtra("MO_TA_CONG_VIEC")

        binding.tvChiTietTen.text = "Tên công việc: $tenHienTai"
        binding.tvChiTietMoTa.text = "Mô tả: $moTaHienTai"

        binding.btnChinhSua.setOnClickListener {
            val intent = Intent(this, ChinhSuaCongViecActivity::class.java).apply {
                putExtra("TEN_CONG_VIEC", tenHienTai)
                putExtra("MO_TA_CONG_VIEC", moTaHienTai)
            }
            moChinhSuaLauncher.launch(intent)
        }
    }
}