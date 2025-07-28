Floward Task – Jetpack Compose Weather App
A simple weather application built using Jetpack Compose with Clean Architecture and MVI pattern. It demonstrates API integration (OpenWeatherMap), bottom navigation, type-safe navigation using Kotlin Serialization, and Hilt for dependency injection.

Features
Dashboard Screen

Fetches weather data for a fixed city (Cairo) from OpenWeatherMap API.

Displays city name, temperature, and weather conditions.

Button to send feedback to Profile screen.

Profile Screen

Displays mock user details (name, email, avatar).

Receives feedback message from Dashboard (cross-screen communication).

Architecture

Clean Architecture: data, domain, presentation

MVI pattern with BaseViewModel (State, Event, SideEffect)

Dependency injection via Hilt

Type-safe navigation via Kotlin Serialization



Tech Stack
Jetpack Compose

Navigation-Compose

Kotlin Coroutines

Retrofit & OkHttp

Hilt

Coil

Kotlin Serialization



Project Structure
graphql
Copy
Edit
com.floward.floward_task
│
├── core/
│   └── bases/          # Base MVI ViewModel & interfaces
│
├── data/
│   ├── remote/         # Retrofit API service & response models
│   └── repository/     # Repository implementation
│
├── domain/
│   ├── model/          # Domain models
│   ├── repository/     # Repository interfaces
│   └── usecase/        # Use cases
│
├── presentation/
│   ├── dashboard/      # Dashboard MVI (state, event, effect, screen)
│   ├── profile/        # Profile MVI (state, event, effect, screen)
│   └── main/           # Main screen with bottom navigation
│
└── di/
    └── AppModule.kt    # Hilt DI setup
Setup
1. Get API Key
Sign up at OpenWeatherMap and obtain an API key.

2. Add API Key
Add your key in AppModule.kt or via local.properties:

properties
Copy
Edit
OPEN_WEATHER_API_KEY="your_api_key"
Build Instructions
bash
Copy
Edit
# Clean and build
./gradlew clean build

# Run on device/emulator
./gradlew installDebug
Navigation
Bottom Navigation: Dashboard ↔ Profile

Safe Args with Serialization: Feedback message passed from Dashboard to Profile

Example:

kotlin
Copy
Edit
navController.navigate(ProfileDestination(feedbackMessage = "Hello"))
Profile screen decodes:

kotlin
Copy
Edit
val args = backStackEntry.toRoute<ProfileDestination>()
MVI Pattern
Each screen has:

State – immutable UI state

Event – user actions

SideEffect – one-time effects (snackbars, navigation)

Base ViewModel handles event collection and state updates.

Requirements
Minimum SDK: 24

Kotlin: 2.0.21

Gradle Plugin: 8.5.2

Compose BOM: 2025.05.01

