package com.example.ba2_info_projectriverraid
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.ba2_info_projectriverraid.entities.Player

class GameView @JvmOverloads constructor (context: Context, attrs: AttributeSet) : SurfaceView(context, attrs) , SurfaceHolder.Callback {

    private val player = Player(context)

    val runnable = object : Runnable {
        override fun run() {
            while (running) {
                val canvas = holder.lockCanvas()
                canvas.drawColor(Color.WHITE) // Set the background color to white
                player.bitmap?.let { canvas.drawBitmap(it, player.entitiesX, player.entitiesY, null) }
                holder.unlockCanvasAndPost(canvas)
            }
        }
    }

    private var thread: Thread? = null
    private var running = false


    init {
        holder.addCallback(this)
        player.entitiesX = width / 2f // Set the player's initial x position
        player.entitiesY = height / 2f // Set the player's initial y position
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        running = true
        thread = Thread(runnable)
        thread?.start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        var screenWidth = width
        var screenHeight = height

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        running = false
        thread?.join()
    }
}
