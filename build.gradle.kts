plugins {
	java
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"
}

group = "com.app"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// General
	implementation("org.springframework.boot:spring-boot-starter-web:3.3.1")
	// Swagger
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
	// Database
	implementation("org.springframework.boot:spring-boot-starter-jdbc:3.3.1")
	runtimeOnly("mysql:mysql-connector-java:8.0.33")
	implementation("org.flywaydb:flyway-core:10.15.2")
	implementation("org.flywaydb:flyway-mysql:10.15.2")

	// Testing
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.1")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.11.0-M2")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

