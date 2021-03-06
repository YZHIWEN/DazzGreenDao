package com.yzw.otherdao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.yzw.OtherInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "OTHER_INFO".
*/
public class OtherInfoDao extends AbstractDao<OtherInfo, String> {

    public static final String TABLENAME = "OTHER_INFO";

    /**
     * Properties of entity OtherInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property IsOk = new Property(1, Boolean.class, "isOk", false, "IS_OK");
        public final static Property Info = new Property(2, String.class, "info", false, "INFO");
    };


    public OtherInfoDao(DaoConfig config) {
        super(config);
    }
    
    public OtherInfoDao(DaoConfig config, OtherDaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"OTHER_INFO\" (" + //
                "\"ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "\"IS_OK\" INTEGER," + // 1: isOk
                "\"INFO\" TEXT);"); // 2: info
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"OTHER_INFO\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, OtherInfo entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        Boolean isOk = entity.getIsOk();
        if (isOk != null) {
            stmt.bindLong(2, isOk ? 1L: 0L);
        }
 
        String info = entity.getInfo();
        if (info != null) {
            stmt.bindString(3, info);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public OtherInfo readEntity(Cursor cursor, int offset) {
        OtherInfo entity = new OtherInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getShort(offset + 1) != 0, // isOk
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // info
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, OtherInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setIsOk(cursor.isNull(offset + 1) ? null : cursor.getShort(offset + 1) != 0);
        entity.setInfo(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(OtherInfo entity, long rowId) {
        return entity.getId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(OtherInfo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
