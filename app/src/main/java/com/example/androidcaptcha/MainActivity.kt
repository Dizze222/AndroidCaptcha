package com.example.androidcaptcha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val keysToCaptcha = listOf("op3","iu3","dek3","wde2","we1","wf3","ef0","ffe4","f43e")
        val arrayPicture = listOf(R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,
            R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine)
        val randomImageView = findViewById<ImageView>(R.id.randomImageView)
        val inputCaptcha = findViewById<EditText>(R.id.inputCaptcha)
        val buttonCheck = findViewById<Button>(R.id.buttonCheck)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val random = arrayPicture.random()
        randomImageView.setImageResource(random)
        var arrayElementToPicture = 0
        for (i in arrayPicture){
            if (random == arrayPicture[arrayElementToPicture]){
                Log.i("TAGi",arrayElementToPicture.toString())
            }else{
                arrayElementToPicture += 1
            }
        }


        buttonCheck.setOnClickListener {
            val inputUserInteger = inputCaptcha.text.toString()
            if (inputUserInteger.equals(keysToCaptcha[arrayElementToPicture])){
                Toast.makeText(this,"Успех", Toast.LENGTH_LONG).show()
                textViewResult.text = "Вы успешно прошли капчу"
            }else{
                Toast.makeText(this,"error", Toast.LENGTH_LONG).show()
            }
        }
    }
}