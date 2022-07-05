package com.example.domain.useCases;

import com.example.data.dto.reviews.ReviewsDto;
import com.example.data.repository.NovelRepository;
import kotlinx.coroutines.flow.Flow;
import com.example.domain.resources.Resource;
import retrofit2.HttpException;
import java.io.IOException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/domain/useCases/GetReviews;", "", "repository", "Lcom/example/data/repository/NovelRepository;", "(Lcom/example/data/repository/NovelRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/domain/resources/Resource;", "Lcom/example/data/dto/reviews/ReviewsDto;", "novelSlug", "", "domain_debug"})
public final class GetReviews {
    private final com.example.data.repository.NovelRepository repository = null;
    
    @javax.inject.Inject()
    public GetReviews(@org.jetbrains.annotations.NotNull()
    com.example.data.repository.NovelRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.domain.resources.Resource<com.example.data.dto.reviews.ReviewsDto>> invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String novelSlug) {
        return null;
    }
}