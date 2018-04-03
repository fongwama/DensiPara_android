package cg.fongwama.densipara.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Orion WAMBERT on 01/04/2018.
 */
public class DbHandler  extends SQLiteOpenHelper{

    public static final String ID_ANALYSE="id_analyse";
    public static final String NOM_PATIENT="nom_patient";
    public static final String NOM_TECHNICIEN="nom_technicien";
    public static final String NBRE_PARASITE="nbre_parasite";
    public static final String NBRE_GLOBULE_BLANC="nbre_globule_blanc";
    public static final String NBRE_GLOBULE_BLANC_SANGE="nbre_globule_blanc_sang";
    public static final String RESULTAT_ANALYSE="resultat_analyse";
    public static final String DATE_ANALYSE="date_analyse";
    public static final String NOM_TABLE="tbl_analyse";
    public static final String CREATE_TABLE="CREATE TABLE "+NOM_TABLE+" ("+
            ID_ANALYSE +" INTEGER AUTO_INCREMENT PRIMARY KEY,"
            +NOM_PATIENT+" varchar(45),"
            +NOM_TECHNICIEN +" varchar(45),"
            +NBRE_PARASITE + " INTEGER ,"
            +NBRE_GLOBULE_BLANC+" INTEGER ,"
            +NBRE_GLOBULE_BLANC_SANGE+" INTEGER ,"
            +RESULTAT_ANALYSE+" INTEGER ,"
            +DATE_ANALYSE+" TIMESTAMP )";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + NOM_TABLE + ";";



    public DbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
}
