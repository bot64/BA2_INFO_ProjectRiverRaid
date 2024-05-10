
import android.view.SurfaceHolder

import kotlinx.coroutines.*
import android.content.Context
import com.example.ba2_info_projectriverraid.entities.Block
import com.example.ba2_info_projectriverraid.entities.Entities
import com.example.ba2_info_projectriverraid.entities.FuelTank
import com.example.ba2_info_projectriverraid.entities.enemies.Ship
import kotlin.random.Random
import com.example.ba2_info_projectriverraid.GameView
import com.example.ba2_info_projectriverraid.entities.Missile
import com.example.ba2_info_projectriverraid.entities.Player
import com.example.ba2_info_projectriverraid.entities.enemies.PerimeterObserver


class GameThread(private val surfaceHolder: SurfaceHolder, private val gameView: GameView) : Thread() {

    // Game state variables
    var running = false
    private val context: Context = gameView.context
    private val coroutineScope = CoroutineScope(Dispatchers.Default)
    //private val enemies = mutableListOf<Enemy>()

    fun startGame(){
        running = true
        try {
            coroutineScope.launch {
                var previousFrameTime = System.currentTimeMillis()
                while (running) {
                    //Update the game state and draw the game objects
                    val currentTime = System.currentTimeMillis()
                    val elapsedTimeMS = (currentTime - previousFrameTime).toDouble()
                    updateGame(elapsedTimeMS); drawGame(); previousFrameTime = currentTime
                }
                // Introduce delay() to control the game loop speed
            }
        } catch(e : Exception) {e.printStackTrace()} //Basic error handling logic
    }
    fun stopGame() {
        running = false
        coroutineScope.cancel()
    }

    sealed class EntityType {
        // Defining the three known kinds for now
        data object Enemy : EntityType()
        data object Block : EntityType()
        data object FuelTank : EntityType()
    }

    private fun createEntities(
        // Creating (numEntities) Entities after their 'type' parameter
        numEntities: Int, entities: MutableList<Entities>,
        screenWidth: Int, screenHeight: Int, type: EntityType
    ) {
        repeat(numEntities) {
            val newEntity = when (type) {
                EntityType.Enemy -> Ship( Random.nextFloat() * screenWidth, Random.nextFloat() * screenHeight, view = gameView)

                EntityType.Block -> Block( Random.nextFloat() * screenWidth, Random.nextFloat() * screenHeight, view = gameView)

                EntityType.FuelTank -> FuelTank( Random.nextFloat() * screenWidth, Random.nextFloat() * screenHeight, view = gameView)
                else -> throw IllegalArgumentException("Invalid Entity Type")
            }
            if (entities.none { Entities.isColliding(newEntity, it) }) {entities.add(newEntity)}
        }
    }
}

