package com.example.ac2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ac2.holders.AlunoAdapter;
import com.example.ac2.models.Aluno;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private AlunoAdapter alunoAdapter;
    TextView txtUsuario;
    Button btnLogout;
    private OkHttpClient client;
    private Gson gson;
    private static final String API_URL = "https://665517463c1d3b6029383522.mockapi.io/ac2/alunos";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView resultTextView;

        client = new OkHttpClient();
        gson = new Gson();

        Request request = new Request.Builder()
                .url(API_URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(() ->
                        Toast.makeText(MainActivity.this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show()
                );
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();
                    ArrayList<Aluno> alunos = gson.fromJson(json, new TypeToken<ArrayList<Aluno>>(){}.getType());
                    runOnUiThread(() -> alunoAdapter.updateData(alunos));
                } else {
                    runOnUiThread(() ->
                            Toast.makeText(MainActivity.this, "Erro na resposta: " + response.message(), Toast.LENGTH_SHORT).show()
                    );
                }
            }
        });
    }

}