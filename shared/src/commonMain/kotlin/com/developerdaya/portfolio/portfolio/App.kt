package com.developerdaya.portfolio.portfolio

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import com.developerdaya.portfolio.ui.PortfolioScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val uriHandler = LocalUriHandler.current
        PortfolioScreen(
            onEmailClick = {

            },
            onOpenUrl = {
                uriHandler.openUri(it)
            },
            onPhoneClick = {

            }
        )
    }
}