package commonarchitcture

import android.os.Build
import ru.laststr.moneykeeper.BuildConfig

actual fun getDeviceInfo(): DeviceInfo {
    return DeviceInfo(
        deviceName = Build.DEVICE,
        osVersion = Build.VERSION.SDK_INT,
        appVersion = BuildConfig.VERSION_NAME,
        buildType = BuildConfig.BUILD_TYPE
    )
}