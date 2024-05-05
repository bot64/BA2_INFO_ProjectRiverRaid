package com.example.ba2_info_projectriverraid.map

class Map(
    val map_id: Long,
    val set_boundaries: List<Boundary>
) {

    fun build_map() {
        // Logic to build the map based on the map ID and boundaries
    }

}

data class Boundary(
    val x1: Double,
    val y1: Double,
    val x2: Double,
    val y2: Double
)