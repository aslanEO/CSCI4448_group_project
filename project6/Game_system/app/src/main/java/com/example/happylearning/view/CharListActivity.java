package com.example.happylearning.view;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.happylearning.R;
import com.example.happylearning.models.CharInfo;

import java.util.ArrayList;
import java.util.List;

public class CharListActivity extends AppCompatActivity {

    /*
     * Description:
     * Learning Page for Lesson one.
     * Adapter pattern was applied in the class for list view.
     */

    private List<CharInfo> CharList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_list);
        getWindow().setBackgroundDrawableResource(R.drawable.background);

        initChar();

        /* Adapter Pattern */
        CharAdapter arrayAdapter = new CharAdapter(CharListActivity.this, R.layout.list_info, CharList);

        android.widget.ListView listView = (android.widget.ListView)findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);
    }

    private void initChar() {
        CharInfo one_zero = new CharInfo(R.drawable.one_z,R.raw.one_z);
        CharList.add(one_zero);
        CharInfo one_one = new CharInfo(R.drawable.one_o,R.raw.one_o);
        CharList.add(one_one);
        CharInfo one_two = new CharInfo(R.drawable.one_t,R.raw.one_t);
        CharList.add(one_two);
        CharInfo one_three = new CharInfo(R.drawable.one_th,R.raw.one_th);
        CharList.add(one_three);
        CharInfo one_four = new CharInfo(R.drawable.one_f,R.raw.one_f);
        CharList.add(one_four);
        CharInfo one_five = new CharInfo(R.drawable.one_fi,R.raw.one_fi);
        CharList.add(one_five);
    }
}
