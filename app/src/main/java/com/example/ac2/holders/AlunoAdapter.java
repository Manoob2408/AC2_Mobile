package com.example.ac2.holders;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ac2.R;
import com.example.ac2.models.Aluno;
import com.google.gson.Gson;

import java.util.ArrayList;

import okhttp3.OkHttpClient;

public class AlunoAdapter extends RecyclerView.Adapter<AlunoHolder> {
    private ArrayList<Aluno> alunos;

    public AlunoAdapter(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    @NonNull
    @Override
    public AlunoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlunoHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_aluno,parent,false));

    }

    public void updateData(ArrayList<Aluno> newAlunos) {
        alunos = newAlunos;
    }

    @Override
    public void onBindViewHolder(@NonNull AlunoHolder holder, int position) {
        Aluno aluno = alunos.get(position);
        holder.textNome.setText(aluno.getNome());
        holder.textRa.setText(Integer.toString(aluno.getRa()));
        holder.textCep.setText(aluno.getCep());
        holder.textLogradouro.setText(aluno.getLogradouro());
        holder.textComplemento.setText(aluno.getComplemento());
        holder.textBairro.setText(aluno.getBairro());
        holder.textCidade.setText(aluno.getCidade());
        holder.textUf.setText(aluno.getUf());
    }

    @Override
    public int getItemCount() {
        return alunos != null ? alunos.size() : 0;
    }
}
