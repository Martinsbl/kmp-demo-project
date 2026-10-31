package org.example.demo

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import org.example.demo.inbox.Inbox
import org.example.demo.mail.Mail

// Lets the back stack be saved on non-Android platforms, where reflection is not available.
internal val navConfig =
    SavedStateConfiguration {
        serializersModule =
            SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Inbox::class)
                    subclass(Mail::class)
                }
            }
    }
