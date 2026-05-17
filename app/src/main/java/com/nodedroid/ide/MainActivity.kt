package com.nodedroid.ide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.content.Intent
import com.nodedroid.ide.editor.EditorActivity
import com.nodedroid.ide.terminal.TerminalActivity
import com.nodedroid.ide.settings.SettingsActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NodeDroidTheme {
                MainScreen(this)
            }
        }
    }
}

@Composable
fun MainScreen(activity: MainActivity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2C3E50))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo/Title Section
        Text(
            text = "NodeDroid",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3498DB),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Node.js IDE for Android",
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Main Buttons
        MainButton(
            text = "New Project",
            onClick = {
                activity.startActivity(Intent(activity, EditorActivity::class.java))
            }
        )

        MainButton(
            text = "Open Project",
            onClick = {
                activity.startActivity(Intent(activity, EditorActivity::class.java))
            }
        )

        MainButton(
            text = "Terminal",
            onClick = {
                activity.startActivity(Intent(activity, TerminalActivity::class.java))
            }
        )

        MainButton(
            text = "Settings",
            onClick = {
                activity.startActivity(Intent(activity, SettingsActivity::class.java))
            }
        )
    }
}

@Composable
fun MainButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3498DB),
            contentColor = Color.White
        )
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun NodeDroidTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Color(0xFF3498DB),
            onPrimary = Color.White,
            primaryContainer = Color(0xFF2C3E50),
            secondary = Color(0xFF3498DB),
        ),
        content = content
    )
}