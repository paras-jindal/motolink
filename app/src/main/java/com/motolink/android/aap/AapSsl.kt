package com.motolink.android.aap

import com.motolink.android.connection.projection.ProjectionConnection

interface AapSsl {
    fun decrypt(start: Int, length: Int, buffer: ByteArray): ByteArrayWithLimit?
    fun encrypt(offset: Int, length: Int, buffer: ByteArray): ByteArrayWithLimit?
    fun postHandshakeReset()
    fun performHandshake(connection: ProjectionConnection): Boolean
    fun release()
}
