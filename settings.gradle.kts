enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }

        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Arch-example"
include(":app")

include(":modules:kotlin:storage-value")
include(":modules:kotlin:storage-value-datastore-delegate")
include(":modules:kotlin:httpclient-result-extensions")
include(":modules:kotlin:flow-result")
include(":modules:kotlin:coroutine-scope-owner")
include(":modules:kotlin:disposable-effect-with-lifecycle")
include(":modules:kotlin:cicerone")
include(":modules:kotlin:cicerone-navigation-compose")
include(":modules:kotlin:navigation-compose-destination")

include(":modules:app:core:entities")

include(":modules:app:data:preferences")
include(":modules:app:data:api")
include(":modules:app:data:database")
include(":modules:app:data:repositories")
include(":modules:app:data:repositories-impl")

include(":modules:app:ui:common:design")
include(":modules:app:ui:common:navigation")
include(":modules:app:ui:common:navigation-impl")

include(":modules:app:ui:screens:onboarding")
include(":modules:app:ui:screens:main")
include(":modules:app:ui:screens:fact")
include(":modules:app:ui:screens:fact-list")