package com.example.androidcaptcha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.androidcaptcha.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val keysToCaptcha = listOf("o","2","q","s","9")
        val arrayPicture = listOf(R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,
            R.drawable.five)
        var testCount = -1
        val indexMutableList = mutableListOf<Int>()
        for (i in arrayPicture){
            testCount++
            indexMutableList.add(testCount)
        }
        indexMutableList.shuffle()
            binding.randomImageViewOne.setImageResource(arrayPicture[indexMutableList[0]])
            binding.randomImageViewTwo.setImageResource(arrayPicture[indexMutableList[1]])
            binding.randomImageViewThree.setImageResource(arrayPicture[indexMutableList[2]])
        val arrayImageView = arrayOf(binding.randomImageViewOne,binding.randomImageViewTwo,binding.randomImageViewThree)



        binding.buttonCheck.setOnClickListener {

            val inputUserIntegerOrString = binding.inputCaptcha.text.toString()

            val chekIsValidCaptcha = keysToCaptcha[indexMutableList[0]] + keysToCaptcha[indexMutableList[1]] + keysToCaptcha[indexMutableList[2]]
            if (inputUserIntegerOrString.equals(chekIsValidCaptcha))
                Toast.makeText(this,"Вы успешно прошли капчу",Toast.LENGTH_LONG).show()

            else
                Toast.makeText(this,"все очень плохо",Toast.LENGTH_LONG).show()

        }




    }
}