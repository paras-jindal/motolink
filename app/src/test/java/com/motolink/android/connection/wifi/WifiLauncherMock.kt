package com.motolink.android.connection.wifi

import com.motolink.android.connection.wifi.modes.WifiLauncherHelper
import com.motolink.android.connection.wifi.modes.WifiLauncherNative
import com.motolink.android.connection.wifi.modes.helper.HelperStrategy
import com.motolink.android.connection.wifi.modes.nativeaa.NativeStrategy
import org.mockito.kotlin.mock

object WifiLauncherMock {

    fun create(
        mode: WifiLauncherMode,
        helperStrategy: HelperStrategy? = null,
        nativeStrategy: NativeStrategy? = null
    ) : WifiLauncher {
        val manager = mock<WifiLauncherManager>()

        if (mode == WifiLauncherMode.HELPER)
            return WifiLauncherHelper(manager, helperStrategy ?: HelperStrategy.DEFAULT)
        else if (mode == WifiLauncherMode.NATIVE)
            return WifiLauncherNative(manager, nativeStrategy ?: NativeStrategy.DEFAULT)
        else // we can just use factory, if strategy wouldn't default from settings
            return mode.factory(manager)
    }
}
