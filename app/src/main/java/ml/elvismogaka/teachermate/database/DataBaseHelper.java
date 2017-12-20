package ml.elvismogaka.teachermate.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ml.elvismogaka.teachermate.ui.AddClassFragment;

/**
 * Created by mosoti on 12/19/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="School.db";
    public static final String CLASS_NAME="class_table";
    public static final String Col1="ID";
    public static final String Col2="name";
    public static final String Col3="classteacher";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME,null,2);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+ CLASS_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,CLASSTEACHER TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CLASS_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean insertClass(String name,String classteacher){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col2,name);
        contentValues.put(Col3,classteacher);
        long result=sqLiteDatabase.insert(CLASS_NAME,null,contentValues);
        if(result== -1)
            return false;
        else
        return true;

    }
}
