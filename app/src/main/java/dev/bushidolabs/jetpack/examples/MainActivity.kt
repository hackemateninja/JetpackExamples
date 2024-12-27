package dev.bushidolabs.jetpack.examples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.bushidolabs.jetpack.ui.theme.JetpackCourseTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			JetpackCourseTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					MyCombined(modifier = Modifier.padding(innerPadding))
				}
			}
		}
	}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
	Text(
		text = "Hello $name! Herman morales",
		modifier = modifier
	)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
	JetpackCourseTheme {
		Greeting(name = "Herman", modifier = Modifier.padding(vertical = 250.dp, horizontal = 50.dp))
	}
}