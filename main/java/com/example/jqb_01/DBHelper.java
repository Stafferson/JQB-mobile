package com.example.jqb_01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "profhelper";
    public static final String TABLE_IS_CHECKED = "checker_year";
    public static final String TABLE_LESSIONS_FIRST =  "year_first";
    //public static final String TABLE_PROFESSIONS = "professions";
    public static final String TABLE_LESSIONS_SECOND =  "year_second";
    public static final String TABLE_LESSIONS_THIRD =  "year_third";
    public static final String TABLE_LESSIONS_FOURTH =  "year_fourth";
    public static final String TABLE_USER_INFO =  "user_info";



    public static final String KEY_ID = "_id";
    public static final String KEY_LESSION_NAME = "lession_name";
    public static final String KEY_LESSION_MARK = "lession_mark";
    public static final String KEY_LESSION_CHECKED = "lession_checked";

    public static final String KEY_USER_NAME = "user_name";
    public static final String KEY_USER_AGE = "user_age";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //String sql = "create table School_Lessions (_id integer primary key, Les_Name text)";
        //db.execSQL(sql);
        /*db.execSQL("create table " + TABLE_LESSIONS + "(" + KEY_ID
                + " integer primary key," + KEY_LESSION_NAME + " text" + ")");*/

        db.execSQL("create table " + TABLE_USER_INFO + "(" + KEY_ID
                + " integer primary key," + KEY_USER_NAME + " text," + KEY_USER_AGE + " integer," + KEY_LESSION_CHECKED + " integer" + ")");


        db.execSQL("create table " + TABLE_LESSIONS_FIRST + "(" + KEY_ID
                + " integer primary key," + KEY_LESSION_NAME + " text," + KEY_LESSION_MARK + " integer," + KEY_LESSION_CHECKED + " integer" + ")");


        db.execSQL("create table " + TABLE_LESSIONS_SECOND + "(" + KEY_ID
                + " integer primary key," + KEY_LESSION_NAME + " text," + KEY_LESSION_MARK + " integer," + KEY_LESSION_CHECKED + " integer" + ")");


        db.execSQL("create table " + TABLE_LESSIONS_THIRD + "(" + KEY_ID
                + " integer primary key," + KEY_LESSION_NAME + " text," + KEY_LESSION_MARK + " integer," + KEY_LESSION_CHECKED + " integer" + ")");


        db.execSQL("create table " + TABLE_LESSIONS_FOURTH + "(" + KEY_ID
                + " integer primary key," + KEY_LESSION_NAME + " text," + KEY_LESSION_MARK + " integer," + KEY_LESSION_CHECKED + " integer" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " +  TABLE_USER_INFO);
        db.execSQL("drop table if exists " +  TABLE_LESSIONS_FIRST);
        db.execSQL("drop table if exists " +  TABLE_LESSIONS_SECOND);
        db.execSQL("drop table if exists " +  TABLE_LESSIONS_THIRD);
        db.execSQL("drop table if exists " +  TABLE_LESSIONS_FOURTH);
        db.execSQL("drop table if exists " +  TABLE_IS_CHECKED);
        onCreate(db);
    }
}
