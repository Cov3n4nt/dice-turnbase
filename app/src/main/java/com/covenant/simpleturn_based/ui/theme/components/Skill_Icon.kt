package com.covenant.simpleturn_based.ui.theme.components

import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Bloodtype
import androidx.compose.material.icons.filled.Healing
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.HourglassBottom
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.ShutterSpeed
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.covenant.simpleturn_based.ui.theme.SimpleTurnBasedTheme


@Composable
fun Skill_Icon(value: String?, modifier: Modifier) {
    when(value){
        "" -> FoolFace()
        "heal" -> DieHeal()
        "fortify" -> DieFortify()
        "selfDamage" -> DieSelfDmg()
        "lifeSteal" -> DieLifeSteal()
        "timeReset" -> DieTimeReset()
        "erode" -> DieErode()
        else -> UnknownDieFace()
    }
}

@Composable
fun FoolFace(){
    Box(modifier = Modifier.size(64.dp)){
        Text(text = "...",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.background,
            fontWeight =  FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)

        )
    }
}

@Composable
fun DieHeal(){
    Box(modifier = Modifier.size(64.dp)){
            Icon(imageVector = Icons.Default.Healing, contentDescription = "",
                modifier = Modifier.align(Alignment.Center))
    }
}
@Composable
fun DieFortify(){
    Box(modifier = Modifier.size(64.dp)){
        Icon(imageVector = Icons.Default.HealthAndSafety, contentDescription = "",
            modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun DieSelfDmg(){
    Box(modifier = Modifier.size(64.dp)){
        Icon(imageVector = Icons.Default.HeartBroken, contentDescription = "",
            modifier = Modifier.align(Alignment.Center))
    }
}
@Composable
fun DieLifeSteal(){
    Box(modifier = Modifier.size(64.dp)){
        Icon(imageVector = Icons.Default.Bloodtype, contentDescription = "",
            modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun DieTimeReset(){
    Box(modifier = Modifier.size(64.dp)){
        Icon(imageVector = Icons.Default.HourglassBottom, contentDescription = "",
            modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun DieErode(){
    Box(modifier = Modifier.size(64.dp)){
        Icon(imageVector = Icons.Default.Spa, contentDescription = "",
            modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun UnknownDieFace() {
    Box(modifier = Modifier.size(64.dp)){
        Icon(imageVector = Icons.Default.QuestionMark, contentDescription = "",
        modifier = Modifier.align(Alignment.Center))
    }
    
}


@Preview
@Composable
fun FoolFacePreview() {
    SimpleTurnBasedTheme {
        FoolFace()
    }
}

@Preview
@Composable
fun DieHealPreview() {
    SimpleTurnBasedTheme {
        DieHeal()
    }
    
}

@Preview
@Composable
fun DieSelfDmgPreview() {
    SimpleTurnBasedTheme {
        DieSelfDmg()
    }
}

@Preview
@Composable
fun DieFortifyPreview() {
    SimpleTurnBasedTheme {
        DieFortify()
    }
}

@Preview
@Composable
fun DieLifeStealPreview() {
    SimpleTurnBasedTheme {
        DieLifeSteal()
    }

}

@Preview
@Composable
fun DieTimeResetPrev() {
    SimpleTurnBasedTheme {
        DieTimeReset()
    }
}
@Preview
@Composable
fun UnknownDieFacePrev() {
    SimpleTurnBasedTheme {
        UnknownDieFace()
    }
}
@Preview
@Composable
fun DieErodePrev() {
    SimpleTurnBasedTheme {
        DieErode()
    }
}


