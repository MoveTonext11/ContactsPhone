package com.anrong.contaactsphone.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.anrong.contaactsphone.Bean.MessageInfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/16.
 * 创建数据库管理工具类
 */

public class SqliteUtils {

    private Context context;
    MessageInfoSqlite msgsqlite = null;
    private SQLiteDatabase db;
    private Cursor cursor;
    private long cymessage;

    public SqliteUtils(Context context) {
        this.context = context;
    }

    public MessageInfoSqlite getinstance() {
        if (msgsqlite == null) {
            msgsqlite = new MessageInfoSqlite(context);
        }
        return msgsqlite;
    }

    /**
     * 添加常用联系人数据   假数据
     */
    public long addcymessage(String name, int num, String phone) {
        try {
            db = msgsqlite.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("polecenum", String.valueOf(num));
            values.put("polecephone", phone);
            cymessage = db.insert("cymessage", null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return cymessage;
    }

    public void addcalllog(String name, long num, String phone) {
        try {
            db = msgsqlite.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("polecenum", num+"");
            values.put("polecephone", phone);
            db.insert("phonelog", null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

    /**
     * 删除数据库数据
     *
     * @param id
     * @return
     */
    public long deletemessage(String id) {
        db = msgsqlite.getWritableDatabase();
        try {
            cymessage = db.delete("cymessage", "messageid=" + id, null);
            Log.d("ceshi", cymessage + "");
        } catch (Exception e) {
        } finally {
            db.close();
        }
        return cymessage;
    }

    /**
     * 查询常用联系人
     */
    public List<MessageInfoBean> querycymessage() {
        List<MessageInfoBean> listinfo = new ArrayList<>();
        try {
            db = msgsqlite.getWritableDatabase();
            cursor = db.query("cymessage", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                MessageInfoBean bean = new MessageInfoBean();
                bean.setName(cursor.getString(cursor.getColumnIndex("name")));
                bean.setPhoneNum(cursor.getString(cursor.getColumnIndex("polecephone")));
                bean.setPoleceNum(cursor.getString(cursor.getColumnIndex("polecenum")));
                bean.id = (cursor.getString(cursor.getColumnIndex("messageid")));
                listinfo.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
            db.close();
        }
        return listinfo;
    }

    /**
     * 查询通话记录
     * @return
     */
    public List<MessageInfoBean> querycalllog() {
        List<MessageInfoBean> listinfo = new ArrayList<>();
        try {
            db = msgsqlite.getWritableDatabase();
            cursor = db.query("phonelog", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                MessageInfoBean bean = new MessageInfoBean();
                bean.setName(cursor.getString(cursor.getColumnIndex("name")));
                bean.setPhoneNum(cursor.getString(cursor.getColumnIndex("polecephone")));
                bean.setPoleceNum(cursor.getString(cursor.getColumnIndex("polecenum")));
                bean.id = (cursor.getString(cursor.getColumnIndex("messageid")));
                listinfo.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
            db.close();
        }
        return listinfo;
    }
    /**
     * 数据库内部类
     */
    public class MessageInfoSqlite extends SQLiteOpenHelper {

        public MessageInfoSqlite(Context context) {
            super(context, "messageinfo", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql1 = "CREATE TABLE cymessage(messageid integer primary key autoincrement, name varchar(20),polecenum varchar(6), polecephone varchar(11) unique)";
            String sql2 = "CREATE TABLE phonelog(messageid integer primary key autoincrement, name varchar(20),polecenum varchar(6),polecephone varchar(11) unique)";
            db.execSQL(sql1);
            db.execSQL(sql2);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

}
