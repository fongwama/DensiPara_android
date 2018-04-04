package cg.fongwama.densipara.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import cg.fongwama.densipara.R;

public class ResultatActitvity extends AppCompatActivity {
    private FloatingActionButton actionButton;

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_actitvity);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        actionButton=(FloatingActionButton)findViewById(R.id.mapchanger);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ResultatActitvity.this,About.class);
                startActivity(intent);
            }
        });
        Intent intent=getIntent();

    }
}
