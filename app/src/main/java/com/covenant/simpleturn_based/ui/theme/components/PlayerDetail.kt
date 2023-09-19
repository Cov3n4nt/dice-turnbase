package com.covenant.simpleturn_based.ui.theme.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.covenant.simpleturn_based.Player
import com.covenant.simpleturn_based.ui.theme.SimpleTurnBasedTheme

@Composable
fun PlayerDetail(player: Player,modifier: Modifier = Modifier) {

    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "${player.name}")
        Row(){
            Box(modifier = Modifier.size(40.dp)){
                Icon(imageVector = Icons.Default.Person, contentDescription = "",
                    modifier = Modifier.align(Alignment.Center))
            }
            Spacer(modifier = Modifier.padding(3.dp))
            Box {
                Box(modifier = Modifier
                    .background(MaterialTheme.colorScheme.tertiaryContainer)
                    .fillMaxWidth(player.health.toFloat() / 500f)
                    .height(40.dp)){}
                Text(text = "${player.health.toInt()}",
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    modifier = Modifier.align(Alignment.Center))
            }

        }
        Spacer(modifier = Modifier.padding(5.dp))
        Row {
            Box(modifier = Modifier.size(40.dp)){
                Icon(imageVector = Icons.Default.Shield, contentDescription = "",
                    modifier = Modifier.align(Alignment.Center))
            }
            Spacer(modifier = Modifier.padding(3.dp))
            Box(modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .fillMaxWidth(player.armor.toFloat() / 200f)
                .height(40.dp)){

                Text(text = "${player.armor.toInt()}",
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    modifier = Modifier.align(Alignment.Center))

            }

        }
    }



}

@Preview
@Composable
fun PlayerDetailPrev() {
    SimpleTurnBasedTheme {
        PlayerDetail(player = Player("Player1"))
    }
}