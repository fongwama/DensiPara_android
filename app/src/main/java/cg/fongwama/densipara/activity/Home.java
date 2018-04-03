package cg.fongwama.densipara.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cg.fongwama.densipara.R;
import cg.fongwama.densipara.adapter.HomeAdapter;
import cg.fongwama.densipara.dao.AnalyseDao;
import cg.fongwama.densipara.dao.DbHandler;
import cg.fongwama.densipara.model.Analyse;
/**
 * Created by Orion WAMBERT on 01/04/2018.
 */
public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private AnalyseDao analyseDao;
    private RecyclerView recyclerView;
    private List<Analyse> analyses;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        init();
        findAll();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        HomeAdapter homeAdapter=new HomeAdapter(this,analyses);
        recyclerView.setAdapter(homeAdapter);


    }
    public void findAll(){
        Cursor cursor=analyseDao.findAll();
        if (cursor.getCount()==0){
            cardView.setVisibility(View.VISIBLE);
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
    public void init(){

        cardView=(CardView)findViewById(R.id.card_invisible);
        analyses=new ArrayList<>();
        recyclerView=(RecyclerView)findViewById(R.id.accueil_recy);
        analyseDao=new AnalyseDao(getApplicationContext());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.accueil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent =new Intent(Home.this,About.class);
            startActivity(intent);
            return true;
        }else if(id==R.id.action_nouveau){
            Intent intent=new Intent(Home.this,Nouveau.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

         if (id == R.id.nav_gallery) {
            Intent intent=new Intent(Home.this,Nouveau.class);
             startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
             Intent intent=new Intent(Home.this,About.class);
             startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
