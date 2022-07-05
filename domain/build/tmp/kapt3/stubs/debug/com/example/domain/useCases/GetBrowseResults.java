package com.example.domain.useCases;

import com.example.data.dto.browse.BrowseDto;
import com.example.data.repository.NovelRepository;
import com.example.domain.resources.Resource;
import com.example.util.AppCoroutineDispatchers;
import kotlinx.coroutines.flow.Flow;
import retrofit2.HttpException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J6\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0086\u0002\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/domain/useCases/GetBrowseResults;", "", "novelRepository", "Lcom/example/data/repository/NovelRepository;", "(Lcom/example/data/repository/NovelRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/domain/resources/Resource;", "Lcom/example/data/dto/browse/BrowseDto;", "ordering", "", "status", "", "category", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lkotlinx/coroutines/flow/Flow;", "domain_debug"})
public final class GetBrowseResults {
    private final com.example.data.repository.NovelRepository novelRepository = null;
    
    @javax.inject.Inject()
    public GetBrowseResults(@org.jetbrains.annotations.NotNull()
    com.example.data.repository.NovelRepository novelRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.domain.resources.Resource<com.example.data.dto.browse.BrowseDto>> invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String ordering, @org.jetbrains.annotations.Nullable()
    java.lang.Integer status, @org.jetbrains.annotations.Nullable()
    java.lang.Integer category) {
        return null;
    }
}