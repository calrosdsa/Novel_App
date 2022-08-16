package com.example.data.local.daos;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.CancellationSignal;
import androidx.collection.LongSparseArray;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.data.local.entities.HistoryNovelEntity;
import com.example.data.local.entities.HistoryNovelEntry;
import com.example.data.local.entities.NovelImageEntity;
import com.example.data.resultentities.HistoryEntryWithNovels;
import com.example.data.util.Converters;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class HistoryNovelDao_Impl extends HistoryNovelDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<HistoryNovelEntry> __insertionAdapterOfHistoryNovelEntry;

  private final EntityDeletionOrUpdateAdapter<HistoryNovelEntry> __deletionAdapterOfHistoryNovelEntry;

  private final EntityDeletionOrUpdateAdapter<HistoryNovelEntry> __updateAdapterOfHistoryNovelEntry;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeletePage;

  private final Converters __converters = new Converters();

  public HistoryNovelDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHistoryNovelEntry = new EntityInsertionAdapter<HistoryNovelEntry>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `history_entries` (`id`,`novel_id`,`page`,`page_order`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HistoryNovelEntry value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getNovelId());
        stmt.bindLong(3, value.getPage());
        stmt.bindLong(4, value.getPageOrder());
      }
    };
    this.__deletionAdapterOfHistoryNovelEntry = new EntityDeletionOrUpdateAdapter<HistoryNovelEntry>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `history_entries` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HistoryNovelEntry value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfHistoryNovelEntry = new EntityDeletionOrUpdateAdapter<HistoryNovelEntry>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `history_entries` SET `id` = ?,`novel_id` = ?,`page` = ?,`page_order` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HistoryNovelEntry value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getNovelId());
        stmt.bindLong(3, value.getPage());
        stmt.bindLong(4, value.getPageOrder());
        stmt.bindLong(5, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM history_entries";
        return _query;
      }
    };
    this.__preparedStmtOfDeletePage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM history_entries WHERE page = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final HistoryNovelEntry entity, final Continuation<? super Long> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfHistoryNovelEntry.insertAndReturnId(entity);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final HistoryNovelEntry[] entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfHistoryNovelEntry.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final List<? extends HistoryNovelEntry> entities,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfHistoryNovelEntry.insert(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteEntity(final HistoryNovelEntry entity,
      final Continuation<? super Integer> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__deletionAdapterOfHistoryNovelEntry.handle(entity);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object update(final HistoryNovelEntry entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfHistoryNovelEntry.handle(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object withTransaction(final Function1<? super Continuation<? super Unit>, ?> tx,
      final Continuation<? super Unit> $completion) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> HistoryNovelDao_Impl.super.withTransaction(tx, __cont), $completion);
  }

  @Override
  public Object insertOrUpdate(final List<? extends HistoryNovelEntry> entities,
      final Continuation<? super Unit> $completion) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> HistoryNovelDao_Impl.super.insertOrUpdate(entities, __cont), $completion);
  }

  @Override
  public Object updatePage(final int page, final List<? extends HistoryNovelEntry> entities,
      final Continuation<? super Unit> $completion) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> HistoryNovelDao_Impl.super.updatePage(page, entities, __cont), $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> arg0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, arg0);
  }

  @Override
  public Object deletePage(final int page, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeletePage.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, page);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeletePage.release(_stmt);
        }
      }
    }, arg1);
  }

  @Override
  public Object getLastPage(final Continuation<? super Integer> arg0) {
    final String _sql = "SELECT MAX(page) from history_entries";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg0);
  }

  @Override
  public Flow<List<HistoryNovelEntry>> entriesObservable(final int page) {
    final String _sql = "SELECT * FROM history_entries WHERE page = ? ORDER BY page_order";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, page);
    return CoroutinesRoom.createFlow(__db, true, new String[]{"history_entries"}, new Callable<List<HistoryNovelEntry>>() {
      @Override
      public List<HistoryNovelEntry> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfNovelId = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_id");
            final int _cursorIndexOfPage = CursorUtil.getColumnIndexOrThrow(_cursor, "page");
            final int _cursorIndexOfPageOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "page_order");
            final List<HistoryNovelEntry> _result = new ArrayList<HistoryNovelEntry>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final HistoryNovelEntry _item;
              final long _tmpId;
              _tmpId = _cursor.getLong(_cursorIndexOfId);
              final long _tmpNovelId;
              _tmpNovelId = _cursor.getLong(_cursorIndexOfNovelId);
              final int _tmpPage;
              _tmpPage = _cursor.getInt(_cursorIndexOfPage);
              final int _tmpPageOrder;
              _tmpPageOrder = _cursor.getInt(_cursorIndexOfPageOrder);
              _item = new HistoryNovelEntry(_tmpId,_tmpNovelId,_tmpPage,_tmpPageOrder);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<HistoryEntryWithNovels>> entriesObservable(final int count, final int offset) {
    final String _sql = "SELECT * FROM history_entries ORDER BY page, page_order LIMIT ? OFFSET ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, count);
    _argIndex = 2;
    _statement.bindLong(_argIndex, offset);
    return CoroutinesRoom.createFlow(__db, true, new String[]{"novel_history","novel_images","history_entries"}, new Callable<List<HistoryEntryWithNovels>>() {
      @Override
      public List<HistoryEntryWithNovels> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfNovelId = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_id");
            final int _cursorIndexOfPage = CursorUtil.getColumnIndexOrThrow(_cursor, "page");
            final int _cursorIndexOfPageOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "page_order");
            final LongSparseArray<ArrayList<HistoryNovelEntity>> _collectionRelations = new LongSparseArray<ArrayList<HistoryNovelEntity>>();
            final LongSparseArray<ArrayList<NovelImageEntity>> _collectionImages = new LongSparseArray<ArrayList<NovelImageEntity>>();
            while (_cursor.moveToNext()) {
              final long _tmpKey = _cursor.getLong(_cursorIndexOfNovelId);
              ArrayList<HistoryNovelEntity> _tmpRelationsCollection = _collectionRelations.get(_tmpKey);
              if (_tmpRelationsCollection == null) {
                _tmpRelationsCollection = new ArrayList<HistoryNovelEntity>();
                _collectionRelations.put(_tmpKey, _tmpRelationsCollection);
              }
              final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfNovelId);
              ArrayList<NovelImageEntity> _tmpImagesCollection = _collectionImages.get(_tmpKey_1);
              if (_tmpImagesCollection == null) {
                _tmpImagesCollection = new ArrayList<NovelImageEntity>();
                _collectionImages.put(_tmpKey_1, _tmpImagesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipnovelHistoryAscomExampleDataLocalEntitiesHistoryNovelEntity(_collectionRelations);
            __fetchRelationshipnovelImagesAscomExampleDataLocalEntitiesNovelImageEntity(_collectionImages);
            final List<HistoryEntryWithNovels> _result = new ArrayList<HistoryEntryWithNovels>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final HistoryEntryWithNovels _item;
              final HistoryNovelEntry _tmpEntry;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfNovelId) && _cursor.isNull(_cursorIndexOfPage) && _cursor.isNull(_cursorIndexOfPageOrder))) {
                final long _tmpId;
                _tmpId = _cursor.getLong(_cursorIndexOfId);
                final long _tmpNovelId;
                _tmpNovelId = _cursor.getLong(_cursorIndexOfNovelId);
                final int _tmpPage;
                _tmpPage = _cursor.getInt(_cursorIndexOfPage);
                final int _tmpPageOrder;
                _tmpPageOrder = _cursor.getInt(_cursorIndexOfPageOrder);
                _tmpEntry = new HistoryNovelEntry(_tmpId,_tmpNovelId,_tmpPage,_tmpPageOrder);
              }  else  {
                _tmpEntry = null;
              }
              ArrayList<HistoryNovelEntity> _tmpRelationsCollection_1 = null;
              final long _tmpKey_2 = _cursor.getLong(_cursorIndexOfNovelId);
              _tmpRelationsCollection_1 = _collectionRelations.get(_tmpKey_2);
              if (_tmpRelationsCollection_1 == null) {
                _tmpRelationsCollection_1 = new ArrayList<HistoryNovelEntity>();
              }
              ArrayList<NovelImageEntity> _tmpImagesCollection_1 = null;
              final long _tmpKey_3 = _cursor.getLong(_cursorIndexOfNovelId);
              _tmpImagesCollection_1 = _collectionImages.get(_tmpKey_3);
              if (_tmpImagesCollection_1 == null) {
                _tmpImagesCollection_1 = new ArrayList<NovelImageEntity>();
              }
              _item = new HistoryEntryWithNovels();
              _item.entry = _tmpEntry;
              _item.relations = _tmpRelationsCollection_1;
              _item.images = _tmpImagesCollection_1;
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public PagingSource<Integer, HistoryEntryWithNovels> entriesPagingSource() {
    final String _sql = "SELECT * FROM history_entries ORDER BY page ASC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new LimitOffsetPagingSource<HistoryEntryWithNovels>(_statement, __db, "novel_history", "novel_images", "history_entries") {
      @Override
      protected List<HistoryEntryWithNovels> convertRows(Cursor cursor) {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfNovelId = CursorUtil.getColumnIndexOrThrow(cursor, "novel_id");
        final int _cursorIndexOfPage = CursorUtil.getColumnIndexOrThrow(cursor, "page");
        final int _cursorIndexOfPageOrder = CursorUtil.getColumnIndexOrThrow(cursor, "page_order");
        final LongSparseArray<ArrayList<HistoryNovelEntity>> _collectionRelations = new LongSparseArray<ArrayList<HistoryNovelEntity>>();
        final LongSparseArray<ArrayList<NovelImageEntity>> _collectionImages = new LongSparseArray<ArrayList<NovelImageEntity>>();
        while (cursor.moveToNext()) {
          final long _tmpKey = cursor.getLong(_cursorIndexOfNovelId);
          ArrayList<HistoryNovelEntity> _tmpRelationsCollection = _collectionRelations.get(_tmpKey);
          if (_tmpRelationsCollection == null) {
            _tmpRelationsCollection = new ArrayList<HistoryNovelEntity>();
            _collectionRelations.put(_tmpKey, _tmpRelationsCollection);
          }
          final long _tmpKey_1 = cursor.getLong(_cursorIndexOfNovelId);
          ArrayList<NovelImageEntity> _tmpImagesCollection = _collectionImages.get(_tmpKey_1);
          if (_tmpImagesCollection == null) {
            _tmpImagesCollection = new ArrayList<NovelImageEntity>();
            _collectionImages.put(_tmpKey_1, _tmpImagesCollection);
          }
        }
        cursor.moveToPosition(-1);
        __fetchRelationshipnovelHistoryAscomExampleDataLocalEntitiesHistoryNovelEntity(_collectionRelations);
        __fetchRelationshipnovelImagesAscomExampleDataLocalEntitiesNovelImageEntity(_collectionImages);
        final List<HistoryEntryWithNovels> _result = new ArrayList<HistoryEntryWithNovels>(cursor.getCount());
        while(cursor.moveToNext()) {
          final HistoryEntryWithNovels _item;
          final HistoryNovelEntry _tmpEntry;
          if (! (cursor.isNull(_cursorIndexOfId) && cursor.isNull(_cursorIndexOfNovelId) && cursor.isNull(_cursorIndexOfPage) && cursor.isNull(_cursorIndexOfPageOrder))) {
            final long _tmpId;
            _tmpId = cursor.getLong(_cursorIndexOfId);
            final long _tmpNovelId;
            _tmpNovelId = cursor.getLong(_cursorIndexOfNovelId);
            final int _tmpPage;
            _tmpPage = cursor.getInt(_cursorIndexOfPage);
            final int _tmpPageOrder;
            _tmpPageOrder = cursor.getInt(_cursorIndexOfPageOrder);
            _tmpEntry = new HistoryNovelEntry(_tmpId,_tmpNovelId,_tmpPage,_tmpPageOrder);
          }  else  {
            _tmpEntry = null;
          }
          ArrayList<HistoryNovelEntity> _tmpRelationsCollection_1 = null;
          final long _tmpKey_2 = cursor.getLong(_cursorIndexOfNovelId);
          _tmpRelationsCollection_1 = _collectionRelations.get(_tmpKey_2);
          if (_tmpRelationsCollection_1 == null) {
            _tmpRelationsCollection_1 = new ArrayList<HistoryNovelEntity>();
          }
          ArrayList<NovelImageEntity> _tmpImagesCollection_1 = null;
          final long _tmpKey_3 = cursor.getLong(_cursorIndexOfNovelId);
          _tmpImagesCollection_1 = _collectionImages.get(_tmpKey_3);
          if (_tmpImagesCollection_1 == null) {
            _tmpImagesCollection_1 = new ArrayList<NovelImageEntity>();
          }
          _item = new HistoryEntryWithNovels();
          _item.entry = _tmpEntry;
          _item.relations = _tmpRelationsCollection_1;
          _item.images = _tmpImagesCollection_1;
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshipnovelHistoryAscomExampleDataLocalEntitiesHistoryNovelEntity(
      final LongSparseArray<ArrayList<HistoryNovelEntity>> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<ArrayList<HistoryNovelEntity>> _tmpInnerMap = new LongSparseArray<ArrayList<HistoryNovelEntity>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipnovelHistoryAscomExampleDataLocalEntitiesHistoryNovelEntity(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<ArrayList<HistoryNovelEntity>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipnovelHistoryAscomExampleDataLocalEntitiesHistoryNovelEntity(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`chapters`,`last_chapter`,`last_chapter_slug`,`novel_cover`,`novel_slug`,`novel_title`,`progress`,`rank`,`viewed_on` FROM `novel_history` WHERE `id` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfChapters = 1;
      final int _cursorIndexOfLastChapter = 2;
      final int _cursorIndexOfLastChapterSlug = 3;
      final int _cursorIndexOfNovelCover = 4;
      final int _cursorIndexOfNovelSlug = 5;
      final int _cursorIndexOfNovelTitle = 6;
      final int _cursorIndexOfProgress = 7;
      final int _cursorIndexOfRank = 8;
      final int _cursorIndexOfViewedOn = 9;
      while(_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_itemKeyIndex);
        ArrayList<HistoryNovelEntity> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final HistoryNovelEntity _item_1;
          final long _tmpId;
          _tmpId = _cursor.getLong(_cursorIndexOfId);
          final int _tmpChapters;
          _tmpChapters = _cursor.getInt(_cursorIndexOfChapters);
          final String _tmpLast_chapter;
          if (_cursor.isNull(_cursorIndexOfLastChapter)) {
            _tmpLast_chapter = null;
          } else {
            _tmpLast_chapter = _cursor.getString(_cursorIndexOfLastChapter);
          }
          final String _tmpLast_chapter_slug;
          if (_cursor.isNull(_cursorIndexOfLastChapterSlug)) {
            _tmpLast_chapter_slug = null;
          } else {
            _tmpLast_chapter_slug = _cursor.getString(_cursorIndexOfLastChapterSlug);
          }
          final String _tmpNovel_cover;
          if (_cursor.isNull(_cursorIndexOfNovelCover)) {
            _tmpNovel_cover = null;
          } else {
            _tmpNovel_cover = _cursor.getString(_cursorIndexOfNovelCover);
          }
          final String _tmpNovel_slug;
          if (_cursor.isNull(_cursorIndexOfNovelSlug)) {
            _tmpNovel_slug = null;
          } else {
            _tmpNovel_slug = _cursor.getString(_cursorIndexOfNovelSlug);
          }
          final String _tmpNovel_title;
          if (_cursor.isNull(_cursorIndexOfNovelTitle)) {
            _tmpNovel_title = null;
          } else {
            _tmpNovel_title = _cursor.getString(_cursorIndexOfNovelTitle);
          }
          final int _tmpProgress;
          _tmpProgress = _cursor.getInt(_cursorIndexOfProgress);
          final int _tmpRank;
          _tmpRank = _cursor.getInt(_cursorIndexOfRank);
          final String _tmpViewed_on;
          if (_cursor.isNull(_cursorIndexOfViewedOn)) {
            _tmpViewed_on = null;
          } else {
            _tmpViewed_on = _cursor.getString(_cursorIndexOfViewedOn);
          }
          _item_1 = new HistoryNovelEntity(_tmpId,_tmpChapters,_tmpLast_chapter,_tmpLast_chapter_slug,_tmpNovel_cover,_tmpNovel_slug,_tmpNovel_title,_tmpProgress,_tmpRank,_tmpViewed_on);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }

  private void __fetchRelationshipnovelImagesAscomExampleDataLocalEntitiesNovelImageEntity(
      final LongSparseArray<ArrayList<NovelImageEntity>> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<ArrayList<NovelImageEntity>> _tmpInnerMap = new LongSparseArray<ArrayList<NovelImageEntity>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipnovelImagesAscomExampleDataLocalEntitiesNovelImageEntity(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<ArrayList<NovelImageEntity>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipnovelImagesAscomExampleDataLocalEntitiesNovelImageEntity(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`novel_id`,`title`,`chapterCount`,`image` FROM `novel_images` WHERE `novel_id` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "novel_id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfNovelId = 1;
      final int _cursorIndexOfTitle = 2;
      final int _cursorIndexOfChapterCount = 3;
      final int _cursorIndexOfImage = 4;
      while(_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_itemKeyIndex);
        ArrayList<NovelImageEntity> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final NovelImageEntity _item_1;
          final long _tmpId;
          _tmpId = _cursor.getLong(_cursorIndexOfId);
          final long _tmpNovelId;
          _tmpNovelId = _cursor.getLong(_cursorIndexOfNovelId);
          final String _tmpTitle;
          if (_cursor.isNull(_cursorIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
          }
          final int _tmpChapterCount;
          _tmpChapterCount = _cursor.getInt(_cursorIndexOfChapterCount);
          final Bitmap _tmpImage;
          final byte[] _tmp;
          if (_cursor.isNull(_cursorIndexOfImage)) {
            _tmp = null;
          } else {
            _tmp = _cursor.getBlob(_cursorIndexOfImage);
          }
          _tmpImage = __converters.toBitmap(_tmp);
          _item_1 = new NovelImageEntity(_tmpId,_tmpNovelId,_tmpTitle,_tmpChapterCount,_tmpImage);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
