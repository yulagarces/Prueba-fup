package com.fup.jennyferlopez.proyectokitetkiwe.fragments.nivelcuatro;


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
public class NumerosUnoFragment extends Fragment implements View.OnClickListener{

    SharedPreferences preferences;
    String avatarSeleccionado, userName;
    TextView tv_puntos;
    ImageView icAvatarNiveles;
    TextView tv_title, num_uno, num_dos, num_tres, num_cuatro, num_cinco;
    int idUsuario;
    GestorBd db;
    int id_user;
    ImageView n_uno, n_dos, n_tres, n_cuatro, n_cinco;

    public NumerosUnoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_numeros_uno, container, false);

        n_uno =(ImageView) view.findViewById(R.id.n_uno);
        n_dos =(ImageView) view.findViewById(R.id.n_dos);
        n_tres =(ImageView) view.findViewById(R.id.n_tres);
        n_cuatro =(ImageView) view.findViewById(R.id.n_cuatro);
        n_cinco =(ImageView) view.findViewById(R.id.n_cinco);
        num_uno = (TextView) view.findViewById(R.id.num_uno);
        num_dos = (TextView) view.findViewById(R.id.num_dos);
        num_tres = (TextView) view.findViewById(R.id.num_tres);
        num_cuatro = (TextView) view.findViewById(R.id.num_cuatro);
        num_cinco = (TextView) view.findViewById(R.id.num_cinco);

        n_uno.setOnClickListener(this);
        n_dos.setOnClickListener(this);
        n_tres.setOnClickListener(this);
        n_cuatro.setOnClickListener(this);
        n_cinco.setOnClickListener(this);

        tv_title = (TextView) view.findViewById(R.id.tv_title);
        icAvatarNiveles = (ImageView) view.findViewById(R.id.ic_avatarNiveles);
        tv_puntos = (TextView) view.findViewById(R.id.tv_puntos);
        String font_url = "font/dklemonyellowsun.otf";
        Typeface font = Typeface.createFromAsset(this.getResources().getAssets(), font_url);
        tv_puntos.setTypeface(font);
        tv_title.setTypeface(font);
        num_uno.setTypeface(font);
        num_dos.setTypeface(font);
        num_tres.setTypeface(font);
        num_cuatro.setTypeface(font);
        num_cinco.setTypeface(font);

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
        if (v.getId() == R.id.n_uno) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.uno);
            mp.start();
        }else if (v.getId() == R.id.n_dos) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.dos);
            mp.start();
        }else if (v.getId() == R.id.n_tres) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.tres);
            mp.start();
        }else if (v.getId() == R.id.n_cuatro) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.cuatro);
            mp.start();
        }else if (v.getId() == R.id.n_cinco) {
            MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.cinco);
            mp.start();
        }
    }

}
