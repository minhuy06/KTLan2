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

        binding.edtTenSua.setText(intent.getStringExtra("TEN_CONG_VIEC"))
        binding.edtMoTaSua.setText(intent.getStringExtra("MO_TA_CONG_VIEC"))

        binding.btnLuu.setOnClickListener {
            val intentResult = android.content.Intent().apply {
                putExtra("TEN_MOI", binding.edtTenSua.text.toString())
                putExtra("MO_TA_MOI", binding.edtMoTaSua.text.toString())
            }
            setResult(RESULT_OK, intentResult)
            finish()
        }
    }
}