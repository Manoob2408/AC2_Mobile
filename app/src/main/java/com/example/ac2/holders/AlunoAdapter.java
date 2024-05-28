package com.example.ac2.holders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ac2.R;
import com.example.ac2.models.Aluno;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

public class AlunoAdapter extends RecyclerView.Adapter<AlunoHolder> {
    private final List<Aluno> alunos;
    Context context;
    public AlunoAdapter(List<Aluno> alunos, Context context) {
        this.alunos = alunos;
        this.context = context;
    }

    @NonNull
    @Override
    public AlunoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlunoHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_aluno,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull AlunoHolder holder, int position) {
        holder.textNome.setText(alunos.get(position).getNome());
        holder.textRa.setText(Integer.toString(alunos.get(position).getRa()));
        holder.textCep.setText(alunos.get(position).getCep());
        holder.textLogradouro.setText(alunos.get(position).getLogradouro());
        holder.textComplemento.setText(alunos.get(position).getComplemento());
        holder.textBairro.setText(alunos.get(position).getBairro());
        holder.textCidade.setText(alunos.get(position).getCidade());
        holder.textUf.setText(alunos.get(position).getUf());
    }

    @Override
    public int getItemCount() {
        return alunos != null ? alunos.size() : 0;
    }
}
