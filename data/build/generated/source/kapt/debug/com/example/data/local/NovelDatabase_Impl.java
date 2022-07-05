package com.example.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.data.local.daos.CategoryDao;
import com.example.data.local.daos.CategoryDao_Impl;
import com.example.data.local.daos.FollowingDao;
import com.example.data.local.daos.FollowingDao_Impl;
import com.example.data.local.daos.HistoryDao;
import com.example.data.local.daos.HistoryDao_Impl;
import com.example.data.local.daos.HistoryNovelDao;
import com.example.data.local.daos.HistoryNovelDao_Impl;
import com.example.data.local.daos.LastRequestDao;
import com.example.data.local.daos.LastRequestDao_Impl;
import com.example.data.local.daos.NovelHistoryDao;
import com.example.data.local.daos.NovelHistoryDao_Impl;
import com.example.data.local.daos.NovelImageDao;
import com.example.data.local.daos.NovelImageDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class NovelDatabase_Impl extends NovelDatabase {
  private volatile HistoryDao _historyDao;

  private volatile FollowingDao _followingDao;

  private volatile CategoryDao _categoryDao;

  private volatile LastRequestDao _lastRequestDao;

  private volatile HistoryNovelDao _historyNovelDao;

  private volatile NovelHistoryDao _novelHistoryDao;

  private volatile NovelImageDao _novelImageDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `history_search` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `label` TEXT NOT NULL, `slug` TEXT NOT NULL, `title` TEXT NOT NULL, `timestamp` INTEGER, `isInHistory` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `following_novels` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `added` TEXT, `chapters` INTEGER NOT NULL, `cover` BLOB, `options` TEXT NOT NULL, `progress` INTEGER NOT NULL, `slug` TEXT NOT NULL, `title` TEXT NOT NULL, `updated` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `category_table` (`id` INTEGER NOT NULL, `title` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `last_requests` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `request` TEXT NOT NULL, `entity_id` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL)");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_last_requests_request_entity_id` ON `last_requests` (`request`, `entity_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `history_entries` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `novel_id` INTEGER NOT NULL, `page` INTEGER NOT NULL, `page_order` INTEGER NOT NULL)");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_history_entries_novel_id` ON `history_entries` (`novel_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `novel_history` (`id` INTEGER NOT NULL, `chapters` INTEGER NOT NULL, `last_chapter` TEXT NOT NULL, `last_chapter_slug` TEXT NOT NULL, `novel_cover` TEXT NOT NULL, `novel_slug` TEXT NOT NULL, `novel_title` TEXT NOT NULL, `progress` INTEGER NOT NULL, `rank` INTEGER NOT NULL, `viewed_on` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `novel_images` (`id` INTEGER NOT NULL, `novel_id` INTEGER NOT NULL, `image` BLOB NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`novel_id`) REFERENCES `novel_history`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_novel_images_novel_id` ON `novel_images` (`novel_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'fc9860a375e04a10928f74ba1929d49a')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `history_search`");
        _db.execSQL("DROP TABLE IF EXISTS `following_novels`");
        _db.execSQL("DROP TABLE IF EXISTS `category_table`");
        _db.execSQL("DROP TABLE IF EXISTS `last_requests`");
        _db.execSQL("DROP TABLE IF EXISTS `history_entries`");
        _db.execSQL("DROP TABLE IF EXISTS `novel_history`");
        _db.execSQL("DROP TABLE IF EXISTS `novel_images`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsHistorySearch = new HashMap<String, TableInfo.Column>(6);
        _columnsHistorySearch.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistorySearch.put("label", new TableInfo.Column("label", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistorySearch.put("slug", new TableInfo.Column("slug", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistorySearch.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistorySearch.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistorySearch.put("isInHistory", new TableInfo.Column("isInHistory", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHistorySearch = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHistorySearch = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHistorySearch = new TableInfo("history_search", _columnsHistorySearch, _foreignKeysHistorySearch, _indicesHistorySearch);
        final TableInfo _existingHistorySearch = TableInfo.read(_db, "history_search");
        if (! _infoHistorySearch.equals(_existingHistorySearch)) {
          return new RoomOpenHelper.ValidationResult(false, "history_search(com.example.data.local.entities.HistorySearchEntity).\n"
                  + " Expected:\n" + _infoHistorySearch + "\n"
                  + " Found:\n" + _existingHistorySearch);
        }
        final HashMap<String, TableInfo.Column> _columnsFollowingNovels = new HashMap<String, TableInfo.Column>(9);
        _columnsFollowingNovels.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFollowingNovels.put("added", new TableInfo.Column("added", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFollowingNovels.put("chapters", new TableInfo.Column("chapters", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFollowingNovels.put("cover", new TableInfo.Column("cover", "BLOB", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFollowingNovels.put("options", new TableInfo.Column("options", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFollowingNovels.put("progress", new TableInfo.Column("progress", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFollowingNovels.put("slug", new TableInfo.Column("slug", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFollowingNovels.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFollowingNovels.put("updated", new TableInfo.Column("updated", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFollowingNovels = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFollowingNovels = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFollowingNovels = new TableInfo("following_novels", _columnsFollowingNovels, _foreignKeysFollowingNovels, _indicesFollowingNovels);
        final TableInfo _existingFollowingNovels = TableInfo.read(_db, "following_novels");
        if (! _infoFollowingNovels.equals(_existingFollowingNovels)) {
          return new RoomOpenHelper.ValidationResult(false, "following_novels(com.example.data.local.entities.FollowingEntity).\n"
                  + " Expected:\n" + _infoFollowingNovels + "\n"
                  + " Found:\n" + _existingFollowingNovels);
        }
        final HashMap<String, TableInfo.Column> _columnsCategoryTable = new HashMap<String, TableInfo.Column>(2);
        _columnsCategoryTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategoryTable.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategoryTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCategoryTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategoryTable = new TableInfo("category_table", _columnsCategoryTable, _foreignKeysCategoryTable, _indicesCategoryTable);
        final TableInfo _existingCategoryTable = TableInfo.read(_db, "category_table");
        if (! _infoCategoryTable.equals(_existingCategoryTable)) {
          return new RoomOpenHelper.ValidationResult(false, "category_table(com.example.data.local.entities.CategoryEntity).\n"
                  + " Expected:\n" + _infoCategoryTable + "\n"
                  + " Found:\n" + _existingCategoryTable);
        }
        final HashMap<String, TableInfo.Column> _columnsLastRequests = new HashMap<String, TableInfo.Column>(4);
        _columnsLastRequests.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLastRequests.put("request", new TableInfo.Column("request", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLastRequests.put("entity_id", new TableInfo.Column("entity_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLastRequests.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLastRequests = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLastRequests = new HashSet<TableInfo.Index>(1);
        _indicesLastRequests.add(new TableInfo.Index("index_last_requests_request_entity_id", true, Arrays.asList("request","entity_id"), Arrays.asList("ASC","ASC")));
        final TableInfo _infoLastRequests = new TableInfo("last_requests", _columnsLastRequests, _foreignKeysLastRequests, _indicesLastRequests);
        final TableInfo _existingLastRequests = TableInfo.read(_db, "last_requests");
        if (! _infoLastRequests.equals(_existingLastRequests)) {
          return new RoomOpenHelper.ValidationResult(false, "last_requests(com.example.data.local.entities.LastRequest).\n"
                  + " Expected:\n" + _infoLastRequests + "\n"
                  + " Found:\n" + _existingLastRequests);
        }
        final HashMap<String, TableInfo.Column> _columnsHistoryEntries = new HashMap<String, TableInfo.Column>(4);
        _columnsHistoryEntries.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistoryEntries.put("novel_id", new TableInfo.Column("novel_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistoryEntries.put("page", new TableInfo.Column("page", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistoryEntries.put("page_order", new TableInfo.Column("page_order", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHistoryEntries = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHistoryEntries = new HashSet<TableInfo.Index>(1);
        _indicesHistoryEntries.add(new TableInfo.Index("index_history_entries_novel_id", true, Arrays.asList("novel_id"), Arrays.asList("ASC")));
        final TableInfo _infoHistoryEntries = new TableInfo("history_entries", _columnsHistoryEntries, _foreignKeysHistoryEntries, _indicesHistoryEntries);
        final TableInfo _existingHistoryEntries = TableInfo.read(_db, "history_entries");
        if (! _infoHistoryEntries.equals(_existingHistoryEntries)) {
          return new RoomOpenHelper.ValidationResult(false, "history_entries(com.example.data.local.entities.HistoryNovelEntry).\n"
                  + " Expected:\n" + _infoHistoryEntries + "\n"
                  + " Found:\n" + _existingHistoryEntries);
        }
        final HashMap<String, TableInfo.Column> _columnsNovelHistory = new HashMap<String, TableInfo.Column>(10);
        _columnsNovelHistory.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNovelHistory.put("chapters", new TableInfo.Column("chapters", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNovelHistory.put("last_chapter", new TableInfo.Column("last_chapter", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNovelHistory.put("last_chapter_slug", new TableInfo.Column("last_chapter_slug", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNovelHistory.put("novel_cover", new TableInfo.Column("novel_cover", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNovelHistory.put("novel_slug", new TableInfo.Column("novel_slug", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNovelHistory.put("novel_title", new TableInfo.Column("novel_title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNovelHistory.put("progress", new TableInfo.Column("progress", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNovelHistory.put("rank", new TableInfo.Column("rank", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNovelHistory.put("viewed_on", new TableInfo.Column("viewed_on", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNovelHistory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNovelHistory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNovelHistory = new TableInfo("novel_history", _columnsNovelHistory, _foreignKeysNovelHistory, _indicesNovelHistory);
        final TableInfo _existingNovelHistory = TableInfo.read(_db, "novel_history");
        if (! _infoNovelHistory.equals(_existingNovelHistory)) {
          return new RoomOpenHelper.ValidationResult(false, "novel_history(com.example.data.local.entities.HistoryNovelEntity).\n"
                  + " Expected:\n" + _infoNovelHistory + "\n"
                  + " Found:\n" + _existingNovelHistory);
        }
        final HashMap<String, TableInfo.Column> _columnsNovelImages = new HashMap<String, TableInfo.Column>(3);
        _columnsNovelImages.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNovelImages.put("novel_id", new TableInfo.Column("novel_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNovelImages.put("image", new TableInfo.Column("image", "BLOB", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNovelImages = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysNovelImages.add(new TableInfo.ForeignKey("novel_history", "CASCADE", "CASCADE",Arrays.asList("novel_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesNovelImages = new HashSet<TableInfo.Index>(1);
        _indicesNovelImages.add(new TableInfo.Index("index_novel_images_novel_id", false, Arrays.asList("novel_id"), Arrays.asList("ASC")));
        final TableInfo _infoNovelImages = new TableInfo("novel_images", _columnsNovelImages, _foreignKeysNovelImages, _indicesNovelImages);
        final TableInfo _existingNovelImages = TableInfo.read(_db, "novel_images");
        if (! _infoNovelImages.equals(_existingNovelImages)) {
          return new RoomOpenHelper.ValidationResult(false, "novel_images(com.example.data.local.entities.NovelImageEntity).\n"
                  + " Expected:\n" + _infoNovelImages + "\n"
                  + " Found:\n" + _existingNovelImages);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "fc9860a375e04a10928f74ba1929d49a", "5de7a3e6a7989428c51202b60b81fb35");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "history_search","following_novels","category_table","last_requests","history_entries","novel_history","novel_images");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `history_search`");
      _db.execSQL("DELETE FROM `following_novels`");
      _db.execSQL("DELETE FROM `category_table`");
      _db.execSQL("DELETE FROM `last_requests`");
      _db.execSQL("DELETE FROM `history_entries`");
      _db.execSQL("DELETE FROM `novel_history`");
      _db.execSQL("DELETE FROM `novel_images`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(HistoryDao.class, HistoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FollowingDao.class, FollowingDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CategoryDao.class, CategoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(LastRequestDao.class, LastRequestDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(HistoryNovelDao.class, HistoryNovelDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(NovelHistoryDao.class, NovelHistoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(NovelImageDao.class, NovelImageDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList(new NovelDatabase_AutoMigration_1_2_Impl());
  }

  @Override
  public HistoryDao showHistorySearch() {
    if (_historyDao != null) {
      return _historyDao;
    } else {
      synchronized(this) {
        if(_historyDao == null) {
          _historyDao = new HistoryDao_Impl(this);
        }
        return _historyDao;
      }
    }
  }

  @Override
  public FollowingDao showFollowings() {
    if (_followingDao != null) {
      return _followingDao;
    } else {
      synchronized(this) {
        if(_followingDao == null) {
          _followingDao = new FollowingDao_Impl(this);
        }
        return _followingDao;
      }
    }
  }

  @Override
  public CategoryDao showCategories() {
    if (_categoryDao != null) {
      return _categoryDao;
    } else {
      synchronized(this) {
        if(_categoryDao == null) {
          _categoryDao = new CategoryDao_Impl(this);
        }
        return _categoryDao;
      }
    }
  }

  @Override
  public LastRequestDao lastRequestDao() {
    if (_lastRequestDao != null) {
      return _lastRequestDao;
    } else {
      synchronized(this) {
        if(_lastRequestDao == null) {
          _lastRequestDao = new LastRequestDao_Impl(this);
        }
        return _lastRequestDao;
      }
    }
  }

  @Override
  public HistoryNovelDao historyNovelsDao() {
    if (_historyNovelDao != null) {
      return _historyNovelDao;
    } else {
      synchronized(this) {
        if(_historyNovelDao == null) {
          _historyNovelDao = new HistoryNovelDao_Impl(this);
        }
        return _historyNovelDao;
      }
    }
  }

  @Override
  public NovelHistoryDao novelHistoryDao() {
    if (_novelHistoryDao != null) {
      return _novelHistoryDao;
    } else {
      synchronized(this) {
        if(_novelHistoryDao == null) {
          _novelHistoryDao = new NovelHistoryDao_Impl(this);
        }
        return _novelHistoryDao;
      }
    }
  }

  @Override
  public NovelImageDao novelImageDao() {
    if (_novelImageDao != null) {
      return _novelImageDao;
    } else {
      synchronized(this) {
        if(_novelImageDao == null) {
          _novelImageDao = new NovelImageDao_Impl(this);
        }
        return _novelImageDao;
      }
    }
  }
}
