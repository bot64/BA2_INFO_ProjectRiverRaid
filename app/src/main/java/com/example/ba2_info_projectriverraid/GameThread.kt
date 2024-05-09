import android.view.SurfaceHolder
import com.example.ba2_info_projectriverraid.GameView



class GameThread(private val surfaceHolder: SurfaceHolder, private val gameView: GameView) : Thread() {

    // Game state variables
    var running = false
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
}