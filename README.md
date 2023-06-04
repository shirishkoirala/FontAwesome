# FontAwesome Icon Library for Android

The FontAwesome Icon Library for Android provides a simple and convenient way to use FontAwesome icons in your Android projects. With this library, you can easily incorporate a wide range of high-quality and scalable icons into your Android app.

## Features

- Easy integration of FontAwesome icons into Android projects.
- Supports a vast collection of FontAwesome icons.
- Lightweight and efficient library.
- Customizable icon size and color.

## Installation

To use the FontAwesome Icon Library in your Android project, follow these steps:

1. Add the library as a dependency in your app-level `build.gradle` file:

   ```groovy
   dependencies {
       implementation 'com.shirishkoirala:fontawesome-library:1.0.0'
   }
   ```
2. Sync your project to fetch the library from the specified dependency.

## Usage
Using the FontAwesome Icon Library is straightforward. Follow these steps to display a FontAwesome icon in your app:

1. Add the `FontAwesomeTextView` widget to your layout XML file:
```xml
   <com.shirishkoirala.fontawesome.TextView
        android:id="@+id/iconTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:iconCode="@string/fa_icon_code"
        app:iconSize="@dimen/icon_size"
        app:iconColor="@color/icon_color"/>
```
2. Set the desired icon code, size, and color in your activity or fragment:
```kotlin
   val iconTextView = findViewById<FontAwesomeTextView>(R.id.iconTextView)
   iconTextView.setIconCode(R.string.fa_icon_code)
   iconTextView.setIconSize(R.dimen.icon_size)
   iconTextView.setIconColor(ContextCompat.getColor(this, R.color.icon_color))
  ```
## Example
Here's an example of how you can display a FontAwesome icon in your Android app:
```xml
   <com.shirishkoirala.fontawesome.TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:iconCode="@string/fa_icon_code"
        app:iconSize="24dp"
        app:iconColor="@color/blue"/>
```
## Contributing
Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue or submit a pull request.

## License
This library is released under the MIT License.