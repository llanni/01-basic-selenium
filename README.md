# 01 - Basic Selenium (JUnit 5)

Minimal Maven project to show a first Selenium test using Selenium Manager (no manual drivers).

## Prereqs
- Java 17 (Temurin recommended)
- Maven 3.9+
- Chrome installed

## Run (headless)
```bash
mvn clean -Dheadless=true test
```

## Run (browser)
```bash
mvn clean -Dheadless=false test
```

The test opens SauceDemo (v1), logs in as `standard_user/secret_sauce`, and verifies inventory page.

## Files
- `src/test/java/.../SauceDemoLoginTest.java`
