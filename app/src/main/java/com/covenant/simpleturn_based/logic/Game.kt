package com.covenant.simpleturn_based.logic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import com.covenant.simpleturn_based.Player
import com.covenant.simpleturn_based.Skills

class Game(val player1: Player, val player2: Player) {
    private val randomizer: Int = (1..2).random()
    var currentPlayer: Player = if(randomizer == 1) player1 else player2
        private set
    var opponent: Player = if (currentPlayer == player1) player2 else player1
        private set
    var isOver: Boolean = false
        private set
    var victor: Player = GameState()
        private set


    fun GameState(): Player{
        if(player1.health <= 0|| player2.health <= 0){
            if(player1.health<= 0){
                isOver = true;
                victor =  player2
                player1.health = 0
            }
            else{
                isOver = true;
                victor =  player1
                player2.health = 0
            }
        }
        return victor
    }

    fun switchTurn(){
        val temp by mutableStateOf(currentPlayer)
        currentPlayer = opponent
        opponent = temp


    }


}
