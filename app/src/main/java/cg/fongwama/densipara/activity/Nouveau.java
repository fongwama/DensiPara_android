package cg.fongwama.densipara.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cg.fongwama.densipara.R;
import cg.fongwama.densipara.dao.AnalyseDao;
import cg.fongwama.densipara.model.Analyse;
/**
 * Created by Orion WAMBERT on 01/04/2018.
 */
public class Nouveau extends AppCompatActivity {
    private Button btnCalcule,btnReset,btnSave;
    private EditText nbreParasite,nbreGlobulBlanc,nbreGParLSang,nomTech,nomPatient;
    private Analyse analyse;
    private TextView resultat;
    private AnalyseDao analyseDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau);
        init();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_nve);
        setSupportActionBar(toolbar);

        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        btnCalcule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(nbreGParLSang.getText().toString().trim().isEmpty()
                        && nbreParasite.getText().toString().isEmpty()
                        && nbreGlobulBlanc.getText().toString().trim().isEmpty() )){

                   int resAnal= analyse.calculer(Integer.parseInt(nbreGlobulBlanc.getText().toString().trim())
                            ,Integer.parseInt(nbreParasite.getText().toString().trim())
                            ,Integer.parseInt(nbreGParLSang.getText().toString().trim()));
                    resultat.setText(R.string.resultat_analyse+" "+resAnal);

                }else{
                    Toast.makeText(getApplicationContext(), R.string.validate_fields,Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(nomTech.getText().toString().trim().isEmpty() )){
                    if (!(nomPatient.getText().toString().trim().isEmpty())){
                           analyse.setNomTechnicien(nomTech.getText().toString().trim());
                           analyse.setNomPatient(nomPatient.getText().toString().trim());
                            if (analyseDao.insert(analyse)){
                                Toast.makeText(getApplicationContext(), R.string.success_ana,Toast.LENGTH_SHORT).show();
                                    resetAll();
                            }else{
                                Toast.makeText(getApplicationContext(), R.string.war_ana,Toast.LENGTH_SHORT).show();
                            }

                    }else{
                        Toast.makeText(getApplicationContext(), R.string.indique_patient,Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(getApplicationContext(), R.string.indique_technicien,Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public void init(){
        btnCalcule=(Button)findViewById(R.id.btn_cal);
        btnReset=(Button)findViewById(R.id.btn_reset);
        btnSave=(Button)findViewById(R.id.btn_save);
        nbreParasite=(EditText)findViewById(R.id.nbreParasite);
        nbreGlobulBlanc=(EditText)findViewById(R.id.nbreGlobule);
        nbreGParLSang=(EditText)findViewById(R.id.nbreGlobByU);
        nomTech=(EditText)findViewById(R.id.nom_Tech);
        nomPatient=(EditText)findViewById(R.id.nom_patient);
        analyse=new Analyse();
        resultat=(TextView)findViewById(R.id.text_result);
        analyseDao=new AnalyseDao(getApplicationContext());
    }
    public void reset(){
        nbreParasite.setText("");
        nbreGlobulBlanc.setText("");
        nbreGParLSang.setText("");
        resultat.setText("");
    }
    public void resetAll(){
        nbreParasite.setText("");
        nbreGlobulBlanc.setText("");
        nbreGParLSang.setText("");
        nomPatient.setText("");
        nomTech.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.nouveau, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent =new Intent(Nouveau.this,About.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
