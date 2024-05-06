import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.ba2_info_projectriverraid.entities.Player
import com.example.ba2_info_projectriverraid.customviews.TopView
import com.example.ba2_info_projectriverraid.customviews.BotView
import android.app.Activity

class GameView(context: Context, attrs: AttributeSet) : SurfaceView(context, attrs) , SurfaceHolder.Callback {

    private val player = Player(context)

    private val runnable = object : Runnable {
        override fun run() {
            while (running) {
                val canvas = holder.lockCanvas()
                canvas.drawColor(Color.WHITE) // Set the background color to white
                canvas.drawBitmap(player.bitmap, player.x_pos, player.y_pos, null)
                holder.unlockCanvasAndPost(canvas)
            }
        }
    }

    private var thread: Thread? = null
    private var running = false

    init {
        holder.addCallback(this)
        player.x_pos = width / 2f // Set the player's initial x position
        player.y_pos = height / 2f // Set the player's initial y position
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        running = true
        thread = Thread(runnable)
        thread?.start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        // Update game objects based on the new surface dimensions
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        running = false
        thread?.join()
    }
}