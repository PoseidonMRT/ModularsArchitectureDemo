
/**
 * @author
 * @Date 2018/12/24
 * @description
 * @since 1.0.0
 */
object Versions{
    val build_gradle = "3.2.1"

    val kotlin = "1.3.11"
    val appcompat_v7 = "28.0.0"
    val constraint_layout = "1.1.3"

    val compileSdkVersion = 28
    val minSdkVersion = 15

    val junit = "4.12"
    val test_runner = "1.0.2"
    val espresso = "3.0.2"
}

object Deps{
    val build_gradle = "com.android.tools.build:gradle:${Versions.build_gradle}"

    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val appcompat_v7 = "com.android.support:appcompat-v7:${Versions.appcompat_v7}"
    val constraint_layout = "com.android.support.constraint:constraint-layout:${Versions.constraint_layout}"

    val junit = "junit:junit:${Versions.junit}"
    val test_runner = "com.android.support.test:runner:${Versions.test_runner}"
    val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
}