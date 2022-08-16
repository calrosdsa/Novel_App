package com.example.data.local.daos;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.data.local.entities.NovelImageEntity;
import com.example.data.util.Converters;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
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
public final class NovelImageDao_Impl extends NovelImageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<NovelImageEntity> __insertionAdapterOfNovelImageEntity;

  private final Converters __converters = new Converters();

  private final EntityInsertionAdapter<NovelImageEntity> __insertionAdapterOfNovelImageEntity_1;

  private final EntityDeletionOrUpdateAdapter<NovelImageEntity> __deletionAdapterOfNovelImageEntity;

  private final EntityDeletionOrUpdateAdapter<NovelImageEntity> __updateAdapterOfNovelImageEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteForShowId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public NovelImageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNovelImageEntity = new EntityInsertionAdapter<NovelImageEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `novel_images` (`id`,`novel_id`,`title`,`chapterCount`,`image`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NovelImageEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getNovelId());
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        stmt.bindLong(4, value.getChapterCount());
        final byte[] _tmp = __converters.fromBitmap(value.getImage());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindBlob(5, _tmp);
        }
      }
    };
    this.__insertionAdapterOfNovelImageEntity_1 = new EntityInsertionAdapter<NovelImageEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `novel_images` (`id`,`novel_id`,`title`,`chapterCount`,`image`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NovelImageEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getNovelId());
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        stmt.bindLong(4, value.getChapterCount());
        final byte[] _tmp = __converters.fromBitmap(value.getImage());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindBlob(5, _tmp);
        }
      }
    };
    this.__deletionAdapterOfNovelImageEntity = new EntityDeletionOrUpdateAdapter<NovelImageEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `novel_images` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NovelImageEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfNovelImageEntity = new EntityDeletionOrUpdateAdapter<NovelImageEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `novel_images` SET `id` = ?,`novel_id` = ?,`title` = ?,`chapterCount` = ?,`image` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NovelImageEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getNovelId());
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        stmt.bindLong(4, value.getChapterCount());
        final byte[] _tmp = __converters.fromBitmap(value.getImage());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindBlob(5, _tmp);
        }
        stmt.bindLong(6, value.getId());
      }
    };
    this.__preparedStmtOfDeleteForShowId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM novel_images WHERE novel_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM novel_images";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final NovelImageEntity entity, final Continuation<? super Long> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfNovelImageEntity.insertAndReturnId(entity);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final NovelImageEntity[] entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNovelImageEntity_1.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final List<? extends NovelImageEntity> entities,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNovelImageEntity_1.insert(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteEntity(final NovelImageEntity entity,
      final Continuation<? super Integer> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__deletionAdapterOfNovelImageEntity.handle(entity);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object update(final NovelImageEntity entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfNovelImageEntity.handle(entity);
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
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> NovelImageDao_Impl.super.withTransaction(tx, __cont), $completion);
  }

  @Override
  public Object insertOrUpdate(final List<? extends NovelImageEntity> entities,
      final Continuation<? super Unit> $completion) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> NovelImageDao_Impl.super.insertOrUpdate(entities, __cont), $completion);
  }

  @Override
  public Object deleteForShowId(final long showId, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteForShowId.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, showId);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteForShowId.release(_stmt);
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
  public Object imageCountForShowId(final long showId, final Continuation<? super Integer> arg1) {
    final String _sql = "SELECT COUNT(*) FROM novel_images WHERE novel_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, showId);
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
    }, arg1);
  }

  @Override
  public Flow<NovelImageEntity> getImagesForShowId(final long showId) {
    final String _sql = "SELECT * FROM novel_images WHERE novel_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, showId);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"novel_images"}, new Callable<NovelImageEntity>() {
      @Override
      public NovelImageEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNovelId = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfChapterCount = CursorUtil.getColumnIndexOrThrow(_cursor, "chapterCount");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final NovelImageEntity _result;
          if(_cursor.moveToFirst()) {
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
            _result = new NovelImageEntity(_tmpId,_tmpNovelId,_tmpTitle,_tmpChapterCount,_tmpImage);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
