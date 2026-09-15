package com.motolink.android.connection.self

import com.motolink.android.App

abstract class SelfLauncher(
    val manager: SelfLauncherManager,
    val services: SelfLauncherServices
) {

    val commManager
        get() = App.provide(services.aap).commManager

    abstract val name: String

    abstract suspend fun run(): Boolean
}
