package com.developerdaya.portfolio.data

// ============================================================
// Data Models
// ============================================================
data class Experience(
    val company: String,
    val location: String,
    val role: String,
    val period: String,
    val highlights: List<String>,
    val isCurrent: Boolean = false
)

data class Project(
    val title: String,
    val description: String,
    val bullets: List<String>,
    val techStack: List<String>,
    val playStoreUrl: String? = null,
    val downloads: String? = null,
    val screenshotResName: String? = null,
    val iconResName: String? = null
)

data class Education(
    val institution: String,
    val degree: String,
    val period: String,
    val location: String
)

data class Certification(
    val title: String,
    val issuer: String,
    val credentialUrl: String? = null
)

// ============================================================
// Resume Content
// ============================================================
object PortfolioData {

    val name = "Dayanand Khatik"
    val role = "A Passionate Android Engineer"
    val location = "India"
    val phone = "+91 9219187843"
    val whatsappNumber = "+91 9219187843"
    val whatsappMessage = "Hello, I'd like to discuss your portfolio!"
    val email = "erdayanandkhatik@gmail.com"
    val linkedIn = "Dayanand Khatik"
    val linkedInUrl = "https://www.linkedin.com/in/dayanand-khatik"
    val github = "Dayanand Khatik"
    val githubUrl = ""
    val portfolio = "Portfolio"
    val yearsOfExperience = "5+"

    val aboutSummary = "Android developer passionate about building delightful mobile experiences."
    val heroTagline = "Building delightful Android experiences with modern tech"
    val aboutStats = listOf(
        Pair("5+", "Years Experience")
    )

    val skills = emptyList<String>()

    val skillCategories = listOf(
        Pair("Languages", listOf("Kotlin")),
        Pair("Android", listOf("Compose", "MVVM", "Clean Architecture", "Hilt", "Coroutines")),
        Pair("Libraries & Tools", listOf("Retrofit", "Room", "Firebase", "ExoPlayer")),
        Pair("Backend & DevOps", listOf("Springboot", "Git"))
    )

    val experiences = listOf(
        Experience(
            company = "Infobay.ai (EduGorilla)",
            location = "Lucknow, Uttar Pradesh, India",
            role = "Android Developer",
            period = "October 2024 - January 2026",
            isCurrent = true,
            highlights = listOf(
                "Built and maintained white-label Android applications for 5,000+ clients with EduGorilla.",
                "Owned Android delivery as Android Manager, handling client feedback, architecture decisions, and multi-device testing."
            )
        ),
        Experience(
            company = "Fluper Limited",
            location = "Noida, Uttar Pradesh, India",
            role = "Android Developer",
            period = "March 2021 - August 2024",
            highlights = listOf(
                "Gained experience across multiple domains, including Food Delivery, Ride Booking, and E commerce projects.",
                "Led delivery of 20+ Android apps published on Google Play Store."
            )
        )
    )

    val projects = listOf(
        Project(
            title = "Live Echo Mic",
            description = "Live singing app with real-time echo and reverb control.",
            bullets = listOf(
                "Built Live Echo Voice Effect, a real-time echo machine for live singing.",
                "Enabled live singing with real-time echo & reverb control for smooth audio experience."
            ),
            techStack = listOf("Google Oboe", "Native C++", "Background services", "In-App Purchases", "Razorpay"),
            playStoreUrl = "https://play.google.com/store/apps/details?id=com.developerdaya.liveechoapp",
            downloads = "100K+",
            screenshotResName = "live_echo",
            iconResName = "live_echo_icon"
        ),
        Project(
            title = "Manthan Radio",
            description = "Story sharing app with User, Admin, and Backend panels.",
            bullets = listOf(
                "Developed User & Admin panels along with backend APIs using Kotlin Spring Boot.",
                "Users can listen to stories and share their stories or knowledge with the world."
            ),
            techStack = listOf("MVVM", "REST APIs", "MotionLayout", "Background Services", "Google Login", "Lottie"),
            screenshotResName = "manthan_radio",
            iconResName = "manthan_radio_logo",
            playStoreUrl = "https://play.google.com/store/apps/details?id=com.developerdaya.manthan.radio",
            downloads = "100+"
        ),
        Project(
            title = "Deep Talk",
            description = "Random voice calling app to connect like-minded people worldwide.",
            bullets = listOf(
                "Created a random voice calling app to connect like-minded people worldwide.",
                "Users can connect based on selected topics to exchange knowledge in real time."
            ),
            techStack = listOf("Agora Voice SDK", "Firebase Realtime db", "Background Microphone Services"),
            screenshotResName = "buddy_talk",
            iconResName = "buddy_talk_logo",
            playStoreUrl = "https://play.google.com/store/apps/details?id=com.developerdaya.deeptalk",
            downloads = "1000+"
        ),
        Project(
            title = "Koyal FM",
            description = "Story listing audio app similar to Kuku FM with background playback.",
            bullets = listOf(
                "Created a story listing audio app similar to Kuku FM with background story playback.",
                "Users can listen stories category-wise & continue listening even when device is locked."
            ),
            techStack = listOf("MotionLayout", "Background Music Service", "MediaStyle Notification", "Lottie"),
            screenshotResName = "koyal_fm",
            iconResName = "koyal_fm_logo",
            playStoreUrl = "https://play.google.com/store/apps/details?id=com.koyalfm.koyalfmapp",
            downloads = "100+"
        ),
        Project(
            title = "Goochil User",
            description = "Comprehensive taxi booking app with effortless navigation.",
            bullets = listOf(
                "Led the development of Goochil User, a comprehensive taxi booking app.",
                "The app features a user-friendly interface that ensures effortless navigation."
            ),
            techStack = listOf("MVVM", "Live Tracking", "Google Map", "Firebase Realtime Database"),
            screenshotResName = "goochil",
            iconResName = "goochil_logo",
            playStoreUrl = "https://play.google.com/store/apps/details?id=com.fluper.multitaxibooking",
            downloads = "100+"
        ),
        Project(
            title = "EduGorilla",
            description = "Exam Prep App with mock tests, PDF learning, and live classes.",
            bullets = listOf(
                "Worked on EduGorilla white-label apps for mock tests, PDF learning, and live classes.",
                "Delivered crash fixes, performance improvements, and client-driven features."
            ),
            techStack = listOf("REST APIs", "Firebase Notifications", "Zoom SDK"),
            screenshotResName = "edugorilla",
            iconResName = "edugorilla_logo",
            playStoreUrl = "https://play.google.com/store/apps/details?id=com.app.testseries.edugorilla",
            downloads = "100K+"
        )
    )

    val education = listOf(
        Education(
            institution = "Sherwood College of Engineering",
            degree = "B.Tech",
            period = "",
            location = "Computer Science - 2020"
        )
    )

    val certifications = emptyList<Certification>()
}
