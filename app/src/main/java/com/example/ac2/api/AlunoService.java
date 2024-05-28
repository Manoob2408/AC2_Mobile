package com.example.ac2.api;

import com.example.ac2.models.Aluno;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlunoService {

    @GET("alunos")
    Call<List<Aluno>> getAlunos();
    @POST("alunos")
    Call<Aluno> postAlunos(@Body Aluno aluno);
    @DELETE("alunos/{id}")
    Call<Void> deleteAluno(@Path("id") int idAluno);
    @GET("alunos/{id}")
    Call<Aluno> getAlunoPorId(@Path("id") int idAluno);
    @PUT("alunos/{id}")
    Call<Aluno> putAluno(@Path("id") int idAluno, @Body Aluno aluno);
}
