# FontAwesome Icon Library for Android

The FontAwesome Icon Library for Android provides a simple and convenient way to use FontAwesome
icons in your Android projects. With this library, you can easily incorporate a wide range of
high-quality and scalable icons into your Android app.

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
       implementation 'com.shirishkoirala:fontawesome:1.0.0'
   }
   ```
2. Sync your project to fetch the library from the specified dependency.

## Usage

Using the FontAwesome Icon Library is straightforward. Follow these steps to display a FontAwesome
icon in your app:

1. Add the `IconTextView` widget to your layout XML file:

```xml

<com.shirishkoirala.fontawesome.IconTextView android:layout_width="wrap_content"
    android:layout_height="wrap_content" android:text="@string/gear"
    android:textColor="@color/white" android:textSize="@dimen/title" />
```

2. Set the desired icon code, size, and color in your activity or fragment:

```java
        IconTextView iconTextView=findViewById(R.id.iconTextView);
        iconTextView.setText(Icons.t);
        iconTextView.setTextSize(24);
        iconTextView.setTextColor(this,R.color.white);
```

2. You can aso use `TextView` widget depending on your use case as follows:

```xml

<com.shirishkoirala.fontawesome.IconView android:layout_width="24dp" android:layout_height="24dp"
    android:src="@string/gear" android:tint="@color/yellow" />
```

3. Set the desired icon code, and color in your activity or fragment:

```java

IconView iconView=(IconView)findViewById(R.id.iconView);
        iconView.setColor(Color.RED);
        iconView.setIcon(Icons.gear);
  ```

## Contributing

Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please
open an issue or submit a pull request.

## License

This library is released under the MIT License.