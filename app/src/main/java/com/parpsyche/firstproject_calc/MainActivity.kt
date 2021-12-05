package com.parpsyche.firstproject_calc

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.notkamui.keval.Keval
import android.media.MediaPlayer


class MainActivity : AppCompatActivity() {

    private lateinit var one: TextView
    private lateinit var two: TextView
    private lateinit var three: TextView
    private lateinit var four: TextView
    private lateinit var five: TextView
    private lateinit var six: TextView
    private lateinit var seven: TextView
    private lateinit var eight: TextView
    private lateinit var nine: TextView
    private lateinit var zero: TextView
    private lateinit var doublezero: TextView
    private lateinit var clear: TextView
    private lateinit var backspace: ImageView
    private lateinit var mod: TextView
    private lateinit var divide: TextView
    private lateinit var multiply: TextView
    private lateinit var add: TextView
    lateinit var minus: TextView
    lateinit var equals: TextView
    private lateinit var decimal: TextView
    private lateinit var temp: TextView
    private lateinit var result: TextView
    private lateinit var fullscreen:ImageButton
    private lateinit var theme:ImageButton
    var mMediaPlayer: MediaPlayer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clear = findViewById(R.id.clear)
        backspace = findViewById(R.id.backspace)
        mod = findViewById(R.id.mod)
        divide = findViewById(R.id.divide)
        multiply = findViewById(R.id.multiply)
        add = findViewById(R.id.plus)
        minus = findViewById(R.id.minus)
        equals = findViewById(R.id.equals)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        doublezero = findViewById(R.id.doublezero)
        decimal = findViewById(R.id.decimal)
        temp = findViewById(R.id.temp)
        result = findViewById(R.id.result)
        fullscreen = findViewById(R.id.fullscreen)
        theme = findViewById(R.id.themedn)

        one.setOnClickListener {
            appendText("1", true)
        }
        two.setOnClickListener {
            appendText("2", true)
        }
        three.setOnClickListener {
            appendText("3", true)
        }
        four.setOnClickListener {
            appendText("4", true)
        }
        five.setOnClickListener {
            appendText("5", true)
        }
        six.setOnClickListener {
            appendText("6", true)
        }
        seven.setOnClickListener {
            appendText("7", true)
        }
        eight.setOnClickListener {
            appendText("8", true)
        }
        nine.setOnClickListener {
            appendText("9", true)
        }
        zero.setOnClickListener {
            appendText("0", true)
        }
        doublezero.setOnClickListener {
            appendText("00", true)
        }
        add.setOnClickListener {
            appendText("+", false)
        }
        minus.setOnClickListener {
            appendText("-", false)
        }
        multiply.setOnClickListener {
            appendText("*", false)
        }
        divide.setOnClickListener {
            appendText("/", false)
        }
        mod.setOnClickListener {
            appendText("%", false)
        }
        backspace.setOnClickListener {
            if(result.text.isEmpty()){
                if (temp.text.isEmpty())
                    temp.text=""
                else
                    temp.text= temp.text.substring(0,temp.text.length-1)
            }
            else{
                temp.text=result.text.substring(0,result.text.length-1)
                result.text=""
            }
        }
        clear.setOnClickListener {
            temp.text = ""
            result.text = ""
        }
        equals.setOnClickListener {
            try {
                result.text = Keval.eval(temp.text.toString()).toString()
            } catch (e: Exception) {
                result.text = e.message
            }
        }

        fullscreen.setOnClickListener {
            toggleFullScreen()
        }
        theme.setOnClickListener {
            if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_NO)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        var burger : ImageButton = findViewById(R.id.burger)
        burger.setOnClickListener{
            if (mMediaPlayer == null) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.burgir)
                mMediaPlayer!!.isLooping = false
                mMediaPlayer!!.start()
            } else mMediaPlayer!!.start()
        }

    }


    private fun toggleFullScreen() {
        if (window.decorView.systemUiVisibility == View.SYSTEM_UI_FLAG_VISIBLE) {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
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