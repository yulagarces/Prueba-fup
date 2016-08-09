package com.fup.jennyferlopez.proyectokitetkiwe.fragments.nivelcuatro;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fup.jennyferlopez.proyectokitetkiwe.R;
import com.fup.jennyferlopez.proyectokitetkiwe.fragments.niveltres.Niveles31Activity;
import com.fup.jennyferlopez.proyectokitetkiwe.gestorbd.GestorBd;
import com.fup.jennyferlopez.proyectokitetkiwe.models.Puntos;
import com.fup.jennyferlopez.proyectokitetkiwe.utils.Preference;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumerosDosFragment extends Fragment implements View.OnClickListener{
    SharedPreferences preferences;
    String avatarSeleccionado, userName;
    TextView tv_puntos;
    ImageView icAvatarNiveles;
    TextView tv_title, num_seis, num_siete, num_ocho, num_nueve, num_diez;
    int idUsuario;
    GestorBd db;
    int id_user;
    ImageView n_seis, n_siete, n_ocho, n_nueve, n_diez;
    Button btnSiguiente;

    public NumerosDosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_numeros_dos, container, false);

        btnSiguiente= (Button) view.findViewById(R.id.fab);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irNivel= new Intent(getActivity(), Nivel41Activity.class);
                startActivity(irNivel);
                getActivity().finish();
            }
        });
        n_seis =(ImageView) view.findViewById(R.id.n_seis);
        n_siete =(ImageView) view.findViewById(R.id.n_siete);
        n_ocho =(ImageView) view.findViewById(R.id.n_ocho);
        n_nueve =(ImageView) view.findViewById(R.id.n_nueve);
        n_diez =(ImageView) view.findViewById(R.id.n_diez);
        num_seis = (TextView) view.findViewById(R.id.num_seis);
        num_siete = (TextView) view.findViewById(R.id.num_siete);
        num_ocho = (TextView) view.findViewById(R.id.num_ocho);
        num_nueve = (TextView) view.findViewById(R.id.num_nueve);
        num_diez = (TextView) view.findViewById(R.id.num_diez);

        n_seis.setOnClickListener(this);
        n_siete.setOnClickListener(this);
        n_ocho.setOnClickListener(this);
        n_nueve.setOnClickListener(this);
        n_diez.setOnClickListener(this);

        tv_title = (TextView) view.findViewById(R.id.tv_title);
        icAvatarNiveles = (ImageView) view.findViewById(R.id.ic_avatarNiveles);
        tv_puntos = (TextView) view.findViewById(R.id.tv_puntos);
        String font_url = "font/dklemonyellowsun.otf";
        Typeface font = Typeface.createFromAsset(this.getResources().getAssets(), font_url);
        tv_puntos.setTypeface(font);
        tv_title.setTypeface(font);
        num_seis.setTypeface(font);
        num_siete.setTypeface(font);
        num_ocho.setTypeface(font);
        num_nueve.setTypeface(font);
        num_diez.setTypeface(font);

        db=new GestorBd(getContext());

        loadPreference();
        cargarTextV();

        return view;
    }
    private void cargarTextV() {
        id_user =db.obtenerId(userName);
        List<Puntos> pts=db.sumaPuntos(id_user);
        pts=db.sumaPuntos(id_user);
        int p=Integer.parseInt(String.valueOf(pts.get(0).getPuntos()));
        tv_puntos.setText(""+ p);
    }


    private void loadPreference() {
        preferences = getActivity().getSharedPreferences(Preference.PREFERENCE_NAME, Activity.MODE_PRIVATE);
        avatarSeleccionado = preferences.getString(Preference.AVATAR_SEECCIONADO, "");
        userName = preferences.getString(Preference.USER_NAME, "");
        idUsuario = preferences.getInt(Preference.USER_ID, 0);

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
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.n_seis) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.seis);
            mp.start();
        }else if (v.getId() == R.id.n_siete) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.siete);
            mp.start();
        }else if (v.getId() == R.id.n_ocho) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.ocho);
            mp.start();
        }else if (v.getId() == R.id.n_nueve) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.nueve);
            mp.start();
        }else if (v.getId() == R.id.n_diez) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.diez);
            mp.start();
        }
    }

}
