package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";


    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(3369,'Sahil Shaikh', 'sahilshaikh@gmail.com','1111','0000000000', 1055000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3370,'Elon Musk', 'elonmusk@gmail.com','1111','0000000000', 50000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3371,'Bernard Arnault', 'BernardArnault@gmail.com','1111','0000000000', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3372,'Jeff Bezos', 'JeffBezos@gmail.com','1111','0000000000', 80000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3373,'Bill Gates', 'BillGates@gmail.com','1111','0000000000', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3374,'Larry Ellison', 'LarryEllison@gmail.com','1111','0000000000', 500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3375,'Larry Page', 'LarryPage@gmail.com','1111','0000000000', 400)");
        db.execSQL("insert into " + TABLE_NAME + " values(3376,'Mark Zuckerberg', 'MarkZuckerberg@gmail.com','1111','0000000000', 20500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3377,'Warren Buffett', 'WarrenBuffett@gmail.com','1111','0000000000', 100500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3378,'Sergey Brin', 'SergeyBrin@gmail.com','1111','0000000000', 99900)");
        db.execSQL("insert into " + TABLE_NAME + " values(3379,'Carlos Slim', 'CarlosSlim@gmail.com','1111','0000000000', 92800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3380,'Jim Walton', 'JimWalton@gmail.com','1111','0000000000', 110030)");
        db.execSQL("insert into " + TABLE_NAME + " values(3381,'Rob Walton', 'RobWalton@gmail.com','1111','0000000000', 584400)");
        db.execSQL("insert into " + TABLE_NAME + " values(3382,'Michael Dell', 'MichaelDell@gmail.com','1111','0000000000', 25)");
        db.execSQL("insert into " + TABLE_NAME + " values(3383,'Charles Koch', 'CharlesKoch@gmail.com','1111','0000000000', 6210)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}