package commonarchitcture

data class DeviceInfo(
    /** Device name supported by build tools */
    val deviceName: String,
    /** In android SDK_INT */
    val osVersion: Int,
    /** Current application version */
    val appVersion: String,
    /** Current build type */
    val buildType: String
)

expect fun getDeviceInfo(): DeviceInfo
