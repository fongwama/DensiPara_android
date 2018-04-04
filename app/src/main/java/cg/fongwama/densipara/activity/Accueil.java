package cg.fongwama.densipara.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import cg.fongwama.densipara.R;
import cg.fongwama.densipara.adapter.ViewPagerAdapter;
import cg.fongwama.densipara.fragment.NveFragment;
import cg.fongwama.densipara.fragment.SauvegardeFragment;

/**
 * Created by HP Notebook on 04/04/2018.
 */
public class Accueil extends AppCompatActivity {
    private ViewPager viewPager;
    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
        viewPager=(ViewPager)findViewById(R.id.viewpagerw);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        tabLayout=(TabLayout)findViewById(R.id.mytabs);
        setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.inflateMenu(R.menu.accueil);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nouveau,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i=item.getItemId();
        if (i==R.id.action_settings){
            Intent intent=new Intent(Accueil.this,About.class);
            startActivity(intent);
        }
        return false;
    }

    private void setViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SauvegardeFragment(),"ACCUEIL");
        adapter.addFragment(new NveFragment(),"NOUVEAU");
        viewPager.setAdapter(adapter);
    }


}
