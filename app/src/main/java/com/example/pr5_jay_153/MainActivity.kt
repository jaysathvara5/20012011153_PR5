package com.example.pr5_jay_153

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
class MainActivity : AppCompatActivity() {
    private lateinit var playbtn : FloatingActionButton
    private lateinit var stopbtn : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playbtn = findViewById(R.id.playbutton)

        playbtn.setOnClickListener(View.OnClickListener {
            play()
        })
        stopbtn = findViewById(R.id.stopbutton)

        stopbtn.setOnClickListener(View.OnClickListener {
            stop()
        })
    }
    private fun play(){
        Intent(applicationContext,
            MyService::class.java).putExtra(MyService.DATA_KEY,MyService.DATA_VALUE).apply {
            startService(this) }
    }
    private fun stop(){

        Intent(applicationContext,MyService::class.java)
            .apply { stopService(this) }
    }
}

