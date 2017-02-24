package leonardo2204.exc11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Xml;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rvPessoas)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.txtBtn)
    void lerArquivoTextoRaw() {
        Toast.makeText(this, readTextFile(R.raw.nougat), Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.csvBtn)
    void lerArquivoCsvRaw() {
        List<Pessoa> pessoas = new ArrayList<>();
        InputStream inputStream = getResources().openRawResource(R.raw.cadastro_pessoa);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] line = linha.split(",");
                Pessoa pessoa = new Pessoa(Integer.valueOf(line[0]),line[1],line[2],Boolean.valueOf(line[3]),line[4]);
                pessoas.add(pessoa);
            }

            setupAdapter(pessoas);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                // handle exception
            }
        }
    }

    @OnClick(R.id.jsonBtn)
    void lerArquivoJson() {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Pessoa>>(){}.getType();

        String json = readTextFile(R.raw.cadastro_pessoa_json);

        List<Pessoa> pessoas = gson.fromJson(json, type);
        setupAdapter(pessoas);
    }

    private String readTextFile(int resId){
        InputStream inputStream = getResources().openRawResource(resId);

        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);
        String line;
        StringBuilder text = new StringBuilder();

        try {
            while (( line = buffreader.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                buffreader.close();
                inputreader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return text.toString();
    }

    private void setupAdapter(List<Pessoa> pessoas) {
        PessoaAdapter pessoaAdapter = new PessoaAdapter(pessoas);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setAdapter(pessoaAdapter);
        recyclerView.setLayoutManager(llm);
    }


}
