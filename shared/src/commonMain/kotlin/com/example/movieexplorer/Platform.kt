package com.example.movieexplorer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform