package com.example.ktlan2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktlan2.databinding.ActivityChinhSuaCongViecBinding

class ChinhSuaCongViecActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChinhSuaCongViecBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChinhSuaCongViecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val congViec = intent.getParcelableExtra<CongViec>("OBJ_CONG_VIEC")

        binding.edtTenSua.setText(congViec?.tenCongViec)
        binding.edtMoTaSua.setText(congViec?.moTa)

        binding.btnLuu.setOnClickListener {
            val intentResult = android.content.Intent().apply {
                val congViecMoi = CongViec(
                    tenCongViec = binding.edtTenSua.text.toString(),
                    moTa = binding.edtMoTaSua.text.toString(),
                    trangThai = congViec?.trangThai ?: false // Giữ nguyên trạng thái
                )
                putExtra("OBJ_CONG_VIEC_MOI", congViecMoi)
            }
            setResult(RESULT_OK, intentResult)
            finish()
        }
    }
}