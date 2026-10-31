package org.example.demo.data

import org.example.demo.SERVER_PORT

// The Android emulator reaches the host machine through 10.0.2.2.
actual val serverUrl: String = "http://10.0.2.2:$SERVER_PORT"
