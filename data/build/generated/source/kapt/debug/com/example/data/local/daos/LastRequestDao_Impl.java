package com.example.data.local.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.data.Converters;
import com.example.data.local.entities.LastRequest;
import com.example.data.local.entities.Request;
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
import org.threeten.bp.Instant;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class LastRequestDao_Impl extends LastRequestDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LastRequest> __insertionAdapterOfLastRequest;

  private final Converters __converters = new Converters();

  private final EntityInsertionAdapter<LastRequest> __insertionAdapterOfLastRequest_1;

  private final EntityDeletionOrUpdateAdapter<LastRequest> __deletionAdapterOfLastRequest;

  private final EntityDeletionOrUpdateAdapter<LastRequest> __updateAdapterOfLastRequest;

  public LastRequestDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLastRequest = new EntityInsertionAdapter<LastRequest>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `last_requests` (`id`,`request`,`entity_id`,`timestamp`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LastRequest value) {
        stmt.bindLong(1, value.getId());
        final String _tmp = __converters.fromRequest(value.getRequest());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        stmt.bindLong(3, value.getEntityId());
        final Long _tmp_1 = __converters.fromInstant(value.getTimestamp());
        if (_tmp_1 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp_1);
        }
      }
    };
    this.__insertionAdapterOfLastRequest_1 = new EntityInsertionAdapter<LastRequest>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `last_requests` (`id`,`request`,`entity_id`,`timestamp`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LastRequest value) {
        stmt.bindLong(1, value.getId());
        final String _tmp = __converters.fromRequest(value.getRequest());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        stmt.bindLong(3, value.getEntityId());
        final Long _tmp_1 = __converters.fromInstant(value.getTimestamp());
        if (_tmp_1 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp_1);
        }
      }
    };
    this.__deletionAdapterOfLastRequest = new EntityDeletionOrUpdateAdapter<LastRequest>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `last_requests` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LastRequest value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfLastRequest = new EntityDeletionOrUpdateAdapter<LastRequest>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `last_requests` SET `id` = ?,`request` = ?,`entity_id` = ?,`timestamp` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LastRequest value) {
        stmt.bindLong(1, value.getId());
        final String _tmp = __converters.fromRequest(value.getRequest());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        stmt.bindLong(3, value.getEntityId());
        final Long _tmp_1 = __converters.fromInstant(value.getTimestamp());
        if (_tmp_1 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp_1);
        }
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public Object insert(final LastRequest entity, final Continuation<? super Long> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfLastRequest.insertAndReturnId(entity);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final LastRequest[] entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLastRequest_1.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final List<? extends LastRequest> entities,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLastRequest_1.insert(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteEntity(final LastRequest entity, final Continuation<? super Integer> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__deletionAdapterOfLastRequest.handle(entity);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object update(final LastRequest entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfLastRequest.handle(entity);
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
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> LastRequestDao_Impl.super.withTransaction(tx, __cont), $completion);
  }

  @Override
  public Object insertOrUpdate(final List<? extends LastRequest> entities,
      final Continuation<? super Unit> $completion) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> LastRequestDao_Impl.super.insertOrUpdate(entities, __cont), $completion);
  }

  @Override
  public Object lastRequest(final Request request, final long entityId,
      final Continuation<? super LastRequest> arg2) {
    final String _sql = "SELECT * FROM last_requests WHERE request = ? AND entity_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final String _tmp = __converters.fromRequest(request);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, entityId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<LastRequest>() {
      @Override
      public LastRequest call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfRequest = CursorUtil.getColumnIndexOrThrow(_cursor, "request");
          final int _cursorIndexOfEntityId = CursorUtil.getColumnIndexOrThrow(_cursor, "entity_id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final LastRequest _result;
          if(_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Request _tmpRequest;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfRequest)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfRequest);
            }
            _tmpRequest = __converters.toRequest(_tmp_1);
            final long _tmpEntityId;
            _tmpEntityId = _cursor.getLong(_cursorIndexOfEntityId);
            final Instant _tmpTimestamp;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            _tmpTimestamp = __converters.toInstant(_tmp_2);
            _result = new LastRequest(_tmpId,_tmpRequest,_tmpEntityId,_tmpTimestamp);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg2);
  }

  @Override
  public Object requestCount(final Request request, final long entityId,
      final Continuation<? super Integer> arg2) {
    final String _sql = "SELECT COUNT(*) FROM last_requests WHERE request = ? AND entity_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final String _tmp = __converters.fromRequest(request);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, entityId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp_1;
            if (_cursor.isNull(0)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(0);
            }
            _result = _tmp_1;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg2);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
