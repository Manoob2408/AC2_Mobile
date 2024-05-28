package com.example.ac2.holders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ac2.R;

public class AlunoHolder extends RecyclerView.ViewHolder {

    public TextView textNome;
    public TextView textRa;
    public TextView textCep;
    public TextView textLogradouro;
    public TextView textComplemento;
    public TextView textBairro;
    public TextView textCidade;
    public TextView textUf;

    public AlunoHolder(View item) {
        super(item);
        textNome = (TextView) item.findViewById(R.id.textNome);
        textRa = (TextView) item.findViewById(R.id.textRa);
        textCep = (TextView) item.findViewById(R.id.textCep);
        textLogradouro = (TextView) item.findViewById(R.id.textLogradouro);
        textComplemento = (TextView) item.findViewById(R.id.textComplemento);
        textBairro = (TextView) item.findViewById(R.id.textBairro);
        textCidade = (TextView) item.findViewById(R.id.textCidade);
        textUf = (TextView) item.findViewById(R.id.textUf);
    }
}
