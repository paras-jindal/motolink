package com.motolink.android.connection.wifi

import com.motolink.android.connection.wifi.modes.helper.HelperStrategy
import com.motolink.android.connection.wifi.modes.nativeaa.NativeStrategy

/**
 * Whether a given WiFi mode/strategy combination uses [com.motolink.android.connection.WifiDirectManager]
 * to run a WiFi Direct P2P group. Shared between [com.motolink.android.aap.AapService.initWifiMode] (stop it on a
 * *settings change*) and [com.motolink.android.aap.AapService.onDisconnected] (stop it on a *user disconnect*) so the
 * two call sites can't drift out of sync.
 */
object WifiModePolicy {
    /**
     * [nativeStrategy] applies to mode 3 only, and is the whole reason this takes a third argument:
     * on the hotspot route the answer must be false, because the caller reacts to a true by
     * force-disabling the hotspot before starting P2P — which would tear down the very access
     * point the route is about to advertise.
     */
    fun usesWifiDirect(
        mode: Int,
        helperStrategy: Int,
        nativeStrategy: NativeStrategy = NativeStrategy.WIFI_DIRECT
    ): Boolean =
        usesWifiDirect(
            WifiLauncherMode.byIdOrDefault(mode),
            HelperStrategy.byIdOrDefault(helperStrategy),
            nativeStrategy)

    fun usesWifiDirect(
        mode: WifiLauncherMode,
        helperStrategy: HelperStrategy,
        nativeStrategy: NativeStrategy = NativeStrategy.WIFI_DIRECT
    ): Boolean =
        WifiLauncherMock.create(mode, helperStrategy, nativeStrategy).hasWifiDirect()
}
