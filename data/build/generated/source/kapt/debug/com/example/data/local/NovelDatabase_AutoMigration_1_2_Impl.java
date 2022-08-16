package com.example.data.local;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.lang.Override;
import java.lang.SuppressWarnings;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
class NovelDatabase_AutoMigration_1_2_Impl extends Migration {
  public NovelDatabase_AutoMigration_1_2_Impl() {
    super(1, 2);
  }

  @Override
  public void migrate(@NonNull SupportSQLiteDatabase database) {
    database.execSQL("CREATE TABLE IF NOT EXISTS `last_requests` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `request` TEXT NOT NULL, `entity_id` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL)");
    database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_last_requests_request_entity_id` ON `last_requests` (`request`, `entity_id`)");
    database.execSQL("CREATE TABLE IF NOT EXISTS `novel_history` (`id` INTEGER NOT NULL, `chapters` INTEGER NOT NULL, `last_chapter` TEXT NOT NULL, `last_chapter_slug` TEXT NOT NULL, `novel_cover` TEXT NOT NULL, `novel_slug` TEXT NOT NULL, `novel_title` TEXT NOT NULL, `progress` INTEGER NOT NULL, `rank` INTEGER NOT NULL, `viewed_on` TEXT NOT NULL, PRIMARY KEY(`id`))");
    database.execSQL("CREATE TABLE IF NOT EXISTS `chapter_novel` (`id` INTEGER NOT NULL, `created_at` TEXT NOT NULL, `novelId` INTEGER NOT NULL, `slug` TEXT NOT NULL, `title` TEXT NOT NULL, `chapter` TEXT NOT NULL, PRIMARY KEY(`id`))");
    database.execSQL("CREATE TABLE IF NOT EXISTS `novel_images` (`id` INTEGER NOT NULL, `novel_id` INTEGER NOT NULL, `title` TEXT NOT NULL, `chapterCount` INTEGER NOT NULL, `image` BLOB NOT NULL, PRIMARY KEY(`id`))");
    database.execSQL("CREATE TABLE IF NOT EXISTS `history_entries` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `novel_id` INTEGER NOT NULL, `page` INTEGER NOT NULL, `page_order` INTEGER NOT NULL)");
    database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_history_entries_novel_id` ON `history_entries` (`novel_id`)");
    database.execSQL("CREATE TABLE IF NOT EXISTS `category_table` (`id` INTEGER NOT NULL, `title` TEXT NOT NULL, PRIMARY KEY(`id`))");
    database.execSQL("CREATE TABLE IF NOT EXISTS `_new_following_novels` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `added` TEXT, `chapters` INTEGER NOT NULL, `cover` BLOB, `options` TEXT NOT NULL, `progress` INTEGER NOT NULL, `slug` TEXT NOT NULL, `title` TEXT NOT NULL, `updated` TEXT NOT NULL)");
    database.execSQL("INSERT INTO `_new_following_novels` (`cover`,`added`,`chapters`,`options`,`progress`,`id`,`title`,`updated`,`slug`) SELECT `cover`,`added`,`chapters`,`options`,`progress`,`id`,`title`,`updated`,`slug` FROM `following_novels`");
    database.execSQL("DROP TABLE `following_novels`");
    database.execSQL("ALTER TABLE `_new_following_novels` RENAME TO `following_novels`");
    database.execSQL("CREATE TABLE IF NOT EXISTS `_new_history_search` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `label` TEXT NOT NULL, `slug` TEXT NOT NULL, `title` TEXT NOT NULL, `timestamp` INTEGER, `isInHistory` INTEGER)");
    database.execSQL("INSERT INTO `_new_history_search` (`id`,`label`,`title`,`slug`) SELECT `id`,`label`,`title`,`slug` FROM `history_search`");
    database.execSQL("DROP TABLE `history_search`");
    database.execSQL("ALTER TABLE `_new_history_search` RENAME TO `history_search`");
  }
}
