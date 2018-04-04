package cg.fongwama.densipara.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import cg.fongwama.densipara.R;
import cg.fongwama.densipara.model.Constante;

public class ResultatActitvity extends AppCompatActivity {
    private FloatingActionButton actionButton;
    private TextView nomPatient,resultaAnal;,
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_actitvity);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        actionButton=(FloatingActionButton)findViewById(R.id.mapchanger);
        nomPatient=(TextView)findViewById(R.id.anaNomPatient);
        resultaAnal=(TextView)findViewById(R.id.anaResultat);
        toolbar.setTitleTextColor(Color.WHITE);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ResultatActitvity.this,About.class);
                startActivity(intent);
            }
        });
        Intent intent=getIntent();

        nomPatient.setText(intent.getStringExtra(Constante.nomPatient));
        resultaAnal.setText(intent.getStringExtra(Constante.resutatAnaluse));

    }
}
