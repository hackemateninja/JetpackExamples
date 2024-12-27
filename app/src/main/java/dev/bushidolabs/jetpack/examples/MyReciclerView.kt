package dev.bushidolabs.jetpack.examples

import SuperHero
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.bushidolabs.jetpack.R
import dev.bushidolabs.jetpack.ui.theme.JetpackCourseTheme

/*@Composable
fun MyRecyclerView(modifier: Modifier) {
	val listItems: List<String> = listOf("Lecha", "Lecho", "Lacha", "Lache")
	
	LazyColumn(modifier = modifier.fillMaxSize()) {
		item { Text(text = "Header") }
		items(count = 10) {
			Text("Est es el item $it")
		}
		items(listItems) { item ->
			Text("esta vez compré, $item")
		}
	}
}*/


fun getSuperHeroes(): List<SuperHero> {
	return listOf(
		SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
		SuperHero("Flash", "Barry Allen", "DC", R.drawable.flash),
		SuperHero("Logan", "James Howlett", "Marvel", R.drawable.logan),
		SuperHero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
		SuperHero("Daredevil", "Matt Murdock", "Marvel", R.drawable.daredevil),
		SuperHero("Green Lantern", "Hal Jordan", "DC", R.drawable.green_lantern),
		SuperHero("Spider-Man", "Peter Parker", "Marvel", R.drawable.spiderman),
		SuperHero("Wonder Woman", "Diana Prince", "DC", R.drawable.wonder_woman)
	)
}

/*@Composable
fun MySuperReciclerView(modifier: Modifier) {
	LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
		item {
			Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
				Text("Name")
				Text("Real name")
				Text("Publisher")
				Text("Photo")
			}
		}
		items(getSuperHeroes()) { hero ->
			Spacer(modifier = Modifier.height(10.dp))
			Card(modifier = Modifier.padding(horizontal = 5.dp).clickable { println(hero) }) {
				Row(
					horizontalArrangement = Arrangement.Absolute.SpaceBetween,
					verticalAlignment = Alignment.CenterVertically,
					modifier = Modifier
						.fillMaxWidth()
						.padding(start = 5.dp)
				) {
					Text(hero.superHeroName)
					Text(hero.realName)
					Text(hero.publisher)
					Image(
						painter = painterResource(id = hero.photo),
						contentDescription = "Super hero avatar"
					)
				}
			}
		}
	}
}*/


@Composable
fun MySuperReciclerGridView(modifier: Modifier) {
	val context = LocalContext.current
	
	LazyVerticalGrid(columns = GridCells.Fixed(2)) {
		items(getSuperHeroes()) { hero ->
			Spacer(modifier = Modifier.height(10.dp))
			Card(
				modifier = Modifier
					.padding(5.dp)
					.clickable {
						Toast
							.makeText(context, "$hero.name", Toast.LENGTH_LONG)
							.show()
					}) {
				Column(
					verticalArrangement = Arrangement.Center,
					horizontalAlignment = Alignment.CenterHorizontally,
					modifier = Modifier
						.fillMaxWidth()
				) {
					Text(hero.superHeroName)
					Text(hero.realName)
					Text(hero.publisher)
					Image(
						painter = painterResource(id = hero.photo),
						contentDescription = "Super hero avatar",
						modifier = Modifier.width(100.dp)
					)
				}
			}
		}
	}
}


@Preview(showSystemUi = true)
@Composable
fun MyReciclerViewPreview() {
	JetpackCourseTheme {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = Color.LightGray)
		) {
			Spacer(modifier = Modifier.height(40.dp))
			MySuperReciclerGridView(modifier = Modifier.padding(horizontal = 20.dp))
		}
	}
}


