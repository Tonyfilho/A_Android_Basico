package pt.atec.agenda04.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import pt.atec.agenda04.R;
import pt.atec.agenda04.dao.AlunoDAO;


public class ListaAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Alunos";
    final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITULO_APPBAR);
        setContentView(R.layout.activity_lista_aluno);
        botaoAdcionaAluno();
    }// fim do on

    private void botaoAdcionaAluno() {
        FloatingActionButton botaoAdciona = findViewById(R.id.activity_lista_button_id_);//buscando o botão de inserir aluno
        botaoAdciona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaAlunoActivity.this, FormularioAlunoActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        //      List<String> Alunos = new ArrayList<>(Arrays.asList("antonio","debora","juan"));
        ListView agenda = findViewById(R.id.activity_lista_aluno_agenda_id);
        agenda.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));
    }
}// fim da class
