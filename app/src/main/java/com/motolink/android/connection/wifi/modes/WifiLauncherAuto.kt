package com.motolink.android.connection.wifi.modes

import com.motolink.android.connection.ConnectionStage
import com.motolink.android.connection.ConnectionStageTracker
import com.motolink.android.connection.wifi.WifiLauncher
import com.motolink.android.connection.wifi.WifiLauncherManager
import com.motolink.android.connection.wifi.WifiLauncherMode
import com.motolink.android.connection.wifi.WifiLauncherStopSequence

class WifiLauncherAuto(
    manager: WifiLauncherManager
) : WifiLauncher(manager) {

    override val mode = WifiLauncherMode.AUTO

    override fun hasSameStartConfiguration(launcher: WifiLauncher): Boolean {
        return launcher is WifiLauncherAuto
    }

    override fun hasWifiDirect() = false

    override fun hasWirelessServer() = true

    override fun hasLocalDiscovery() = true

    override fun start(noInfoToasts: Boolean) {
        // Auto discovery for standard server mode via NSD/mDNS
        // #startDiscovery(oneShot = false) handled by SharedServices
        ConnectionStageTracker.report(ConnectionStage.SEARCHING)
    }

    override fun stop(seq: WifiLauncherStopSequence) {
    }
}
