package com.fup.jennyferlopez.proyectokitetkiwe.fragments.niveluno;


import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fup.jennyferlopez.proyectokitetkiwe.R;
import com.fup.jennyferlopez.proyectokitetkiwe.gestorbd.GestorBd;
import com.fup.jennyferlopez.proyectokitetkiwe.models.Puntos;
import com.fup.jennyferlopez.proyectokitetkiwe.utils.Preference;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VocalesDosFragment extends Fragment implements View.OnClickListener{

    SharedPreferences preferences;
    String avatarSeleccionado, userName;
    TextView tv_puntos;
    ImageView icAvatarNiveles;
    TextView tv_title;
    int id_user;
    GestorBd db;

    ImageView v_glotal_a, v_glotal_e, v_glotal_i, v_glotal_u, n_glotal_a, n_glotal_e, n_glotal_i, n_glotal_u;
    public VocalesDosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_vocales_dos, container, false);

        db=new GestorBd(getActivity());
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        icAvatarNiveles = (ImageView) view.findViewById(R.id.ic_avatarNiveles);
        tv_puntos = (TextView) view.findViewById(R.id.tv_puntos);

        v_glotal_a=(ImageView) view.findViewById(R.id.v_glotal_a);
        v_glotal_e=(ImageView) view.findViewById(R.id.v_glotal_e);
        v_glotal_i=(ImageView) view.findViewById(R.id.v_glotal_i);
        v_glotal_u=(ImageView) view.findViewById(R.id.v_glotal_u);
        n_glotal_a=(ImageView) view.findViewById(R.id.n_glotal_a);
        n_glotal_e=(ImageView) view.findViewById(R.id.n_glotal_e);
        n_glotal_i=(ImageView) view.findViewById(R.id.n_glotal_i);
        n_glotal_u=(ImageView) view.findViewById(R.id.n_glotal_u);

        v_glotal_a.setOnClickListener(this);
        v_glotal_e.setOnClickListener(this);
        v_glotal_i.setOnClickListener(this);
        v_glotal_u.setOnClickListener(this);
        n_glotal_a.setOnClickListener(this);
        n_glotal_e.setOnClickListener(this);
        n_glotal_i.setOnClickListener(this);
        n_glotal_u.setOnClickListener(this);

        String font_url = "font/dklemonyellowsun.otf";
        Typeface font = Typeface.createFromAsset(this.getResources().getAssets(), font_url);
        tv_puntos.setTypeface(font);
        tv_title.setTypeface(font);

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
        if (v.getId() == R.id.v_glotal_a) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.v_glotal_a);
            mp.start();
        }else if (v.getId() == R.id.v_glotal_e) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.v_glotal_e);
            mp.start();
        }else if (v.getId() == R.id.v_glotal_i) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.v_glotal_i);
            mp.start();
        }else if (v.getId() == R.id.v_glotal_u) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.v_glotal_u);
            mp.start();
        }else if (v.getId() == R.id.n_glotal_a) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.n_glotal_a);
            mp.start();
        }else if (v.getId() == R.id.n_glotal_e) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.n_glotal_e);
            mp.start();
        }else if (v.getId() == R.id.n_glotal_i) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.n_glotal_i);
            mp.start();
        }else if (v.getId() == R.id.n_glotal_u) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.n_glotal_u);
            mp.start();
        }
    }
}
