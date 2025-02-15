package arch.exampleapp.data.api.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class FactJson(
    @SerialName("length")
    val length: Int,

    @SerialName("fact")
    val fact: String,
)