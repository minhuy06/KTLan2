package com.example.ktlan2

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ktlan2.databinding.ActivityChiTietCongViecBinding

class ChiTietCongViecActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChiTietCongViecBinding
    private var congViecHienTai: CongViec? = null

    private val moChinhSuaLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val congViecSua = data?.getParcelableExtra<CongViec>("OBJ_CONG_VIEC_MOI")

            if (congViecSua != null) {
                congViecHienTai = congViecSua
                binding.tvChiTietTen.text = congViecHienTai?.layThongTin()
                binding.tvChiTietMoTa.text = ""
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiTietCongViecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        congViecHienTai = intent.getSerializableExtra("KEY_CONG_VIEC") as? CongViec

        binding.tvChiTietTen.text = congViecHienTai?.layThongTin()
        binding.tvChiTietMoTa.text = ""

        binding.chkHoanThanh.isChecked = congViecHienTai?.trangThai ?: false

        binding.chkHoanThanh.setOnCheckedChangeListener { _, isChecked ->
            congViecHienTai?.trangThai = isChecked

            binding.tvChiTietTen.text = congViecHienTai?.layThongTin()
        }

        binding.btnChinhSua.setOnClickListener {
            val intent = android.content.Intent(this, ChinhSuaCongViecActivity::class.java).apply {
                putExtra("KEY_CONG_VIEC", congViecHienTai)
            }
            moChinhSuaLauncher.launch(intent)
        }
    }
}