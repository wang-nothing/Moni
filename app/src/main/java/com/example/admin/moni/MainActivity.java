package com.example.admin.moni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.moni.view.ShowActivity;
import com.example.library.AutoFlowLayout;
import com.example.library.FlowAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mian_image_search,main_image_delete;
    private TextView main_tv_cancel;
    private EditText main_et_search;
    private AutoFlowLayout main_autoflowlayout;
    private List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mList = new ArrayList<>();
        main_autoflowlayout = findViewById(R.id.main_autoflowlayout);
        mian_image_search = findViewById(R.id.mian_image_search);
        main_tv_cancel = findViewById(R.id.main_tv_cancel);
        main_image_delete = findViewById(R.id.main_image_delete);
        main_et_search = findViewById(R.id.main_et_search);
        initImageListener();
    }

    private void initImageListener() {
        mian_image_search.setOnClickListener(this);
        main_tv_cancel.setOnClickListener(this);
        main_image_delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mian_image_search:
                String et_text = main_et_search.getText().toString();

                mList.add(et_text);

                Myadapter();
                break;

            case R.id.main_tv_cancel:
                main_et_search.getText().clear();
                break;

            case R.id.main_image_delete:
                main_et_search.getText().clear();
                mList.clear();
                main_autoflowlayout.removeAllViews();
                break;
        }
    }

    private void Myadapter() {
        main_autoflowlayout.setAdapter(new FlowAdapter(mList) {

            private TextView item_tv;
            private View mView;

            @Override
            public View getView(final int i) {
                mView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_main, null);
                item_tv = mView.findViewById(R.id.item_tv);
                item_tv.setText(mList.get(i));
                item_tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String item_text = item_tv.getText().toString();
                        Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                        intent.putExtra("item_text", item_text);
                        startActivity(intent);
                    }
                });
                mList.clear();
                return mView;
            }
        });
    }
}
