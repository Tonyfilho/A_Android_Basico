package pt.atec.agenda04.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import pt.atec.agenda04.R;
import pt.atec.agenda04.dao.AlunoDAO;
import pt.atec.agenda04.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo Aluno";
    final AlunoDAO alunoDAO = new AlunoDAO();
    private EditText campoEmail; // atributos criando com Ctrl + Alt + f
    private EditText campoNome;
    private EditText campoFone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITULO_APPBAR);
        setContentView(R.layout.activity_formulario_aluno);
        inicializaçãoDosCampos();

        Button botaoSalvar = findViewById(R.id.activity_botao_formulario_aluno_id);
        criaBotaoSalvar(botaoSalvar);

    }// fim do oncreated

    private void criaBotaoSalvar(Button botaoSalvar) {
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     Toast.makeText(FormularioAlunoActivity.this, "teste no botão ", Toast.LENGTH_SHORT).show();
                Aluno alunoNovo = CriaAluno();
//                Toast.makeText(FormularioAlunoActivity.this, alunoNovo.getNome() + " nome "
//                +alunoNovo.getEmail() +" email " + alunoNovo.getFone() +" telefone", Toast.LENGTH_SHORT).show();
                salvarAluno(alunoNovo);

            }// fim do onclick
        });
    }

    private void inicializaçãoDosCampos() {
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoFone = findViewById(R.id.activity_formulario_aluno_telefone);
    }

    private void salvarAluno(Aluno alunoNovo) {
        alunoDAO.salvar(alunoNovo);// buscando os dados do metodo DAO
        finish();//finalizando nossa activity, substituindo o startActivity
    }

    private Aluno CriaAluno() {
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        String telefone = campoFone.getText().toString();
        return new Aluno(nome, email, telefone);
    }


}
