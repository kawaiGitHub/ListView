package com.test.listviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn:Button = findViewById(R.id.btn)
        val lv:ListView = findViewById(R.id.lv)

        val adapter =ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            mutableListOf()
        )

        lv.adapter =adapter

        btn.setOnClickListener {

            val et =EditText(this)

            AlertDialog.Builder(this)
                .setTitle("今日の予定は？")
                .setMessage("予定を追加")
                .setView(et)
                .setPositiveButton("追加"){ _, _ ->

                    val myTdd = et.text.toString()
                    adapter.add(myTdd)

                }
                .setNegativeButton("キャンセル",null)
                .show()
        }

        lv.setOnItemClickListener { _, _, i, _ ->
            AlertDialog.Builder(this)
                .setTitle("削除しますか")
                .setPositiveButton("Yes" ){ _, _ ->
                    adapter.remove(adapter.getItem(i))
                }
                .setNegativeButton("No",null)
                .show()
        }

    }
}











