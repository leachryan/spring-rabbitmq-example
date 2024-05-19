import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version libs.versions.springBoot
	id("io.spring.dependency-management") version libs.versions.springDependencyManagement
	kotlin("jvm") version libs.versions.kotlin
	kotlin("plugin.spring") version libs.versions.kotlin
}

group = "dev.leachryan"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.springBootStarterAmqp)
	implementation(libs.kotlinReflect)
	implementation(libs.springRabbitStream)
	testImplementation(testLibs.springBootStarterTest)
	testImplementation(testLibs.springRabbitTest)
	testRuntimeOnly(testLibs.junitPlatformLauncher)
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = libs.versions.java.get()
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
