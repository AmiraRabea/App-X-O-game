package com.example.my2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IInterface
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buSelect(view:View){
        val buChoise=view as Button
        var callID=0
        when(buChoise.id){
            R.id.bu1-> callID=1
            R.id.bu2-> callID=2
            R.id.bu3-> callID=3
            R.id.bu4-> callID=4
            R.id.bu5-> callID=5
            R.id.bu6-> callID=6
            R.id.bu7-> callID=7
            R.id.bu8-> callID=8
            R.id.bu9-> callID=9
        }
        Log.d("callID:",callID.toString())
        PlayGame(callID, buChoise)

    }
    var player1= ArrayList<Int>()
    var player2= ArrayList<Int>()
    var activeplayer=1

    fun PlayGame(callID: Int , buChoise:Button){
        if(activeplayer==1){
            buChoise.text="X"
            buChoise.setBackgroundResource(R.color.blue)
            player1.add(callID)
            activeplayer=2
            try {
                Autoplay()
            }catch (e: Exception){
                Toast.makeText(this,"No One win" ,Toast.LENGTH_LONG ).show()
            }

        }else{
            buChoise.text="O"
            buChoise.setBackgroundResource(R.color.dark)
            player2.add(callID)
            activeplayer=1
        }
        buChoise.isEnabled=false
        Cleckwinner()
    }
    fun Cleckwinner(){
        var winner=-1
            if(player1.contains(1)&& player1.contains(2)&& player1.contains(3)){winner=1}
            if(player1.contains(1)&& player1.contains(4)&& player1.contains(7)){winner=1}
            if(player1.contains(2)&& player1.contains(5)&& player1.contains(8)){winner=1}
            if(player1.contains(3)&& player1.contains(6)&& player1.contains(9)){winner=1}
            if(player1.contains(7)&& player1.contains(8)&& player1.contains(9)){winner=1}
            if(player1.contains(4)&& player1.contains(5)&& player1.contains(6)){winner=1}


            if(player2.contains(1)&& player2.contains(2)&& player2.contains(3)){winner=2}
            if(player2.contains(1)&& player2.contains(4)&& player2.contains(7)){winner=2}
            if(player2.contains(2)&& player2.contains(5)&& player2.contains(8)){winner=2}
            if(player2.contains(3)&& player2.contains(6)&& player2.contains(9)){winner=2}
            if(player2.contains(7)&& player2.contains(8)&& player2.contains(9)){winner=2}
            if(player2.contains(4)&& player2.contains(5)&& player2.contains(6)){winner=2}

        if(winner!=-1){
            try {
                if(winner==1){
                    Toast.makeText(this,"player 1 win the game" ,Toast.LENGTH_LONG ).show()
                    //onBYE()

                }
                else{
                    Toast.makeText(this,"player 2 win the game" ,Toast.LENGTH_LONG ).show()
                    //onBYE()
                }
            }catch (e: Exception){
                Toast.makeText(this,"No One win" ,Toast.LENGTH_LONG ).show()
            }

        }
    }
    //program exit
    fun onBYE() {
        exitProcess(-1)
    }

    fun Autoplay(){
       var emptycells=ArrayList<Int>()
        for(callID in 1..9){
            if(!(player1.contains(callID)||player2.contains(callID))){
                emptycells.add(callID)
            }

        }
        val r= java.util.Random()
        val randomindix=r.nextInt(emptycells.size-0)+0
        val callID= emptycells[randomindix]
        var buSelect:Button?
        when(callID){
            1 ->buSelect=bu1
            2 ->buSelect=bu2
            3 ->buSelect=bu3
            4 ->buSelect=bu4
            5 ->buSelect=bu5
            6 ->buSelect=bu6
            7 ->buSelect=bu7
            8 ->buSelect=bu8
            9 ->buSelect=bu9
            else->{buSelect=bu1}
        }

        PlayGame(callID,buSelect)


    }
}