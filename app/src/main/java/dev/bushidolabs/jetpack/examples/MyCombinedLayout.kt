package dev.bushidolabs.jetpack.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyCombined(modifier: Modifier = Modifier) {
	Column(
		verticalArrangement = Arrangement.Top,
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier
			.fillMaxSize()
			.background(color = Color.DarkGray)
	) {
		Box(
			modifier = Modifier
				.weight(1f)
				.fillMaxWidth()
				.background(color = Color.Cyan),
			contentAlignment = Alignment.Center
		) {
			Text(text = "Example 1")
		}
		Spacer(modifier = Modifier.height(20.dp))
		Row(
			modifier = Modifier
				.weight(1f)
				.fillMaxWidth()
				.background(color = Color.Blue)
		) {
			Box(
				Modifier
					.weight(1f)
					.fillMaxHeight()
					.background(color = Color.Red),
				contentAlignment = Alignment.Center
			) {
				Text(text = "Example 2")
			}
			Spacer(modifier = Modifier.width(20.dp))
			Box(
				modifier = Modifier
					.weight(1f)
					.fillMaxHeight()
					.background(color = Color.Green),
				contentAlignment = Alignment.Center
			) {
				Text(text = "Example 3")
			}
		}
		Spacer(modifier = Modifier.height(20.dp))
		Box(
			Modifier
				.weight(1f)
				.fillMaxWidth()
				.background(color = Color.Magenta),
			contentAlignment = Alignment.Center
		) {
			Text(text = "example 4")
		}
	}
}