package com.example.data.local.daos;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.CancellationSignal;
import androidx.collection.LongSparseArray;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.data.Converters;
import com.example.data.local.entities.HistoryNovelEntity;
import com.example.data.local.entities.NovelImageEntity;
import com.example.data.resultentities.HistoryDetailed;
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
public final class NovelHistoryDao_Impl extends NovelHistoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<HistoryNovelEntity> __insertionAdapterOfHistoryNovelEntity;

  private final EntityDeletionOrUpdateAdapter<HistoryNovelEntity> __deletionAdapterOfHistoryNovelEntity;

  private final EntityDeletionOrUpdateAdapter<HistoryNovelEntity> __updateAdapterOfHistoryNovelEntity;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final Converters __converters = new Converters();

  public NovelHistoryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHistoryNovelEntity = new EntityInsertionAdapter<HistoryNovelEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `novel_history` (`id`,`chapters`,`last_chapter`,`last_chapter_slug`,`novel_cover`,`novel_slug`,`novel_title`,`progress`,`rank`,`viewed_on`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HistoryNovelEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getChapters());
        if (value.getLast_chapter() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLast_chapter());
        }
        if (value.getLast_chapter_slug() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLast_chapter_slug());
        }
        if (value.getNovel_cover() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNovel_cover());
        }
        if (value.getNovel_slug() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getNovel_slug());
        }
        if (value.getNovel_title() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getNovel_title());
        }
        stmt.bindLong(8, value.getProgress());
        stmt.bindLong(9, value.getRank());
        if (value.getViewed_on() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getViewed_on());
        }
      }
    };
    this.__deletionAdapterOfHistoryNovelEntity = new EntityDeletionOrUpdateAdapter<HistoryNovelEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `novel_history` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HistoryNovelEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfHistoryNovelEntity = new EntityDeletionOrUpdateAdapter<HistoryNovelEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `novel_history` SET `id` = ?,`chapters` = ?,`last_chapter` = ?,`last_chapter_slug` = ?,`novel_cover` = ?,`novel_slug` = ?,`novel_title` = ?,`progress` = ?,`rank` = ?,`viewed_on` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HistoryNovelEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getChapters());
        if (value.getLast_chapter() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLast_chapter());
        }
        if (value.getLast_chapter_slug() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLast_chapter_slug());
        }
        if (value.getNovel_cover() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNovel_cover());
        }
        if (value.getNovel_slug() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getNovel_slug());
        }
        if (value.getNovel_title() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getNovel_title());
        }
        stmt.bindLong(8, value.getProgress());
        stmt.bindLong(9, value.getRank());
        if (value.getViewed_on() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getViewed_on());
        }
        stmt.bindLong(11, value.getId());
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM novel_history WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM novel_history";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final HistoryNovelEntity entity, final Continuation<? super Long> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfHistoryNovelEntity.insertAndReturnId(entity);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final HistoryNovelEntity[] entity,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfHistoryNovelEntity.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final List<? extends HistoryNovelEntity> entities,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfHistoryNovelEntity.insert(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteEntity(final HistoryNovelEntity entity,
      final Continuation<? super Integer> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__deletionAdapterOfHistoryNovelEntity.handle(entity);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object update(final HistoryNovelEntity entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfHistoryNovelEntity.handle(entity);
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
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> NovelHistoryDao_Impl.super.withTransaction(tx, __cont), $completion);
  }

  @Override
  public Object insertOrUpdate(final List<? extends HistoryNovelEntity> entities,
      final Continuation<? super Unit> $completion) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> NovelHistoryDao_Impl.super.insertOrUpdate(entities, __cont), $completion);
  }

  @Override
  public Object delete(final long id, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDelete.release(_stmt);
        }
      }
    }, arg1);
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
  public Flow<HistoryNovelEntity> getNovelWithIdFlow(final long id) {
    final String _sql = "SELECT * FROM novel_history WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"novel_history"}, new Callable<HistoryNovelEntity>() {
      @Override
      public HistoryNovelEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChapters = CursorUtil.getColumnIndexOrThrow(_cursor, "chapters");
          final int _cursorIndexOfLastChapter = CursorUtil.getColumnIndexOrThrow(_cursor, "last_chapter");
          final int _cursorIndexOfLastChapterSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "last_chapter_slug");
          final int _cursorIndexOfNovelCover = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_cover");
          final int _cursorIndexOfNovelSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_slug");
          final int _cursorIndexOfNovelTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_title");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfRank = CursorUtil.getColumnIndexOrThrow(_cursor, "rank");
          final int _cursorIndexOfViewedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "viewed_on");
          final HistoryNovelEntity _result;
          if(_cursor.moveToFirst()) {
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
            _result = new HistoryNovelEntity(_tmpId,_tmpChapters,_tmpLast_chapter,_tmpLast_chapter_slug,_tmpNovel_cover,_tmpNovel_slug,_tmpNovel_title,_tmpProgress,_tmpRank,_tmpViewed_on);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getHistoryWithIdDetailed(final long id,
      final Continuation<? super HistoryDetailed> arg1) {
    final String _sql = "SELECT * FROM novel_history WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, true, _cancellationSignal, new Callable<HistoryDetailed>() {
      @Override
      public HistoryDetailed call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfChapters = CursorUtil.getColumnIndexOrThrow(_cursor, "chapters");
            final int _cursorIndexOfLastChapter = CursorUtil.getColumnIndexOrThrow(_cursor, "last_chapter");
            final int _cursorIndexOfLastChapterSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "last_chapter_slug");
            final int _cursorIndexOfNovelCover = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_cover");
            final int _cursorIndexOfNovelSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_slug");
            final int _cursorIndexOfNovelTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_title");
            final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
            final int _cursorIndexOfRank = CursorUtil.getColumnIndexOrThrow(_cursor, "rank");
            final int _cursorIndexOfViewedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "viewed_on");
            final LongSparseArray<ArrayList<NovelImageEntity>> _collectionImages = new LongSparseArray<ArrayList<NovelImageEntity>>();
            while (_cursor.moveToNext()) {
              final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
              ArrayList<NovelImageEntity> _tmpImagesCollection = _collectionImages.get(_tmpKey);
              if (_tmpImagesCollection == null) {
                _tmpImagesCollection = new ArrayList<NovelImageEntity>();
                _collectionImages.put(_tmpKey, _tmpImagesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipnovelImagesAscomExampleDataLocalEntitiesNovelImageEntity(_collectionImages);
            final HistoryDetailed _result;
            if(_cursor.moveToFirst()) {
              final HistoryNovelEntity _tmpShow;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfChapters) && _cursor.isNull(_cursorIndexOfLastChapter) && _cursor.isNull(_cursorIndexOfLastChapterSlug) && _cursor.isNull(_cursorIndexOfNovelCover) && _cursor.isNull(_cursorIndexOfNovelSlug) && _cursor.isNull(_cursorIndexOfNovelTitle) && _cursor.isNull(_cursorIndexOfProgress) && _cursor.isNull(_cursorIndexOfRank) && _cursor.isNull(_cursorIndexOfViewedOn))) {
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
                _tmpShow = new HistoryNovelEntity(_tmpId,_tmpChapters,_tmpLast_chapter,_tmpLast_chapter_slug,_tmpNovel_cover,_tmpNovel_slug,_tmpNovel_title,_tmpProgress,_tmpRank,_tmpViewed_on);
              }  else  {
                _tmpShow = null;
              }
              ArrayList<NovelImageEntity> _tmpImagesCollection_1 = null;
              final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
              _tmpImagesCollection_1 = _collectionImages.get(_tmpKey_1);
              if (_tmpImagesCollection_1 == null) {
                _tmpImagesCollection_1 = new ArrayList<NovelImageEntity>();
              }
              _result = new HistoryDetailed();
              _result.show = _tmpShow;
              _result.images = _tmpImagesCollection_1;
            } else {
              _result = null;
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
            _statement.release();
          }
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Flow<HistoryDetailed> getHistoryDetailedWithIdFlow(final long id) {
    final String _sql = "SELECT * FROM novel_history WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, true, new String[]{"novel_images","novel_history"}, new Callable<HistoryDetailed>() {
      @Override
      public HistoryDetailed call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfChapters = CursorUtil.getColumnIndexOrThrow(_cursor, "chapters");
            final int _cursorIndexOfLastChapter = CursorUtil.getColumnIndexOrThrow(_cursor, "last_chapter");
            final int _cursorIndexOfLastChapterSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "last_chapter_slug");
            final int _cursorIndexOfNovelCover = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_cover");
            final int _cursorIndexOfNovelSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_slug");
            final int _cursorIndexOfNovelTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_title");
            final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
            final int _cursorIndexOfRank = CursorUtil.getColumnIndexOrThrow(_cursor, "rank");
            final int _cursorIndexOfViewedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "viewed_on");
            final LongSparseArray<ArrayList<NovelImageEntity>> _collectionImages = new LongSparseArray<ArrayList<NovelImageEntity>>();
            while (_cursor.moveToNext()) {
              final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
              ArrayList<NovelImageEntity> _tmpImagesCollection = _collectionImages.get(_tmpKey);
              if (_tmpImagesCollection == null) {
                _tmpImagesCollection = new ArrayList<NovelImageEntity>();
                _collectionImages.put(_tmpKey, _tmpImagesCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipnovelImagesAscomExampleDataLocalEntitiesNovelImageEntity(_collectionImages);
            final HistoryDetailed _result;
            if(_cursor.moveToFirst()) {
              final HistoryNovelEntity _tmpShow;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfChapters) && _cursor.isNull(_cursorIndexOfLastChapter) && _cursor.isNull(_cursorIndexOfLastChapterSlug) && _cursor.isNull(_cursorIndexOfNovelCover) && _cursor.isNull(_cursorIndexOfNovelSlug) && _cursor.isNull(_cursorIndexOfNovelTitle) && _cursor.isNull(_cursorIndexOfProgress) && _cursor.isNull(_cursorIndexOfRank) && _cursor.isNull(_cursorIndexOfViewedOn))) {
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
                _tmpShow = new HistoryNovelEntity(_tmpId,_tmpChapters,_tmpLast_chapter,_tmpLast_chapter_slug,_tmpNovel_cover,_tmpNovel_slug,_tmpNovel_title,_tmpProgress,_tmpRank,_tmpViewed_on);
              }  else  {
                _tmpShow = null;
              }
              ArrayList<NovelImageEntity> _tmpImagesCollection_1 = null;
              final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
              _tmpImagesCollection_1 = _collectionImages.get(_tmpKey_1);
              if (_tmpImagesCollection_1 == null) {
                _tmpImagesCollection_1 = new ArrayList<NovelImageEntity>();
              }
              _result = new HistoryDetailed();
              _result.show = _tmpShow;
              _result.images = _tmpImagesCollection_1;
            } else {
              _result = null;
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
  public Object getShowWithId(final long id, final Continuation<? super HistoryNovelEntity> arg1) {
    final String _sql = "SELECT * FROM novel_history WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<HistoryNovelEntity>() {
      @Override
      public HistoryNovelEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChapters = CursorUtil.getColumnIndexOrThrow(_cursor, "chapters");
          final int _cursorIndexOfLastChapter = CursorUtil.getColumnIndexOrThrow(_cursor, "last_chapter");
          final int _cursorIndexOfLastChapterSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "last_chapter_slug");
          final int _cursorIndexOfNovelCover = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_cover");
          final int _cursorIndexOfNovelSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_slug");
          final int _cursorIndexOfNovelTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_title");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfRank = CursorUtil.getColumnIndexOrThrow(_cursor, "rank");
          final int _cursorIndexOfViewedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "viewed_on");
          final HistoryNovelEntity _result;
          if(_cursor.moveToFirst()) {
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
            _result = new HistoryNovelEntity(_tmpId,_tmpChapters,_tmpLast_chapter,_tmpLast_chapter_slug,_tmpNovel_cover,_tmpNovel_slug,_tmpNovel_title,_tmpProgress,_tmpRank,_tmpViewed_on);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg1);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
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
    _stringBuilder.append("SELECT `id`,`novel_id`,`image` FROM `novel_images` WHERE `novel_id` IN (");
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
      final int _cursorIndexOfImage = 2;
      while(_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_itemKeyIndex);
        ArrayList<NovelImageEntity> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final NovelImageEntity _item_1;
          final long _tmpId;
          _tmpId = _cursor.getLong(_cursorIndexOfId);
          final long _tmpNovelId;
          _tmpNovelId = _cursor.getLong(_cursorIndexOfNovelId);
          final Bitmap _tmpImage;
          final byte[] _tmp;
          if (_cursor.isNull(_cursorIndexOfImage)) {
            _tmp = null;
          } else {
            _tmp = _cursor.getBlob(_cursorIndexOfImage);
          }
          _tmpImage = __converters.toBitmap(_tmp);
          _item_1 = new NovelImageEntity(_tmpId,_tmpNovelId,_tmpImage);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
