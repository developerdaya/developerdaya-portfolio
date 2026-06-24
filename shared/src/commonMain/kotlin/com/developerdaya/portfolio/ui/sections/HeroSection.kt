package com.developerdaya.portfolio.ui.sections

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developerdaya.portfolio.ui.components.GradientButton
import com.developerdaya.portfolio.ui.components.OutlineButton
import com.developerdaya.portfolio.ui.components.TechBadge
import com.developerdaya.portfolio.ui.theme.PortfolioTheme
import com.developerdaya.portfolio.data.PortfolioData
import kotlinx.coroutines.delay

@Composable
fun HeroSection(
    onContactClick: () -> Unit = {},
    onViewWorkClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val colors = PortfolioTheme.colors
    val spacing = PortfolioTheme.spacing

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0A0E1A),
                        Color(0xFF0F1629),
                        Color(0xFF111827)
                    )
                )
            )
            // Decorative grid pattern drawn on canvas
            .drawBehind {
                val gridColor = Color(0xFF1A2235)
                val spacing = 40f
                var x = 0f
                while (x < size.width) {
                    drawLine(gridColor, Offset(x, 0f), Offset(x, size.height), 0.5f)
                    x += spacing
                }
                var y = 0f
                while (y < size.height) {
                    drawLine(gridColor, Offset(0f, y), Offset(size.width, y), 0.5f)
                    y += spacing
                }

                // Glow circle
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0x3000D4AA),
                            Color.Transparent
                        ),
                        center = Offset(size.width * 0.7f, size.height * 0.3f),
                        radius = 400f
                    ),
                    radius = 400f,
                    center = Offset(size.width * 0.7f, size.height * 0.3f)
                )
            }
            .padding(horizontal = spacing.screenHorizontal)
            .padding(top = 0.dp, bottom = spacing.section)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Name
            Text(
                text = PortfolioData.name,
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = 32.sp),
                color = Color.White,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(spacing.small))

            // Role
            Text(
                text = PortfolioData.role,
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 18.sp),
                color = colors.primary,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(spacing.large))
        }
    }
}
