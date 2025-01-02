package dev.bushidolabs.jetpack.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import dev.bushidolabs.jetpack.ui.theme.JetpackCourseTheme

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
	
	var count by rememberSaveable { mutableIntStateOf(0) }
	
	StatelessCounter(modifier, count) {
		count++
	}
	
}

@Composable
private fun StatelessCounter(modifier: Modifier, count: Int, onPress: () -> Unit) {
	Column(modifier = modifier.padding(16.dp)) {
		if (count > 0) {
			Text(
				text = "You've had $count glasses."
			)
		}
		
		Button(
			enabled = count < 10,
			onClick = onPress,
			modifier = Modifier
				.padding(top = 8.dp)
		) {
			Text("Add one")
		}
	}
}

data class WellnessTask(val id: Int, val label: String, val isChecked: Boolean)

private fun getWellnessTasks() =
	List(size = 30) { i -> WellnessTask(i, "Task # $i", isChecked = false) }

@Composable
fun WellnessTaskItem(
	taskName: String,
	isChecked: Boolean,
	onCheckedChange: (Boolean) -> Unit,
	onClose: () -> Unit,
	modifier: Modifier = Modifier
) {
	
	Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
		Text(
			modifier = Modifier
				.weight(1f)
				.padding(start = 16.dp),
			text = taskName
		)
		Checkbox(
			checked = isChecked,
			onCheckedChange = onCheckedChange
		)
		IconButton(onClick = onClose) {
			Icon(Icons.Filled.Close, contentDescription = "Close")
		}
	}
}

class WellnessViewModel : ViewModel() {
	private val _tasks = getWellnessTasks().toMutableStateList()
	
	val tasks get() = _tasks
	
	fun onTaskCheckedChange(taskId: Int, isChecked: Boolean) {
		val index = _tasks.indexOfFirst { it.id == taskId }
		if (index != -1) {
			_tasks[index] = _tasks[index].copy(isChecked = isChecked)
		}
	}
	
	fun removeTask(task: WellnessTask) {
		_tasks.remove(task)
	}
	
}

@Composable
fun WellnessScreen(
	modifier: Modifier = Modifier,
	wellnessViewModel: WellnessViewModel = WellnessViewModel()
) {
	Column(modifier = modifier) {
		WaterCounter()
		LazyColumn(modifier = modifier) {
			items(items = wellnessViewModel.tasks, key = { task -> task.id }) { task ->
				WellnessTaskItem(
					taskName = task.label,
					isChecked = task.isChecked,
					onCheckedChange = { isChecked ->
						wellnessViewModel.onTaskCheckedChange(task.id, isChecked)
					},
					onClose = { wellnessViewModel.removeTask(task) }
				)
			}
		}
	}
}

@Preview(showSystemUi = true)
@Composable
fun WellnessScreenPreview(){
	JetpackCourseTheme {
		WellnessScreen()
	}
}