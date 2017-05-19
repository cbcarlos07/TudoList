package tudolist.cursoandroid.com.tudolist;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
    private Button botaoAdicionar;
    private ListView listView;
    private EditText textoTarefa;
    private SQLiteDatabase bancoDados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            botaoAdicionar = (Button) findViewById(R.id.botaoAdicionarId);
            listView = (ListView) findViewById(R.id.listViewId);
            textoTarefa = (EditText) findViewById(R.id.textoId);

            //banco de Dados
            bancoDados = openOrCreateDatabase("apptarefas", MODE_PRIVATE, null);

            // tabela tarefas
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS tarefas (id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR) ");

            botaoAdicionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String texto = textoTarefa.getText().toString();
                    salvarTarefa(texto);

                }
            });
            //cursor recupera as tarefas
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM tarefas", null);

            //recupera os ids das colunas
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");

            //listar as tarefas
            cursor.moveToFirst();
            while ( cursor != null ){

                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }



    }

    private void salvarTarefa(String texto){
        bancoDados.execSQL("INSERT INTO tarefas (tarefa) VALUES(" + texto + ")");
    }
}
