package extensions

import androidx.room.gradle.RoomExtension
import com.android.build.api.dsl.CommonExtension
import com.google.devtools.ksp.gradle.KspExtension
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

internal val Project.extensionContainer: ExtensionContainer
    get() = (this as ExtensionAware).extensions

private fun <T> ExtensionContainer.configure(
    name: String,
    action: T.() -> Unit,
) = configure(name, Action<T> { action() })

internal fun ExtensionContainer.configureAndroid(
    action: CommonExtension<*, *, *, *, *, *>.() -> Unit,
) = configure(name = "android", action = action)

internal fun Project.kotlinJvmCompilerOptions(block: KotlinJvmCompilerOptions.() -> Unit) {
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions(block)
    }
}

internal fun ExtensionContainer.configureKsp(
    action: KspExtension.() -> Unit,
) = configure(name = "ksp", action = action)

internal fun ExtensionContainer.configureRoom(
    action: RoomExtension.() -> Unit,
) = configure(name = "room", action = action)

internal fun DependencyHandler.implementation(dependencyNotation: Any) =
    add("implementation", dependencyNotation)

internal fun DependencyHandler.debugImplementation(dependencyNotation: Any) =
    add("debugImplementation", dependencyNotation)

internal fun DependencyHandler.androidTestImplementation(dependencyNotation: Any) =
    add("androidTestImplementation", dependencyNotation)

internal fun DependencyHandler.ksp(dependencyNotation: Any) =
    add("ksp", dependencyNotation)