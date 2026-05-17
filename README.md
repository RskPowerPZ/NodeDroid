# NodeDroid - Mobile Node.js IDE

![NodeDroid](https://img.shields.io/badge/NodeDroid-v1.0.0-blue)
![Android](https://img.shields.io/badge/Android-5.0%2B-green)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9.10-purple)

A powerful mobile Node.js IDE for Android, inspired by Pydroid 3, Acode, VS Code, and Termux.

## Features

✨ **Modern UI**
- Jetpack Compose for reactive UI
- Material Design 3 components
- Dark theme (VS Code inspired)

📝 **Code Editor**
- Syntax highlighting
- Line numbers
- Auto-indentation
- Code folding
- Find and replace

🚀 **Code Execution**
- Run JavaScript/Node.js code
- Real-time output panel
- Error reporting

💻 **Terminal**
- Built-in terminal emulation
- Command execution
- File navigation

⚙️ **Settings**
- Customizable editor theme
- Font size adjustment
- Auto-save functionality

## Requirements

- Android SDK 21 (API Level 21) or higher
- Minimum 2GB RAM
- 50MB free storage

## Building

### Prerequisites
- Android Studio Hedgehog or newer
- Java 17 or higher
- Gradle 8.1.0 or newer

### Build Instructions

```bash
# Clone the repository
git clone https://github.com/RskPowerPZ/NodeDroid.git
cd NodeDroid

# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease
```

The built APK will be located in `app/build/outputs/apk/`

## Installation

### From APK
1. Enable "Unknown sources" in Android settings
2. Download the APK file
3. Tap to install

### From Android Studio
1. Connect your Android device via USB
2. Enable USB debugging
3. Run: `./gradlew installDebug`

## Project Structure

```
NodeDroid/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/nodedroid/ide/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── editor/
│   │   │   │   │   └── EditorActivity.kt
│   │   │   │   ├── terminal/
│   │   │   │   │   └── TerminalActivity.kt
│   │   │   │   └── settings/
│   │   │   │       └── SettingsActivity.kt
│   │   │   ├── res/
│   │   │   │   ├── values/
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   └── themes.xml
│   │   │   │   └── mipmap/
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── README.md
```

## Technologies Used

- **UI Framework**: Jetpack Compose
- **Language**: Kotlin
- **Editor**: Sora Editor
- **Build System**: Gradle
- **Min SDK**: Android 5.0 (API 21)
- **Target SDK**: Android 14 (API 34)

## Dependencies

- androidx.compose.ui:ui
- androidx.compose.material3:material3
- androidx.activity:activity-compose
- io.github.rosemoe.sora-editor:editor
- com.squareup.retrofit2:retrofit
- org.jetbrains.kotlinx:kotlinx-coroutines-android

## Development

### Code Style
- Kotlin coding conventions
- Compose best practices
- Material Design 3 guidelines

### Testing
```bash
# Run unit tests
./gradlew test

# Run instrumented tests
./gradlew connectedAndroidTest
```

## Contributing

Contributions are welcome! Please:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

MIT License - See LICENSE file for details

## Acknowledgments

- **Pydroid 3** - Python IDE inspiration
- **Acode** - Web IDE inspiration
- **VS Code** - Theme and UI inspiration
- **Termux** - Terminal functionality inspiration

## Support

For issues, questions, or suggestions, please open an issue on GitHub.

## Roadmap

- [ ] Node.js runtime integration
- [ ] Package manager (npm/yarn) integration
- [ ] Git integration
- [ ] File explorer enhancement
- [ ] Debugging tools
- [ ] Multi-file project support
- [ ] Cloud sync
- [ ] Plugin system

---

**Made with ❤️ by NodeDroid Team**
