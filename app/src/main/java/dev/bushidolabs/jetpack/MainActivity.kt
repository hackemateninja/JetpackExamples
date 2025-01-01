package dev.bushidolabs.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.bushidolabs.jetpack.examples.MySootheApp

import dev.bushidolabs.jetpack.ui.theme.JetpackCourseTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			JetpackCourseTheme {
				MySootheApp()
			}
		}
	}
}




