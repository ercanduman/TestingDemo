package com.enbcreative.testingdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        btn_previous_second_activity.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        btn_launch_dialog_second_activity.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        MaterialDialog(this).show {
            input(
                waitForPositiveButton = true,
                allowEmpty = false,
                hint = "Input message here..."
            ) { _, inputData ->
                handleInputData(inputData.toString())
            }
            title(R.string.dialog_title)
            positiveButton(android.R.string.ok)
        }
    }

    private fun handleInputData(inputData: String) {
        Log.d(this.javaClass.simpleName, "Dialog input data: $inputData")
        title_second.text = inputData
    }
}
