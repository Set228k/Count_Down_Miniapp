package com.example.count_down_miniapp

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.count_down_miniapp.databinding.ActivityMainBinding
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private var timer:CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            bStart.setOnClickListener {
                StartCountDownTimer(20000)

            }
        }
    }

    private fun StartCountDownTimer(timeMillis:Long){
        timer?.cancel()
        timer = object :CountDownTimer(timeMillis, 1){
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimer.text = millisUntilFinished.toString()
            }

            override fun onFinish() {
                binding.tvTimer.text = "Finish"
            }

        }.start()

    }
}