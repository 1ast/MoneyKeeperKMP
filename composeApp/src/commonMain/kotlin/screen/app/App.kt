package screen.app

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import moneykeeper.composeapp.generated.resources.Res
import moneykeeper.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import screen.history.HistoryScreen
import screen.main.DashboardScreen

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        TabNavigator(DashboardScreen()) { navigator ->
            Scaffold(topBar = {
                TopAppBar(title = {
                    Text(
                        text = stringResource(Res.string.app_name),
                        modifier = Modifier.padding(horizontal = 10.dp),
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 20.sp
                    )
                })
            }, bottomBar = {
                NavigationBar {
                    TabItem(DashboardScreen())
                    TabItem(HistoryScreen())
                }
            }) {
                CurrentTab()
            }
        }
    }
}

@Composable
private fun RowScope.TabItem(tab: Tab) {
    val navigator = LocalTabNavigator.current

    NavigationBarItem(
        selected = navigator.current.options.index == tab.options.index,
        onClick = {
            navigator.current = tab
        },
        icon = {
            tab.options.icon?.let { painter ->
                Icon(painter, contentDescription = tab.options.title)
            }
        },
        label = {
            Text(tab.options.title)
        }
    )
}