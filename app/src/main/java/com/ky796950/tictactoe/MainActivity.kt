package com.ky796950.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnreset.setOnClickListener {
            resetBoard()
            resetText()
        }
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var player1Points = 0
    var player2Points = 0

    var activePlayer = 1
    var roundCount = 0

    fun squareClick(view: View) {
        val btnSelected = view as Button
        var cellID = 0
        when(btnSelected.id){
            R.id.button_00 -> cellID = 1
            R.id.button_01 -> cellID = 2
            R.id.button_02 -> cellID = 3
            R.id.button_10 -> cellID = 4
            R.id.button_11 -> cellID = 5
            R.id.button_12 -> cellID = 6
            R.id.button_20 -> cellID = 7
            R.id.button_21 -> cellID = 8
            R.id.button_22 -> cellID = 9
        }
        playGame(cellID,btnSelected)
    }

    private fun playGame(cellID: Int, btnSelected: Button) {

        if (activePlayer == 1){
            //text_player1.setTextColor(Color.parseColor("fc0202"))
            //text_player2.setTextColor(Color.parseColor("050505"))
            btnSelected.text = "X"
            player1.add(cellID)
            activePlayer = 2
            roundCount++
        }
        else{
            //text_player1.setTextColor(Color.parseColor("050505"))
            //text_player2.setTextColor(Color.parseColor("fc0202"))
            btnSelected.text = "O"
            player2.add(cellID)
            activePlayer = 1
            roundCount++
        }
        btnSelected.isEnabled = false

        checkWinner()
    }

    private fun checkWinner() {
        var winner = -1

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_LONG).show()
                player1Points++
                resetBoard()
                updatePointsText()
            }
            if (winner == 2) {
                Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_LONG).show()
                player2Points++
                resetBoard()
                updatePointsText()
            }
        } else {
            if (roundCount == 9) {
                Toast.makeText(this, "Draw!", Toast.LENGTH_LONG).show()
                resetBoard()
            }
        }
    }
    private fun updatePointsText() {
        text_player1.text = "Player 1 : " + player1Points
        text_player2.text = "Player 2 : " + player2Points
    }

    private fun resetText() {
        player1Points = 0
        player2Points = 0
        updatePointsText()
    }

    private fun resetBoard() {
        button_00.text = null
        button_01.text = null
        button_02.text = null
        button_10.text = null
        button_11.text = null
        button_12.text = null
        button_20.text = null
        button_21.text = null
        button_22.text = null

        button_00.isEnabled = true
        button_01.isEnabled = true
        button_02.isEnabled = true
        button_10.isEnabled = true
        button_11.isEnabled = true
        button_12.isEnabled = true
        button_20.isEnabled = true
        button_21.isEnabled = true
        button_22.isEnabled = true

        activePlayer = 1
        roundCount = 0
        player1.clear()
        player2.clear()
    }
}