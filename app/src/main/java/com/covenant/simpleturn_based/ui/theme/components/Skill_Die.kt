package com.covenant.simpleturn_based.ui.theme.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.covenant.simpleturn_based.ui.theme.SimpleTurnBasedTheme

@Composable
fun Skill_Die(
    value: String?,
    modifier: Modifier = Modifier,
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.tertiary,
        modifier = modifier,
    ) {
            Skill_Icon(value = value, modifier = Modifier)

    }
}


@Preview
@Composable
fun Skill_DiePrev() {
    SimpleTurnBasedTheme {
        Skill_Die(value = "erode")
    }
}