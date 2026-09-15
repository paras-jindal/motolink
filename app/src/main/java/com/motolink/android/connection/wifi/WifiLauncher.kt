package com.motolink.android.connection.wifi

import com.motolink.android.App

abstract class WifiLauncher(val manager: WifiLauncherManager) {


    abstract val mode: WifiLauncherMode

    abstract fun hasSameStartConfiguration(launcher: WifiLauncher): Boolean

    abstract fun hasWifiDirect(): Boolean

    abstract fun hasWirelessServer(): Boolean

    abstract fun hasLocalDiscovery(): Boolean

    abstract fun start(noInfoToasts: Boolean)

    abstract fun stop(seq: WifiLauncherStopSequence)

    open fun restartDiscovery() {
        manager.startDiscovery()
    }


    protected val service get() = manager.service

    protected val settings get() = App.provide(service).settings
}
