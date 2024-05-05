package com.example.ba2_info_projectriverraid.utils

import com.example.ba2_info_projectriverraid.map.Boundary

// Difficulty.kt
object Difficulty {

    // Difficulty 000 settings (dev playground)
    val DIFFICULTY_000_MAP_BOUNDARIES = listOf(
        Boundary(0.0, 0.0, 100.0, 100.0)
    )
    val DIFFICULTY_000_ENEMY_SPEED = 0.0
    val DIFFICULTY_000_ENEMY_GENERATION_RATE = 0L

    // Difficulty 001 settings (easy)
    val DIFFICULTY_001_MAP_BOUNDARIES = listOf(
        Boundary(0.0, 0.0, 100.0, 100.0)
    )
    val DIFFICULTY_001_ENEMY_SPEED = 2.0
    val DIFFICULTY_001_ENEMY_GENERATION_RATE = 1000L

    // Difficulty 002 settings (medium)
    val DIFFICULTY_002_MAP_BOUNDARIES = listOf(
        Boundary(0.0, 0.0, 200.0, 200.0),
        Boundary(50.0, 50.0, 150.0, 150.0)
    )
    val DIFFICULTY_002_ENEMY_SPEED = 3.0
    val DIFFICULTY_002_ENEMY_GENERATION_RATE = 750L

    // ... and so on for other difficulty levels

}