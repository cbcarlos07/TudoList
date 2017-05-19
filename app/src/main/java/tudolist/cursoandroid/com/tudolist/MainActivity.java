package tudolist.cursoandroid.com.tudolist;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
    private Button botaoAdicionar;
    private ListView listView;
    private EditText texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botaoAdicionar = (Button) findViewById(R.id.botaoAdicionarId);
        listView       = (ListView) findViewById(R.id.listViewId);
        texto          = (EditText) findViewById(R.id.textoId);

    }
}
