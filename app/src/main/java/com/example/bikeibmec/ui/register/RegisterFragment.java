package com.example.bikeibmec.ui.register;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.example.bikeibmec.R;
import com.example.bikeibmec.model.user.CreditCard;
import com.example.bikeibmec.model.user.User;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextInputEditText campoNome, campoSobrenome, campoCelular, campoEmail, numeroCartao, titularCartao,validadeCartao, cvCartao;
    private RadioButton sexoMasculino, sexoFeminio, cartãoMasterCard,cartãoVisa;
    private CheckBox checkBoxComputacao, checkBoxCivil, checkBoxProducao, checkBoxMecanica;
    private Button registerButton;


    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//        Intent intent = new Intent(getActivity(), CadastroDadosPessoaisActitvity.class);
//        startActivity(intent);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_register, container, false);

        //Usuario

        //Text
        campoNome = rootView.findViewById(R.id.textInputEditName);
        campoSobrenome = rootView.findViewById(R.id.textInputEditeSobrenome);
        campoCelular = rootView.findViewById(R.id.textInputEditeCelular);
        campoEmail = rootView.findViewById(R.id.textInputEditeEmail);

        //RadioButton Sexo
        sexoMasculino = rootView.findViewById(R.id.radioButtonM);
        sexoFeminio = rootView.findViewById(R.id.radioButtonF);

        //Checkbox
        checkBoxComputacao = rootView.findViewById(R.id.checkBoxComputacao);
        checkBoxCivil = rootView.findViewById(R.id.checkBoxCivil);
        checkBoxMecanica = rootView.findViewById(R.id.checkBoxMecanica);
        checkBoxProducao = rootView.findViewById(R.id.checkBoxProducao);

        //Cartão

        //RadioButton bandeira do cartão
        cartãoMasterCard = rootView.findViewById(R.id.radioButtonMasterCard);
        cartãoVisa = rootView.findViewById(R.id.radioButtonVisa);

        //Text
        numeroCartao = rootView.findViewById(R.id.textInputEditeCartaoNumero);
        titularCartao = rootView.findViewById(R.id.textInputEditeCartaoTitular);
        validadeCartao = rootView.findViewById(R.id.textInputEditeCartaoValidade);
        cvCartao = rootView.findViewById(R.id.textInputEditeCartaoCv);


        registerButton = (Button) rootView.findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CadastroConfirmacaoActitvity.class);
                intent.putExtra("user", createUser());
                startActivity( intent );
            }
        });


        return rootView;
    }

//    public void cadastrar(View view){
//
//        Intent intent = new Intent(getActivity(), CadastroConfirmacaoActitvity.class);
//        intent.putExtra("user", createUser());
//        startActivity( intent );
//
//    }

    public User createUser(){

        CreditCard creditCard = new CreditCard(radioButtonBandeiraCartao(), numeroCartao.getText().toString()
                , titularCartao.getText().toString(), validadeCartao.getText().toString(), cvCartao.getText().toString());

        return new User(campoNome.getText().toString(),campoSobrenome.getText().toString(), radioButtonSexo(),
                checkBoxCurso(), campoCelular.getText().toString(), campoEmail.getText().toString(), creditCard);
    }

    public ArrayList<String> checkBoxCurso(){
        ArrayList<String> cursos = new ArrayList<String>();
        if (checkBoxComputacao.isChecked()){
            cursos.add(checkBoxComputacao.getText().toString());
        }
        if (checkBoxCivil.isChecked()){
            cursos.add(checkBoxCivil.getText().toString());
        }
        if (checkBoxMecanica.isChecked()){
            cursos.add(checkBoxMecanica.getText().toString());
        }
        if (checkBoxProducao.isChecked()){
            cursos.add(checkBoxProducao.getText().toString());
        }

        return cursos;

    }

    public String radioButtonSexo(){

        if (sexoMasculino.isChecked()){
            return sexoMasculino.getText().toString();
        }else{
            return sexoFeminio.getText().toString();
        }
    }

    public String radioButtonBandeiraCartao(){

        if (cartãoMasterCard.isChecked()){
            return cartãoMasterCard.getText().toString();
        }else{
            return cartãoVisa.getText().toString();
        }
    }
}