package com.motolink.android

import android.app.NotificationManager
import android.content.Context
import android.net.wifi.WifiManager
import com.motolink.android.connection.CommManager
import com.motolink.android.decoder.audio.AudioDecoder
import com.motolink.android.decoder.video.DeviceMemoryProfile
import com.motolink.android.decoder.video.VideoDecoder
import com.motolink.android.connection.carkey.CarKeysManager
import com.motolink.android.utils.SUExecutor
import com.motolink.android.utils.Settings

class AppComponent(private val app: App) {

    val settings = Settings(app)
    // A function, not a reading: this decoder is a process singleton, so anything resolved here
    // once would outlive every settings change the user makes.
    val videoDecoder = VideoDecoder(settings) {
        DeviceMemoryProfile.readWithOverride(app, settings.debugForceMemoryProfile)
    }
    val audioDecoder = AudioDecoder()

    val notificationManager: NotificationManager
        get() = app.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val wifiManager: WifiManager
        get() = app.getSystemService(Context.WIFI_SERVICE) as WifiManager

    val commManager = CommManager(app, settings, audioDecoder, videoDecoder)

    val suExecutor = SUExecutor()

    val carKeysManager = CarKeysManager()
}
