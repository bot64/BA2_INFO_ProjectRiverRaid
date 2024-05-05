package com.example.ba2_info_projectriverraid.map

class Map(
    val map_id: Long = 1,
    val set_boundaries: List<Boundary>
) {

    fun build_map() {
        // Logic to build the map based on the map ID and boundaries

    }

}

data class Boundary(
    val x1: Double = 0.0,
    val y1: Double = 0.0,
    val x2: Double = 100.0,
    val y2: Double = 100.0
)