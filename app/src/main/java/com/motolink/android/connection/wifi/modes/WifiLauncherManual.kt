package com.motolink.android.connection.wifi.modes

import android.content.Context
import com.motolink.android.connection.wifi.WifiLauncher
import com.motolink.android.connection.wifi.WifiLauncherManager
import com.motolink.android.connection.wifi.WifiLauncherMode
import com.motolink.android.connection.wifi.WifiLauncherSharedServices
import com.motolink.android.connection.wifi.WifiLauncherStopSequence
import com.motolink.android.utils.Settings

class WifiLauncherManual(
    manager: WifiLauncherManager
) : WifiLauncher(manager) {

    override val mode = WifiLauncherMode.MANUAL

    override fun hasSameStartConfiguration(launcher: WifiLauncher) = launcher is WifiLauncherManual

    override fun hasWifiDirect() = false

    override fun hasWirelessServer() = false

    override fun hasLocalDiscovery() = false

    override fun start(noInfoToasts: Boolean) {
    }

    override fun stop(seq: WifiLauncherStopSequence) {
    }
}
