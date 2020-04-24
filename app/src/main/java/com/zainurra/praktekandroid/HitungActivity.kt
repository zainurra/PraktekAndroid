package com.zainurra.praktekandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hitung.*

class HitungActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung)

        buttonHitung.setOnClickListener{
            var isEmptyFielnd =false

            val stringPanjang = editPanjang.text.toString()
            val stringLebar = editLebar.text.toString()
            val stringTinggi = editTinggi.text.toString()

            if(stringPanjang.equals("")){
                isEmptyFielnd = true
                editPanjang.error = "Data Kosong"
            }

            if(stringLebar.equals("")){
                isEmptyFielnd = true
                editLebar.error = "Data Kosong"
            }

            if(stringTinggi.equals("")){
                isEmptyFielnd = true
                editTinggi.error = "Data Kosong"
            }

            if(!isEmptyFielnd){

                val panjang = stringPanjang.toFloat()
                val lebar = stringLebar.toFloat()
                val tinggi = stringTinggi.toFloat()

                textHasil.text = (panjang * lebar * tinggi).toString()

            }

        }
    }
}
