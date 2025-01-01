import androidx.annotation.DrawableRes


data class SuperHero(
	var superHeroName: String,
	val realName: String,
	var publisher: String,
	@DrawableRes var photo: Int
)