package com.example.bikeibmec.ui.schedules;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.bikeibmec.R;
import com.example.bikeibmec.adapter.MarcacoesAdapter;
import com.example.bikeibmec.model.appointment.Marcacao;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SchedulesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SchedulesFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Marcacao> marcacaoList = new ArrayList<>();


    public SchedulesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SchedulesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SchedulesFragment newInstance(String param1, String param2) {
        SchedulesFragment fragment = new SchedulesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_schedules, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);

        createMarcacaos();
        MarcacoesAdapter marcacoesAdapter = new MarcacoesAdapter(marcacaoList);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration( new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(marcacoesAdapter);

        return rootView;
    }

    public void createMarcacaos(){
        marcacaoList.add( new Marcacao("Pedalada em grupo", "14:00", "30/05/2022"));
        marcacaoList.add( new Marcacao("Exame fisico", "09:00", "06/06/2022"));
        marcacaoList.add( new Marcacao("Exibição de bikes", "19:00", "15/07/2022"));
        marcacaoList.add( new Marcacao("Pedalada na serra em grupo", "06:00", "05/08/2022"));
    }
}