import android.content.Context
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.ba2_info_projectriverraid.entities.Player

class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback {

    private val player = Player(context)

    private val runnable = object : Runnable {
        override fun run() {
            while (running) {
                val canvas = holder.lockCanvas()
                canvas.drawBitmap(player.bitmap, player.x_pos, player.y_pos, null)
                holder.unlockCanvasAndPost(canvas)
            }
        }
    }

    private var thread: Thread? = null
    private var running = false

    init {
        holder.addCallback(this)
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