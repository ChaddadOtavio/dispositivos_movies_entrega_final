package com.example.mainscreen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Cadastrar extends AppCompatActivity {

    private EditText clienteCpfEdt, clienteNomeEdt, clienteEmailEdt, clienteTelefoneEdt, clienteEnderecoEdt, clienteComplementoEdt, clienteSenhaEdt;
    private Button voltar, cadastar;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        clienteCpfEdt = findViewById(R.id.editTextNumberSigned);
        clienteNomeEdt = findViewById(R.id.textInputEditText2);
        clienteEmailEdt = findViewById(R.id.editTextTextEmailAddress);
        clienteTelefoneEdt = findViewById(R.id.editTextPhone);
        clienteEnderecoEdt = findViewById(R.id.editTextTextPostalAddress);
        clienteComplementoEdt = findViewById(R.id.textInputEditText);
        clienteSenhaEdt = findViewById(R.id.editTextTextPassword);

        dbHandler= new DBHandler(Cadastrar.this);

        findViewById(R.id.voltar);
        voltar.setOnClickListener(view -> {
            Intent intent = new Intent(Cadastrar.this,MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.cadastar);
        cadastar.setOnClickListener(v -> {
            String clienteCPF = clienteCpfEdt.getText().toString();
            String clienteNome = clienteNomeEdt.getText().toString();
            String clienteEmail = clienteEmailEdt.getText().toString();
            String clienteTelefone = clienteTelefoneEdt.getText().toString();
            String clienteEndereco = clienteEnderecoEdt.getText().toString();
            String clienteComplemento = clienteComplementoEdt.getText().toString();
            String clienteSenha = clienteSenhaEdt.getText().toString();

            if (clienteCPF.isEmpty() && clienteNome.isEmpty() && clienteEmail.isEmpty() && clienteTelefone.isEmpty() && clienteEndereco.isEmpty() && clienteComplemento.isEmpty() && clienteSenha.isEmpty()){
                Toast.makeText(Cadastrar.this, "Por favor preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            dbHandler.addNewCliente(clienteCPF, clienteNome, clienteEmail, clienteTelefone, clienteEndereco, clienteComplemento, clienteSenha);

            Toast.makeText(Cadastrar.this, "Usuario criado com sucesso", Toast.LENGTH_SHORT).show();
            clienteCpfEdt.setText("");
            clienteNomeEdt.setText("");
            clienteEmailEdt.setText("");
            clienteTelefoneEdt.setText("");
            clienteEnderecoEdt.setText("");
            clienteComplementoEdt.setText("");
            clienteSenhaEdt.setText("");
        });
    }
}