package com.example.data.local.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.data.local.entities.HistorySearchEntity;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
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
public final class HistoryDao_Impl implements HistoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<HistorySearchEntity> __insertionAdapterOfHistorySearchEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeletePage;

  public HistoryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHistorySearchEntity = new EntityInsertionAdapter<HistorySearchEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `history_search` (`id`,`label`,`slug`,`title`,`timestamp`,`isInHistory`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HistorySearchEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getLabel() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getLabel());
        }
        if (value.getSlug() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSlug());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTitle());
        }
        if (value.getTimestamp() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getTimestamp());
        }
        final Integer _tmp = value.isInHistory() == null ? null : (value.isInHistory() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp);
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM history_search";
        return _query;
      }
    };
    this.__preparedStmtOfDeletePage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM history_search WHERE label = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertHistorySearch(final HistorySearchEntity historySearch,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfHistorySearchEntity.insert(historySearch);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
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
  public Object deletePage(final String label, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeletePage.acquire();
        int _argIndex = 1;
        if (label == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, label);
        }
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
  public PagingSource<Integer, HistorySearchEntity> getAllHistories() {
    final String _sql = "SELECT * FROM history_search ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new LimitOffsetPagingSource<HistorySearchEntity>(_statement, __db, "history_search") {
      @Override
      protected List<HistorySearchEntity> convertRows(Cursor cursor) {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(cursor, "label");
        final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(cursor, "slug");
        final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
        final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(cursor, "timestamp");
        final int _cursorIndexOfIsInHistory = CursorUtil.getColumnIndexOrThrow(cursor, "isInHistory");
        final List<HistorySearchEntity> _result = new ArrayList<HistorySearchEntity>(cursor.getCount());
        while(cursor.moveToNext()) {
          final HistorySearchEntity _item;
          final long _tmpId;
          _tmpId = cursor.getLong(_cursorIndexOfId);
          final String _tmpLabel;
          if (cursor.isNull(_cursorIndexOfLabel)) {
            _tmpLabel = null;
          } else {
            _tmpLabel = cursor.getString(_cursorIndexOfLabel);
          }
          final String _tmpSlug;
          if (cursor.isNull(_cursorIndexOfSlug)) {
            _tmpSlug = null;
          } else {
            _tmpSlug = cursor.getString(_cursorIndexOfSlug);
          }
          final String _tmpTitle;
          if (cursor.isNull(_cursorIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = cursor.getString(_cursorIndexOfTitle);
          }
          final Long _tmpTimestamp;
          if (cursor.isNull(_cursorIndexOfTimestamp)) {
            _tmpTimestamp = null;
          } else {
            _tmpTimestamp = cursor.getLong(_cursorIndexOfTimestamp);
          }
          final Boolean _tmpIsInHistory;
          final Integer _tmp;
          if (cursor.isNull(_cursorIndexOfIsInHistory)) {
            _tmp = null;
          } else {
            _tmp = cursor.getInt(_cursorIndexOfIsInHistory);
          }
          _tmpIsInHistory = _tmp == null ? null : _tmp != 0;
          _item = new HistorySearchEntity(_tmpId,_tmpLabel,_tmpSlug,_tmpTitle,_tmpTimestamp,_tmpIsInHistory);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @Override
  public Flow<List<HistorySearchEntity>> getAllNovelsSearchs() {
    final String _sql = "SELECT * FROM history_search ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"history_search"}, new Callable<List<HistorySearchEntity>>() {
      @Override
      public List<HistorySearchEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "slug");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfIsInHistory = CursorUtil.getColumnIndexOrThrow(_cursor, "isInHistory");
          final List<HistorySearchEntity> _result = new ArrayList<HistorySearchEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final HistorySearchEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
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
            final Long _tmpTimestamp;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmpTimestamp = null;
            } else {
              _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            final Boolean _tmpIsInHistory;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfIsInHistory)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfIsInHistory);
            }
            _tmpIsInHistory = _tmp == null ? null : _tmp != 0;
            _item = new HistorySearchEntity(_tmpId,_tmpLabel,_tmpSlug,_tmpTitle,_tmpTimestamp,_tmpIsInHistory);
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
  public Flow<List<HistorySearchEntity>> getHistorySearch() {
    final String _sql = "SELECT * FROM history_search WHERE isInHistory= 1 ORDER BY timestamp DESC LIMIT 20 ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"history_search"}, new Callable<List<HistorySearchEntity>>() {
      @Override
      public List<HistorySearchEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "slug");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfIsInHistory = CursorUtil.getColumnIndexOrThrow(_cursor, "isInHistory");
          final List<HistorySearchEntity> _result = new ArrayList<HistorySearchEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final HistorySearchEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
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
            final Long _tmpTimestamp;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmpTimestamp = null;
            } else {
              _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            final Boolean _tmpIsInHistory;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfIsInHistory)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfIsInHistory);
            }
            _tmpIsInHistory = _tmp == null ? null : _tmp != 0;
            _item = new HistorySearchEntity(_tmpId,_tmpLabel,_tmpSlug,_tmpTitle,_tmpTimestamp,_tmpIsInHistory);
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
  public Object search(final String query,
      final Continuation<? super List<HistorySearchEntity>> arg1) {
    final String _sql = "\n"
            + "            SELECT * \n"
            + "            FROM history_search\n"
            + "            WHERE LOWER(title) LIKE '%' || LOWER(?) || '%' OR\n"
            + "                UPPER(?) == title  LIMIT 10\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<HistorySearchEntity>>() {
      @Override
      public List<HistorySearchEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "slug");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfIsInHistory = CursorUtil.getColumnIndexOrThrow(_cursor, "isInHistory");
          final List<HistorySearchEntity> _result = new ArrayList<HistorySearchEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final HistorySearchEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
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
            final Long _tmpTimestamp;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmpTimestamp = null;
            } else {
              _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            final Boolean _tmpIsInHistory;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfIsInHistory)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfIsInHistory);
            }
            _tmpIsInHistory = _tmp == null ? null : _tmp != 0;
            _item = new HistorySearchEntity(_tmpId,_tmpLabel,_tmpSlug,_tmpTitle,_tmpTimestamp,_tmpIsInHistory);
            _result.add(_item);
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
}
