package arch.exampleapp.data.api.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ErrorJson(
    @SerialName("message")
    val message: String,

    @SerialName("code")
    val code: Int,
)