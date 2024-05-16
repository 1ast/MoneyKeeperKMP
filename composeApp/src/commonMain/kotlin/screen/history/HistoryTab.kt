package screen.history

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import moneykeeper.composeapp.generated.resources.Res
import moneykeeper.composeapp.generated.resources.history_title
import moneykeeper.composeapp.generated.resources.ic_history
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import kotlin.jvm.Transient

data class HistoryTab(
    @Transient
    val onNavigator: (isRoot: Boolean) -> Unit,
) : Tab {

    @Composable
    override fun Content() {
        Navigator(screen = HistoryScreen()) { navigator ->
            LaunchedEffect(navigator.lastItem) {
                onNavigator(navigator.lastItem is HistoryScreen)
            }
            SlideTransition(navigator = navigator)
        }
    }

    @OptIn(ExperimentalResourceApi::class)
    override val options: TabOptions
        @Composable
        get() {
            val index: UShort = 1u
            val title: String = stringResource(Res.string.history_title)
            val icon: Painter = rememberVectorPainter(vectorResource(Res.drawable.ic_history))
            return remember { TabOptions(index, title, icon) }
        }
}