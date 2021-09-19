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
        val arrayPicture = listOf(R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,
            R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine)
        val randomImageView = findViewById<ImageView>(R.id.randomImageView)
        val inputCaptcha = findViewById<EditText>(R.id.inputCaptcha)
        val buttonCheck = findViewById<Button>(R.id.buttonCheck)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val random = arrayPicture.random()
        randomImageView.setImageResource(random)
        var count = 0
        for (i in arrayPicture){
            if (random == arrayPicture[count]){
                Log.d("TAG", count.toString())
            }else{
                count+= 1
            }
        }
        inputCaptcha.inputType = InputType.TYPE_CLASS_NUMBER
        buttonCheck.setOnClickListener {
            val inputUserInteger = inputCaptcha.text.toString().toInt()
            if(count == (inputUserInteger - 1)){
                Toast.makeText(this,"Успех", Toast.LENGTH_LONG).show()
                textViewResult.text = "Вы успешно прошли капчу"
            }else{
                Toast.makeText(this,"error", Toast.LENGTH_LONG).show()
            }
        }
    }
}