plugins {
    java
    application
}

group = "ru.nefedov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

application {
    mainClass.set("ru.nefedov.HelloWorld")
}