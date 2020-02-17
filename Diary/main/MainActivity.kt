package com.example.diary

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.*
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate (savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val editText = findViewById<EditText>(R.id.editText)
        val btnSave = findViewById<Button>(R.id.btnSave)

        datePicker.setOnDateChangedListener { _, year, monthOfYear, dayOfMonth ->
            var fileName = "$year$monthOfYear$dayOfMonth.txt"

            try{
                var inFs: FileInputStream = openFileInput(fileName)
                var str = inFs.reader().readText()

                editText.setText(str)

                inFs.close()

            }catch (e: IOException){
                editText.setText("")
            }
        }

        btnSave.setOnClickListener{
            var fileName = "${datePicker.year}${datePicker.month}${datePicker.dayOfMonth}.txt"

            var outFs: FileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE)
            var str = editText.text.toString()
            outFs.write(str.toByteArray())

            Toast.makeText(applicationContext, "${datePicker.year}년 ${datePicker.month+1}월 ${datePicker.dayOfMonth}일 저장되었습니다.", Toast.LENGTH_SHORT).show()

            outFs.close()

        }

    }

}
