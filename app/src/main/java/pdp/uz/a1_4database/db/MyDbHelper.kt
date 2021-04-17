package pdp.uz.a1_4database.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import pdp.uz.a1_4database.models.Phone
import pdp.uz.a1_4database.utils.Constant

class MyDbHelper(context: Context) :
    SQLiteOpenHelper(context, Constant.DB_NAME, null, Constant.VERSION), DatabaseService {
    override fun onCreate(db: SQLiteDatabase?) {
        val query =
            "create table ${Constant.TABLE_NAME} (${Constant.ID} integer not null primary key autoincrement unique, ${Constant.GROUPS} text not null, ${Constant.NAME} text not null, ${Constant.INFO} text not null)"

        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists ${Constant.TABLE_NAME}")
        onCreate(db)
    }

    override fun addPhone(phone: Phone) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constant.GROUPS, phone.group)
        contentValues.put(Constant.NAME, phone.name)
        contentValues.put(Constant.INFO, phone.info)
        database.insert(Constant.TABLE_NAME, null, contentValues)
        database.close()
    }

    override fun getPhoneById(id: Int): Phone {
        val database = this.readableDatabase
        val cursor = database.query(
            Constant.TABLE_NAME,
            arrayOf(Constant.ID, Constant.GROUPS, Constant.NAME, Constant.INFO),
            "${Constant.ID} = ?",
            arrayOf(id.toString()),
            null,
            null,
            null
        )
        cursor?.moveToFirst()
        return Phone(
            cursor.getInt(0),
            cursor.getString(1),
            cursor.getString(2),
            cursor.getString(3)
        )
    }

    override fun getAllPhones(): ArrayList<Phone> {
        val arrayList = ArrayList<Phone>()
        val query = "select * from ${Constant.TABLE_NAME}"
        val database = this.readableDatabase
        val cursor = database.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val phone = Phone(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
                )
                arrayList.add(phone)
            } while (cursor.moveToNext())
        }
        return arrayList
    }
}