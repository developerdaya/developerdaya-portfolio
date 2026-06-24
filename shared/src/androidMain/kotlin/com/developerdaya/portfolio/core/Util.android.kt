package com.developerdaya.portfolio.core

import android.content.Intent
import android.net.Uri

actual fun openUrl(url: String) {
    // Requires context to actually launch on Android. 
    // Usually handled via LocalUriHandler in Compose.
    println("openUrl called with: $url")
}
