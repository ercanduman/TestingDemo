package com.enbcreative.testingdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_next_main.setOnClickListener { startActivity(Intent(this, SecondActivity::class.java)) }

        btn_to_fragments_act_main.setOnClickListener {
            startActivity(Intent(this, FragmentsActivity::class.java))
        }
    }
}
