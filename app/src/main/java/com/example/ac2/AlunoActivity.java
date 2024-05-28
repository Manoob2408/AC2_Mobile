package com.example.ac2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ac2.api.AlunoService;
import com.example.ac2.api.ApiClient;
import com.example.ac2.models.Aluno;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlunoActivity extends AppCompatActivity {

    Button btnSalvar;
    AlunoService apiService;
    TextView txtnome, txtra, txtcep, txtlogradouro, txtcomplemento, txtbairro, txtcidade, txtuf;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        apiService = ApiClient.getAlunoService();
        txtnome = findViewById(R.id.txtNomeAluno);
        txtra = findViewById(R.id.txtRaAluno);
        txtcep = findViewById(R.id.txtCepAluno);
        txtlogradouro = findViewById(R.id.txtLogradouro);
        txtcomplemento = findViewById(R.id.txtComplemento);
        txtbairro = findViewById(R.id.txtBairro);
        txtcidade = findViewById(R.id.txtCidade);
        txtuf = findViewById(R.id.txtUf);

        id = getIntent().getIntExtra("id", 0);
        if (id > 0) {
            apiService.getAlunoPorId(id).enqueue(new Callback<Aluno>() {
                @Override
                public void onResponse(Call<Aluno> call, Response<Aluno> response) {
                    if (response.isSuccessful()) {
                        txtra.setText(response.body().getRa());
                        txtnome.setText(response.body().getNome());
                        txtcep.setText(response.body().getCep());
                        txtlogradouro.setText(response.body().getLogradouro());
                        txtcomplemento.setText(response.body().getComplemento());
                        txtbairro.setText(response.body().getBairro());
                        txtcidade.setText(response.body().getCidade());
                        txtuf.setText(response.body().getUf());
                    }
                }

                @Override
                public void onFailure(Call<Aluno> call, Throwable t) {
                    Log.e("Obter usuario", "Erro ao obter usuario");
                }
            });
        }
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno aluno = new Aluno();
                aluno.setNome(txtnome.getText().toString());
                aluno.setRa(Integer.parseInt(txtra.getText().toString()));
                aluno.setCep(txtcep.getText().toString());
                aluno.setLogradouro(txtlogradouro.getText().toString());
                aluno.setComplemento(txtcomplemento.getText().toString());
                aluno.setBairro(txtbairro.getText().toString());
                aluno.setCidade(txtcidade.getText().toString());
                aluno.setUf(txtuf.getText().toString());

                if (id == 0)
                    inserirAluno(aluno);
            }
        });
    }

    private void inserirAluno(Aluno aluno) {
        Call<Aluno> call = apiService.postAlunos(aluno);
        call.enqueue(new Callback<Aluno>() {
            @Override
            public void onResponse(Call<Aluno> call, Response<Aluno> response) {
                if (response.isSuccessful()) {
                    Aluno createdPost = response.body();
                    Toast.makeText(AlunoActivity.this, "Inserido com sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Log.e("Inserir", "Erro ao criar: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Aluno> call, Throwable t) {
                Log.e("Inserir", "Erro ao criar: " + t.getMessage());
            }
        });
    }
}