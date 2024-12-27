package dev.bushidolabs.jetpack.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyRow() {
	Row(
		modifier = Modifier
      .horizontalScroll(rememberScrollState())
      .fillMaxSize(),
		horizontalArrangement = Arrangement.SpaceAround,
		verticalAlignment = Alignment.CenterVertically
	) {
		Box(
      Modifier
        .background(color = Color.Red)
        .width(150.dp)
        .height(150.dp),
			contentAlignment = Alignment.Center
		) {
			Text(text = "Hola mundo 1")
		}
		Box(
      Modifier
        .background(color = Color.Red)
        .width(150.dp)
        .height(150.dp),
			contentAlignment = Alignment.Center
		) {
			Text(text = "Hola mundo 1")
		}
		Box(
      Modifier
        .background(color = Color.Red)
        .width(150.dp)
        .height(150.dp),
			contentAlignment = Alignment.Center
		) {
			Text(text = "Hola mundo 1")
		}
		Box(
      Modifier
        .background(color = Color.Red)
        .width(150.dp)
        .height(150.dp),
			contentAlignment = Alignment.Center
		) {
			Text(text = "Hola mundo 1")
		}
		Box(
      Modifier
        .background(color = Color.Blue)
        .width(150.dp)
        .height(150.dp),
			contentAlignment = Alignment.Center
		) {
			Text(text = "Hola mundo 2")
		}
		Box(
      Modifier
        .background(color = Color.Blue)
        .width(150.dp)
        .height(150.dp),
			contentAlignment = Alignment.Center
		) {
			Text(text = "Hola mundo 2")
		}
		Box(
      Modifier
        .background(color = Color.Blue)
        .width(150.dp)
        .height(150.dp),
			contentAlignment = Alignment.Center
		) {
			Text(text = "Hola mundo 2")
		}
		Box(
      Modifier
        .background(color = Color.Blue)
        .width(150.dp)
        .height(150.dp),
			contentAlignment = Alignment.Center
		) {
			Text(text = "Hola mundo 2")
		}
	}
}