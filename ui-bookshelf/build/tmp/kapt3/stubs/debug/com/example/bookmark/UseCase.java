package com.example.bookmark;

import androidx.lifecycle.MediatorLiveData;
import com.example.domain.util.NovelOrder;
import com.example.data.local.entities.FollowingEntity;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006H\u0016R \u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/example/bookmark/UseCase;", "P", "R", "", "()V", "result", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/example/bookmark/Results;", "getResult", "()Landroidx/lifecycle/MediatorLiveData;", "execute", "", "parameters", "(Ljava/lang/Object;)V", "observe", "ui-bookshelf_debug"})
public abstract class UseCase<P extends java.lang.Object, R extends java.lang.Object> {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MediatorLiveData<com.example.bookmark.Results<R>> result = null;
    
    public UseCase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final androidx.lifecycle.MediatorLiveData<com.example.bookmark.Results<R>> getResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public androidx.lifecycle.MediatorLiveData<com.example.bookmark.Results<R>> observe() {
        return null;
    }
    
    public abstract void execute(P parameters);
}