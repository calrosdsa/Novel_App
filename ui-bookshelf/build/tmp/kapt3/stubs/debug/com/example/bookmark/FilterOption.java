package com.example.bookmark;

import androidx.lifecycle.MediatorLiveData;
import com.example.domain.util.NovelOrder;
import com.example.data.local.entities.FollowingEntity;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B9\b\u0004\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r\u0082\u0001\u0002\u0013\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/example/bookmark/FilterOption;", "", "values", "", "", "title", "isOrderType", "", "listNovelOrder", "Lcom/example/domain/util/NovelOrder;", "(Ljava/util/List;Ljava/lang/String;ZLjava/util/List;)V", "()Z", "getListNovelOrder", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getValues", "Filter", "Sorted", "Lcom/example/bookmark/FilterOption$Filter;", "Lcom/example/bookmark/FilterOption$Sorted;", "ui-bookshelf_debug"})
public abstract class FilterOption {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> values = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    private final boolean isOrderType = false;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.example.domain.util.NovelOrder> listNovelOrder = null;
    
    private FilterOption(java.util.List<java.lang.String> values, java.lang.String title, boolean isOrderType, java.util.List<? extends com.example.domain.util.NovelOrder> listNovelOrder) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getValues() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final boolean isOrderType() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.domain.util.NovelOrder> getListNovelOrder() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/bookmark/FilterOption$Filter;", "Lcom/example/bookmark/FilterOption;", "()V", "ui-bookshelf_debug"})
    public static final class Filter extends com.example.bookmark.FilterOption {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.bookmark.FilterOption.Filter INSTANCE = null;
        
        private Filter() {
            super(null, null, false, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/bookmark/FilterOption$Sorted;", "Lcom/example/bookmark/FilterOption;", "()V", "ui-bookshelf_debug"})
    public static final class Sorted extends com.example.bookmark.FilterOption {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.bookmark.FilterOption.Sorted INSTANCE = null;
        
        private Sorted() {
            super(null, null, false, null);
        }
    }
}