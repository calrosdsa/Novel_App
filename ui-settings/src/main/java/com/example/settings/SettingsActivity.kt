package com.example.settings

import android.annotation.SuppressLint
import  android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.compose.theme.AppThemeNovel
import com.example.settings.components.RowOption
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject
@AndroidEntryPoint
class SettingsActivity : ComponentActivity() {
    @Inject lateinit var userSettings: UserSettings

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val language = userSettings.languageStream.collectAsState()
            val currentL = Locale.getDefault()
            //val languageLocal:AppPrefs = AppPrefs(currentL.language)
            val localLanguage: String = when(language.value){
                Language.DEFAULT -> currentL.language
                Language.ENGLISH -> "en"
                Language.SPANISH -> "es"
            }
            LocaleUtils.setLocale(LocalContext.current, localLanguage)
            var visible by remember { mutableStateOf(false) }
            var visible2 by remember { mutableStateOf(false) }
            val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
            val theme = userSettings.themeStream.collectAsState()
            val useDarkColors =  when (theme.value) {
                AppTheme.MODE_AUTO -> isSystemInDarkTheme()
                AppTheme.MODE_DAY -> false
                AppTheme.MODE_NIGHT -> true
            }
            val LanguageItems = listOf(
                RadioButtonItem(
                    id = Language.SPANISH.ordinal,
                    title = stringResource(id = R.string.spanish),
                ),
                RadioButtonItem(
                    id = Language.ENGLISH.ordinal,
                    title = stringResource(id = R.string.english),
                ),
            )
            AppThemeNovel(darkTheme = useDarkColors) {
                  Scaffold(
                  topBar = {
                      Column() {
                      Row(verticalAlignment = Alignment.CenterVertically,
                      modifier = Modifier
                          .height(55.dp)
                          .fillMaxWidth()
                          .background(color = MaterialTheme.colors.background)
                          .padding(10.dp)) {
                          Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Back1212"
                          ,modifier= Modifier
                                  .size(34.dp)
                                  .clickable { onBackPressedDispatcher?.onBackPressed() })
                          Spacer(modifier = Modifier.width(24.dp))
                          Text(text = stringResource(R.string.setting),style=MaterialTheme.typography.h6)
                      }
                      Divider(modifier = Modifier.fillMaxWidth(),color = Color.LightGray,thickness = 0.5.dp)
                      }
                  }
              ) {
                  Column(
                      Modifier
                          .fillMaxWidth()
                          .padding(horizontal = 30.dp)) {
                      Spacer(modifier = Modifier.height(10.dp))
                      Text(text = stringResource(R.string.user_interface),color = MaterialTheme.colors.primary
                          ,style = MaterialTheme.typography.subtitle2)

                      RowOption(title = stringResource(id = R.string.theme),
                          subtitle = if(useDarkColors) stringResource(id = R.string.dark)
                          else if ( useDarkColors == false) stringResource(id = R.string.light)
                          else  stringResource(id = R.string.system),
                          showDialog = {bool -> visible2 = bool} )
                      RowOption(title = stringResource(id = R.string.language),
                          subtitle = if(localLanguage == "es" ) "Español" else "English",
                          showDialog = {bool -> visible = bool} )
                      
                  }
                  if (visible2) {
                  Dialog(onDismissRequest = { visible2 = false }) {
                      LandingScreen(selectedTheme = theme.value,
                          onItemSelected ={theme-> userSettings.theme = theme;visible2 = false},title = "Ui Mode" )
                  }
                  }
                      if (visible) {
                          Dialog(onDismissRequest = { visible = false }) {
                              Column(
                                  modifier = Modifier
                                      .fillMaxHeight(0.6f)
                                      .fillMaxWidth(0.9f)
                                      .clip(shape = RoundedCornerShape(20.dp))
                                      .background(color = Color.White),
                                  horizontalAlignment = Alignment.CenterHorizontally,
                              ) {
                                  Text(
                                      text = stringResource(id = R.string.language),
                                      style = MaterialTheme.typography.h6,
                                      modifier = Modifier.padding(top = 24.dp),
                                      color = Color.Black
                                  )
                                  Spacer(modifier = Modifier.height(24.dp))
                       RadioGroup(items = LanguageItems,
                           selected = language.value.ordinal,
                           onItemSelect = { id -> userSettings.language = Language.fromOrdinal(id);
                               visible=false},
                           modifier = Modifier.fillMaxWidth(.6f))
                              }
                          }
                      }
              }
            }
        }
    }
data class RadioButtonItem(
    val id: Int,
    val title: String,
)
  


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AnimatedButton() {
    val selected = remember { mutableStateOf(false) }
    val scale = animateFloatAsState(if (selected.value) 2f else 1f)

    Column(
        Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {  },
            modifier = Modifier
                .scale(scale.value)
                .height(40.dp)
                .width(200.dp)
                .pointerInteropFilter {
                    when (it.action) {
                        MotionEvent.ACTION_DOWN -> {
                            selected.value = true
                        }

                        MotionEvent.ACTION_UP -> {
                            selected.value = false
                        }
                    }
                    true
                }
        ) {
            Text(text = "Explore Airbnb", fontSize = 15.sp, color = Color.White)
        }
    }
}

@Composable
private fun RadioGroupItem(
    item: RadioButtonItem,
    selected: Boolean,
    onClick: ((Int) -> Unit)?,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .selectable(
                selected = selected,
                onClick = { onClick?.invoke(item.id) },
                role = Role.RadioButton
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = null,
            colors = RadioButtonDefaults.colors( Color(0xFF4A6572), Color(0xFF81A9B3))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = item.title,
            style = MaterialTheme.typography.body2,
            color = Color.Black
        )
    }
}

@Composable
fun RadioGroup(
    items: Iterable<RadioButtonItem>,
    selected: Int,
    onItemSelect: ((Int) -> Unit)?,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.selectableGroup()
    ) {
        items.forEach { item ->
            RadioGroupItem(
                item = item,
                selected = selected == item.id,
                onClick = { onItemSelect?.invoke(item.id) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun LandingScreen(
    selectedTheme: AppTheme ,
    onItemSelected: (AppTheme) -> Unit,
    modifier: Modifier = Modifier,
    title: String
) {
    val themeItems = listOf(
        RadioButtonItem(
            id = AppTheme.MODE_DAY.ordinal,
            title = stringResource(id = R.string.light),
        ),
        RadioButtonItem(
            id = AppTheme.MODE_NIGHT.ordinal,
            title = stringResource(id = R.string.dark),
        ),
        RadioButtonItem(
            id = AppTheme.MODE_AUTO.ordinal,
            title = stringResource(id = R.string.system),
        ),
    )

    Column(
        modifier = modifier
            .fillMaxHeight(0.6f)
            .fillMaxWidth(0.9f)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(top = 24.dp),
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(24.dp))
        RadioGroup(
            items = themeItems,
            selected = selectedTheme.ordinal,
            onItemSelect = { id -> onItemSelected(AppTheme.fromOrdinal(id)) },
            modifier = Modifier.fillMaxWidth(.6f),
        )


    }
}}