package cg.fongwama.densipara.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cg.fongwama.densipara.R;
import cg.fongwama.densipara.dao.AnalyseDao;
import cg.fongwama.densipara.dao.DbHandler;
import cg.fongwama.densipara.model.Analyse;

/**
 * Created by HP Notebook on 03/10/2017.
 */
public class SauvegardeFragment extends Fragment{
    private RecyclerView recyclerView;
    private AnalyseDao analyseDao;
    private List<Analyse> analyses;
    public SauvegardeFragment(){


    }
    public void findAll(){
        Cursor cursor=analyseDao.findAll();
        if (cursor.getCount()==0){

        }else{
            int indexNomPatient=cursor.getColumnIndex(DbHandler.NOM_PATIENT);
            int indexNomTech=cursor.getColumnIndex(DbHandler.NOM_TECHNICIEN);
            int indexNbrePara=cursor.getColumnIndex(DbHandler.NBRE_PARASITE);
            int indexNbreGlobule=cursor.getColumnIndex(DbHandler.NBRE_GLOBULE_BLANC);
            int indexGbSang=cursor.getColumnIndex(DbHandler.NBRE_GLOBULE_BLANC_SANGE);
            int indexResultat=cursor.getColumnIndex(DbHandler.RESULTAT_ANALYSE);
            try {
                while (cursor.moveToNext()){
                    Analyse analyse=new Analyse();
                    analyse.setNomPatient(cursor.getString(indexNomPatient));
                    analyse.setNomTechnicien(cursor.getString(indexNomTech));
                    analyse.setNbreParasite(cursor.getInt(indexNbrePara));
                    analyse.setNbreGlobuleBlanc(cursor.getInt(indexNbreGlobule));
                    analyse.setNbreGlobParSang(cursor.getInt(indexGbSang));
                    analyse.setResutatAnaluse(cursor.getInt(indexResultat));
                    analyses.add(analyse);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            analyseDao.getDb().close();
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v=inflater.inflate(R.layout.sve_fragment,container,false);
        analyses=new ArrayList<>();
        analyseDao=new AnalyseDao(v.getContext());

        findAll();
        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerview);
      return v;
    }
}
