package acn.gasendo.randomjokesapplication.datasource.remotemodel

import kotlinx.serialization.Serializable
import acn.gasendo.randomjokesapplication.domain.model.JokeModel

@Serializable
data class JokeDto(
    val setup: String,
    val punchline: String,
    val id: Int,
    val type: String
)

fun JokeDto.toPost(): JokeModel {
    return JokeModel(
        setup = setup,
        punchline = punchline,
        type = type
    )
}