package com.example.ba2_info_projectriverraid.utils

import com.example.ba2_info_projectriverraid.map.Boundary
data class Map(
    val mapId: Long,
    val boundaries: List<Boundary>
)
// Difficulty enum class
enum class DifficultyAndData(
    val mapBoundaries: List<Boundary>,
    val enemySpeed: Float = 1.0f,
    val enemyGenerationRate: Long,
    val playerSpeed: Float = 1.0f,
    val playerStartingHealth: Int = 5,
    val fuelDepleteRate: Float = 1.0f,
    val fuelOnstart: Float = 100.0f,
    val playerHome: Pair<Float, Float> = Pair(0.0f, 0.0f))
    {
    EASY(
        mapBoundaries = listOf(Boundary(0.0, 0.0, 100.0, 100.0)),
        enemySpeed = .75,
        enemyGenerationRate = 75L,
        playerStartingHealth = 10,
        fuelDepleteRate = 0.75
    ),
    MEDIUM(
        mapBoundaries = listOf(
            Boundary(0.0, 0.0, 200.0, 200.0),
            Boundary(50.0, 50.0, 150.0, 150.0)
        ),
        enemySpeed = 3.0,
        enemyGenerationRate = 150L
    ),
    HARD(
        mapBoundaries = listOf(
            Boundary(0.0, 0.0, 300.0, 300.0),
            Boundary(100.0, 100.0, 200.0, 200.0),
            Boundary(150.0, 150.0, 250.0, 250.0)
        ),
        enemySpeed = 4.0,
        enemyGenerationRate = 200L
    ),
}