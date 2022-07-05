package com.example.novels.navigation
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.NavDestination.Companion.hierarchy
import com.google.accompanist.navigation.animation.composable



@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.composableDetail(
    route: String,
    content: @Composable () -> Unit,
) {

    composable(
        route = route,
        enterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Left,
            animationSpec = tween(500))
        },
        popEnterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Right,
            animationSpec = tween(400))
        },
        popExitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Right,
            animationSpec = tween(400))
        },
        exitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Left,
            animationSpec = tween(500))
        }
//                enterTransition = { slideInHorizontally(initialOffsetX = { 3000 }, animationSpec = tween(500))},
//        exitTransition = { slideOutHorizontally(targetOffsetX = { 3000 }, animationSpec = tween(500))},
 //       popEnterTransition = { slideInHorizontally(initialOffsetX = { 3000 }, animationSpec = tween(500))},
 //       popExitTransition= { slideOutHorizontally(targetOffsetX = { 3000 }, animationSpec = tween(500))},
    ) {
        content()
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.composableRecommended(
    route: String,
    content: @Composable () -> Unit,
) {

    composable(
        route = route,
        enterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Up,
            animationSpec = tween(500))
        },
        popEnterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Up,
            animationSpec = tween(400))
        },
        popExitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Down,
            animationSpec = tween(400))
        },
        exitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Down,
            animationSpec = tween(500))
        }
    ) {
        content()
    }
}

