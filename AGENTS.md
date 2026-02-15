# Repository Guidelines

## Project Structure & Module Organization
This repository is a single-module Android app:

- `app/src/main/java/com/example/tm1_4_todo_junto_funciona/`: app source (Java + Kotlin activities, fragments, adapters).
- `app/src/main/res/`: layouts, drawables, navigation graph, fonts, values.
- `app/src/test/`: local JVM unit tests.
- `app/src/androidTest/`: instrumented/device tests.
- Root Gradle files: `build.gradle.kts`, `settings.gradle.kts`, `gradle/libs.versions.toml`.

Keep new screens split by concern (for example, `FeatureNameActivity` + `activity_feature_name.xml`) and place shared UI resources in `res/values/`.

## Build, Test, and Development Commands
- `./gradlew assembleDebug`: builds a debug APK for local validation.
- `./gradlew testDebugUnitTest`: runs JVM unit tests in `app/src/test`.
- `./gradlew connectedDebugAndroidTest`: runs instrumented tests on a connected emulator/device.
- `./gradlew lint`: runs Android lint checks.
- `./gradlew clean`: clears build outputs when troubleshooting.

Run commands from the repository root.

## Coding Style & Naming Conventions
- Use 4-space indentation and keep files UTF-8.
- Java/Kotlin classes: `PascalCase` (example: `RecyclerExampleActivity`).
- Methods/variables: `camelCase`; constants: `UPPER_SNAKE_CASE`.
- Layout and resource names: `snake_case` (example: `activity_main_widgets.xml`).
- Prefer descriptive class names tied to role (`...Activity`, `...Fragment`, `...Adapter`).

No dedicated formatter/linter config is checked in; follow Android Studio defaults and run IDE reformat before committing.

## Testing Guidelines
- Frameworks: JUnit4 (`test`) and AndroidX test + Espresso (`androidTest`).
- Name tests with suffixes like `*Test` (unit) and `*InstrumentedTest` (device).
- Add at least one test for new logic-heavy code paths and bug fixes.
- Validate both test suites when touching UI/navigation behavior.

## Commit & Pull Request Guidelines
Recent history uses short, informal commit messages. For new work, prefer clear imperative messages:

- `feat: add drawer menu navigation`
- `fix: prevent null crash in login flow`

Pull requests should include:

- What changed and why.
- Linked issue/task (if available).
- Screenshots/video for UI changes.
- Test evidence (commands run and results).
