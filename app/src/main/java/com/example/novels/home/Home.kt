package com.example.novels.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.Window
import android.view.WindowManager
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.compose.ui.SearchTopBar
import com.example.novels.MainDestination

import com.example.novels.R
import com.example.novels.Screen
import com.example.novels.navigation.homeGraph
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Home(
    context:Context,
    window: Window
) {
    val navController = rememberAnimatedNavController()
    val bottomTabs = listOf(Screen.Home, Screen.BookShelf, Screen.Profile)
    val discoverRoute =  Screen.Explore.route + "?status={status}&category={category}&ordering={ordering}"
    val bottomTabsRoutes = bottomTabs.map { it.route}.plus(discoverRoute)
    val showBottomBar : Boolean = navController
          .currentBackStackEntryAsState().value?.destination?.route in bottomTabsRoutes
    // Launch an effect to track changes to the current back stack entry, and push them
    // as a screen views to analytics
  //  LaunchedEffect(navController) {
    //    navController.currentBackStackEntryFlow.collect { entry ->
   //     }
 //   }
    val state = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = state,
        drawerShape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp),
     drawerContent = {
         Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.background)
         ) {

         Button(onClick = {
             coroutineScope.launch {
             state.drawerState.close()
                 //delay(50)
             }
             navController.navigate(MainDestination.RECOMMENDED_SCREEN)
         }) {

         }
         }
     },
        bottomBar = {
                val currentSelectedItem by navController.currentScreenAsState()
            if (showBottomBar){

                HomeBottomNavigation(
                    selectedNavigation = currentSelectedItem,
                    onNavigationSelected = { selected ->
                       navController.navigate(selected.route) {
                            launchSingleTop = true
                            restoreState = true
//                            popUpTo(findStartDestination(navController.graph).id) {
//                                saveState = true
//                            }
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) {
        AnimatedNavHost(
            navController = navController,
            startDestination = MainDestination.HOME_ROUTE,
      //      modifier = Modifier.padding(innerPaddingModifier),
   //         enterTransition = { defaultTiviEnterTransition(initialState, targetState) },
   //         exitTransition = { defaultTiviExitTransition(initialState, targetState) },
  //          popEnterTransition = { defaultTiviPopEnterTransition() },
   //         popExitTransition = { defaultTiviPopExitTransition() },
        ) {
            homeGraph(navController=navController,
                context = context,
                state = state,
                modifier = Modifier.padding(it),
                window = window
            )
        }
    }
}


//private fun NavController.shouldUseBottomNavigation(){
  //  val shouldBottomNav = remember { mutableStateOf( false) }

 //   val bottomTabs = listOf(Screen.Home, Screen.BookShelf, Screen.Explore, Screen.Profile)
 //   val bottomTabsRoutes = bottomTabs.map { it.route }
//    val shouldShowNavBottom : Boolean
//    @Composable get() =
//        currentBackStackEntryAsState().value?.destination?.route in bottomBarRoutes
 //   return shouldBottomNav
//}

@Stable
@Composable
private fun NavController.currentScreenAsState(): State<Screen> {
    val selectedItem = remember { mutableStateOf<Screen>(Screen.Home) }

    DisposableEffect(this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            when {
                destination.hierarchy.any { it.route == Screen.Home.route } -> {
                    selectedItem.value = Screen.Home
                }
                destination.hierarchy.any { it.route == Screen.BookShelf.route } -> {
                    selectedItem.value = Screen.BookShelf
                }
                destination.hierarchy.any { it.route == Screen.Explore.route } -> {
                    selectedItem.value = Screen.Explore
                }
                destination.hierarchy.any { it.route == Screen.Profile.route } -> {
                    selectedItem.value = Screen.Profile
                }
            }
        }
        addOnDestinationChangedListener(listener)

        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }

    return selectedItem
}




@Composable
internal fun HomeBottomNavigation(
    selectedNavigation: Screen,
    onNavigationSelected: (Screen) -> Unit,
    modifier: Modifier = Modifier,
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = contentColorFor(MaterialTheme.colors.surface),
//        modifier = modifier.zIndex(-1f)
        modifier = modifier.zIndex(-1f)

    ) {
        HomeNavigationItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    HomeNavigationItemIcon(
                        item = item,
                        selected = selectedNavigation == item.screen
                    )
                },
                label = { Text(text = stringResource(item.labelResId)) },
                selected = selectedNavigation == item.screen,
                onClick = { onNavigationSelected(item.screen) },
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
internal fun HomeNavigationRail(
    selectedNavigation: Screen,
    onNavigationSelected: (Screen) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        color = MaterialTheme.colors.surface,
        elevation = 20.dp,
        modifier = modifier,
    ) {
       BottomNavigation() {
            HomeNavigationItems.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        HomeNavigationItemIcon(
                            item = item,
                            selected = selectedNavigation == item.screen
                        )
                    },
                    alwaysShowLabel = false,
                    label = { Text(text = stringResource(item.labelResId)) },
                    selected = selectedNavigation == item.screen,
                    onClick = { onNavigationSelected(item.screen) },
                )
       }
        }
    }
}



@Composable
private fun HomeNavigationItemIcon(item: HomeNavigationItem, selected: Boolean) {
    val painter = when (item) {
        is HomeNavigationItem.ResourceIcon -> painterResource(item.iconResId)
        is HomeNavigationItem.ImageVectorIcon -> rememberVectorPainter(item.iconImageVector)
    }
    val selectedPainter = when (item) {
        is HomeNavigationItem.ResourceIcon -> item.selectedIconResId?.let { painterResource(it) }
        is HomeNavigationItem.ImageVectorIcon -> item.selectedImageVector?.let { rememberVectorPainter(it) }
    }

    if (selectedPainter != null) {
        Crossfade(targetState = selected) {
            Icon(
                painter = if (it) selectedPainter else painter,
                contentDescription = stringResource(item.contentDescriptionResId),
            )
        }
    } else {
        Icon(
            painter = painter,
            contentDescription = stringResource(item.contentDescriptionResId),
        )
    }
}

private sealed class HomeNavigationItem(
    val screen: Screen,
    @StringRes val labelResId: Int,
    @StringRes val contentDescriptionResId: Int,
) {
    class ResourceIcon(
        screen: Screen,
        @StringRes labelResId: Int,
        @StringRes contentDescriptionResId: Int,
        @DrawableRes val iconResId: Int,
        @DrawableRes val selectedIconResId: Int? = null,
    ) : HomeNavigationItem(screen, labelResId, contentDescriptionResId)

    class ImageVectorIcon(
        screen: Screen,
        @StringRes labelResId: Int,
        @StringRes contentDescriptionResId: Int,
        val iconImageVector: ImageVector,
        val selectedImageVector: ImageVector? = null,
    ) : HomeNavigationItem(screen, labelResId, contentDescriptionResId)
}

private val HomeNavigationItems = listOf(
    HomeNavigationItem.ImageVectorIcon(
        screen = Screen.Home,
        labelResId = R.string.home,
        contentDescriptionResId = R.string.home,
        iconImageVector = Icons.Outlined.Weekend,
        selectedImageVector = Icons.Default.Weekend,
    ),
    HomeNavigationItem.ImageVectorIcon(
        screen = Screen.BookShelf,
        labelResId = R.string.bookshlef,
        contentDescriptionResId = R.string.bookshlef,
        iconImageVector = Icons.Outlined.Bookmarks,
        selectedImageVector = Icons.Default.Bookmarks,
    ),
    HomeNavigationItem.ImageVectorIcon(
        screen = Screen.Explore,
        labelResId = R.string.discover,
        contentDescriptionResId = R.string.discover,
        iconImageVector = Icons.Outlined.Explore,
        selectedImageVector = Icons.Default.Explore,
    ),
    HomeNavigationItem.ImageVectorIcon(
        screen = Screen.Profile,
        labelResId = R.string.perfil,
        contentDescriptionResId = R.string.perfil,
        iconImageVector = Icons.Outlined.Person,
        selectedImageVector = Icons.Default.Person,

        ),
)


private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)


private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}










@ExperimentalAnimationApi
private fun AnimatedContentScope<*>.defaultTiviEnterTransition(
    initial: NavBackStackEntry,
    target: NavBackStackEntry,
): EnterTransition {
    val initialNavGraph = initial.destination.hostNavGraph
    val targetNavGraph = target.destination.hostNavGraph
    // If we're crossing nav graphs (bottom navigation graphs), we crossfade
    if (initialNavGraph.id != targetNavGraph.id) {
    return slideIntoContainer(AnimatedContentScope.SlideDirection.Start, animationSpec = tween(500))
    }
    // Otherwise we're in the same nav graph, we can imply a direction
        return fadeIn()
}

@ExperimentalAnimationApi
private fun AnimatedContentScope<*>.defaultTiviExitTransition(
    initial: NavBackStackEntry,
    target: NavBackStackEntry,
): ExitTransition {
    val initialNavGraph = initial.destination.hostNavGraph
    val targetNavGraph = target.destination.hostNavGraph
    // If we're crossing nav graphs (bottom navigation graphs), we crossfade
    if (initialNavGraph.id != targetNavGraph.id) {
    return   slideOutOfContainer(AnimatedContentScope.SlideDirection.Start, animationSpec = tween(500))
    }
    // Otherwise we're in the same nav graph, we can imply a direction
        return fadeOut()
}

private val NavDestination.hostNavGraph: NavGraph
    get() = hierarchy.first { it is NavGraph } as NavGraph

@ExperimentalAnimationApi
private fun AnimatedContentScope<*>.defaultTiviPopEnterTransition(): EnterTransition {
    return  slideIntoContainer(AnimatedContentScope.SlideDirection.End, animationSpec = tween(500))
}

@ExperimentalAnimationApi
private fun AnimatedContentScope<*>.defaultTiviPopExitTransition(): ExitTransition {
    return  slideOutOfContainer(AnimatedContentScope.SlideDirection.End, animationSpec = tween(500))
}