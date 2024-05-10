package com.example.ba2_info_projectriverraid.entities
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.ba2_info_projectriverraid.GameView

class Block(
    blockX: Float,
    blockY: Float,
    blockSize: Pair<Float, Float> = Pair(80f, 80f),
    health: Float = 999999f,
    onScreen: Boolean = true,
    val view: GameView,
    val scrollSpeed : Float = 200f,
    val blockPaint: Paint = Paint()
) : Entities(blockX, blockY, blockSize, onScreen, health, collisionOrdinal = 3) {

    init {
        blockPaint.color = Color.YELLOW
    }
    fun draw (canvas : Canvas){
        canvas.drawRect(
            entitiesX - entitiesSize.first,
            entitiesY - entitiesSize.second,
            entitiesX + entitiesSize.first,
            entitiesY + entitiesSize.second,
            blockPaint
        )
    }
    override fun delete() {
        view.blocks.remove(this)
    }
    fun update(interval : Double){
        var scroll = (interval * scrollSpeed).toFloat()
        entitiesY += scroll
    }
    override fun damage(entities1: Entities, entities2: Entities){

    }
    override fun bounce(entities1: Entities, entities2: Entities){

    }
    override fun refuel(entities1: Entities, entities2: Entities){

    }
}