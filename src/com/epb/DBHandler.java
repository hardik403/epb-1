package com.epb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {
	@SuppressWarnings("unused")
	private static final int DATABASE_VERSION = 1;
	private static String DB_NAME = "database";
	private static String DB_PATH;
	private static SQLiteDatabase mDataBase;
	private AssetManager am;

	public DBHandler(Context paramContext) {
		super(paramContext, DB_NAME, null, 1);
		try {
			this.am = paramContext.getAssets();
			DB_PATH = paramContext.getDatabasePath(getDatabaseName())
					.toString();
			Log.i("DB PATH 2:", "==" + DB_PATH);
			createDataBase();
			openDataBase();
			return;
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean checkDataBase() {
		File dbFile = new File(DB_PATH + DB_NAME);
		return dbFile.exists();
	}

	private void createDataBase() {
		// FLog.i("@@createDataBase");
		if (!checkDataBase())
			getReadableDatabase();
		try {
			copyDataBase();
			return;
		} catch (IOException localIOException) {
			localIOException.printStackTrace();
		}

	}

	private void openDataBase() throws SQLException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException,
			ClassNotFoundException {
		Log.i("@@openDataBase", "=========");
		mDataBase = SQLiteDatabase.openDatabase(DB_PATH, null, 0);
	}

	public void close() {
		if (mDataBase != null)
			mDataBase.close();
		super.close();
	}

	public void copyDataBase() throws IOException {
		InputStream localInputStream = this.am.open(DB_NAME);
		FileOutputStream localFileOutputStream = new FileOutputStream(DB_PATH);
		byte[] arrayOfByte = new byte[1024];
		while (true) {
			int i = localInputStream.read(arrayOfByte);
			if (i <= 0) {
				localFileOutputStream.flush();
				localFileOutputStream.close();
				localInputStream.close();
				return;
			}
			localFileOutputStream.write(arrayOfByte, 0, i);
		}
	}

	public void delete(String paramString1, String paramString2)
			throws SQLException {
		mDataBase.delete(paramString1, paramString2, null);
	}

	public void insert(String paramString, ContentValues paramContentValues)
			throws SQLException {
		mDataBase.insert(paramString, null, paramContentValues);
	}

	public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
	}

	public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1,
			int paramInt2) {
	}

	public Cursor select(String paramString) throws SQLException {
		return mDataBase.rawQuery(paramString, null);
	}

	public void sqlCommand(String paramString) {
		mDataBase.execSQL(paramString);
	}

	public void update(String paramString1, ContentValues paramContentValues,
			String paramString2) {
		mDataBase.update(paramString1, paramContentValues, paramString2, null);
	}
}
