# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# signingConfigs.release.proguardFiles and signingConfigs.debug.proguardFiles
# vectors.

# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Compose
-keep class androidx.compose.** { *; }

# Kotlin
-keep class kotlin.** { *; }
-keep interface kotlin.** { *; }

# Material Design 3
-keep class com.google.android.material.** { *; }
-keep interface com.google.android.material.** { *; }

# Retrofit
-keep class retrofit2.** { *; }
-keepclassmembers class retrofit2.** { *; }

# Sora Editor
-keep class io.github.rosemoe.sora.** { *; }
