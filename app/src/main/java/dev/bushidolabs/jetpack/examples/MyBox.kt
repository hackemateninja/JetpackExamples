package dev.bushidolabs.jetpack.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun MyBox() {
	Box(
		modifier = Modifier
      .fillMaxSize()
      .background(color = Color.Blue),
		contentAlignment = Alignment.Center
	) {
		Box(
			modifier = Modifier
        .background(color = Color.Red)
        .width(150.dp)
        .height(150.dp),
			contentAlignment = Alignment.Center
		) {
			Text(text = "Hola box", fontSize = 35.sp)
		}
	}
}