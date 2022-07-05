package com.example.data.repository.history_novels;

import com.example.data.local.daos.LastRequestDao;
import com.example.data.local.entities.Request;
import com.example.data.repository.lastrequests.GroupLastRequestStore;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/data/repository/history_novels/HistoryNovelShowsLastRequestStore;", "Lcom/example/data/repository/lastrequests/GroupLastRequestStore;", "dao", "Lcom/example/data/local/daos/LastRequestDao;", "(Lcom/example/data/local/daos/LastRequestDao;)V", "data_debug"})
public final class HistoryNovelShowsLastRequestStore extends com.example.data.repository.lastrequests.GroupLastRequestStore {
    
    @javax.inject.Inject()
    public HistoryNovelShowsLastRequestStore(@org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.LastRequestDao dao) {
        super(null, null);
    }
}