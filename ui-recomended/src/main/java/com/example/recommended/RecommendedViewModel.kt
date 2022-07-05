package com.example.recommended

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.daos.FollowingDao
import com.example.data.local.entities.FollowingEntity
import com.example.data.repository.NovelRepository
import com.example.data.repository.NovelUtil
import com.example.domain.StateRefresh
import com.example.domain.UserAuth
import com.example.domain.UserData
import com.example.domain.resources.Resource
import com.example.domain.useCases.GetChapters
import com.example.domain.useCases.GetRecommended
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject
@HiltViewModel
class RecommendedViewModel @Inject constructor(
    private val getRecommended: GetRecommended,
    private val getChapters: GetChapters,
    private val novelRepository: NovelRepository,
    private val novelUtil: NovelUtil,
    private val followingDao: FollowingDao,
    private val auth: UserAuth,
    @ApplicationContext context: Context
) : ViewModel(){
    private val tokenKey  = auth.tokenValue.token

    var state by mutableStateOf(RecommendedState())
    var currentId by mutableStateOf(0)
    var ids by mutableStateOf(emptyList<Int>())

    private val _stateChapters = mutableStateOf(NovelChaptersState())
    val chapters: State<NovelChaptersState> = _stateChapters


    var imgBit:Bitmap? by mutableStateOf(null)

//    val novelsId:List<Int> = followingDao.getAllNovelIds().collect{
//
//    }

    init {
        viewModelScope.launch {
     imgBit = novelUtil.getImageBitmap(context,
         "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThroTXm4kovdHyw6NAVJQ3fkGlDfnJaECkmmNTPIuahK7OZ2DmOre_hh4n80RmVj-DjU8&usqp=CAU")
        }
         Log.d("REFRESHVALUE", auth.refresh.name)
        getAllNovelsIds()
        getAllNovelsFoo()
    }

    private fun getAllNovelsFoo(){
        getRecommended().onEach { result ->
            when(result){
                is Resource.Success ->{
                    state =  RecommendedState(recommended = result.data)
                    currentId = result.data?.get(0)?.id!!
                }
                is Resource.Loading -> {
                    state = RecommendedState(isLoading = true)
                }
                is Resource.Error -> {
                    state = RecommendedState(error = result.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getAllNovelsIds(){
        viewModelScope.launch {
            followingDao.getAllNovelIds().collect{
               ids = it
                //Log.d("NOVELID", "${ids[0]} idsss",)
            }
        }
    }

    fun getChaptersNovel(novelSlug:String){
        getChapters(novelSlug).onEach { result ->

            when(result){
                is Resource.Success->{
                    _stateChapters.value = NovelChaptersState(chapters = result.data)
                }
                is Resource.Loading->{
                    _stateChapters.value = NovelChaptersState(is_loading = true)
                }
                is Resource.Error->{
                    _stateChapters.value = NovelChaptersState(error = result.message?:"An expected error ocurred")

                }
            }
        }.launchIn(viewModelScope)
    }

    fun getCurrentId (id:Int){
        currentId = id
    }

    fun addNovelToBookMark(){
        if(tokenKey != "") {

            viewModelScope.launch {
                flow {
                    try {
                    val result = novelRepository.addToBookMark(tokenKey, currentId)
                    emit(Resource.Loading())
                    emit(Resource.Success(result))
                    }catch (e:IOException){
                        emit(Resource.Error(e.localizedMessage?:"An unexpected error"))
                    }
                }.collect{result->
                    when(result){
                        is Resource.Success -> {
                            if(ids.contains(currentId)){
                                followingDao.deleteNovelById(currentId)
                            }else{
                            followingDao.insertFollowing(FollowingEntity(
                                cover = imgBit,
                                id = currentId
                            ))
                            }
                            auth.refresh = StateRefresh.REFRESH

                        }
                        else ->Unit
                    }
                }
            }
        }
    }


}