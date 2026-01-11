package com.yassinelakdimi.studybuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.yassinelakdimi.studybuddy.ui.navigation.StudyBuddyNav
import com.yassinelakdimi.studybuddy.ui.theme.StudyBuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val container = AppContainer(applicationContext)

        setContent {
            StudyBuddyTheme {
                StudyBuddyNav(repository = container.repository)
            }
        }
    }
}
