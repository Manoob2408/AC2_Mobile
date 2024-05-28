package com.example.ac2.holders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ac2.R;

public class AlunoHolder extends RecyclerView.ViewHolder {

    TextView textNome;
    TextView textRa;
    TextView textCep;
    TextView textLogradouro;
    TextView textComplemento;
    TextView textBairro;
    TextView textCidade;
    TextView textUf;

    public AlunoHolder(View item) {
        super(item);
        textNome = item.findViewById(R.id.textNome);
        textRa = item.findViewById(R.id.textRa);
        textCep = item.findViewById(R.id.textCep);
        textLogradouro = item.findViewById(R.id.textLogradouro);
        textComplemento = item.findViewById(R.id.textComplemento);
        textBairro = item.findViewById(R.id.textBairro);
        textCidade = item.findViewById(R.id.textCidade);
        textUf = item.findViewById(R.id.textUf);
    }
}
