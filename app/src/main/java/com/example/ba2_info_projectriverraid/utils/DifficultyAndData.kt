package com.example.ba2_info_projectriverraid.utils

import com.example.ba2_info_projectriverraid.map.Boundary
data class Map(
    val mapId: Long,
    val boundaries: List<Boundary>
)
// Difficulty enum class
enum class DifficultyAndData(
    val mapBoundaries: List<Boundary>,
    val enemySpeed: Double = 1.0,
    val enemyGenerationRate: Long,
    val playerSpeed: Double = 1.0,
    val playerStartingHealth: Int = 5,
    val fuelDepleteRate: Double = 1.0,
    val fuelOnstart: Double = 100.0,
    val playerHome: Pair<Double, Double> = Pair(screenWidth / 2.0, 0.0))
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