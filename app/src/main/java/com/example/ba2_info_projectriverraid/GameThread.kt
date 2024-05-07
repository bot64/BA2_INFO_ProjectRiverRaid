import android.view.SurfaceHolder
import androidx.media3.player.Player
import android.content.Context
import com.example.ba2_info_projectriverraid.entities.Block
import com.example.ba2_info_projectriverraid.entities.Entities
import com.example.ba2_info_projectriverraid.entities.FuelTank
import com.example.ba2_info_projectriverraid.entities.enemies.ship.Ship
import kotlin.random.Random

class GameThread(private val surfaceHolder: SurfaceHolder, private val gameView: GameView) : Thread() {
    // Switching the creation of Entities to the GameThread class through a generic createEntities() method

    // Game state variables
    var running = false
    private val context: Context = gameView.context
    //private val enemies = mutableListOf<Enemy>()

    override fun run() {
        while (running) {
                // Update the game state
                //player.update()
                //enemies.forEach { it.update() }

                // Draw the game objects
                val canvas = surfaceHolder.lockCanvas()
                if (canvas != null) {
                    gameView.draw(canvas)
                    surfaceHolder.unlockCanvasAndPost(canvas)
                }
            }
        }
    sealed class EntityType{
        // Defining the three known kinds for now
        object Enemy : EntityType()
        object Block : EntityType()
        object FuelTank : EntityType()
    }
    private fun createEntities
            // Creating (numEntities) Entities after their 'type' parameter
                (numEntities: Int, entities: MutableList<Entities>,
                 screenWidth: Int, screenHeight: Int, type: EntityType){
                    repeat (numEntities){
                        val newEntity = when (type){
                        EntityType.Enemy -> Ship(context, Random.nextFloat() * screenWidth, Random.nextFloat() * screenHeight, Pair(20f, 20f), 1f)
                        EntityType.Block -> Block(context, Random.nextFloat() * screenWidth, Random.nextFloat() * screenHeight)
                        EntityType.FuelTank -> FuelTank(context, Random.nextFloat()*screenWidth, Random.nextFloat() * screenHeight, Pair(20f,20f))
                            else -> throw IllegalArgumentException("Invalid Entity Type")
                    }
                        entities.add(newEntity)
        }
    }
}

