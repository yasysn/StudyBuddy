package com.yassinelakdimi.studybuddy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yassinelakdimi.studybuddy.data.repository.StudyRepository
import com.yassinelakdimi.studybuddy.ui.screens.progress.ProgressScreen
import com.yassinelakdimi.studybuddy.ui.screens.progress.ProgressViewModel
import com.yassinelakdimi.studybuddy.ui.screens.progress.ProgressViewModelFactory
import com.yassinelakdimi.studybuddy.ui.screens.tasks.AddTaskScreen
import com.yassinelakdimi.studybuddy.ui.screens.tasks.AddTaskViewModel
import com.yassinelakdimi.studybuddy.ui.screens.tasks.AddTaskViewModelFactory
import com.yassinelakdimi.studybuddy.ui.screens.tasks.TasksScreen
import com.yassinelakdimi.studybuddy.ui.screens.tasks.TasksViewModel
import com.yassinelakdimi.studybuddy.ui.screens.tasks.TasksViewModelFactory
import com.yassinelakdimi.studybuddy.ui.screens.timer.TimerScreen
import com.yassinelakdimi.studybuddy.ui.screens.timer.TimerViewModel
import com.yassinelakdimi.studybuddy.ui.screens.timer.TimerViewModelFactory

object Routes {
    const val TASKS = "tasks"
    const val ADD_TASK = "add_task"
    const val PROGRESS = "progress"

    const val TIMER = "timer/{taskId}"
    fun timerRoute(taskId: Int) = "timer/$taskId"
}

@Composable
fun StudyBuddyNav(
    repository: StudyRepository,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.TASKS,
        modifier = modifier
    ) {
        composable(Routes.TASKS) {
            val vm: TasksViewModel =
                viewModel(factory = TasksViewModelFactory(repository))

            TasksScreen(
                viewModel = vm,
                onAddClick = { navController.navigate(Routes.ADD_TASK) },
                onTimerClick = { navController.navigate(Routes.timerRoute(-1)) },
                onProgressClick = { navController.navigate(Routes.PROGRESS) },
                onStartTask = { taskId -> navController.navigate(Routes.timerRoute(taskId)) }
            )
        }

        composable(Routes.ADD_TASK) {
            val vm: AddTaskViewModel =
                viewModel(factory = AddTaskViewModelFactory(repository))

            AddTaskScreen(
                viewModel = vm,
                onTaskAdded = { navController.popBackStack() }
            )
        }

        composable(Routes.PROGRESS) {
            val vm: ProgressViewModel =
                viewModel(factory = ProgressViewModelFactory(repository))

            ProgressScreen(
                viewModel = vm,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.TIMER) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")?.toIntOrNull() ?: -1

            val vm: TimerViewModel =
                viewModel(factory = TimerViewModelFactory(repository))

            vm.setTaskId(taskId)

            TimerScreen(
                viewModel = vm,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
