package pe.comercio.material_searchable_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher{

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<UserEntity> userEntityList = new ArrayList<>();

    private AppCompatEditText txtSearch;
    private AppCompatButton btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rcvContact);
        txtSearch = (AppCompatEditText) findViewById(R.id.txtSearch);
        btnSearch = (AppCompatButton) findViewById(R.id.btnSearch);

        userEntityList.add(new UserEntity("carlos"));
        userEntityList.add(new UserEntity("ricardo"));
        userEntityList.add(new UserEntity("jose"));
        userEntityList.add(new UserEntity("hernesto"));
        userEntityList.add(new UserEntity("eduardo"));
        userEntityList.add(new UserEntity("fabri"));
        userEntityList.add(new UserEntity("monkey"));
        userEntityList.add(new UserEntity("monkey"));
        userEntityList.add(new UserEntity("rabbit"));
        userEntityList.add(new UserEntity("lion"));
        userEntityList.add(new UserEntity("been"));
        userEntityList.add(new UserEntity("monkey"));
        userEntityList.add(new UserEntity("monkey"));
        userEntityList.add(new UserEntity("monkey"));
        userEntityList.add(new UserEntity("monkey"));

        userAdapter = new UserAdapter(this, userEntityList);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(userAdapter);

        btnSearch.setOnClickListener(this);
        txtSearch.addTextChangedListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSearch:
                Toast.makeText(MainActivity.this, txtSearch.getText().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        userAdapter.getFilter().filter(charSequence.toString());
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
