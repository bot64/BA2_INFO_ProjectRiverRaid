import kotlinx.coroutines.*
import android.view.SurfaceHolder
import com.example.ba2_info_projectriverraid.entities.Block
import com.example.ba2_info_projectriverraid.entities.Entities
import com.example.ba2_info_projectriverraid.entities.FuelTank
import com.example.ba2_info_projectriverraid.entities.enemies.Ship
import com.example.ba2_info_projectriverraid.GameView
import com.example.ba2_info_projectriverraid.entities.Missile
import com.example.ba2_info_projectriverraid.entities.Player

class GameThread(private val surfaceHolder: SurfaceHolder, private val gameView: GameView) : Runnable {

    // Game state variables
    var running = false
    val entities = mutableListOf<Entities>()
    val missiles = mutableListOf<Missile>()
    var shootPressed = false
    var lastMissileShotTime: Long = 0.toLong()
    var moveLeftPressed = false
    var moveRightPressed = false
    val player = Player(
        entitiesX = 0f, entitiesY = 0f,
        view = gameView,
        moveRightPressed = moveRightPressed,
        moveLeftPressed = moveLeftPressed,
        shootPressed = shootPressed
    )
    private val coroutineScope = CoroutineScope(Dispatchers.Default)
    //private val enemies = mutableListOf<Enemy>()
    override fun run() {startGame()}
    fun updatePositions(elapsedTimeMS: Double) {
        //Managing the user's actions and clock time for the user, missiles and other entities
        val interval = elapsedTimeMS / 1000.0
        if (System.currentTimeMillis() - lastMissileShotTime >= 200 && shootPressed) {
            synchronized(missiles) {missiles.add(Missile(player.entitiesX, player.entitiesY, view=gameView))}
            lastMissileShotTime = System.currentTimeMillis()
        }
        synchronized(missiles) { for (missile in missiles) {missile.update()}}
        synchronized(entities) {
            for (entity in entities) {
                when (entity) {
                    is Ship -> entity.update(interval)
                    is Block -> entity.update(interval)
                    is FuelTank -> entity.update(interval)
                }
            }
        }
        synchronized(player) {player.move(moveLeftPressed, moveRightPressed)}
    }
    fun updateGame(elapsedTimeMS: Double){
        val interval = elapsedTimeMS/1000f
        updatePositions(interval)
    }
    fun drawGame(){ //Drawing the game objects on a Main coroutine
        coroutineScope.launch(Dispatchers.Main){
            val canvas = surfaceHolder.lockCanvas()
            if (canvas != null) {
                gameView.draw(canvas)
                surfaceHolder.unlockCanvasAndPost(canvas)
            }
        }
    }
    fun startGame() {
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
            }
        } catch(e : Exception) {e.printStackTrace()} //Basic error handling logic
    }
    fun stopGame() {
        running = false
        coroutineScope.cancel()
    }
}