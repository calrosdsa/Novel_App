package com.example.domain;

import android.util.Log;
import androidx.paging.ExperimentalPagingApi;
import androidx.paging.LoadType;
import androidx.paging.PagingState;
import androidx.paging.RemoteMediator;
import com.example.data.local.entities.HistoryNovelEntry;
import com.example.data.local.entities.PaginatedEntry;
import com.example.data.resultentities.EntryWithHistoryNovels;
import com.example.data.resultentities.HistoryEntryWithNovels;

/**
 * A [RemoteMediator] which works on [PaginatedEntry] entities. [fetch] will be called with the
 * next page to load.
 */
@kotlin.OptIn(markerClass = {androidx.paging.ExperimentalPagingApi.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00010\u0005B;\u00121\u0010\u0007\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ#\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0013H\u0002\u00a2\u0006\u0002\u0010\u0014J#\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0013H\u0002\u00a2\u0006\u0002\u0010\u0014J#\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0013H\u0002\u00a2\u0006\u0002\u0010\u0014J\u0011\u0010\u0017\u001a\u00020\u0018H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J-\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eR>\u0010\u0007\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\bX\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\n\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/example/domain/PaginatedEntryRemoteMediator;", "LI", "Lcom/example/data/resultentities/EntryWithHistoryNovels;", "ET", "Lcom/example/data/local/entities/PaginatedEntry;", "Landroidx/paging/RemoteMediator;", "", "fetch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "page", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getRemoteKeyClosestToCurrentPosition", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "getRemoteKeyForFirstItem", "getRemoteKeyForLastItem", "initialize", "Landroidx/paging/RemoteMediator$InitializeAction;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Landroidx/paging/RemoteMediator$MediatorResult;", "loadType", "Landroidx/paging/LoadType;", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_debug"})
public final class PaginatedEntryRemoteMediator<LI extends com.example.data.resultentities.EntryWithHistoryNovels<ET>, ET extends com.example.data.local.entities.PaginatedEntry> extends androidx.paging.RemoteMediator<java.lang.Integer, LI> {
    private final kotlin.jvm.functions.Function2<java.lang.Integer, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> fetch = null;
    
    public PaginatedEntryRemoteMediator(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> fetch) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object initialize(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.paging.RemoteMediator.InitializeAction> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object load(@org.jetbrains.annotations.NotNull()
    androidx.paging.LoadType loadType, @org.jetbrains.annotations.NotNull()
    androidx.paging.PagingState<java.lang.Integer, LI> state, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.paging.RemoteMediator.MediatorResult> continuation) {
        return null;
    }
    
    private final java.lang.Integer getRemoteKeyForLastItem(androidx.paging.PagingState<java.lang.Integer, LI> state) {
        return null;
    }
    
    private final java.lang.Integer getRemoteKeyForFirstItem(androidx.paging.PagingState<java.lang.Integer, LI> state) {
        return null;
    }
    
    private final java.lang.Integer getRemoteKeyClosestToCurrentPosition(androidx.paging.PagingState<java.lang.Integer, LI> state) {
        return null;
    }
}