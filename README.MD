# Compose Multiplatform Application

## Preview
### Android
![photo_2023-11-17_22-17-45](https://github.com/samehesmael277/Tasks-KMP/assets/91541580/d513e036-d080-4278-84d3-ce72e003a56f)

### Desktop
![Screenshot from 2023-11-17 22-08-54](https://github.com/samehesmael277/Tasks-KMP/assets/91541580/974e2128-7c45-445a-b8bf-60f2e41106d7)

<br>

## Built with:
- **Kotlin**
- **Kotlinx Coroutines**
- **Moko MVVM**
- **SQLDelight**

<br>

## Before running!
 - check your system with [KDoctor](https://github.com/Kotlin/kdoctor)
 - install JDK 17 on your machine
 - add `local.properties` file to the project root and set a path to Android SDK there

### Android
To run the application on android device/emulator:  
 - open project in Android Studio and run imported android run configuration

To build the application bundle:
 - run `./gradlew :composeApp:assembleDebug`
 - find `.apk` file in `composeApp/build/outputs/apk/debug/composeApp-debug.apk`

### Desktop
Run the desktop application: `./gradlew :composeApp:run`

### iOS
To run the application on iPhone device/simulator:
 - Open `iosApp/iosApp.xcproject` in Xcode and run standard configuration
 - Or use [Kotlin Multiplatform Mobile plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile) for Android Studio

### Browser
Run the browser application: `./gradlew :composeApp:jsBrowserDevelopmentRun`

