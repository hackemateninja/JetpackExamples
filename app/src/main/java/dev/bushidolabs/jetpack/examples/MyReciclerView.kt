package dev.bushidolabs.jetpack.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.bushidolabs.jetpack.ui.theme.JetpackCourseTheme

@Composable
fun MyReciclerView(modifier: Modifier){
	val listItems: List<String> = listOf("Lecha", "Lecho", "Lacha", "Lache")
	
	LazyColumn(modifier =  modifier.fillMaxSize()) {
		item { Text(text = "Header") }
		items(count = 10){
			Text("Est es el item $it")
		}
		items(listItems){ item ->
			Text("esta vez compré, $item")
		}
	}
}

@Preview(showSystemUi = true, )
@Composable
fun MyReciclerViewPreview(){
	JetpackCourseTheme {
		Column(modifier = Modifier
			.fillMaxSize()
			.background(color = Color.LightGray)) {
			Spacer(modifier = Modifier.height(40.dp))
			MyReciclerView(modifier = Modifier.padding(horizontal = 20.dp))
		}
	}
}


