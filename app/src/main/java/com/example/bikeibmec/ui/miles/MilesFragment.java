package com.example.bikeibmec.ui.miles;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.bikeibmec.MainActivity;
import com.example.bikeibmec.R;
import com.example.bikeibmec.adapter.MilhasAdapter;
import com.example.bikeibmec.model.milhas.MilhasPost;
import com.example.bikeibmec.ui.register.CadastroConfirmacaoActitvity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MilesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MilesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerMilhas;
    private List<MilhasPost> milhasPostList = new ArrayList<>();

    private Button saibaMaisButton;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MilesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MilesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MilesFragment newInstance(String param1, String param2) {
        MilesFragment fragment = new MilesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_miles, container, false);

        recyclerMilhas = rootView.findViewById(R.id.recyclerMilhas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerMilhas.setLayoutManager(layoutManager);
        recyclerMilhas.setHasFixedSize(true);

        createMilhasPost();
        MilhasAdapter milhasAdapter = new MilhasAdapter(milhasPostList);

        recyclerMilhas.addItemDecoration( new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        recyclerMilhas.setAdapter(milhasAdapter);

        return rootView;
    }

    public void createMilhasPost(){
        milhasPostList.add( new MilhasPost("Programa de milhas", "Junte milhas e troque por viajens", R.drawable.imagem1));
        milhasPostList.add( new MilhasPost("Dobre a suas milhas!", "Participe da pedalada nas montanhas esse final de semana e ganhe o dobro de milhas", R.drawable.imagem4));
        milhasPostList.add( new MilhasPost("Viajem para Paris com desconto!", "Só hoje desconto de 50% na troca de milhas por uma passagem para Paris!", R.drawable.imagem3));
    }



}