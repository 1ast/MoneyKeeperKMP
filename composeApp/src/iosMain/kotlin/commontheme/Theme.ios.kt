package commontheme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import commonarchitcture.DeviceInfo

actual fun supportDynamicTheme(deviceInfo: DeviceInfo): Boolean {
    TODO("Not yet implemented")
}

@Composable
actual fun enableDynamicTheme(darkTheme: Boolean): ColorScheme {
    TODO("Not yet implemented")
}

@Composable
actual fun enableM3(colorScheme: ColorScheme, darkTheme: Boolean) {
}