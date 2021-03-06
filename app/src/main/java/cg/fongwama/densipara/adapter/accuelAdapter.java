package cg.fongwama.densipara.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import cg.fongwama.densipara.R;
import cg.fongwama.densipara.activity.ResultatActitvity;
import cg.fongwama.densipara.model.Analyse;
import cg.fongwama.densipara.model.Constante;

/**
 * Created by Orion WAMBERT on 01/04/2018.
 */
public class AccuelAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Analyse>analyses;
    private  Analyse analyse;
    public AccuelAdapter(Context context, List<Analyse> analyses){
        this.context=context;
        this.analyses=analyses;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sve_model,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        analyse =analyses.get(position);
            ((MyViewHolder)holder).nomPatient.setText(analyse.getNomPatient());
            ((MyViewHolder)holder).resultat.setText(String.valueOf(analyse.getResutatAnaluse()));
        ((MyViewHolder)holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(v.getContext(), ResultatActitvity.class);
                intent.putExtra(Constante.nomPatient,analyse.getNomPatient());
                intent.putExtra(Constante.nomTechnicien,analyse.getNomTechnicien());
                intent.putExtra(Constante.nbreGlobParSang,analyse.getNbreGlobParSang());
                intent.putExtra(Constante.nbreGlobuleBlanc,analyse.getNbreGlobuleBlanc());
                intent.putExtra(Constante.nbreParasite,analyse.getNbreParasite());
                intent.putExtra(Constante.resutatAnaluse,analyse.getResutatAnaluse());
                v.getContext().startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return analyses.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nomPatient;
        private TextView resultat;
        public MyViewHolder(View itemView) {
            super(itemView);
            nomPatient=(TextView)itemView.findViewById(R.id.text_nom_patient_rec);
            resultat=(TextView)itemView.findViewById(R.id.text_resultat_rec);
        }
    }
}
