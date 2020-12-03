package com.example.tictactoe

import android.content.Context
import android.graphics.Color.RED
import android.graphics.Color.YELLOW
import android.hardware.camera2.params.RggbChannelVector.RED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.ArrayList

class MainActivity() : AppCompatActivity(), View.OnClickListener {
    private lateinit var button1:Button
    private lateinit var button2:Button
    private lateinit var button3:Button
    private lateinit var button4:Button
    private lateinit var button5:Button
    private lateinit var button6:Button
    private lateinit var button7:Button
    private lateinit var button8:Button
    private lateinit var button9:Button
    private lateinit var Resetbutton:Button

    private var activeplayer=1

    private var firstplayer=ArrayList<Int>()
    private var secondplayer=ArrayList<Int>()

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }
    private fun init(){

        button1=findViewById(R.id.button1)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button4)
        button5=findViewById(R.id.button5)
        button6=findViewById(R.id.button6)
        button7=findViewById(R.id.button7)
        button8=findViewById(R.id.button8)
        button9=findViewById(R.id.button9)
        Resetbutton=findViewById(R.id.Resetbutton)


        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

    }
    override fun onClick(clickedview :View?){

        if (clickedview is Button){

            var buttonNumber=0

            when(clickedview.id){
                R.id.button1->buttonNumber=1
                R.id.button2->buttonNumber=2
                R.id.button3->buttonNumber=3
                R.id.button4->buttonNumber=4
                R.id.button5->buttonNumber=5
                R.id.button6->buttonNumber=6
                R.id.button7->buttonNumber=7
                R.id.button8->buttonNumber=8
                R.id.button9->buttonNumber=9


            }
            if (buttonNumber!=0)
                playgame(buttonNumber,clickedview)
        }

    }

    private fun playgame(buttonNumber: Int, clickedview: Button) {
        if (activeplayer==1){
            clickedview.text="X"
            clickedview.setBackgroundColor(color.RED)
            firstplayer.add(buttonNumber)
            activeplayer=2
        }else{
            clickedview.text="0"
            clickedview.setBackgroundColor(color.YELLOW)
            secondplayer.add(buttonNumber)
            activeplayer=1
        }
        clickedview.isEnabled=false
        check()


        
    }
    private fun check(){
        var winnerPlayer=0
        if (firstplayer.contains(1)&&firstplayer.contains(2)&&firstplayer.contains(3)){
            winnerPlayer=1

        }
        if(secondplayer.contains(1)&&secondplayer.contains(2)&&secondplayer.contains(3)){
            winnerPlayer=2
        }
        if (firstplayer.contains(4)&&firstplayer.contains(5)&&firstplayer.contains(6)){
            winnerPlayer=1

        }
        if(secondplayer.contains(4)&&secondplayer.contains(5)&&secondplayer.contains(6)){
            winnerPlayer=2
        }
        if (firstplayer.contains(7)&&firstplayer.contains(2)&&firstplayer.contains(3)){
            winnerPlayer=1

        }
        if(secondplayer.contains(7)&&secondplayer.contains(8)&&secondplayer.contains(9)){
            winnerPlayer=2
        }
        if (firstplayer.contains(1)&&firstplayer.contains(4)&&firstplayer.contains(7)){
            winnerPlayer=1

        }
        if(secondplayer.contains(1)&&secondplayer.contains(4)&&secondplayer.contains(7)){
            winnerPlayer=2
        }
        if (firstplayer.contains(2)&&firstplayer.contains(5)&&firstplayer.contains(8)){
            winnerPlayer=1

        }
        if(secondplayer.contains(2)&&secondplayer.contains(5)&&secondplayer.contains(8)){
            winnerPlayer=2
        }
        if (firstplayer.contains(3)&&firstplayer.contains(6)&&firstplayer.contains(9)){
            winnerPlayer=1

        }
        if(secondplayer.contains(3)&&secondplayer.contains(6)&&secondplayer.contains(9)){
            winnerPlayer=2
        }
        if (firstplayer.contains(1)&&firstplayer.contains(5)&&firstplayer.contains(9)){
            winnerPlayer=1

        }
        if(secondplayer.contains(1)&&secondplayer.contains(5)&&secondplayer.contains(9)){
            winnerPlayer=2
        }
        if (firstplayer.contains(3)&&firstplayer.contains(5)&&firstplayer.contains(7)){
            winnerPlayer=1

        }

        if(secondplayer.contains(3)&&secondplayer.contains(5)&&secondplayer.contains(7)){
            winnerPlayer=2
        }
        val mainActivity = if (winnerPlayer != 0) {
            if (winnerPlayer == 1)
                Toast.makeText(Context:this, text:"X WIN", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context:this, text:"0 WIN", Toast.LENGTH_LONG).show()


        }
        disableButtons()


    }
    private fun disableButtons(){
        button1.isEnabled=false
        button2.isEnabled=false
        button3.isEnabled=false
        button4.isEnabled=false
        button5.isEnabled=false
        button6.isEnabled=false
        button7.isEnabled=false
        button8.isEnabled=false
        button9.isEnabled=false
    }

}
