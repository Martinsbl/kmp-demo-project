package org.example.demo

// The Android emulator reaches the host machine through 10.0.2.2.
actual val serverUrl: String = "http://10.0.2.2:$SERVER_PORT"
