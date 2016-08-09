package com.fup.jennyferlopez.proyectokitetkiwe.fragments.niveltres;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fup.jennyferlopez.proyectokitetkiwe.R;
import com.fup.jennyferlopez.proyectokitetkiwe.fragments.nivelcuatro.Nivel4Activity;
import com.fup.jennyferlopez.proyectokitetkiwe.fragments.niveldos.CompTren2Activity;
import com.fup.jennyferlopez.proyectokitetkiwe.fragments.niveldos.Nivel23Activity;
import com.fup.jennyferlopez.proyectokitetkiwe.gestorbd.GestorBd;
import com.fup.jennyferlopez.proyectokitetkiwe.models.Puntos;
import com.fup.jennyferlopez.proyectokitetkiwe.utils.Preference;

import java.util.List;

public class SopaColoresActivity extends AppCompatActivity implements View.OnClickListener{

    SharedPreferences preferences;
    String avatarSeleccionado, userName;
    TextView tv_puntos;

    ImageView icAvatarNiveles;
    TextView tv_title;
    int id_user;
    GestorBd db;
    GridView sopaLetras;
    ImageView imgToast, img_t, img_th, img_tx, img_c, img_huevo;
    private final String[] items = new String[]{ "c","x", "k", "i", "t", "x", "b",
                                                  "d","b","e","h","t","ç","ĕ","y",
                                                  "ç","ç","n","a","w","y","k","d",
                                                  "x","e","o","m","k","a","h","u",
                                                  "i","i","r","u","n","p","u","y",
                                                  "h","y","t","x","u","ç","ç","x",
                                                  "m","b","s","s","i","r","ĕ","ç",
                                                  "e","l","d","h","s","l","t","ῦ",
                                                  "a","m","i","x","l","ç","m","k","p"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sopa_colores);
        db=new GestorBd(getApplication());

        img_t = (ImageView) findViewById(R.id.img_t2);
        img_th = (ImageView) findViewById(R.id.img_th2);
        img_tx = (ImageView) findViewById(R.id.img_tx2);
        img_c = (ImageView) findViewById(R.id.img_c2);
        img_huevo = (ImageView) findViewById(R.id.img_parca);
       // sopaLetras=(GridView) findViewById(R.id.grid);
        tv_title = (TextView) findViewById(R.id.tv_title);
        icAvatarNiveles = (ImageView) findViewById(R.id.ic_avatarNiveles);
        tv_puntos = (TextView) findViewById(R.id.tv_puntos);

       /* GridAdapterSopa gridAdapter = new GridAdapterSopa(this, items);
        sopaLetras.setAdapter(gridAdapter);*/
        String font_url ="font/dklemonyellowsun.otf";
        Typeface font = Typeface.createFromAsset(this.getResources().getAssets(), font_url);
        tv_puntos.setTypeface(font);
        tv_title.setTypeface(font);

        img_t.setOnClickListener(this);
        img_th.setOnClickListener(this);
        img_tx.setOnClickListener(this);
        img_c.setOnClickListener(this);
        loadPreference();
        cargarTextV();
    }
    private void cargarTextV() {
        id_user =db.obtenerId(userName);
        List<Puntos> pts=db.sumaPuntos(id_user);
        pts=db.sumaPuntos(id_user);
        int p=Integer.parseInt(String.valueOf(pts.get(0).getPuntos()));
        tv_puntos.setText(""+ p);
    }

    private void loadPreference() {
        preferences = getSharedPreferences(Preference.PREFERENCE_NAME, Activity.MODE_PRIVATE);
        avatarSeleccionado = preferences.getString(Preference.AVATAR_SEECCIONADO, "");
        userName =preferences.getString(Preference.USER_NAME, "");

        if (avatarSeleccionado.equals(null)) {
            icAvatarNiveles.setBackgroundResource(Integer.parseInt(null));
        } else if (avatarSeleccionado.equals("1")) {
            icAvatarNiveles.setBackgroundResource(R.drawable.nino_uno_n);
        } else if (avatarSeleccionado.equals("2")) {
            icAvatarNiveles.setBackgroundResource(R.drawable.nino_dos_n);
        } else if (avatarSeleccionado.equals("3")) {
            icAvatarNiveles.setBackgroundResource(R.drawable.nino_tres_n);
        } else if (avatarSeleccionado.equals("4")) {
            icAvatarNiveles.setBackgroundResource(R.drawable.nina_uno_n);
        } else if (avatarSeleccionado.equals("5")) {
            icAvatarNiveles.setBackgroundResource(R.drawable.nina_dos_n);
        } else if (avatarSeleccionado.equals("6")) {
            icAvatarNiveles.setBackgroundResource(R.drawable.nina_tres_n);
        }
    }

    public void ircuatro(View view) {
        Intent irMenu = new Intent(getApplication(), QuizTresActivity.class);
        startActivity(irMenu);
        finish();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if (id==R.id.img_c2){
            img_huevo.setBackgroundResource(R.drawable.img_huevo_verde_r);
            Thread timerThread = new Thread(){
                public void run(){
                    try{
                        sleep(2000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }finally{
                        Intent ir=new Intent(getApplicationContext(), HuevosCol2Activity.class);
                        startActivity(ir);
                        finish();
                    }
                }
            };
            timerThread.start();
        }else{
            Toast.makeText(this, "sigue intentando", Toast.LENGTH_SHORT).show();
        }
    }
    }

