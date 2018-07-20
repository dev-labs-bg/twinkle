![logo](https://raw.githubusercontent.com/dev-labs-bg/twinkle/master/preview.gif)



`Twinkle` is a Kotlin library which makes any View in your Android app twinkle.

This library creates ImageViews and animates them generating a sparkle effect.

Original iOS version [here](https://github.com/piemonte/Twinkle).

[![Download](https://img.shields.io/badge/download-1.0-6db33f.svg?style=flat-square&label=version)](https://jitpack.io/#dev-labs-bg/twinkle) [![Twitter URL](https://img.shields.io/badge/twitter-%40devlabsbg-1DA1F2.svg?style=flat-square&logo=twitter)](http://twitter.com/devlabsbg)


## Usage

The sample project provides an example of how to integrate Twinkle, otherwise you can follow this example.

```kotlin
text_view.twinkle()

```

For more control.
```kotlin
val t = twinkle_text.twinkle()
t.stop()
```


The library includes several optional arguments.
```kotlin
text_view.twinkle(drawableRes = R.drawable.image, duration = 1200, sparsity = 200, size = 120)
```

Since the library generates ImageView objects, if you run it on multiple views, with high speed/duration you might notice a bit of lag. That's normal, due to the expensive generation of the image views.

---
## Download

### Gradle

```gradle
dependencies {
  compile 'bg.devlabs.twinkle:twinkle:<latest_version>'
}
 ```
 
### Maven
```xml
<dependency>
  <groupId>bg.devlabs.twinkle</groupId>
  <artifactId>twinkle</artifactId>
  <version>latest_version</version>
  <type>pom</type>
</dependency>
```

### Manually

You can also manually download [the library class](https://github.com/dev-labs-bg/twinkle/blob/master/twinkle/src/main/java/bg/devlabs/twinkle/Twinkle.kt) and use it in your application.

---
## Compatibility

Minimum Android SDK: API level 19

---
## Author

Radoslav Yankov [@Radoslav_Y](https://twitter.com/Radoslav_Y)

---
## Getting help

If you spot a problem you can open an issue on the Github page, or alternatively, you can tweet us at [@devlabsbg](https://twitter.com/devlabsbg)

---
## License

Transitioner is released under the [MIT License](https://github.com/dev-labs-bg/twinkle/blob/master/LICENSE).
