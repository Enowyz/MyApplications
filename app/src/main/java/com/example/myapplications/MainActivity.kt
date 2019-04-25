package com.example.myapplications

import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button
import android.content.Context.VIBRATOR_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.os.Parcelable.Creator



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val btn_click_me = findViewById(R.id.btn_vibrate) as Button
        btn_click_me.setOnClickListener {
            val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibratorService.vibrate(longArrayOf(500, 500, 600, 600), -1)
        }

        val btn_click_me_2 = findViewById(R.id.btn_vib2) as Button
        btn_click_me_2.setOnClickListener {
            val vibratorService2 = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibratorService2.vibrate(3000)
        }

        val btn_click_me_3 = findViewById(R.id.btn_amp) as Button
        btn_click_me_3.setOnClickListener {
            val vibratorService3 = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibratorService3.vibrate(VibrationEffect.createWaveform(longArrayOf(500), intArrayOf(2),-1))
        }

        val btn_click_me_4 = findViewById(R.id.btn_amp2) as Button
        btn_click_me_4.setOnClickListener {
            val vibratorService4 = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibratorService4.vibrate(VibrationEffect.createWaveform(longArrayOf(500), intArrayOf(250),-1))
        }

        val btn_click_me_5 = findViewById(R.id.btn_check) as Button
        btn_click_me_5.setOnClickListener {
            val vibratorService5 = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            if(vibratorService5.hasAmplitudeControl()) {
                vibratorService5.vibrate(1000)
            }else{
                vibratorService5.vibrate(longArrayOf(500, 500, 600, 600), -1)

            }
        }


/*
        //update version
        val btn_click_me_2 = findViewById(R.id.btn_close) as Button

        btn_click_me_2.setOnClickListener {
            val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

            if ( vibrator.hasVibrator()) {
            // Vibrator availability checking

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    Vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
                    // New vibrate method for API Level 26 or higher

                    //val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                    //vibratorService.vibrate(500)

                }
                else {
                    vibrator.vibrate(500) // Vibrate method for below API Level 26
                }
            }
        }*/
    }
}

