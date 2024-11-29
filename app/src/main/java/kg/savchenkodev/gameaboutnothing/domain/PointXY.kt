package kg.savchenkodev.gameaboutnothing.domain

data class PointXY(
    val x: Int,
    val y: Int
)

data class Size(
    val width: Int,
    val height: Int
)

enum class LevelState {
   Loading, Default, Started, Finished
}