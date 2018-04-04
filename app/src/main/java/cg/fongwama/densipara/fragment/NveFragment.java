package cg.fongwama.densipara.fragment;


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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cg.fongwama.densipara.R;
import cg.fongwama.densipara.dao.AnalyseDao;
import cg.fongwama.densipara.model.Analyse;

/**
 * Created by Orion WAMBERT on 14/10/2017.
 */
public class NveFragment extends Fragment {
    private Button btnCalcule,btnReset,btnSave;
    private EditText nbreParasite,nbreGlobulBlanc,nbreGParLSang,nomTech,nomPatient;
    private Analyse analyse;
    private TextView resultat;
    private AnalyseDao analyseDao;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.content_nouveau,container,false);
        btnCalcule=(Button)v.findViewById(R.id.btn_cal);
        btnReset=(Button)v.findViewById(R.id.btn_reset);
        btnSave=(Button)v.findViewById(R.id.btn_save);
        nbreParasite=(EditText)v.findViewById(R.id.nbreParasite);
        nbreGlobulBlanc=(EditText)v.findViewById(R.id.nbreGlobule);
        nbreGParLSang=(EditText)v.findViewById(R.id.nbreGlobByU);
        nomTech=(EditText)v.findViewById(R.id.nom_Tech);
        nomPatient=(EditText)v.findViewById(R.id.nom_patient);
        analyse=new Analyse();
        resultat=(TextView)v.findViewById(R.id.text_result);
        analyseDao=new AnalyseDao(v.getContext());
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
                    Toast.makeText(v.getContext(), R.string.validate_fields,Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(v.getContext(), R.string.success_ana,Toast.LENGTH_SHORT).show();
                            resetAll();
                        }else{
                            Toast.makeText(v.getContext(), R.string.war_ana,Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(v.getContext(), R.string.indique_patient,Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(v.getContext(), R.string.indique_technicien,Toast.LENGTH_SHORT).show();
                }
            }
        });




        return v;
    }






}
