package com.covenant.simpleturn_based

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.covenant.simpleturn_based.logic.Game

class Player(val name: String) {

    var health by mutableStateOf(500)
    var armor by mutableStateOf(200.0)
    var combo by mutableStateOf(0)

    fun attack(player: Player): Int{
        combo++
        var CritDmg = 1
        if(combo > 5){
             CritDmg = (2..3).random()
            combo = 0
        }
        val Dmg = (1..80).random() * CritDmg

        if(player.armor > 0.0){
            val armorDmg = Dmg * 0.50
            player.armor -= armorDmg

            val healthDmg = Dmg - armorDmg
            player.health -= healthDmg.toInt()

        }

        else {
            player.health -= Dmg
        }

        if (player.armor < 0.0) {
            player.armor = 0.0
        }

        return Dmg


    }
}