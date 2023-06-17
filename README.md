# FontAwesome Icon Library for Android

The FontAwesome Icon Library for Android provides a simple and convenient way to use FontAwesome icons in your Android projects. With this library, you can easily incorporate a wide range of high-quality and scalable icons into your Android app. It allows user to easily create drawables using Font Awesome icons and utilize Unicode values in strings.xml files to set text in TextView. The library also provides two additional helper views, namely `IconTextView` and `IconView`.

## Features

- Easy integration of FontAwesome icons into Android projects.
- Access a wide range of Font Awesome icons and use them to create drawables effortlessly.
- Lightweight and efficient library.
- Customizable icon size and color.
- With Jetpack Compose Wrapper

## Installation

To use the FontAwesome Icon Library in your Android project, follow these steps:

1. Add the library as a dependency in your app-level `build.gradle` file:

    ```groovy
        dependencies {
           implementation 'com.shirishkoirala:FontAwesome:0.2.0'
        }
    ```

2. Sync your project to fetch the library from the specified dependency.

## Usage
Using the FontAwesome Icon Library is straightforward but can be achieved in different ways. First, identify the desired icon from the available Font Awesome icons. You can refer to the [Font Awesome website ](https://fontawesome.com/icons) for a comprehensive list of icons. Follow any of the following ways to add icon to your project.

### Creating Drawables with Font Awesome Icons and adding it to `ImageView`To create a drawable using a Font Awesome icon, follow these steps:
1. In your XML layout file, define an ImageView:
    ```xml
    <ImageView
        android:id="@+id/imageView"
        android:layout_width="24dp"
        android:layout_height="24dp"/>
    ```

2. Create `IconDrawable` as following:
   ```java
    IconDrawable whiteGearIcon = new IconDrawable(this, Icons.gear, Color.WHITE)
   ```

3. Add it to the `ImageView`
   ```java
   ImageView imageView = (ImageView)findViewById(R.id.imageView);
   imageView.setImageDrawable(whiteGearIcon);
   ```
### Using `IconTextView`

1. Add the `IconTextView` widget to your layout XML file:

    ```xml
    
    <com.shirishkoirala.fontawesome.IconTextView 
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/gear"
        android:textColor="@color/white" 
        android:textSize="@dimen/title" />
    ```

2. Change the desired icon code, size, and color in your activity or fragment:

    ```java
    IconTextView iconTextView = findViewById(R.id.iconTextView);
    iconTextView.setText(Icons.t);
    iconTextView.setTextSize(24);
    iconTextView.setTextColor(this,R.color.white);
    ```
### Using `IconView`
1.  Add the `IconView` widget to your layout XML file:

    ```xml
    <com.shirishkoirala.fontawesome.IconView
        android:layout_width="24dp"
        android:layout_height="24dp"
        android:src="@string/gear" 
        android:tint="@color/yellow" />
    ```

3. Change the desired icon code, and color in your activity or fragment:

    ```java
    IconView iconView = (IconView) findViewById(R.id.iconView);
    iconView.setColor(Color.RED);
    iconView.setIcon(Icons.gear);
    ```

### Using Jetpack Compose

```kotlin
ComposeIconView(
    color = R.color.black,
    modifier = Modifier.padding(it),
    size = Dp(35f)
)
```
## Contributing

Contributions are welcome! If you encounter any issues or have suggestions for improvement, please feel free to create an issue or submit a pull request on the GitHub repository.

## License
The FontAwesome Android Library is licensed under the MIT License.

## Acknowledgments
I would like to express our gratitude to the open-source community for their contributions and support.

Thank you for using the FontAwesome Android Library! I hope it helps simplify your development process and enhances your Android applications with beautiful Font Awesome icons.