package com.zainurra.praktekandroid

import android.graphics.Color
import android.media.AsyncPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.random.Random

private const val BATU = 1
private const val GUNTING = 2
private const val KERTAS = 3

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        var pilihanKomputer:Int
        var pilihanPlayer:Int

        buttonBatu.setOnClickListener {
            textPlayer.text = "BATU"
            pilihanPlayer = BATU
            pilihanKomputer = getPIlihanKomputer()
            textKomputer.text = ""
            Handler().postDelayed({
                textHasil.text = suwit(pilihanPlayer,pilihanKomputer)
                showPilihanKomputer(pilihanKomputer)
            },2000)
        }

        buttonGunting.setOnClickListener {
            textPlayer.text = "GUNTING"
            pilihanPlayer = GUNTING
            pilihanKomputer = getPIlihanKomputer()
            textKomputer.text = ""
            Handler().postDelayed({
                textHasil.text = suwit(pilihanPlayer,pilihanKomputer)
                showPilihanKomputer(pilihanKomputer)
            },2000)
        }

        buttonKertas.setOnClickListener {
            textPlayer.text = "KERTAS"
            pilihanPlayer = KERTAS
            pilihanKomputer = getPIlihanKomputer()
            textKomputer.text = ""
            Handler().postDelayed({
                textHasil.text = suwit(pilihanPlayer,pilihanKomputer)
                showPilihanKomputer(pilihanKomputer)
            },2000)
        }

    }

    fun getPIlihanKomputer():Int{
        return Random.nextInt(3) + 1;
    }

    fun suwit(pilihanPlayer: Int, pilihanKomputer: Int): String {
        var hasil: String = ""
        if (pilihanPlayer == pilihanKomputer){
            hasil = "SERI"
            textHasil.setTextColor(Color.GRAY)
        }
        else if ((pilihanPlayer == BATU && pilihanKomputer == KERTAS) ||
            (pilihanPlayer == GUNTING && pilihanKomputer == BATU) ||
            (pilihanPlayer == KERTAS && pilihanKomputer == GUNTING)){
            hasil = "YOU LOSE"
        textHasil.setTextColor(Color.RED)
    }
        else {
        hasil = "YOU WIN"
        textHasil.setTextColor(Color.GREEN)
    }
        return hasil
    }

    fun showPilihanKomputer(pilihanKomputer: Int){
        when(pilihanKomputer){
            1 -> textKomputer.text = "Komputer Memilih : BATU"
            2 -> textKomputer.text = "Komputer Memilih : GUNTING"
            3 -> textKomputer.text = "Komputer Memilih : KERTAS"
        }
    }
}
