package cg.fongwama.densipara.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Orion WAMBERT on 01/04/2018.
 */
public class AnalyseBase {

        protected final static int VERSION = 1;
        protected final static String NOM = "densipara.db";

        protected SQLiteDatabase mDb = null;
        private DbHandler dbHandler=null;

        public AnalyseBase(Context pContext) {
            this.dbHandler = new DbHandler(pContext, NOM, null, VERSION);
        }

        public SQLiteDatabase open() {
            mDb = dbHandler.getWritableDatabase();
            return mDb;
        }

        public void close() {
            mDb.close();
        }

        public SQLiteDatabase getDb() {
            return mDb;
        }
    }
