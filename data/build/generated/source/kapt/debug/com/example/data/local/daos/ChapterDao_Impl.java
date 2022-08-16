package com.example.data.local.daos;

import android.database.Cursor;
import android.graphics.Bitmap;
import androidx.collection.LongSparseArray;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.data.local.entities.ChapterEntity;
import com.example.data.local.entities.NovelImageEntity;
import com.example.data.resultentities.ChapterAndNovelImage;
import com.example.data.util.Converters;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ChapterDao_Impl extends ChapterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ChapterEntity> __insertionAdapterOfChapterEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteImage;

  private final Converters __converters = new Converters();

  public ChapterDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChapterEntity = new EntityInsertionAdapter<ChapterEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `chapter_novel` (`id`,`created_at`,`novelId`,`slug`,`title`,`chapter`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChapterEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getCreated_at() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCreated_at());
        }
        stmt.bindLong(3, value.getNovelId());
        if (value.getSlug() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSlug());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTitle());
        }
        if (value.getChapter() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getChapter());
        }
      }
    };
    this.__preparedStmtOfDeleteImage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM novel_images WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertChapters(final List<ChapterEntity> chapters) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChapterEntity.insert(chapters);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Object deleteImage(final long id, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteImage.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteImage.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<ChapterAndNovelImage>> getAllChapters() {
    final String _sql = "SELECT * FROM novel_images";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, true, new String[]{"chapter_novel","novel_images"}, new Callable<List<ChapterAndNovelImage>>() {
      @Override
      public List<ChapterAndNovelImage> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfNovelId = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_id");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
            final int _cursorIndexOfChapterCount = CursorUtil.getColumnIndexOrThrow(_cursor, "chapterCount");
            final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
            final LongSparseArray<ArrayList<ChapterEntity>> _collectionChapters = new LongSparseArray<ArrayList<ChapterEntity>>();
            while (_cursor.moveToNext()) {
              final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
              ArrayList<ChapterEntity> _tmpChaptersCollection = _collectionChapters.get(_tmpKey);
              if (_tmpChaptersCollection == null) {
                _tmpChaptersCollection = new ArrayList<ChapterEntity>();
                _collectionChapters.put(_tmpKey, _tmpChaptersCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipchapterNovelAscomExampleDataLocalEntitiesChapterEntity(_collectionChapters);
            final List<ChapterAndNovelImage> _result = new ArrayList<ChapterAndNovelImage>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final ChapterAndNovelImage _item;
              final NovelImageEntity _tmpNovelImage;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfNovelId) && _cursor.isNull(_cursorIndexOfTitle) && _cursor.isNull(_cursorIndexOfChapterCount) && _cursor.isNull(_cursorIndexOfImage))) {
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
                _tmpNovelImage = new NovelImageEntity(_tmpId,_tmpNovelId,_tmpTitle,_tmpChapterCount,_tmpImage);
              }  else  {
                _tmpNovelImage = null;
              }
              ArrayList<ChapterEntity> _tmpChaptersCollection_1 = null;
              final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
              _tmpChaptersCollection_1 = _collectionChapters.get(_tmpKey_1);
              if (_tmpChaptersCollection_1 == null) {
                _tmpChaptersCollection_1 = new ArrayList<ChapterEntity>();
              }
              _item = new ChapterAndNovelImage(_tmpNovelImage,_tmpChaptersCollection_1);
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
  public Flow<ChapterAndNovelImage> getAllChaptersById(final long id) {
    final String _sql = "SELECT * FROM novel_images WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, true, new String[]{"chapter_novel","novel_images"}, new Callable<ChapterAndNovelImage>() {
      @Override
      public ChapterAndNovelImage call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfNovelId = CursorUtil.getColumnIndexOrThrow(_cursor, "novel_id");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
            final int _cursorIndexOfChapterCount = CursorUtil.getColumnIndexOrThrow(_cursor, "chapterCount");
            final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
            final LongSparseArray<ArrayList<ChapterEntity>> _collectionChapters = new LongSparseArray<ArrayList<ChapterEntity>>();
            while (_cursor.moveToNext()) {
              final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
              ArrayList<ChapterEntity> _tmpChaptersCollection = _collectionChapters.get(_tmpKey);
              if (_tmpChaptersCollection == null) {
                _tmpChaptersCollection = new ArrayList<ChapterEntity>();
                _collectionChapters.put(_tmpKey, _tmpChaptersCollection);
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipchapterNovelAscomExampleDataLocalEntitiesChapterEntity(_collectionChapters);
            final ChapterAndNovelImage _result;
            if(_cursor.moveToFirst()) {
              final NovelImageEntity _tmpNovelImage;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfNovelId) && _cursor.isNull(_cursorIndexOfTitle) && _cursor.isNull(_cursorIndexOfChapterCount) && _cursor.isNull(_cursorIndexOfImage))) {
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
                _tmpNovelImage = new NovelImageEntity(_tmpId,_tmpNovelId,_tmpTitle,_tmpChapterCount,_tmpImage);
              }  else  {
                _tmpNovelImage = null;
              }
              ArrayList<ChapterEntity> _tmpChaptersCollection_1 = null;
              final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
              _tmpChaptersCollection_1 = _collectionChapters.get(_tmpKey_1);
              if (_tmpChaptersCollection_1 == null) {
                _tmpChaptersCollection_1 = new ArrayList<ChapterEntity>();
              }
              _result = new ChapterAndNovelImage(_tmpNovelImage,_tmpChaptersCollection_1);
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
  public Flow<ChapterEntity> getChapterBySlug(final String slug) {
    final String _sql = "SELECT * FROM chapter_novel WHERE slug = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (slug == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, slug);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"chapter_novel"}, new Callable<ChapterEntity>() {
      @Override
      public ChapterEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final int _cursorIndexOfNovelId = CursorUtil.getColumnIndexOrThrow(_cursor, "novelId");
          final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "slug");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfChapter = CursorUtil.getColumnIndexOrThrow(_cursor, "chapter");
          final ChapterEntity _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCreated_at;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreated_at = null;
            } else {
              _tmpCreated_at = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final int _tmpNovelId;
            _tmpNovelId = _cursor.getInt(_cursorIndexOfNovelId);
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
            final String _tmpChapter;
            if (_cursor.isNull(_cursorIndexOfChapter)) {
              _tmpChapter = null;
            } else {
              _tmpChapter = _cursor.getString(_cursorIndexOfChapter);
            }
            _result = new ChapterEntity(_tmpId,_tmpCreated_at,_tmpNovelId,_tmpSlug,_tmpTitle,_tmpChapter);
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
  public Object deleteChapters(final List<Integer> ids,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        StringBuilder _stringBuilder = StringUtil.newStringBuilder();
        _stringBuilder.append("DELETE FROM chapter_novel WHERE id in (");
        final int _inputSize = ids.size();
        StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
        _stringBuilder.append(")");
        final String _sql = _stringBuilder.toString();
        final SupportSQLiteStatement _stmt = __db.compileStatement(_sql);
        int _argIndex = 1;
        for (Integer _item : ids) {
          if (_item == null) {
            _stmt.bindNull(_argIndex);
          } else {
            _stmt.bindLong(_argIndex, _item);
          }
          _argIndex ++;
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshipchapterNovelAscomExampleDataLocalEntitiesChapterEntity(
      final LongSparseArray<ArrayList<ChapterEntity>> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<ArrayList<ChapterEntity>> _tmpInnerMap = new LongSparseArray<ArrayList<ChapterEntity>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipchapterNovelAscomExampleDataLocalEntitiesChapterEntity(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<ArrayList<ChapterEntity>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipchapterNovelAscomExampleDataLocalEntitiesChapterEntity(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`created_at`,`novelId`,`slug`,`title`,`chapter` FROM `chapter_novel` WHERE `novelId` IN (");
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
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "novelId");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfCreatedAt = 1;
      final int _cursorIndexOfNovelId = 2;
      final int _cursorIndexOfSlug = 3;
      final int _cursorIndexOfTitle = 4;
      final int _cursorIndexOfChapter = 5;
      while(_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_itemKeyIndex);
        ArrayList<ChapterEntity> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final ChapterEntity _item_1;
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          final String _tmpCreated_at;
          if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
            _tmpCreated_at = null;
          } else {
            _tmpCreated_at = _cursor.getString(_cursorIndexOfCreatedAt);
          }
          final int _tmpNovelId;
          _tmpNovelId = _cursor.getInt(_cursorIndexOfNovelId);
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
          final String _tmpChapter;
          if (_cursor.isNull(_cursorIndexOfChapter)) {
            _tmpChapter = null;
          } else {
            _tmpChapter = _cursor.getString(_cursorIndexOfChapter);
          }
          _item_1 = new ChapterEntity(_tmpId,_tmpCreated_at,_tmpNovelId,_tmpSlug,_tmpTitle,_tmpChapter);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
