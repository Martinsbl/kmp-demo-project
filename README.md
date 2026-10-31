# Penguin Mail

A tiny email reader for the penguins of Bouvet Island. The Ktor server serves a static list of mails, and the
Compose Multiplatform app shows them with Navigation 3: list and mail side by side on wide screens, one page at a time
on phones.

This project is targeting Android, Desktop (JVM), iOS, Web, Server, built with
the [Kotlin Toolchain](https://kotlin-toolchain.org/latest/).

- [/app/androidApp](./app/androidApp) contains the Android application.
- [/app/desktopApp](./app/desktopApp) contains the desktop (JVM) application.
- [/app/iosApp](./app/iosApp) contains the iOS application.
- [/app/shared](./app/shared) holds the code shared across your applications — Compose UI,
  business logic, and platform-specific implementations. [src](./app/shared/src) is for common code; the
  sibling `src@<platform>` folders (for example `src@android`) hold code compiled only for the platform named in the
  folder.
- [/app/webApp](./app/webApp) contains the web application, compiled to WebAssembly with Kotlin/Wasm.
- [/core](./core) holds the `Email` model shared by the server and the apps.
- [/server](./server) contains the Ktor server application.
- [/plugins/ktlint](./plugins/ktlint) is a Kotlin Toolchain plugin that runs [ktlint](https://pinterest.github.io/ktlint/)
  on every module.

### Code organization

The code is sliced vertically: each feature has its own package holding everything it needs, from the navigation key
to the screen and its view model. Folders under `src` follow the packages, leaving out the common `org.example.demo`
root.

- `app/shared/src`
  - `inbox` — the list of mails.
  - `mail` — a single mail, and the placeholder shown when none is selected.
  - `data` — `MailApi` and the platform-specific server URL, used by both features.
  - `common` — `UiState`, shared by the features' view models.
  - `theme` — the Bouvet colors, typography, shapes and top bar.
  - `App.kt` and `NavConfig.kt` wire the features together with Navigation 3.
- `server/src`
  - `emails` — the `/emails` routes and the mails they serve.
  - `Application.kt` starts the server and installs the plugins and routes.

The `kotlin` (macOS/Linux) and `kotlin.bat` (Windows) scripts in the project root are self-bootstrapping wrappers for
the Kotlin Toolchain: they download the pinned toolchain version on first use, so no separate installation is required.
Build the whole project with `./kotlin build`.

### Running

Start the server first, then run any of the apps:

- Server: `./kotlin run -m server`
- Android app: `./kotlin run -m androidApp`
- Desktop app: `./kotlin run -m desktopApp`
- iOS app: `./kotlin run -m iosApp`
- Web app: `./kotlin run -m webApp`

### Testing

Run the project's tests with `./kotlin test`, or `./kotlin test -m <module>` for a single module.

### Linting

The code is linted with [ktlint](https://pinterest.github.io/ktlint/), configured in [.editorconfig](./.editorconfig).

- Lint: `./kotlin check ktlint`
- Fix what ktlint can fix on its own: `./kotlin do ktlintFormat`

Both take `-m <module>` to limit them to a single module. `./kotlin check` runs the lint together with the tests.

---

Learn more
about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html), [Kotlin Toolchain](https://kotlin-toolchain.org/latest/), [Compose Multiplatform](https://kotlinlang.org/compose-multiplatform/), [Kotlin/Wasm](https://kotl.in/wasm/), [Ktor](https://ktor.io/).
