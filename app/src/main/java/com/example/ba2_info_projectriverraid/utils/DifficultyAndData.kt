package com.example.ba2_info_projectriverraid.utils


// Difficulty enum class teub
enum class DifficultyAndData(
    val mapBoundaries: Array<Float> = arrayOf<Float>(0f, 1f,0f,1f),
    val enemySpeed: Float = 1.0f,
    val enemyGenerationRate: Long,
    val playerSpeed: Float = 1.0f,
    val playerStartingHealth: Float = 5.0f,
    val fuelDepleteRate: Float = 1.0f,
    val fuelOnstart: Float = 100.0f,
    val playerHome: Pair<Float, Float> = Pair(0f, 0f),
    val defaultSize: Pair<Float, Float> = Pair(20f, 20f),
    val collisionMatrix : Array<IntArray> = arrayOf(
        intArrayOf(0, 1, 1, 3, 0),
        intArrayOf(0, 2, 2, 0, 1),
        intArrayOf(0, 0, 0, 4, 1),
        intArrayOf(0, 0, 0, 0, 1),
        intArrayOf(0, 0, 0, 0, 0)
    )
)

    {
    EASY(
        enemySpeed = .75f,
        enemyGenerationRate = 75L,
        playerStartingHealth = 10f,
        fuelDepleteRate = 0.75f
    ),
    MEDIUM(


        enemySpeed = 3.0f,
        enemyGenerationRate = 150L
    ),
    HARD(

        enemySpeed = 4.0f,
        enemyGenerationRate = 200L
    ),
}