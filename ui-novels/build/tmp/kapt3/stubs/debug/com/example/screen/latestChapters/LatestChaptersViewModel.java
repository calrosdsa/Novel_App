package com.example.screen.latestChapters;

import androidx.lifecycle.ViewModel;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import com.example.data.dto.chaptersLatest.Result;
import com.example.domain.pagination.NovelPaginationImpl;
import com.example.data.remote.ApiService;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/screen/latestChapters/LatestChaptersViewModel;", "Landroidx/lifecycle/ViewModel;", "apiService", "Lcom/example/data/remote/ApiService;", "(Lcom/example/data/remote/ApiService;)V", "pager", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/example/data/dto/chaptersLatest/Result;", "getPager", "()Lkotlinx/coroutines/flow/Flow;", "ui-novels_debug"})
public final class LatestChaptersViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.data.remote.ApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.data.dto.chaptersLatest.Result>> pager = null;
    
    @javax.inject.Inject()
    public LatestChaptersViewModel(@org.jetbrains.annotations.NotNull()
    com.example.data.remote.ApiService apiService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.data.dto.chaptersLatest.Result>> getPager() {
        return null;
    }
}