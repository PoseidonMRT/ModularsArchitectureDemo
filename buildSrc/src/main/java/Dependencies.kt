/**
 * @author tuozhaobing
 * @Date 2018/12/24
 * @description dependencies manager for all-modules
 * @since 1.0.0
 */

object Versions{
    val build_gradle = "3.2.1"

    val kotlin = "1.3.11"
    val appcompat_v7 = "28.0.0"
    val constraint_layout = "1.1.3"

    val lifecycle = "2.0.0"

    val compileSdkVersion = 28
    val minSdkVersion = 17
    val targetSdkVersion = 28

    //test
    val junit = "4.12"
    val test_runner = "1.0.2"
    val espresso = "3.0.2"

    val dagger2 = "2.16"
    val rxjava2 = "2.2.4"
    val rxandroid = "2.1.0"

    val arouterApi = "1.4.1"
    val arouterCompiler = "1.2.2"

    val lottie = "2.7.0"

    val retrofit = "2.5.0"
    val okHttp = "3.12.0"
    val gson = "2.8.5"
}

object Deps{
    val build_gradle = "com.android.tools.build:gradle:${Versions.build_gradle}"

    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val appcompat_v7 = "com.android.support:appcompat-v7:${Versions.appcompat_v7}"
    val recyclerView = "com.android.support:recyclerview-v7:${Versions.appcompat_v7}"
    val constraint_layout = "com.android.support.constraint:constraint-layout:${Versions.constraint_layout}"

    val junit = "junit:junit:${Versions.junit}"
    val test_runner = "com.android.support.test:runner:${Versions.test_runner}"
    val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"

    val dagger2 = "com.google.dagger:dagger:${Versions.dagger2}"
    val dagger2Compiler = "com.google.dagger:dagger-compiler:${Versions.dagger2}"
    val dagger2Android = "com.google.dagger:dagger-android:${Versions.dagger2}"
    val dagger2AndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger2}"
    val dagger2AndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger2}"

    val rxjava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxjava2}"
    val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"

    val arouterApi = "com.alibaba:arouter-api:${Versions.arouterApi}"
    val arouterCompiler = "com.alibaba:arouter-compiler:${Versions.arouterCompiler}"

    val lottie = "com.airbnb.android:lottie:${Versions.lottie}"

    val lifecycle_extension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    val viewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle}"
    val liveData = "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycle}"

    val adapter_rxjava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val convert_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
}

object ModuleBuildType{
    val isBuildModuleOnly = true
}