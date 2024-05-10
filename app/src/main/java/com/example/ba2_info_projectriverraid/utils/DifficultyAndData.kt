package com.example.ba2_info_projectriverraid.utils

import android.opengl.Matrix
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
    val playerStartingHealth: Float = 5.0f,
    val fuelDepleteRate: Float = 1.0f,
    val fuelOnstart: Float = 100.0f,
    val playerHome: Pair<Float, Float> = Pair(0f, 0f),
    val defaultSize: Pair<Float, Float> = Pair(20f, 20f),
    val collisionMatrix : Array<IntArray> = arrayOf(
        intArrayOf(0, 1, 1, 3, 0, 0, 0),
        intArrayOf(0, 2, 2, 0, 1, 2, 4),
        intArrayOf(0, 0, 0, 4, 1, 0, 4),
        intArrayOf(0, 0, 0, 0, 1, 0, 4),
        intArrayOf(0, 0, 0, 0, 0, 0, 4),
        intArrayOf(0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0)
    )
)

    {
    EASY(
        mapBoundaries = listOf(Boundary(0.0, 0.0, 100.0, 100.0)),
        enemySpeed = .75f,
        enemyGenerationRate = 75L,
        playerStartingHealth = 10f,
        fuelDepleteRate = 0.75f
    ),
    MEDIUM(
        mapBoundaries = listOf(
            Boundary(0.0, 0.0, 200.0, 200.0),
            Boundary(50.0, 50.0, 150.0, 150.0)
        ),
        enemySpeed = 3.0f,
        enemyGenerationRate = 150L
    ),
    HARD(
        mapBoundaries = listOf(
            Boundary(0.0, 0.0, 300.0, 300.0),
            Boundary(100.0, 100.0, 200.0, 200.0),
            Boundary(150.0, 150.0, 250.0, 250.0)
        ),
        enemySpeed = 4.0f,
        enemyGenerationRate = 200L
    ),
}