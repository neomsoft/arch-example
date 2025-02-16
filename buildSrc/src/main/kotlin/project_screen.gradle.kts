import toml.projects

plugins {
    id("project_platform")
    id("project_koin")
    id("project_compose")
}

dependencies {
    implementation(projects.modules.kotlin.flowResult)
    implementation(projects.modules.kotlin.coroutineScopeOwner)
    implementation(projects.modules.app.core.entity)
    implementation(projects.modules.app.data.repositories)
    implementation(projects.modules.app.ui.common.design)
    implementation(projects.modules.app.ui.common.navigation)
}