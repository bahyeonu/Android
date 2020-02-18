package com.example.intentexample

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCall = findViewById<Button>(R.id.btnCall)
        val btnWeb = findViewById<Button>(R.id.btnWeb)
        val btnGmap = findViewById<Button>(R.id.btnGmap)
        val btnGserch = findViewById<Button>(R.id.btnGsearch)
        val btnSms = findViewById<Button>(R.id.btnSms)
        val btnPhoto = findViewById<Button>(R.id.btnPhoto)

        btnCall.setOnClickListener{
            var uri = Uri.parse("tel:01050565961")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        btnWeb.setOnClickListener{
            var uri: Uri = Uri.parse("http://google.com")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnGmap.setOnClickListener{
            var uri = Uri.parse("http://maps.google.com/map?q="+37.555178+","+126.970774)
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnGserch.setOnClickListener {
            var intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, "안드로이드")
            startActivity(intent)
        }

        btnSms.setOnClickListener {
            var intent = Intent(Intent.ACTION_SENDTO)
            intent.putExtra("sms_body", "안드로이드")
            intent.setData(Uri.parse("smsto:" + Uri.encode("010-5056-5961")))
            startActivity(intent)
        }

        btnPhoto.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
    }
}
