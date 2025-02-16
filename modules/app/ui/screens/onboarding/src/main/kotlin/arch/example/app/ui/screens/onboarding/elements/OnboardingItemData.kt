package arch.example.app.ui.screens.onboarding.elements

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import arch.example.app.ui.common.design.R

@Immutable
internal data class OnboardingItem(
    @DrawableRes val image: Int,
    @StringRes val text: Int,
) {

    companion object {
        fun getData(): List<OnboardingItem> = listOf(
            OnboardingItem(
                image = R.drawable.onboarding_image_1,
                text = R.string.onboarding_title_1,
            ),
            OnboardingItem(
                image = R.drawable.onboarding_image_2,
                text = R.string.onboarding_title_2,
            ),
            OnboardingItem(
                image = R.drawable.onboarding_image_3,
                text = R.string.onboarding_title_3,
            )
        )
    }
}