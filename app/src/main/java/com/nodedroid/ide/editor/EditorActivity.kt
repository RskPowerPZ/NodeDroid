package com.nodedroid.ide.editor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

class EditorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EditorTheme {
                EditorScreen(this)
            }
        }
    }
}

@Composable
fun EditorScreen(activity: EditorActivity) {
    val scope = rememberCoroutineScope()
    var editorContent by remember { mutableStateOf("// Welcome to NodeDroid\n// Start coding here...\n") }
    var currentFile by remember { mutableStateOf("untitled.js") }
    var isSaved by remember { mutableStateOf(true) }
    var showOutput by remember { mutableStateOf(false) }
    var output by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E1E))
    ) {
        // Top Toolbar
        EditorToolbar(
            currentFile = currentFile,
            isSaved = isSaved,
            onSave = {
                scope.launch(Dispatchers.IO) {
                    saveFile(currentFile, editorContent)
                    isSaved = true
                }
            },
            onRun = {
                scope.launch(Dispatchers.Default) {
                    output = runCode(editorContent)
                    showOutput = true
                }
            }
        )

        // Editor Content
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            // Line Numbers
            LineNumbers(editorContent)

            // Code Editor
            CodeEditor(
                content = editorContent,
                onContentChange = {
                    editorContent = it
                    isSaved = false
                },
                modifier = Modifier.weight(1f)
            )
        }

        // Output Section
        if (showOutput) {
            OutputPanel(
                output = output,
                onClose = { showOutput = false }
            )
        }
    }
}

@Composable
fun EditorToolbar(
    currentFile: String,
    isSaved: Boolean,
    onSave: () -> Unit,
    onRun: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = currentFile + if (!isSaved) " *" else "",
                color = Color.White,
                fontSize = 14.sp
            )
        },
        actions = {
            IconButton(onClick = onSave) {
                Icon(Icons.Filled.Save, contentDescription = "Save", tint = Color(0xFF3498DB))
            }
            IconButton(onClick = onRun) {
                Icon(Icons.Filled.PlayArrow, contentDescription = "Run", tint = Color(0xFF27AE60))
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF2C3E50)
        ),
        modifier = Modifier.height(56.dp)
    )
}

@Composable
fun LineNumbers(content: String) {
    val lines = content.split("\n").size
    Column(
        modifier = Modifier
            .background(Color(0xFF252526))
            .padding(horizontal = 8.dp)
            .width(50.dp)
    ) {
        repeat(lines) { index ->
            Text(
                text = (index + 1).toString(),
                color = Color(0xFF858585),
                fontSize = 12.sp,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier.height(20.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.End
            )
        }
    }
}

@Composable
fun CodeEditor(
    content: String,
    onContentChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = content,
        onValueChange = onContentChange,
        modifier = modifier
            .fillMaxHeight()
            .background(Color(0xFF1E1E1E)),
        textStyle = androidx.compose.ui.text.TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            color = Color(0xFFD4D4D4)
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            focusedContainerColor = Color(0xFF1E1E1E),
            unfocusedContainerColor = Color(0xFF1E1E1E)
        ),
        singleLine = false
    )
}

@Composable
fun OutputPanel(output: String, onClose: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color(0xFF000000))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF2C3E50))
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Output", color = Color.White, fontSize = 12.sp)
                IconButton(onClick = onClose, modifier = Modifier.size(24.dp)) {
                    Icon(Icons.Filled.Close, contentDescription = "Close", tint = Color.White, modifier = Modifier.size(16.dp))
                }
            }

            TextField(
                value = output,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF000000)),
                enabled = false,
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.sp,
                    color = Color(0xFF00FF00)
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    disabledBorderColor = Color.Transparent,
                    disabledContainerColor = Color(0xFF000000)
                )
            )
        }
    }
}

@Composable
fun EditorTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Color(0xFF3498DB),
            surface = Color(0xFF1E1E1E),
        ),
        content = content
    )
}

fun saveFile(fileName: String, content: String) {
    try {
        val file = File("/sdcard/NodeDroid/$fileName")
        file.parentFile?.mkdirs()
        file.writeText(content)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun runCode(code: String): String {
    return try {
        // Placeholder: Execute Node.js code
        "Code execution started...\n$code\n✓ Execution completed"
    } catch (e: Exception) {
        "Error: ${e.message}"
    }
}