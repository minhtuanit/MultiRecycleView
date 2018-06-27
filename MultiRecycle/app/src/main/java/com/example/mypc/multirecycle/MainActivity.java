package com.example.mypc.multirecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Object> callSMSList = new ArrayList<>();
    private CallSmsAdapter callSmsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_List);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        init();
        callSmsAdapter = new CallSmsAdapter(this,callSMSList);
        recyclerView.setAdapter(callSmsAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void init() {
        callSMSList.add(new Call("Tuan","012131122"));
        callSMSList.add(new Sms("Nhu","Tuan dep trai qua"));
        callSMSList.add(new Call("Tuan","012131122"));
        callSMSList.add(new Sms("Nhu","Tuan dep trai qua"));
        callSMSList.add(new Call("Tuasn","012131122"));
        callSMSList.add(new Sms("Nhu","Tuan dep trai qua"));
        callSMSList.add(new Call("Tuanss","012131122"));
        callSMSList.add(new Call("Tussssan","012131122"));
        callSMSList.add(new Sms("Nhu","Tuan dep trai qua"));
        callSMSList.add(new Sms("Nhu","Tuan dep trai qua"));
        callSMSList.add(new Sms("Nhu","Tuan dep trai qua"));
        callSMSList.add(new Sms("Nhasdu","Tuan dep trai qua"));
    }
}
