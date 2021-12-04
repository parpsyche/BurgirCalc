package com.parpsyche.firstproject_calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.trimmedLength
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var one: TextView
    lateinit var two: TextView
    lateinit var three: TextView
    lateinit var four: TextView
    lateinit var five: TextView
    lateinit var six: TextView
    lateinit var seven: TextView
    lateinit var eight: TextView
    lateinit var nine: TextView
    lateinit var zero: TextView
    lateinit var doublezero: TextView
    lateinit var clear: TextView
    lateinit var backspace: ImageView
    lateinit var mod: TextView
    lateinit var divide: TextView
    lateinit var multiply: TextView
    lateinit var add: TextView
    lateinit var minus: TextView
    lateinit var equals: TextView
    lateinit var decimal: TextView
    lateinit var temp: TextView
    lateinit var result: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clear = findViewById(R.id.clear)
        backspace= findViewById(R.id.backspace)
        mod = findViewById(R.id.mod)
        divide = findViewById(R.id.divide)
        multiply= findViewById(R.id.multiply)
        add= findViewById(R.id.plus)
        minus= findViewById(R.id.minus)
        equals= findViewById(R.id.equals)
        one= findViewById(R.id.one)
        two= findViewById(R.id.two)
        three= findViewById(R.id.three)
        four= findViewById(R.id.four)
        five= findViewById(R.id.five)
        six= findViewById(R.id.six)
        seven= findViewById(R.id.seven)
        eight= findViewById(R.id.eight)
        nine= findViewById(R.id.nine)
        zero= findViewById(R.id.zero)
        doublezero= findViewById(R.id.doublezero)
        decimal = findViewById(R.id.decimal)
        temp = findViewById(R.id.temp)
        result= findViewById(R.id.result)

        one.setOnClickListener{
            appendText("1",true)
        }
        two.setOnClickListener{
            appendText("2",true)
        }
        three.setOnClickListener{
            appendText("3",true)
        }
        four.setOnClickListener{
            appendText("4",true)
        }
        five.setOnClickListener{
            appendText("5",true)
        }
        six.setOnClickListener{
            appendText("6",true)
        }
        seven.setOnClickListener{
            appendText("7",true)
        }
        eight.setOnClickListener{
            appendText("8",true)
        }
        nine.setOnClickListener{
            appendText("9",true)
        }
        zero.setOnClickListener{
            appendText("0",true)
        }
        doublezero.setOnClickListener{
            appendText("00",true)
        }
        add.setOnClickListener{
            appendText("+",false)
        }
        minus.setOnClickListener{
            appendText("-",false)
        }
        multiply.setOnClickListener{
            appendText("*",false)
        }
        divide.setOnClickListener{
            appendText("/",false)
        }
        mod.setOnClickListener{
            appendText("%",false)
        }
        backspace.setOnClickListener{
            temp.text=result.text.trimStart()
            result.text=""
        }
        clear.setOnClickListener{
            temp.text=""
            result.text=""
        }
        equals.setOnClickListener{
            try {
                result.text = ExpressionBuilder(temp.text.toString()).build().evaluate().toString()

            }
            catch (e : Exception){
                result.text = e.message
            }
        }

    }

    private fun appendText(value:String, toBeCleared:Boolean){
        if(result.text!="")
            temp.text=""

        if (toBeCleared){
            result.text = ""
            temp.append(value)
        }else {
            temp.append(result.text)
            temp.append(value)
            result.text=""
        }
    }
}