package com.motolink.android.aap.protocol.messages

import com.motolink.android.aap.AapMessage
import com.motolink.android.aap.protocol.Channel
import com.motolink.android.aap.protocol.proto.Sensors
import com.google.protobuf.Message

open class SensorEvent(val sensorType: Int, proto: Message)
    : AapMessage(Channel.ID_SEN, Sensors.SensorsMsgType.SENSOR_EVENT_VALUE, proto)
