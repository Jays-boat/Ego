package com.jayboat.ego.utils

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.jayboat.ego.App

class SQLHelper : SQLiteOpenHelper(App.getAppContext(), NAME, null, VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.apply {
            execSQL(CREATE_TABLE_MUSIC_STATE)
            execSQL(CREATE_TABLE_MUSIC_COMMEND)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    companion object {
        const val VERSION = 1
        const val NAME = "music"
        private const val CREATE_TABLE_MUSIC_STATE =
                "CREATE TABLE music_state (" +
                        "id INTEGER PRIMARY KEY NOT NULL," +
                        "name VARCHAR(50) DEFAULT ''," +
                        "img_url TEXT DEFAULT ''," +
                        "artists VARCHAR(100) DEFAULT ''," +
                        "like INTEGER DEFAULT 0," +
                        "star INTEGER DEFAULT 0" +
                        ")"

        private const val CREATE_TABLE_MUSIC_COMMEND =
                "CREATE TABLE music_commend (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "music_id INTEGER NOT NULL," +
                        "commend TEXT DEFAULT 'null'," +
                        "FOREIGN KEY(music_id) REFERENCES music_state(id)" +
                        ")"

    }

}