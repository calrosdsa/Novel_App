package com.example.data.remote;

import com.example.data.dto.allNovels.AllNovelsDto;
import com.example.data.dto.browse.BrowseDto;
import com.example.data.dto.chapters.*;
import com.example.data.dto.novel.NovelDetailDto;
import com.example.data.dto.novels.NovelsDto;
import com.example.data.dto.chaptersLatest.LatestChaptersDto;
import com.example.data.dto.history.HistoryDtoItem;
import com.example.data.dto.library.BookMarkDto;
import com.example.data.dto.novel.Category;
import com.example.data.dto.profile.ProfileDto;
import com.example.data.dto.recommended.Recommended;
import com.example.data.dto.reviews.ReviewsDto;
import com.example.data.dto.searchNovel.ResultSearch;
import com.example.data.dto.user.LoginRequest;
import com.example.data.dto.user.LoginResponse;
import com.example.data.dto.user.SignUpRequest;
import com.example.data.dto.user.SignUpResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/example/data/remote/NovelOption;", "", "option", "", "(I)V", "getOption", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "data_debug"})
public final class NovelOption {
    private final int option = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.remote.NovelOption copy(int option) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public NovelOption(int option) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getOption() {
        return 0;
    }
}