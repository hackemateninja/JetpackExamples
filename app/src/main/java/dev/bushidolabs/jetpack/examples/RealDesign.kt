package dev.bushidolabs.jetpack.examples

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.bushidolabs.jetpack.R
import dev.bushidolabs.jetpack.ui.theme.JetpackCourseTheme
import java.util.Locale


// Step: Search bar - Modifiers
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
	modifier: Modifier = Modifier
) {
	TextField(
		value = "",
		onValueChange = {},
		leadingIcon = {
			Icon(Icons.Default.Search, contentDescription = null)
		},
		placeholder = {
			Text(stringResource(id = R.string.placeholder_search))
		},
		modifier = modifier
			.heightIn(min = 56.dp)
			.fillMaxWidth()
	)
}

// Step: Align your body - Alignment
@Composable
fun AlignYourBodyElement(
	@DrawableRes drawable: Int,
	@StringRes text: Int,
	modifier: Modifier = Modifier
) {
	Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
		Image(
			painterResource(id = drawable),
			contentDescription = null,
			contentScale = ContentScale.Crop,
			modifier = Modifier
				.size(88.dp)
				.clip(CircleShape)
		)
		Text(
			stringResource(id = text),
			style = MaterialTheme.typography.titleSmall,
			modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
		
		)
	}
}

// Step: Favorite collection card - Material Surface
@Composable
fun FavoriteCollectionCard(
	@DrawableRes drawable: Int,
	@StringRes text: Int,
	modifier: Modifier = Modifier
) {
	Surface(
		shape = MaterialTheme.shapes.small,
		modifier = modifier
	) {
		Row(
			verticalAlignment = Alignment.CenterVertically,
			modifier = Modifier
				.width(192.dp)
				.height(56.dp)
		) {
			Image(
				painter = painterResource(drawable),
				contentDescription = null,
				contentScale = ContentScale.Crop,
				modifier = Modifier
					.size(56.dp)
			)
			Text(
				text = stringResource(text),
				style = MaterialTheme.typography.titleSmall,
				modifier = Modifier.padding(horizontal = 16.dp)
			)
		}
	}
}


// Step: Align your body row - Arrangements
@Composable
fun AlignYourBodyRow(
	modifier: Modifier = Modifier
) {
	LazyRow(
		horizontalArrangement = Arrangement.spacedBy(8.dp),
		contentPadding = PaddingValues(horizontal = 16.dp),
		modifier = modifier
	) {
		items(alignYourBodyData) { item ->
			AlignYourBodyElement(drawable = item.drawable, text = item.text)
		}
	}
}

// Step: Favorite collections grid - LazyGrid
@Composable
fun FavoriteCollectionsGrid(
	modifier: Modifier = Modifier
) {
	LazyHorizontalGrid(
		rows = GridCells.Fixed(2),
		contentPadding = PaddingValues(horizontal = 16.dp),
		horizontalArrangement = Arrangement.spacedBy(8.dp),
		modifier = modifier.height(120.dp)
	) {
		items(favoriteCollectionsData) { item ->
			FavoriteCollectionCard(drawable = item.drawable, text = item.text)
		}
	}
}

// Step: Home section - Slot APIs
@Composable
fun HomeSection(
	@StringRes title: Int,
	modifier: Modifier = Modifier,
	content: @Composable () -> Unit,
) {
	Column(modifier = modifier) {
		Text(
			stringResource(id = title).uppercase(Locale.getDefault()),
			style = MaterialTheme.typography.titleMedium,
			modifier = Modifier
				.paddingFromBaseline(top = 40.dp, bottom = 8.dp)
				.padding(horizontal = 16.dp)
		)
		content()
	}
}

// Step: Home screen - Scrolling
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
	Column(
		modifier.verticalScroll(rememberScrollState())
	) {
		Spacer(Modifier.height(16.dp))
		SearchBar(Modifier.padding(horizontal = 16.dp))
		HomeSection(title = R.string.align_your_body) {
			AlignYourBodyRow()
		}
		HomeSection(title = R.string.favorite_collections) {
			FavoriteCollectionsGrid()
		}
	}
}

// Step: Bottom navigation - Material
@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
	NavigationBar(
		containerColor = MaterialTheme.colorScheme.background,
		modifier = modifier
	) {
		NavigationBarItem(
			selected = true,
			onClick = {},
			icon = {
				Icon(Icons.Default.Spa, contentDescription = null)
			},
			label = {
				Text(stringResource(id = R.string.bottom_navigation_home))
			}
		)
		NavigationBarItem(
			selected = false,
			onClick = {},
			icon = {
				Icon(Icons.Default.AccountCircle, contentDescription = null)
			},
			label = {
				Text(stringResource(id = R.string.bottom_navigation_profile))
			}
		)
	}
}

// Step: MySoothe App - Scaffold
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MySootheAppPortrait() {
	Scaffold(
		bottomBar = { SootheBottomNavigation() }
	) { padding ->
		HomeScreen(Modifier.padding(padding))
	}
}

// Step: Bottom navigation - Material
@Composable
private fun SootheNavigationRail(modifier: Modifier = Modifier) {
	NavigationRail(
		modifier = modifier.padding(start = 8.dp, end = 8.dp),
		containerColor = MaterialTheme.colorScheme.background,
	) {
		Column(
			modifier = modifier.fillMaxHeight(),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			NavigationRailItem(
				icon = {
					Icon(
						imageVector = Icons.Default.Spa,
						contentDescription = null
					)
				},
				label = {
					Text(stringResource(R.string.bottom_navigation_home))
				},
				selected = true,
				onClick = {}
			)
			Spacer(modifier = Modifier.height(8.dp))
			NavigationRailItem(
				icon = {
					Icon(
						imageVector = Icons.Default.AccountCircle,
						contentDescription = null
					)
				},
				label = {
					Text(stringResource(R.string.bottom_navigation_profile))
				},
				selected = false,
				onClick = {}
			)
		}
	}
}
// Step: Landscape Mode
@Composable
fun MySootheAppLandscape() {
	JetpackCourseTheme {
		Surface(color = MaterialTheme.colorScheme.background) {
			Row {
				SootheNavigationRail()
				HomeScreen()
			}
		}
	}
}

// Step: MySoothe App

@Composable
fun MySootheApp() {
}

private val alignYourBodyData = listOf(
	R.drawable.ab1_inversions to R.string.ab1_inversions,
	R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
	R.drawable.ab3_stretching to R.string.ab3_stretching,
	R.drawable.ab4_tabata to R.string.ab4_tabata,
	R.drawable.ab5_hiit to R.string.ab5_hiit,
	R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
	R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
	R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
	R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
	R.drawable.fc4_self_massage to R.string.fc4_self_massage,
	R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
	R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
	@DrawableRes val drawable: Int,
	@StringRes val text: Int
)

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun SearchBarPreview() {
	JetpackCourseTheme { SearchBar(Modifier.padding(8.dp)) }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyElementPreview() {
	JetpackCourseTheme {
		AlignYourBodyElement(
			drawable = R.drawable.ab1_inversions,
			text = R.string.ab1_inversions,
			modifier = Modifier.padding(8.dp)
		)
	}
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionCardPreview() {
	JetpackCourseTheme {
		FavoriteCollectionCard(
			drawable = R.drawable.fc2_nature_meditations,
			text = R.string.fc2_nature_meditations,
			modifier = Modifier.padding(8.dp)
		)
	}
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionsGridPreview() {
	JetpackCourseTheme { FavoriteCollectionsGrid() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyRowPreview() {
	JetpackCourseTheme {
		AlignYourBodyRow(
			modifier = Modifier.padding(8.dp)
		)
	}
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HomeSectionPreview() {
	JetpackCourseTheme {
		HomeSection(title = R.string.align_your_body) {
			AlignYourBodyRow()
		}
	}
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ScreenContentPreview() {
	JetpackCourseTheme { HomeScreen() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BottomNavigationPreview() {
	JetpackCourseTheme { SootheBottomNavigation(Modifier.padding(top = 24.dp)) }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun NavigationRailPreview() {
	JetpackCourseTheme { SootheNavigationRail() }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MySoothePortraitPreview() {
	MySootheAppPortrait()
}

@Preview(widthDp = 640, heightDp = 360)
@Composable
fun MySootheLandscapePreview() {
	MySootheAppLandscape()
}