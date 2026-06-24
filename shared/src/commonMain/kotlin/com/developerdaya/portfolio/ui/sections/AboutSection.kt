package com.developerdaya.portfolio.ui.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.developerdaya.portfolio.ui.components.PortfolioCard
import com.developerdaya.portfolio.ui.components.SectionHeader
import com.developerdaya.portfolio.ui.theme.PortfolioTheme
import com.developerdaya.portfolio.data.PortfolioData

@Composable
fun AboutSection(modifier: Modifier = Modifier) {
    val colors = PortfolioTheme.colors
    val spacing = PortfolioTheme.spacing

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = spacing.screenHorizontal)
            .padding(vertical = spacing.section)
    ) {
        SectionHeader(
            title = "About Me",
            subtitle = "Who I am and what drives me"
        )

        Spacer(Modifier.height(spacing.large))

        PortfolioCard {
            Text(
                text = PortfolioData.aboutSummary,
                style = MaterialTheme.typography.bodyLarge,
                color = colors.textSecondary,
                lineHeight = MaterialTheme.typography.bodyLarge.lineHeight
            )
        }
    }
}
