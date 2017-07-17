
# Flickr Sample App

An app that allows users to search for images on Flickr and that contains a scrollable view displays retrieved image thumbnails in 3 columns.

The app persists previous search queries using the SearchRecentSuggestionsProvider, and the data survives app reruns and device reboots. 

SearchRecentSuggestionsProvider stores the search history in a database called suggestions.db within your app’s databases directory. 

At most up to 250 search terms are kept in the database.

The app consists of one activity and doesn't have a specific layout for tablets.

[Flickr's API can be found here](https://www.flickr.com/services/api/explore/flickr.photos.search "Flickr API")

## Architecture

The main modules of the app are presentation, domain, data, created in order to ensure a separation of concerns for the layers of the app. 

The presentation layer handles all views and interations with views and invokes the interactor that fetches the data.

The domain layer is independent of any other layer. It defines ways of communicating with outside layers by dependency inversion.

The data layer implements interfaces from the domain layer and also uses the repository to pick the right implementation to serve the presentation layer.

Each layer has its own data objects that are mapped to each other with data mappers.

## Build

 The project was developed using Android studio with a minSdkVersion 21 and targetSdkVersion 25. It was built with SDK version 25 and build tools version 25.0.2 
 
 Build Steps

    Open Android Studio and launch the Android SDK manager from it (Tools | Android | SDK Manager)
	
    Check that these two components are installed and updated to the latest version. Install or upgrade them if necessary.
        Android SDK Platform Tools
        Android Support Library
		
    Return to Android Studio and select Import Project
	
    Select the root folder and import
	
	Rename "blank_keystore.properties" to "keystore.properties" and replace the value "{{FLICKR_KEY}}" with the API Key.
	
    Click Build tab then Clean Project to rebuild

    Configuration :
    This project was built on JDK 1.8 and com.android.tools.build:gradle:2.3.1

    How to run tests :
    Unit tests are run with JUnit, Mockito and Robolectric. Including the libraries in the classpath for testing

    Deployment instructions :
    Import the root folder into your IDE (tested on Android Studio), then run project.

## Miscellaneous

 With more time, I would implement the application with RXJava and use Dagger 2 for dependency injection.
 
 I would also implement more unit tests as well as integration tests.
 
 I would implement a caching layer for responses from the API

## Attribution

 [Code Styles](https://github.com/uber/java-code-styles)
 
 [Build Scripts](https://github.com/vincentbrison/vb-android-app-quality)
 
 [Checkstyle and lint config](https://github.com/uber/android-template)
