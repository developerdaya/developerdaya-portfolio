package com.developerdaya.portfolio.ui.design

import androidx.compose.ui.graphics.Color
import com.developerdaya.portfolio.ui.theme.Accent
import com.developerdaya.portfolio.ui.theme.DarkBackground
import com.developerdaya.portfolio.ui.theme.DarkBorder
import com.developerdaya.portfolio.ui.theme.DarkCard
import com.developerdaya.portfolio.ui.theme.DarkCardElevated
import com.developerdaya.portfolio.ui.theme.DarkSurface
import com.developerdaya.portfolio.ui.theme.DarkTextPrimary
import com.developerdaya.portfolio.ui.theme.DarkTextSecondary
import com.developerdaya.portfolio.ui.theme.GradientEnd
import com.developerdaya.portfolio.ui.theme.GradientStart
import com.developerdaya.portfolio.ui.theme.LightBackground
import com.developerdaya.portfolio.ui.theme.LightBorder
import com.developerdaya.portfolio.ui.theme.LightCard
import com.developerdaya.portfolio.ui.theme.LightCardElevated
import com.developerdaya.portfolio.ui.theme.LightSurface
import com.developerdaya.portfolio.ui.theme.LightTextPrimary
import com.developerdaya.portfolio.ui.theme.LightTextSecondary
import com.developerdaya.portfolio.ui.theme.Primary
import com.developerdaya.portfolio.ui.theme.Secondary
import com.developerdaya.portfolio.ui.theme.TechBadgeBg
import com.developerdaya.portfolio.ui.theme.TechBadgeBorder
import com.developerdaya.portfolio.ui.theme.TechBadgeText
import com.developerdaya.portfolio.ui.theme.TimelineDot
import com.developerdaya.portfolio.ui.theme.TimelineLine

/**
 * Semantic color tokens that adapt to light/dark theme.
 * Usage: PortfolioTheme.colors.primary
 */
data class PortfolioColors(
    val primary: Color,
    val secondary: Color,
    val accent: Color,
    val background: Color,
    val surface: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val cardBackground: Color,
    val cardBackgroundElevated: Color,
    val border: Color,

    // Semantic sections
    val heroBackground: Color,
    val sectionBackground: Color,
    val alternateBackground: Color,

    // Gradient
    val accentGradientStart: Color,
    val accentGradientEnd: Color,

    // Tech Badge
    val techBadgeBackground: Color,
    val techBadgeBorderColor: Color,
    val techBadgeTextColor: Color,

    // Timeline
    val timelineLine: Color,
    val timelineDot: Color,

    // Chip / Tag
    val chipBackground: Color,
    val chipText: Color,
    val chipBorder: Color,
    val chipBackgroundAlt: Color,

    val isDark: Boolean
)

val DarkPortfolioColors = PortfolioColors(
    primary = Primary,
    secondary = Secondary,
    accent = Accent,
    background = DarkBackground,
    surface = DarkSurface,
    textPrimary = DarkTextPrimary,
    textSecondary = DarkTextSecondary,
    cardBackground = DarkCard,
    cardBackgroundElevated = DarkCardElevated,
    border = DarkBorder,
    heroBackground = DarkBackground,
    sectionBackground = DarkSurface,
    alternateBackground = DarkCard,
    accentGradientStart = GradientStart,
    accentGradientEnd = GradientEnd,
    techBadgeBackground = TechBadgeBg,
    techBadgeBorderColor = TechBadgeBorder,
    techBadgeTextColor = TechBadgeText,
    timelineLine = TimelineLine,
    timelineDot = TimelineDot,
    chipBackground = Color(0xFF1F2A40),
    chipText = Primary,
    chipBorder = Color(0xFF2A3550),
    chipBackgroundAlt = Color(0xFF1A1F30),
    isDark = true
)

val LightPortfolioColors = PortfolioColors(
    primary = Primary,
    secondary = Secondary,
    accent = Accent,
    background = LightBackground,
    surface = LightSurface,
    textPrimary = LightTextPrimary,
    textSecondary = LightTextSecondary,
    cardBackground = LightCard,
    cardBackgroundElevated = LightCardElevated,
    border = LightBorder,
    heroBackground = Color(0xFF0A0E1A),
    sectionBackground = LightBackground,
    alternateBackground = LightCardElevated,
    accentGradientStart = GradientStart,
    accentGradientEnd = GradientEnd,
    techBadgeBackground = Color(0xFFE6FBF7),
    techBadgeBorderColor = Primary,
    techBadgeTextColor = Color(0xFF007A60),
    timelineLine = LightBorder,
    timelineDot = Primary,
    chipBackground = Color(0xFFE6FBF7),
    chipText = Color(0xFF006B52),
    chipBorder = Color(0xFFB3EFE3),
    chipBackgroundAlt = Color(0xFFF0F4FF),
    isDark = false
)
