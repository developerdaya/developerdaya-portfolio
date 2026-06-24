package com.developerdaya.portfolio.ui

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.developerdaya.portfolio.ui.sections.AboutSection


import com.developerdaya.portfolio.ui.sections.EducationSection
import com.developerdaya.portfolio.ui.sections.ExperienceSection

import com.developerdaya.portfolio.ui.sections.HeroSection
import com.developerdaya.portfolio.ui.sections.ProjectsSection
import com.developerdaya.portfolio.ui.theme.PortfolioTheme
import kotlinx.coroutines.launch

/**
 * Main Portfolio Screen — single scrollable page composing all sections.
 *
 * Sections (in order):
 *  1. HeroSection
 *  2. AboutSection
 *  3. EducationSection
 *  4. ProjectsSection
 *  5. ExperienceSection
 *  6. Bottom note
 */
@Composable
fun PortfolioScreen(
    onOpenUrl: (String) -> Unit = {}
) {
    val colors = PortfolioTheme.colors
    val listState = rememberLazyListState()

    val coroutineScope = rememberCoroutineScope()

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .background(colors.background)
    ) {
        // 1. Hero
        item {
            HeroSection(
                onContactClick = {
                    // Scroll to contact section (not present in current list, but keeps callback safe)
                },
                onViewWorkClick = {
                    coroutineScope.launch {
                        listState.animateScrollToItem(3) // Projects section (index 3: Hero=0, About=1, Education=2, Projects=3)
                    }
                }
            )
        }

        // 2. About
        item { AboutSection() }

        // 3. Education
        item { EducationSection() }

        // 4. Projects
        item { ProjectsSection(onOpenUrl = onOpenUrl) }

        // 5. Experience
        item { ExperienceSection() }
        
        // 6. Bottom note
        item {
            Text(
                text = "Built with Compose Multiple Platform",
                style = MaterialTheme.typography.bodySmall,
                color = colors.textSecondary,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }


    }
}
