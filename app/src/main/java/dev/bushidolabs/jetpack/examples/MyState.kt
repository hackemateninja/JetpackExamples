package dev.bushidolabs.jetpack.examples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MyButton(text: String, onPress: () -> Unit) {
	Button(onClick = { onPress() }) {
		Text(text)
	}
}

@Composable
fun MyText(text: String){
	Text(
		text,
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 50.dp),
		textAlign = TextAlign.Center,
		fontSize = 40.sp
	)
}


@Preview(showSystemUi = true)
@Composable
fun MyState() {
	
	
	var count by rememberSaveable { mutableStateOf(0) }
	
	
	fun handleIncrement() {
		count++
	}
	
	fun handleDecrement() {
		count--
	}
	
	fun handleReset() {
		count = 0
	}
	
	fun currentText(count: Int): String {
		return when {
			count < 0 -> "El número es menor que 0"
			count == 0 -> "El número es igual a 0"
			count > 10 -> "El número es mayor que 10"
			else -> "El número está entre 1 y 10"
		}
	}
	
	Column(
		modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Box {
			MyText(text = "Hello world $count \n\n ${currentText(count)}")
		}
		
		Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
			MyButton(text = "increment") { handleIncrement() }
			
			MyButton(text = "Reset") { handleReset() }
			
			MyButton(text = "decrement") { handleDecrement() }
		}
	}
}


