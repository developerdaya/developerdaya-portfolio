package com.developerdaya.portfolio.ui.sections

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developerdaya.portfolio.data.PortfolioData
import com.developerdaya.portfolio.ui.components.SectionHeader
import com.developerdaya.portfolio.ui.theme.PortfolioTheme

@Composable
fun SkillsSection(modifier: Modifier = Modifier) {
    val colors = PortfolioTheme.colors
    val spacing = PortfolioTheme.spacing

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = spacing.section)
    ) {
        // Header with padding
        Column(modifier = Modifier.padding(horizontal = spacing.screenHorizontal)) {
            SectionHeader(
                title = "Skills",
                subtitle = "Technologies and tools I work with"
            )
        }

        Spacer(Modifier.height(spacing.large))

        // Skill categories
        PortfolioData.skillCategories.forEach { (category, skills) ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = spacing.screenHorizontal,
                        end = spacing.screenHorizontal,
                        bottom = spacing.medium
                    )
            ) {
                Text(
                    text = category,
                    style = MaterialTheme.typography.titleMedium,
                    color = colors.textPrimary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Spacer(Modifier.height(spacing.small))

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(spacing.small),
                    verticalArrangement = Arrangement.spacedBy(spacing.small),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    skills.forEach { skill ->
                        PremiumSkillChip(name = skill)
                    }
                }
            }
        }
    }
}

@Composable
fun PremiumSkillChip(
    name: String,
    modifier: Modifier = Modifier
) {
    val lowercaseName = name.lowercase()
    val hasIcon = lowercaseName in listOf("kotlin", "java", "android", "compose", "firebase", "springboot", "git", "gitlab")

    // Determine colors
    val bgColor = when {
        lowercaseName == "kotlin" || lowercaseName == "coroutines" -> Color(0xFF7F52FF) // Purple
        lowercaseName == "java" -> Color(0xFFE76F00) // Orange
        lowercaseName in listOf("android", "mvvm", "retrofit", "room") -> Color(0xFF3DDC84) // Android Green
        lowercaseName in listOf("compose", "hilt", "paging3", "ci/cd") -> Color(0xFF4285F4) // Compose/Google Blue
        lowercaseName in listOf("clean architecture", "exoplayer") -> Color(0xFF121212) // Black/Dark
        lowercaseName == "firebase" -> Color(0xFFFFCA28) // Yellow
        lowercaseName == "springboot" -> Color(0xFF6DB33F) // Spring Green
        lowercaseName == "aws" -> Color(0xFF232F3E) // Dark Grey/Navy
        lowercaseName == "git" -> Color(0xFFF05032) // Git Red
        lowercaseName == "gitlab" -> Color(0xFFFC6D26) // Gitlab Orange
        else -> Color(0xFF1E293B) // Default fallback
    }

    val textColor = if (lowercaseName == "firebase") Color(0xFF121212) else Color.White
    val borderColor = if (lowercaseName in listOf("clean architecture", "exoplayer")) Color(0xFF333333) else Color(0x22FFFFFF)

    val chipShape = RoundedCornerShape(8.dp)

    Row(
        modifier = modifier
            .clip(chipShape)
            .background(bgColor)
            .border(1.dp, borderColor, chipShape)
            .padding(
                start = if (hasIcon) 6.dp else 12.dp,
                end = 12.dp,
                top = if (hasIcon) 6.dp else 8.dp,
                bottom = if (hasIcon) 6.dp else 8.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (hasIcon) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                // Determine icon tint (icon matches chip color or brand color)
                val iconTint = when (lowercaseName) {
                    "kotlin" -> Color(0xFF7F52FF)
                    "java" -> Color(0xFFE76F00)
                    "android" -> Color(0xFF3DDC84)
                    "compose" -> Color(0xFF4285F4)
                    "springboot" -> Color(0xFF6DB33F)
                    else -> bgColor
                }
                SkillIcon(name = lowercaseName, tint = iconTint)
            }
        }

        Text(
            text = name.uppercase(),
            color = textColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun SkillIcon(name: String, tint: Color) {
    Canvas(modifier = Modifier.size(16.dp)) {
        val width = size.width
        val height = size.height
        when (name.lowercase()) {
            "kotlin" -> {
                // Kotlin logo is a diagonal gradient split
                val path = Path().apply {
                    moveTo(0f, height)
                    lineTo(width, 0f)
                    lineTo(0f, 0f)
                    close()
                }
                drawPath(
                    path = path,
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFE10098), Color(0xFF7F52FF), Color(0xFFF15A24))
                    )
                )
                val path2 = Path().apply {
                    moveTo(0f, height)
                    lineTo(width, height)
                    lineTo(width * 0.5f, height * 0.5f)
                    close()
                }
                drawPath(
                    path = path2,
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF7F52FF), Color(0xFFF15A24))
                    )
                )
            }
            "java" -> {
                // Java Coffee Cup
                // Cup body
                val cupPath = Path().apply {
                    moveTo(width * 0.25f, height * 0.4f)
                    lineTo(width * 0.75f, height * 0.4f)
                    cubicTo(
                        width * 0.75f, height * 0.75f,
                        width * 0.65f, height * 0.85f,
                        width * 0.5f, height * 0.85f
                    )
                    cubicTo(
                        width * 0.35f, height * 0.85f,
                        width * 0.25f, height * 0.75f,
                        width * 0.25f, height * 0.4f
                    )
                    close()
                }
                drawPath(cupPath, color = tint)

                // Cup Handle
                val handlePath = Path().apply {
                    moveTo(width * 0.75f, height * 0.48f)
                    cubicTo(
                        width * 0.92f, height * 0.48f,
                        width * 0.92f, height * 0.72f,
                        width * 0.75f, height * 0.72f
                    )
                }
                drawPath(
                    handlePath,
                    color = tint,
                    style = Stroke(width = 2.dp.toPx(), cap = StrokeCap.Round)
                )

                // Saucer
                val saucerPath = Path().apply {
                    moveTo(width * 0.15f, height * 0.9f)
                    lineTo(width * 0.85f, height * 0.9f)
                }
                drawPath(
                    saucerPath,
                    color = tint,
                    style = Stroke(width = 1.5.dp.toPx(), cap = StrokeCap.Round)
                )

                // Steam lines
                val steam1 = Path().apply {
                    moveTo(width * 0.4f, height * 0.3f)
                    quadraticBezierTo(width * 0.35f, height * 0.2f, width * 0.4f, height * 0.1f)
                }
                val steam2 = Path().apply {
                    moveTo(width * 0.6f, height * 0.3f)
                    quadraticBezierTo(width * 0.55f, height * 0.2f, width * 0.6f, height * 0.1f)
                }
                drawPath(
                    steam1,
                    color = tint,
                    style = Stroke(width = 1.dp.toPx(), cap = StrokeCap.Round)
                )
                drawPath(
                    steam2,
                    color = tint,
                    style = Stroke(width = 1.dp.toPx(), cap = StrokeCap.Round)
                )
            }
            "android" -> {
                // Android Robot head
                // Dome (Head)
                drawArc(
                    color = tint,
                    startAngle = 180f,
                    sweepAngle = 180f,
                    useCenter = true,
                    topLeft = Offset(width * 0.15f, height * 0.25f),
                    size = Size(width * 0.7f, height * 0.7f)
                )

                // Antennas
                drawLine(
                    color = tint,
                    start = Offset(width * 0.3f, height * 0.3f),
                    end = Offset(width * 0.18f, height * 0.12f),
                    strokeWidth = 1.5.dp.toPx(),
                    cap = StrokeCap.Round
                )
                drawLine(
                    color = tint,
                    start = Offset(width * 0.7f, height * 0.3f),
                    end = Offset(width * 0.82f, height * 0.12f),
                    strokeWidth = 1.5.dp.toPx(),
                    cap = StrokeCap.Round
                )

                // Eyes (on the white background square, head is green, so eyes are white)
                drawCircle(
                    color = Color.White,
                    radius = 1.dp.toPx(),
                    center = Offset(width * 0.38f, height * 0.45f)
                )
                drawCircle(
                    color = Color.White,
                    radius = 1.dp.toPx(),
                    center = Offset(width * 0.62f, height * 0.45f)
                )
            }
            "compose" -> {
                // Compose Logo - stylized concentric shapes
                drawArc(
                    color = tint,
                    startAngle = 45f,
                    sweepAngle = 270f,
                    useCenter = false,
                    topLeft = Offset(width * 0.1f, height * 0.1f),
                    size = Size(width * 0.8f, height * 0.8f),
                    style = Stroke(width = 2.5.dp.toPx(), cap = StrokeCap.Round)
                )
                drawArc(
                    color = tint.copy(alpha = 0.7f),
                    startAngle = 45f,
                    sweepAngle = 270f,
                    useCenter = false,
                    topLeft = Offset(width * 0.25f, height * 0.25f),
                    size = Size(width * 0.5f, height * 0.5f),
                    style = Stroke(width = 2.dp.toPx(), cap = StrokeCap.Round)
                )
                drawCircle(
                    color = tint,
                    radius = 2.dp.toPx(),
                    center = Offset(width * 0.5f, height * 0.5f)
                )
            }
            "firebase" -> {
                // Firebase logo (flame)
                val path = Path().apply {
                    moveTo(width * 0.5f, height * 0.05f)
                    lineTo(width * 0.2f, height * 0.65f)
                    lineTo(width * 0.48f, height * 0.65f)
                    close()
                }
                drawPath(path, color = Color(0xFFFF9100))

                val path2 = Path().apply {
                    moveTo(width * 0.5f, height * 0.05f)
                    lineTo(width * 0.8f, height * 0.65f)
                    lineTo(width * 0.52f, height * 0.65f)
                    close()
                }
                drawPath(path2, color = Color(0xFFFFC400))

                val base = Path().apply {
                    moveTo(width * 0.2f, height * 0.65f)
                    lineTo(width * 0.5f, height * 0.95f)
                    lineTo(width * 0.8f, height * 0.65f)
                    close()
                }
                drawPath(base, color = Color(0xFFDD2C00))
            }
            "springboot" -> {
                // Spring Boot leaf
                val leafPath = Path().apply {
                    moveTo(width * 0.5f, height * 0.15f)
                    quadraticBezierTo(width * 0.85f, height * 0.35f, width * 0.7f, height * 0.75f)
                    quadraticBezierTo(width * 0.5f, height * 0.9f, width * 0.3f, height * 0.75f)
                    quadraticBezierTo(width * 0.15f, height * 0.35f, width * 0.5f, height * 0.15f)
                    close()
                }
                drawPath(leafPath, color = tint)

                drawLine(
                    color = Color.White,
                    start = Offset(width * 0.5f, height * 0.85f),
                    end = Offset(width * 0.5f, height * 0.25f),
                    strokeWidth = 1.dp.toPx()
                )
            }
            "git" -> {
                // Git logo: rotated square (diamond) with branching lines
                val diamond = Path().apply {
                    moveTo(width * 0.5f, height * 0.1f)
                    lineTo(width * 0.9f, height * 0.5f)
                    lineTo(width * 0.5f, height * 0.9f)
                    lineTo(width * 0.1f, height * 0.5f)
                    close()
                }
                drawPath(diamond, color = Color(0xFFF05032))

                drawLine(
                    color = Color.White,
                    start = Offset(width * 0.5f, height * 0.3f),
                    end = Offset(width * 0.5f, height * 0.7f),
                    strokeWidth = 1.5.dp.toPx()
                )

                val branch = Path().apply {
                    moveTo(width * 0.5f, height * 0.5f)
                    quadraticBezierTo(width * 0.65f, height * 0.45f, width * 0.68f, height * 0.35f)
                }
                drawPath(
                    branch,
                    color = Color.White,
                    style = Stroke(width = 1.5.dp.toPx(), cap = StrokeCap.Round)
                )

                drawCircle(color = Color.White, radius = 2.dp.toPx(), center = Offset(width * 0.5f, height * 0.3f))
                drawCircle(color = Color.White, radius = 2.dp.toPx(), center = Offset(width * 0.5f, height * 0.7f))
                drawCircle(color = Color.White, radius = 2.dp.toPx(), center = Offset(width * 0.68f, height * 0.35f))
            }
            "gitlab" -> {
                // Gitlab fox head made of triangles
                val center = Path().apply {
                    moveTo(width * 0.5f, height * 0.85f)
                    lineTo(width * 0.25f, height * 0.45f)
                    lineTo(width * 0.75f, height * 0.45f)
                    close()
                }
                drawPath(center, color = Color(0xFFE24329))

                val leftEar = Path().apply {
                    moveTo(width * 0.25f, height * 0.45f)
                    lineTo(width * 0.1f, height * 0.2f)
                    lineTo(width * 0.35f, height * 0.35f)
                    close()
                }
                drawPath(leftEar, color = Color(0xFFFC6D26))

                val rightEar = Path().apply {
                    moveTo(width * 0.75f, height * 0.45f)
                    lineTo(width * 0.9f, height * 0.2f)
                    lineTo(width * 0.65f, height * 0.35f)
                    close()
                }
                drawPath(rightEar, color = Color(0xFFFC6D26))

                val leftFace = Path().apply {
                    moveTo(width * 0.25f, height * 0.45f)
                    lineTo(width * 0.35f, height * 0.35f)
                    lineTo(width * 0.5f, height * 0.85f)
                    close()
                }
                drawPath(leftFace, color = Color(0xFFFCA121))

                val rightFace = Path().apply {
                    moveTo(width * 0.75f, height * 0.45f)
                    lineTo(width * 0.65f, height * 0.35f)
                    lineTo(width * 0.5f, height * 0.85f)
                    close()
                }
                drawPath(rightFace, color = Color(0xFFFCA121))
            }
        }
    }
}
