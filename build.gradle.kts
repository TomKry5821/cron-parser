plugins {
    id("java")
    id("application")
}

group = "pl.tk"
version = "1.0.0-SNAPSHOT"

application {
    mainClass = "pl.tk.Main"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
