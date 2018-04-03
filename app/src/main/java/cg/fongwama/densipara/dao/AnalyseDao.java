package cg.fongwama.densipara.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import cg.fongwama.densipara.model.Analyse;

/**
 * Created by Orion WAMBERT on 01/04/2018.
 */
public class AnalyseDao extends AnalyseBase{

    public AnalyseDao(Context pContext) {
        super(pContext);
    }

    public boolean insert(Analyse analyse){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DbHandler.NOM_PATIENT,analyse.getNomPatient());
        contentValues.put(DbHandler.NOM_TECHNICIEN,analyse.getNomTechnicien());
        contentValues.put(DbHandler.NBRE_PARASITE,analyse.getNbreParasite());
        contentValues.put(DbHandler.NBRE_GLOBULE_BLANC,analyse.getNbreGlobuleBlanc());
        contentValues.put(DbHandler.NBRE_GLOBULE_BLANC_SANGE,analyse.getNbreGlobParSang());
        contentValues.put(DbHandler.RESULTAT_ANALYSE,analyse.getResutatAnaluse());
        open();
        long result=mDb.insert(DbHandler.NOM_TABLE,null,contentValues);
        if (result==-1){
            close();
            return false;
        }else{
            close();
            return true;
        }

    }
    public Cursor findAll(){
        open();
        Cursor cursor=mDb.rawQuery("SELECT * FROM "+DbHandler.NOM_TABLE,null);
        return cursor;
    }


}
