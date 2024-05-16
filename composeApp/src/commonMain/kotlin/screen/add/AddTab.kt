package screen.add

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
import moneykeeper.composeapp.generated.resources.add_tab_title
import moneykeeper.composeapp.generated.resources.ic_add_circle
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import kotlin.jvm.Transient

class AddTab(
    @Transient
    val onNavigator: (isRoot: Boolean) -> Unit,
) : Tab {
    @Composable
    override fun Content() {
        Navigator(AddScreen()) { navigator ->
            LaunchedEffect(navigator.lastItem) {
                onNavigator(navigator.lastItem is AddScreen)
            }
            SlideTransition(navigator = navigator)
        }
    }

    @OptIn(ExperimentalResourceApi::class)
    override val options: TabOptions
        @Composable
        get() {
            val index: UShort = 2u
            val title: String = stringResource(Res.string.add_tab_title)
            val icon: Painter = rememberVectorPainter(vectorResource(Res.drawable.ic_add_circle))
            return remember { TabOptions(index, title, icon) }
        }
}