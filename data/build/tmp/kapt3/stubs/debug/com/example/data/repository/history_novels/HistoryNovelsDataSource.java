package com.example.data.repository.history_novels;

import android.util.Log;
import com.example.data.dto.history.HistoryDtoItem;
import com.example.data.local.entities.HistoryNovelEntity;
import com.example.data.local.entities.HistoryNovelEntry;
import com.example.data.mapper.HistoryDtoToHistoryEntity;
import com.example.data.remote.ApiService;
import com.example.data.util.IndexedMapper;
import com.example.domain.UserAuth;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ+\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f0\u00110\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000RG\u0010\r\u001a6\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000f\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f0\u00110\u000f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eX\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/example/data/repository/history_novels/HistoryNovelsDataSource;", "", "apiService", "Lcom/example/data/remote/ApiService;", "historyDtoToHistoryEntity", "Lcom/example/data/mapper/HistoryDtoToHistoryEntity;", "auth", "Lcom/example/domain/UserAuth;", "(Lcom/example/data/remote/ApiService;Lcom/example/data/mapper/HistoryDtoToHistoryEntity;Lcom/example/domain/UserAuth;)V", "entryMapper", "Lcom/example/data/util/IndexedMapper;", "Lcom/example/data/dto/history/HistoryDtoItem;", "Lcom/example/data/local/entities/HistoryNovelEntry;", "resultsMapper", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "Lkotlin/Pair;", "Lcom/example/data/local/entities/HistoryNovelEntity;", "Lkotlin/jvm/functions/Function2;", "token", "", "getToken", "()Ljava/lang/String;", "invoke", "page", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class HistoryNovelsDataSource {
    private final com.example.data.remote.ApiService apiService = null;
    private final com.example.domain.UserAuth auth = null;
    private final com.example.data.util.IndexedMapper<com.example.data.dto.history.HistoryDtoItem, com.example.data.local.entities.HistoryNovelEntry> entryMapper = null;
    private final kotlin.jvm.functions.Function2<java.util.List<com.example.data.dto.history.HistoryDtoItem>, kotlin.coroutines.Continuation<? super java.util.List<kotlin.Pair<com.example.data.local.entities.HistoryNovelEntity, com.example.data.local.entities.HistoryNovelEntry>>>, java.lang.Object> resultsMapper = null;
    
    @javax.inject.Inject()
    public HistoryNovelsDataSource(@org.jetbrains.annotations.NotNull()
    com.example.data.remote.ApiService apiService, @org.jetbrains.annotations.NotNull()
    com.example.data.mapper.HistoryDtoToHistoryEntity historyDtoToHistoryEntity, @org.jetbrains.annotations.NotNull()
    com.example.domain.UserAuth auth) {
        super();
    }
    
    private final java.lang.String getToken() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<kotlin.Pair<com.example.data.local.entities.HistoryNovelEntity, com.example.data.local.entities.HistoryNovelEntry>>> continuation) {
        return null;
    }
}