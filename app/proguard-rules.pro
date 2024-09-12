# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
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
# General rules to optimize code
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
-dontpreverify
-dontobfuscate
-dontnote **

# Keep exception names
-keepattributes SourceFile,LineNumberTable

# Keep Room entities and DAOs
-keep class androidx.room.** { *; }
-keep interface androidx.room.* { *; }
-keep class dev.shrishri1108.JavaRoomMVVM.db.** { *; }

# Keep schema and migration classes
-keep class androidx.sqlite.db.** { *; }

# Keep AndroidX libraries
-keep class androidx.** { *; }
-dontwarn androidx.**