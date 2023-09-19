package com.covenant.simpleturn_based

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.covenant.simpleturn_based.logic.Game
import com.covenant.simpleturn_based.ui.theme.components.Skill_Die
import com.covenant.simpleturn_based.ui.theme.SimpleTurnBasedTheme
import com.covenant.simpleturn_based.ui.theme.components.PlayerDetail
import com.covenant.simpleturn_based.ui.theme.components.Skill_Die


@Composable
fun RunGame() {

    val player1 = remember { Player("Player1")}
    val player2 = remember { Player("Player2") }
    val game = remember { Game(player1, player2) }
    var skillDescription by remember { mutableStateOf("") }
    var skillUsed by remember { mutableStateOf("") }
    var dmgRolled by remember { mutableStateOf(0) }
    var skills = Skills(game.currentPlayer,game.opponent)

    game.GameState()
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {

        Column {
            PlayerDetail(player = player1)
            Spacer(modifier = Modifier.padding(8.dp))
            PlayerDetail(player = player2)
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "Turn: ${game.currentPlayer.name}",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = "${game.currentPlayer.name}'s Combo: ${game.currentPlayer.combo}",
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    dmgRolled = game.currentPlayer.attack(game.opponent)
                    game.switchTurn()

                }, modifier = Modifier.padding(8.dp),
                enabled = !game.isOver,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
            ) {
                Text(text = "Attack")
            }

            Button(
                onClick = {
                    skillUsed = skills.useSkill()

                    skillDescription = when (skillUsed) {
                        "heal" -> "${game.currentPlayer.name} used heal"
                        "fortify" -> "${game.currentPlayer.name} used fortify"
                        "selfDamage" -> "${game.currentPlayer.name} inflicted  selfDamage"
                        "lifeSteal" -> "${game.currentPlayer.name} siphoned their enemy's health"
                        "timeReset" -> "${game.currentPlayer.name} turned back their own time"
                        "erode" -> "${game.currentPlayer.name} inflicts erode to their enemy"
                        else -> "Invalid skill"
                    }

                    game.switchTurn()

                }, modifier = Modifier.padding(8.dp),
                enabled = !game.isOver,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
            ) {
                Text(text = "Use Skill")

            }

        }

        if (!game.isOver) {

            Text(
                text = "Damage dealt: $dmgRolled", modifier = Modifier.align(
                    Alignment.CenterHorizontally
                )
            )

            Text(text = skillDescription, modifier = Modifier.align(Alignment.CenterHorizontally))

            Skill_Die(
                value = skillUsed, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(20.dp)
            )
        } else {
            Text(
                text = "Victor: ${game.victor.name}",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }


    }

    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleTurnBasedTheme {
        RunGame()
    }
}
