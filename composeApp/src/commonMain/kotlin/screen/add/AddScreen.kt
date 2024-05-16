package screen.add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import ext.LightTransparent
import moneykeeper.composeapp.generated.resources.Res
import moneykeeper.composeapp.generated.resources.add_cash_account
import moneykeeper.composeapp.generated.resources.add_money_order
import moneykeeper.composeapp.generated.resources.ic_cash_account
import moneykeeper.composeapp.generated.resources.ic_money
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

class AddScreen : Screen {
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp).padding(bottom = 100.dp)
        ) {
            addingItem(
                painter = rememberVectorPainter(vectorResource(Res.drawable.ic_cash_account)),
                title = stringResource(Res.string.add_cash_account)
            )
            addingItem(
                painter = rememberVectorPainter(vectorResource(Res.drawable.ic_money)),
                title = stringResource(Res.string.add_money_order)
            )
        }
    }

    @Composable
    private fun addingItem(
        painter: Painter,
        title: String
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
                .background(color = Color.LightTransparent, shape = RoundedCornerShape(30))
        ) {
            Icon(painter, contentDescription = title, modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp))
            Text(
                text = title,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Left,
                maxLines = 1,
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)
            )
        }
    }
}