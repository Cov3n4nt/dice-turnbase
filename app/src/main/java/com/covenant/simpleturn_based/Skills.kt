package com.covenant.simpleturn_based

class Skills(val Currentplayer: Player, val opponent: Player){

    private fun heal() {
        val healAmount: Int = (10..50).random()
        if (Currentplayer.health >= 300) {
            println("Already at Full Health")
        } else {
            Currentplayer.health += healAmount
            if (Currentplayer.health > 300) {
                Currentplayer.health = 300
            }
        }
    }

    private fun fortify() {
        val amount: Int = (10..50).random()
        if(Currentplayer.armor >= 200.0){
            Currentplayer.armor = 200.0
        }
        else{
            Currentplayer.armor += amount
        }

    }

    private fun selfDamage() {
        val selfDmg: Int = (10..100).random()
        Currentplayer.health -= selfDmg
    }

    private fun lifeSteal() {
       val amount: Int = (10..50).random()
        opponent.health -= amount
        Currentplayer.health += amount
    }
    private fun timeReset(){
        Currentplayer.health = 500
        Currentplayer.armor = 200.0
    }

    private fun erode(){
        opponent.armor = 0.0
    }




    fun useSkill():String {
        val skill = listOf(::heal, ::fortify, ::selfDamage, ::lifeSteal, ::timeReset, ::erode)
        val selectedSkill = skill.random()
        selectedSkill()

        return when (selectedSkill) {
            ::heal -> "heal"
            ::fortify -> "fortify"
            ::selfDamage -> "selfDamage"
            ::lifeSteal -> "lifeSteal"
            ::timeReset -> "timeReset"
            ::erode -> "erode"
            else -> "Invalid Skill"

        }

    }

}