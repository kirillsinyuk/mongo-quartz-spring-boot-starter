plugins {
	`maven-publish`
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"
}

group = "com.kvsinyuk"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.getByName<Jar>("bootJar").enabled = false

publishing {
	repositories {
		maven {
			name = "GitHubPackages"
			url = uri("https://maven.pkg.github.com/SinyukKirill/xls-generator-spring-boot-starter")
			credentials {
				username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
				password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
			}
		}
	}
	publications {
		register<MavenPublication>("gpr") {
			from(components["java"])
		}
	}
}
