package com.example.chapters.component

import android.view.Window
import android.view.WindowManager
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.settings.AppTheme
import com.example.settings.FontOption
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@Composable
fun ChapterSheetModal(
    _window:Window,
    brightStream:StateFlow<Float>,
    setBrightness:(Float)->Unit,
    setTheme:(AppTheme)->Unit,
    currentTheme:StateFlow<AppTheme>,
    autoScroll:()->Unit,
    setScrollSpeed:(Float)->Unit,
    scroll:Float,
    fontSize:Float,
    setFontSize:(Float)->Unit,
    showChapters:()->Unit,
    setFontWeight:(FontOption)->Unit,
    fontWeightValue:FontWeight
){
    val bright = brightStream.collectAsState().value
    val theme by currentTheme.collectAsState()
    val layoutParam = _window.attributes
    Column(
        modifier = Modifier
//            .height(500.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .background(MaterialTheme.colors.surface)
            .padding(top = 5.dp)
    ){
        Icon(imageVector = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(45.dp, 28.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colors.background),
            contentDescription = "chapter_modal_sheet")
        Box(modifier = Modifier
            .padding(12.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(
                MaterialTheme.colors.background.copy(
                    alpha = 0.8f
                )
            )
            .padding(10.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RowItemChapter(imageVector = Icons.Default.Menu, title = "Chapters", onClick = {
                        showChapters()
                })
                Crossfade(targetState =theme ==  AppTheme.MODE_NIGHT  ) {

                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable {
                            if(it){
                                setTheme(AppTheme.MODE_DAY)
                            }else{
                                setTheme(AppTheme.MODE_NIGHT)
                            }
                        }) {
                        Icon(imageVector = if(it) Icons.Default.WbSunny else Icons.Default.ModeNight,
                            contentDescription = "brghtness_icon",
                            modifier = Modifier
                                .size(35.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colors.surface)
                                .padding(7.dp)
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = if(it) "Light" else "Dark", style = MaterialTheme.typography.subtitle2)
                    }
                }
                RowItemChapter(imageVector = Icons.Default.Mouse, title = "AutoScroll", onClick = { autoScroll() })
                RowItemChapter(imageVector = Icons.Default.Message, title = "Vote", onClick = { })

            }
        }
        Text(text = "Brightness", style = MaterialTheme.typography.h6.copy(
            fontSize = 17.sp
        ), modifier = Modifier.padding(start = 12.dp)
        )
        Box(modifier = Modifier
            .padding(12.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(
                MaterialTheme.colors.background.copy(
                    alpha = 0.8f
                )
            )
            .padding(10.dp)
        ) {

            Slider(
                value = bright, onValueChange = {
//                    brillo.value = it
                    setBrightness(it)
//                    Settings.System.putInt(
//                        contentResolver,
//                        Settings.System.SCREEN_BRIGHTNESS,
//                        brightness
//                    )
                    layoutParam.screenBrightness = it
                    _window.attributes = layoutParam
                }, valueRange = 0f..1f,
                onValueChangeFinished = {

                }
            )
        }
        Box(modifier = Modifier
            .padding(12.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(
                MaterialTheme.colors.background.copy(
                    alpha = 0.8f
                )
            )
            .padding(10.dp)
        ){
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
            Text(text = "Use system brightness")
                Checkbox(checked = bright == WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE
                    ,onCheckedChange = {
                        if(it){
                        setBrightness(-1.0f)
                        layoutParam.screenBrightness = -1.0f
                        }else{
                            setBrightness(0.2f)
                            layoutParam.screenBrightness = bright
                        }
                        _window.attributes = layoutParam
                    })
            }
        }
        Text(text = "Scroll Speed", style = MaterialTheme.typography.h6.copy(
            fontSize = 17.sp
        ), modifier = Modifier.padding(start = 12.dp)
        )
        Box(modifier = Modifier
            .padding(12.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(
                MaterialTheme.colors.background.copy(
                    alpha = 0.8f
                )
            )
            .padding(10.dp)
        ) {
            Slider(
                value = scroll, onValueChange = {
                    setScrollSpeed(it)
                }, valueRange = 5f..70f,
            )
        }

        Text(text = "Text size", style = MaterialTheme.typography.h6.copy(
            fontSize = 17.sp
        ), modifier = Modifier.padding(start = 12.dp)
        )
        Box(modifier = Modifier
            .padding(12.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(
                MaterialTheme.colors.background.copy(
                    alpha = 0.8f
                )
            )
            .padding(10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
              Text(text = "A-", style = MaterialTheme.typography.h5)
            Slider(
                value = fontSize, onValueChange = {
                    setFontSize(it)
                }, valueRange = 10f..28f,
            )
            }
        }
        Text(text = "Text size", style = MaterialTheme.typography.h6.copy(
            fontSize = 17.sp
        ), modifier = Modifier.padding(start = 12.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        Text(text =  "Light", style = MaterialTheme.typography.h6.copy(
            fontWeight = FontWeight.Light
        ), modifier = Modifier
            .padding(8.dp).clickable { setFontWeight(FontOption.LIGHT) },
            color = if(fontWeightValue == FontWeight.Light) MaterialTheme.colors.primary else MaterialTheme.colors.onSecondary.copy(alpha = 0.7f)
        )
        Text(text = "Thim", style = MaterialTheme.typography.h6.copy(
            fontWeight = FontWeight.Thin
        ), modifier = Modifier
            .padding(8.dp).clickable { setFontWeight(FontOption.THIN) },
            color = if(fontWeightValue == FontWeight.Thin) MaterialTheme.colors.primary else MaterialTheme.colors.onSecondary.copy(alpha = 0.7f)
        )
        Text(text = "Normal", style = MaterialTheme.typography.h6.copy(
            fontWeight = FontWeight.Normal
        ), modifier = Modifier
            .padding(8.dp).clickable { setFontWeight(FontOption.NORMAL) },
            color = if(fontWeightValue == FontWeight.Normal) MaterialTheme.colors.primary else MaterialTheme.colors.onSecondary.copy(alpha = 0.7f)
        )
        Text(text = "Semi Bold", style = MaterialTheme.typography.h6.copy(
            fontWeight = FontWeight.SemiBold
        ), modifier = Modifier
            .padding(8.dp).clickable { setFontWeight(FontOption.SEMIBOLD) },
            color = if(fontWeightValue == FontWeight.SemiBold) MaterialTheme.colors.primary else MaterialTheme.colors.onSecondary.copy(alpha = 0.7f)
        )
        Text(text = "Extra Bold", style = MaterialTheme.typography.h6.copy(
            fontWeight = FontWeight.ExtraBold
        ), modifier = Modifier
            .padding(8.dp).clickable { setFontWeight(FontOption.EXTRABOLD) },
            color = if(fontWeightValue == FontWeight.ExtraBold) MaterialTheme.colors.primary else MaterialTheme.colors.onSecondary.copy(alpha = 0.7f)
        )
        }
    }
}


@Composable
fun RowItemChapter(
    imageVector: ImageVector,
    title: String,
    onClick:()->Unit
){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.clickable {
        onClick()
    }) {
        Icon(imageVector = imageVector, contentDescription = title,
            modifier = Modifier
                .size(35.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.surface)
                .padding(7.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = title, style = MaterialTheme.typography.subtitle2)
    }
}


