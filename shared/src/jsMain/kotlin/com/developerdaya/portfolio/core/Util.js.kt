package com.developerdaya.portfolio.core

import kotlinx.browser.window

actual fun openUrl(url: String) {
    window.open(url, "_blank")
}
