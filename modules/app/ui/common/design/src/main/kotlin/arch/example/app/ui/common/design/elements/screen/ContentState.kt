package arch.example.app.ui.common.design.elements.screen

import io.github.neomsoft.flow.result.FlowResult

enum class ContentState {
    Loading,
    LoadingError,
    Loaded;

    companion object {

        fun from(
            resultState: FlowResult<*>,
            vararg resultStates: FlowResult<*>,
        ): ContentState {
            val allResultStates = resultStates.toList() + resultState

            if (allResultStates.any { it is FlowResult.Error }) {
                return LoadingError
            }

            if (allResultStates.any { it is FlowResult.Loading }) {
                return Loading
            }

            return Loaded
        }

    }
}
