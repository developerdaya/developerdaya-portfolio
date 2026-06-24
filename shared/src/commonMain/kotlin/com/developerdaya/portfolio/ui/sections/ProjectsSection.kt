package com.developerdaya.portfolio.ui.sections

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Laptop
import androidx.compose.material.icons.filled.LocalTaxi
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Radio
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developerdaya.portfolio.data.PortfolioData
import com.developerdaya.portfolio.data.Project
import com.developerdaya.portfolio.ui.components.SectionHeader
import com.developerdaya.portfolio.ui.theme.PortfolioTheme
import org.jetbrains.compose.resources.painterResource
import portfolio.shared.generated.resources.*

@Composable
fun ProjectsSection(modifier: Modifier = Modifier, onOpenUrl: (String) -> Unit = {}) {
    val colors = PortfolioTheme.colors
    val spacing = PortfolioTheme.spacing

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = spacing.screenHorizontal)
            .padding(vertical = spacing.section)
    ) {
        SectionHeader(
            title = "Projects",
            subtitle = "Apps and features I've built"
        )

        Spacer(Modifier.height(spacing.large))

        PortfolioData.projects.forEachIndexed { index, project ->
            ProjectCard(
                project = project,
                index = index,
                onOpenUrl = onOpenUrl
            )
            Spacer(Modifier.height(spacing.medium))
        }
    }
}

@Composable
private fun ProjectCard(
    project: Project,
    index: Int,
    modifier: Modifier = Modifier,
    onOpenUrl: (String) -> Unit = {}
) {
    val colors = PortfolioTheme.colors
    val spacing = PortfolioTheme.spacing

    // Alternate gradient accent for variety
    val accentColors = listOf(
        Pair(colors.accentGradientStart, colors.accentGradientEnd),
        Pair(colors.secondary, colors.accentGradientStart),
        Pair(colors.accent, colors.secondary),
        Pair(colors.accentGradientEnd, colors.accent),
        Pair(colors.accentGradientStart, colors.accent)
    )
    val (gradStart, gradEnd) = accentColors[index % accentColors.size]

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(colors.cardBackground)
            .border(1.dp, colors.border, RoundedCornerShape(16.dp))
    ) {
        // Gradient accent bar at top
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(gradStart, gradEnd))
                )
        )

        Column(modifier = Modifier.padding(spacing.cardPadding)) {
            // 1. Icon & Name Row (Icon + Name & Play Button)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // App Icon Box
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF1E1E1E))
                        .border(1.dp, Color(0xFF333333), RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    val iconPainter = when (project.iconResName) {
                        "live_echo_icon" -> painterResource(Res.drawable.live_echo_icon)
                        "manthan_radio_logo" -> painterResource(Res.drawable.manthan_radio_logo)
                        "buddy_talk_logo" -> painterResource(Res.drawable.buddy_talk_logo)
                        "koyal_fm_logo" -> painterResource(Res.drawable.koyal_fm_logo)
                        else -> null
                    }

                    if (iconPainter != null) {
                        Image(
                            painter = iconPainter,
                            contentDescription = "Project Icon",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        val icon = when (project.title.lowercase()) {
                            "live echo mic" -> Icons.Default.Mic
                            "manthan radio" -> Icons.Default.Radio
                            "buddy talk" -> Icons.Default.Call
                            "koyal fm" -> Icons.Default.MusicNote
                            "goochil user" -> Icons.Default.LocalTaxi
                            "edugorilla" -> Icons.Default.School
                            else -> Icons.Default.Laptop
                        }
                        Icon(
                            imageVector = icon,
                            contentDescription = "Project Icon",
                            tint = colors.primary,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }

                // Name, Subtext & Google Play Button
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = project.title,
                        style = MaterialTheme.typography.titleLarge,
                        color = colors.textPrimary,
                        fontWeight = FontWeight.Bold
                    )
                    
                    if (project.downloads != null) {
                        Spacer(Modifier.height(2.dp))
                        Text(
                            text = "${project.downloads} Downloads",
                            style = MaterialTheme.typography.bodySmall,
                            color = colors.textSecondary,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    if (project.playStoreUrl != null) {
                        Spacer(Modifier.height(6.dp))
                        GooglePlayButton(onClick = { onOpenUrl(project.playStoreUrl) })
                    }
                }
            }

            Spacer(Modifier.height(spacing.medium))

            // 2. Screenshot & Bullet Points Row
            val screenshotPainter = when (project.screenshotResName) {
                "live_echo" -> painterResource(Res.drawable.live_echo)
                "manthan_radio" -> painterResource(Res.drawable.manthan_radio)
                "buddy_talk" -> painterResource(Res.drawable.buddy_talk)
                "koyal_fm" -> painterResource(Res.drawable.koyal_fm)
                else -> null
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.Top
            ) {
                if (screenshotPainter != null) {
                    // Screenshot with a nice dark phone bezel border
                    Box(
                        modifier = Modifier
                            .width(110.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.Black)
                            .border(3.dp, Color(0xFF1E1E1E), RoundedCornerShape(12.dp))
                    ) {
                        Image(
                            painter = screenshotPainter,
                            contentDescription = "${project.title} Screenshot",
                            modifier = Modifier.fillMaxWidth(),
                            contentScale = ContentScale.FillWidth
                        )
                    }
                }

                // Description & Bullets Column
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = project.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = colors.textPrimary,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    project.bullets.forEach { bullet ->
                        Row(
                            modifier = Modifier.padding(bottom = 6.dp),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(top = 6.dp)
                                    .size(5.dp)
                                    .background(
                                        brush = Brush.radialGradient(listOf(gradStart, gradEnd)),
                                        shape = CircleShape
                                    )
                            )
                            Text(
                                text = bullet,
                                style = MaterialTheme.typography.bodySmall,
                                color = colors.textSecondary
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(spacing.medium))

            // 3. Tech Stack Chips at Bottom (Very Small)
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(spacing.small),
                verticalArrangement = Arrangement.spacedBy(spacing.small),
                modifier = Modifier.fillMaxWidth()
            ) {
                project.techStack.forEach { tech ->
                    SmallTechChip(text = tech)
                }
            }
        }
    }
}

@Composable
fun SmallTechChip(
    text: String,
    modifier: Modifier = Modifier
) {
    val colors = PortfolioTheme.colors
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(colors.chipBackground)
            .border(width = 1.dp, color = colors.chipBorder, shape = RoundedCornerShape(4.dp))
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = text,
            color = colors.chipText,
            fontSize = 9.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun GooglePlayButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(Color.Black)
            .border(1.dp, Color(0xFF333333), RoundedCornerShape(6.dp))
            .clickable { onClick() }
            .padding(horizontal = 10.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        // Draw custom Google Play triangle logo
        Canvas(modifier = Modifier.size(16.dp)) {
            val w = size.width
            val h = size.height

            // 1. Blue part (left triangle pointing right)
            val bluePath = Path().apply {
                moveTo(0f, 0f)
                lineTo(w * 0.55f, h * 0.5f)
                lineTo(0f, h)
                close()
            }
            drawPath(bluePath, color = Color(0xFF00C6FF))

            // 2. Green part (bottom-right triangle)
            val greenPath = Path().apply {
                moveTo(0f, h)
                lineTo(w * 0.55f, h * 0.5f)
                lineTo(w * 0.8f, h * 0.75f)
                close()
            }
            drawPath(greenPath, color = Color(0xFF00E175))

            // 3. Yellow part (right triangle pointing left)
            val yellowPath = Path().apply {
                moveTo(w * 0.8f, h * 0.75f)
                lineTo(w * 0.55f, h * 0.5f)
                lineTo(w * 0.8f, h * 0.25f)
                lineTo(w, h * 0.5f)
                close()
            }
            drawPath(yellowPath, color = Color(0xFFFFD300))

            // 4. Red part (top-right triangle)
            val redPath = Path().apply {
                moveTo(0f, 0f)
                lineTo(w * 0.55f, h * 0.5f)
                lineTo(w * 0.8f, h * 0.25f)
                close()
            }
            drawPath(redPath, color = Color(0xFFFF3A44))
        }

        Text(
            text = "Play Store",
            color = Color.White,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.2.sp
        )
    }
}
