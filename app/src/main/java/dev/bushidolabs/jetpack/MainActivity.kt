package dev.bushidolabs.jetpack

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import dev.bushidolabs.jetpack.data.LocalEmailsDataProvider
import dev.bushidolabs.jetpack.ui.ReplyApp
import dev.bushidolabs.jetpack.ui.ReplyHomeUIState
import dev.bushidolabs.jetpack.ui.ReplyHomeViewModel

import dev.bushidolabs.jetpack.ui.theme.JetpackCourseTheme

class MainActivity : ComponentActivity() {
	
	private val viewModel: ReplyHomeViewModel by viewModels()
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		enableEdgeToEdge()
		
		setContent {
			val uiState by viewModel.uiState.collectAsState()
			JetpackCourseTheme {
				ReplyApp(
					replyHomeUIState = uiState,
					closeDetailScreen = {
						viewModel.closeDetailScreen()
					},
					navigateToDetail = { emailId ->
						viewModel.setSelectedEmail(emailId)
					}
				)
			}
		}
	}
}

@Preview(
	uiMode = UI_MODE_NIGHT_YES,
	showSystemUi = true,
	name = "DefaultPreviewDark"
)
@Preview(
	uiMode = UI_MODE_NIGHT_NO,
	showSystemUi = true,
	name = "DefaultPreviewLight"
)
@Composable
fun ReplyAppPreviewLight() {
	JetpackCourseTheme {
		ReplyApp(
			replyHomeUIState = ReplyHomeUIState(
				emails = LocalEmailsDataProvider.allEmails
			)
		)
	}
}





