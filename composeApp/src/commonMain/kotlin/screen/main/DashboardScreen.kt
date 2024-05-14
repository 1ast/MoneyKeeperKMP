package screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import moneykeeper.composeapp.generated.resources.Res
import moneykeeper.composeapp.generated.resources.dashboard_title
import moneykeeper.composeapp.generated.resources.ic_dashboard
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

class DashboardScreen : Tab {
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(stringResource(Res.string.dashboard_title))
        }
    }

    @OptIn(ExperimentalResourceApi::class)
    override val options: TabOptions
        @Composable
        get() {
            val index: UShort = 0u
            val title: String = stringResource(Res.string.dashboard_title)
            val icon: Painter = rememberVectorPainter(vectorResource(Res.drawable.ic_dashboard))
            return TabOptions(index, title, icon)
        }
}