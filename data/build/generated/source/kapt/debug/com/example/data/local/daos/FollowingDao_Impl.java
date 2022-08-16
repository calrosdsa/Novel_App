package com.example.data.local.daos;

import android.database.Cursor;
import android.graphics.Bitmap;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.data.local.entities.FollowingEntity;
import com.example.data.util.Converters;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class FollowingDao_Impl implements FollowingDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FollowingEntity> __insertionAdapterOfFollowingEntity;

  private final Converters __converters = new Converters();

  private final SharedSQLiteStatement __preparedStmtOfDeleteNovel;

  private final SharedSQLiteStatement __preparedStmtOfDeleteNovelById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public FollowingDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFollowingEntity = new EntityInsertionAdapter<FollowingEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `following_novels` (`id`,`added`,`chapters`,`cover`,`options`,`progress`,`slug`,`title`,`updated`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FollowingEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getAdded() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAdded());
        }
        stmt.bindLong(3, value.getChapters());
        final byte[] _tmp = __converters.fromBitmap(value.getCover());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindBlob(4, _tmp);
        }
        final String _tmp_1 = __converters.listToJsonString(value.getOptions());
        if (_tmp_1 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_1);
        }
        stmt.bindLong(6, value.getProgress());
        if (value.getSlug() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSlug());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTitle());
        }
        if (value.getUpdated() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUpdated());
        }
      }
    };
    this.__preparedStmtOfDeleteNovel = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM following_novels WHERE title = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteNovelById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM following_novels WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM following_novels";
        return _query;
      }
    };
  }

  @Override
  public Object insertFollowings(final List<FollowingEntity> followings,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFollowingEntity.insert(followings);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertFollowing(final FollowingEntity followings,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFollowingEntity.insert(followings);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteNovel(final String novelId, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteNovel.acquire();
        int _argIndex = 1;
        if (novelId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, novelId);
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteNovel.release(_stmt);
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteNovelById(final int id, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteNovelById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteNovelById.release(_stmt);
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
  public Flow<List<FollowingEntity>> getAllFollowings() {
    final String _sql = "SELECT * FROM following_novels";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"following_novels"}, new Callable<List<FollowingEntity>>() {
      @Override
      public List<FollowingEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAdded = CursorUtil.getColumnIndexOrThrow(_cursor, "added");
          final int _cursorIndexOfChapters = CursorUtil.getColumnIndexOrThrow(_cursor, "chapters");
          final int _cursorIndexOfCover = CursorUtil.getColumnIndexOrThrow(_cursor, "cover");
          final int _cursorIndexOfOptions = CursorUtil.getColumnIndexOrThrow(_cursor, "options");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "progress");
          final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "slug");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "updated");
          final List<FollowingEntity> _result = new ArrayList<FollowingEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FollowingEntity _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final String _tmpAdded;
            if (_cursor.isNull(_cursorIndexOfAdded)) {
              _tmpAdded = null;
            } else {
              _tmpAdded = _cursor.getString(_cursorIndexOfAdded);
            }
            final int _tmpChapters;
            _tmpChapters = _cursor.getInt(_cursorIndexOfChapters);
            final Bitmap _tmpCover;
            final byte[] _tmp;
            if (_cursor.isNull(_cursorIndexOfCover)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getBlob(_cursorIndexOfCover);
            }
            _tmpCover = __converters.toBitmap(_tmp);
            final List<Integer> _tmpOptions;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfOptions)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfOptions);
            }
            _tmpOptions = __converters.jsonStringToList(_tmp_1);
            final int _tmpProgress;
            _tmpProgress = _cursor.getInt(_cursorIndexOfProgress);
            final String _tmpSlug;
            if (_cursor.isNull(_cursorIndexOfSlug)) {
              _tmpSlug = null;
            } else {
              _tmpSlug = _cursor.getString(_cursorIndexOfSlug);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpUpdated;
            if (_cursor.isNull(_cursorIndexOfUpdated)) {
              _tmpUpdated = null;
            } else {
              _tmpUpdated = _cursor.getString(_cursorIndexOfUpdated);
            }
            _item = new FollowingEntity(_tmpId,_tmpAdded,_tmpChapters,_tmpCover,_tmpOptions,_tmpProgress,_tmpSlug,_tmpTitle,_tmpUpdated);
            _result.add(_item);
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
  public Flow<List<Integer>> getAllNovelIds() {
    final String _sql = "SELECT id FROM following_novels";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"following_novels"}, new Callable<List<Integer>>() {
      @Override
      public List<Integer> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<Integer> _result = new ArrayList<Integer>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Integer _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getInt(0);
            }
            _result.add(_item);
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
