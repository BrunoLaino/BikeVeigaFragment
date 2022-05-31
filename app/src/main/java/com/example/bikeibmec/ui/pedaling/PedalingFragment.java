package com.example.bikeibmec.ui.pedaling;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bikeibmec.R;
import com.example.bikeibmec.ui.register.CadastroConfirmacaoActitvity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.DecimalFormat;
import java.util.Random;

public class PedalingFragment extends Fragment {


    private TextView textDistancia;
    private TextView textDuracao;
    private TextView textCalorias;
    private TextView textVelMed;
    private Button iniciarButton;
    private Button pararButton;
    
    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(-34, 151);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_pedaling, container, false);
        textDistancia = rootView.findViewById(R.id.textDistancia);
        textDuracao = rootView.findViewById(R.id.textDuracao);
        textCalorias = rootView.findViewById(R.id.textCalorias);
        textVelMed = rootView.findViewById(R.id.textVelMed);


        iniciarButton = (Button) rootView.findViewById(R.id.inicarButton);
        iniciarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                DecimalFormat formato = new DecimalFormat("#.##");

                int distancia = random.nextInt(10000);
                int duracaoMinutos = random.nextInt(60);
                int duracaoSegundos = random.nextInt(60);
                int calorias = random.nextInt(1000);
                double velMed = random.nextDouble() * 30;

                textDuracao.setText("Duração: " + String.format("%02d", duracaoMinutos) + ":" + String.format("%02d",duracaoSegundos) + " minutos");
                textDistancia.setText("Distancia: " + distancia + "m");
                textCalorias.setText("Calorias: " + calorias + " cal");
                textVelMed.setText("Velocidade media: " + formato.format(velMed)  + " km");
            }
        });


        pararButton = (Button) rootView.findViewById(R.id.pararButton);
        pararButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDuracao.setText("Duração:");
                textDistancia.setText("Distancia:");
                textCalorias.setText("Calorias:");
                textVelMed.setText("Velocidade media:");
            }
        });



        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}