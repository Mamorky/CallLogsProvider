package com.example.calllogsprovider;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements CallLogContract.View{

    CallLogContract.Presenter presenter;
    private CallLogAdapter adapter;
    private ListView listView;

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getCallLogs();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new CallLogAdapter(this);
        presenter = new CallLogsPresenter(this);
        listView = findViewById(R.id.listViewMio);
        listView.setAdapter(adapter);
    }

    @Override
    public void setCursor() {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void swapCursor(Cursor cursor) {
        adapter.swapCursor(cursor);
    }
}
