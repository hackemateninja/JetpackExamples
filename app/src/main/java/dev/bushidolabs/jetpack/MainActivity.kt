package dev.bushidolabs.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.bushidolabs.jetpack.examples.MySuperReciclerGridView
import dev.bushidolabs.jetpack.ui.theme.JetpackCourseTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			JetpackCourseTheme {
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
					MySuperReciclerGridView(modifier = Modifier)
				}
			}
		}
	}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
	Surface(color = MaterialTheme.colorScheme.primary) {
		Text(
			text = "Hello $name! Herman morales",
			modifier = modifier
		)
	}
}

@Preview(showBackground = true, name = "Text preview")
@Composable
fun GreetingPreview() {
	JetpackCourseTheme {
		Greeting(name = "Herman", modifier = Modifier.padding())
	}
}