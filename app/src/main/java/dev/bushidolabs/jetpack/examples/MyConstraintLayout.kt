package dev.bushidolabs.jetpack.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyConstrainLayout(modifier: Modifier = Modifier) {
	ConstraintLayout(modifier = modifier.fillMaxSize()) {
		
		val (boxRed, boxGray, boxGreen, boxMagenta, boxYellow, boxDark, boxBlack, boxCyan, boxBlue) = createRefs()
		
		val size = 75.dp
		val bigSize = 175.dp
		
		Box(modifier = Modifier
			.size(bigSize)
			.background(Color.DarkGray)
			.constrainAs(boxDark) {
				bottom.linkTo(boxGreen.top)
				start.linkTo(boxGreen.start)
			})
		
		Box(modifier = Modifier
			.size(bigSize)
			.background(Color.Cyan)
			.constrainAs(boxCyan) {
				bottom.linkTo(boxMagenta.top)
				end.linkTo(boxMagenta.end)
			})
		
		
		Box(modifier = Modifier
			.size(bigSize)
			.background(Color.Blue)
			.constrainAs(boxBlue) {
				top.linkTo(boxYellow.bottom)
				start.linkTo(parent.start)
				end.linkTo(parent.end)
			})
		
		
		Box(modifier = Modifier
			.size(size)
			.background(Color.Black)
			.constrainAs(boxBlack) {
				start.linkTo(boxCyan.end)
				top.linkTo(boxCyan.top)
				bottom.linkTo(boxCyan.bottom)
			})
		
		
		Box(modifier = Modifier
			.size(size)
			.background(Color.Red)
			.constrainAs(boxRed) {
				top.linkTo(boxYellow.bottom)
				start.linkTo(boxYellow.end)
			})
		Box(modifier = Modifier
			.size(size)
			.background(Color.Gray)
			.constrainAs(boxGray) {
				top.linkTo(boxYellow.bottom)
				end.linkTo(boxYellow.start)
			})
		Box(modifier = Modifier
			.size(size)
			.background(Color.Green)
			.constrainAs(boxGreen) {
				bottom.linkTo(boxYellow.top)
				start.linkTo(boxYellow.end)
			})
		Box(modifier = Modifier
			.size(size)
			.background(Color.Magenta)
			.constrainAs(boxMagenta) {
				bottom.linkTo(boxYellow.top)
				end.linkTo(boxYellow.start)
			})
		Box(modifier = Modifier
			.size(size)
			.background(Color.Yellow)
			.constrainAs(boxYellow) {
				bottom.linkTo(parent.bottom)
				end.linkTo(parent.end)
				top.linkTo(parent.top)
				start.linkTo(parent.start)
			})
	}
}