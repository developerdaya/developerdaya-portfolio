package com.developerdaya.portfolio.portfolio

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform