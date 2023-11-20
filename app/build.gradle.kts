plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.acquireprinter"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.acquireprinter"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {



    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.drawerlayout:drawerlayout:1.2.0")

    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.sqlite:sqlite:2.3.1")

    implementation("androidx.activity:activity-ktx:1.5.0")


    //ini untuk implementasi google mapsnya, utils untuk utilisasi jika user ingin zoom atau apalah
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    implementation("com.google.android.gms:play-services-base:18.2.0")
    implementation("com.google.android.gms:play-services-location:18.0.0")
    //

    implementation(platform("com.google.firebase:firebase-bom:32.4.0"))

    implementation("com.google.firebase:firebase-database:20.3.0")
    implementation("com.google.firebase:firebase-auth:21.1.0")

    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-storage:20.3.0")

    //image handler
    implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}