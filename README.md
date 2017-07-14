
# Flickr Sample App

Android sample app for searching images using, Flickr's API. 

## Build

    The project was developed using Android studio with a minSdkVersion 16 and targetSdkVersion 25 It was built with 
    SDK version 25 and build tools version 25.0.2

    Building using Android Studio...

    Open Android Studio and launch the Android SDK manager from it (Tools | Android | SDK Manager)
    Check that these two components are installed and updated to the latest version. Install or upgrade them if necessary.
        Android SDK Platform Tools
        Android Support Library
        Google Play Services
        Google Repository
    Return to Android Studio and select Import Project
    Select the root folder and import
    Click Build tab then Clean Project to rebuild

    Configuration

    This project was built on JDK 1.8 and com.android.tools.build:gradle:2.3.1

    Dependencies

    compile 'com.android.support:appcompat-v7:25.3.1' compile 'com.android.support:recyclerview-v7:25.3.1' compile 'com.android.support:design:25.3.1' testCompile 'junit:junit:4.12' testCompile "org.robolectric:robolectric:3.3.2"

    How to run tests

    Unit tests are run with JUnit and Robolectric. Including the libraries in the classpath for testing

    Deployment instructions

    Import the root folder into your IDE (tested on Android Studio), then run project.




## Attribution

 Code styles from https://github.com/uber/java-code-styles
 
 Using code quality build script from https://github.com/vincentbrison/vb-android-app-quality
 
 Checkstyle and lint config from https://github.com/uber/android-template
