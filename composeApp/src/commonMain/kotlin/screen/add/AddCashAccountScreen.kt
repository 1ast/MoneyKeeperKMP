package screen.add

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import moneykeeper.composeapp.generated.resources.Res
import moneykeeper.composeapp.generated.resources.add_cash_account
import moneykeeper.composeapp.generated.resources.ic_arrow_back
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

class AddCashAccountScreen : Screen {
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Scaffold(topBar = {
            topBar(navigator)
        }) {
            Text(text = stringResource(Res.string.add_cash_account), modifier = Modifier.fillMaxSize())
        }
    }

    @OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
    @Composable
    fun topBar(navigator: Navigator) {
        TopAppBar(title = {
            Text(
                text = stringResource(Res.string.add_cash_account),
                modifier = Modifier.padding(horizontal = 10.dp),
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp
            )
        }, navigationIcon = {
            Icon(
                imageVector = vectorResource(Res.drawable.ic_arrow_back),
                contentDescription = null,
                modifier = Modifier.fillMaxHeight().clickable(true) {
                    navigator.pop()
                }
            )
        })
    }
}