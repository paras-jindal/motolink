package com.motolink.android.utils

import android.content.IntentFilter
import com.motolink.android.contract.KeyIntent

object IntentFilters {
    val keyEvent = IntentFilter(KeyIntent.action)
}