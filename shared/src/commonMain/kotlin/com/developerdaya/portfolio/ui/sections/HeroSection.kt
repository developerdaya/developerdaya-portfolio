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
            .background(colors.heroBackground)
            .padding(horizontal = spacing.screenHorizontal)
            .padding(top = 14.dp, bottom = spacing.sectionBottom)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Name
            Text(
                text = PortfolioData.name,
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = 32.sp),
                color = colors.textPrimary,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(spacing.small))

            // Role
            Text(
                text = PortfolioData.role,
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 18.sp),
                color = colors.textSecondary,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(spacing.medium))

            // Animated Tagline
            TypingAnimatedText(
                lines = PortfolioData.animatedTaglines,
                textStyle = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 18.sp,
                    color = colors.primary,
                    fontWeight = FontWeight.Bold
                )
            )

        }
    }
}

@Composable
fun TypingAnimatedText(
    lines: List<String>,
    textStyle: androidx.compose.ui.text.TextStyle,
    modifier: Modifier = Modifier
) {
    var textToDisplay by remember { mutableStateOf("") }
    var lineIndex by remember { mutableStateOf(0) }
    
    LaunchedEffect(lines) {
        while (true) {
            val currentLine = lines[lineIndex]
            
            // Type
            for (i in 0..currentLine.length) {
                textToDisplay = currentLine.substring(0, i)
                delay(100) // typing speed
            }
            
            // Pause
            delay(1500)
            
            // Erase
            for (i in currentLine.length downTo 0) {
                textToDisplay = currentLine.substring(0, i)
                delay(50) // erasing speed
            }
            
            lineIndex = (lineIndex + 1) % lines.size
        }
    }
    
    Text(
        text = textToDisplay + "|",
        style = textStyle,
        modifier = modifier
    )
}
