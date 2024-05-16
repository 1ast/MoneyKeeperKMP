package screen.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import commontheme.AppTheme
import moneykeeper.composeapp.generated.resources.Res
import moneykeeper.composeapp.generated.resources.app_name
import moneykeeper.composeapp.generated.resources.ic_add
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import screen.add.AddTab
import screen.history.HistoryTab
import screen.main.DashboardTab

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    AppTheme {
        var isVisible by remember { mutableStateOf(true) }
        val dashboardScreen = remember {
            DashboardTab(
                onNavigator = { isVisible = it }
            )
        }

        TabNavigator(dashboardScreen) { navigator ->
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
                AnimatedVisibility(visible = isVisible, enter = slideInVertically { height ->
                    height
                }, exit = slideOutVertically { height ->
                    height
                }) {
                    NavigationBar {
                        TabItem(dashboardScreen)
                        TabItem(HistoryTab(onNavigator = { isVisible = it }))
                    }
                }
            }, floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navigator.current = AddTab(onNavigator = { isVisible = it })

                    },

                    shape = CircleShape,
                    elevation = FloatingActionButtonDefaults.elevation(0.dp),
                    modifier = Modifier.offset(y = 80.dp),
                ) {
                    Icon(imageVector = vectorResource(Res.drawable.ic_add), contentDescription = null)

                }
            }, floatingActionButtonPosition = FabPosition.Center,
                modifier = Modifier.fillMaxSize()
                    .statusBarsPadding()
                    .navigationBarsPadding()
            ) {
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
