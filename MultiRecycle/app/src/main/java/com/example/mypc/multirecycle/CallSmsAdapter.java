package com.example.mypc.multirecycle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CallSmsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static int TYPE_CALL=1,TYPE_SMS=2;
    private List<Object> callSMSList =new ArrayList();
    private Context context;

    public CallSmsAdapter(Context context,List<Object> list){
        this.context = context;
        this.callSMSList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = 0;
        RecyclerView.ViewHolder viewHolder;

        if( viewType == TYPE_CALL){
            layout = R.layout.item_call;
            View callView = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
            viewHolder = new CallViewHolder(callView);
        }
        else{
            layout = R.layout.item_sms;
            View smsView = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
            viewHolder = new SmsViewHolder(smsView);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = holder.getItemViewType();

        if( viewType == 1 ) {
            Call call = (Call)callSMSList.get(position);
            ((CallViewHolder)holder).ShowCall(call);
        }
        else{
            Sms sms = (Sms)callSMSList.get(position);
            ((SmsViewHolder)holder).ShowSms(sms);
        }
    }

    @Override
    public int getItemCount() {
        return callSMSList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if( callSMSList.get(position) instanceof  Call) return 1;
        else return 2;
    }

    public class  CallViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_Name,txt_NumberPhone;

        public CallViewHolder(View itemView) {
            super(itemView);
            txt_Name = itemView.findViewById(R.id.txt_Name);
            txt_NumberPhone = itemView.findViewById(R.id.txt_NumberPhone);
        }
        public void ShowCall(Call call){
            txt_Name.setText(call.getName());
            txt_NumberPhone.setText(call.getNumberPhone());
        }
    }

    public class SmsViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_Name,txt_Text;

        public SmsViewHolder(View itemView) {
            super(itemView);
            txt_Name = itemView.findViewById(R.id.txt_Name);
            txt_Text = itemView.findViewById(R.id.txt_Text);

        }

        public void ShowSms(Sms sms){
            txt_Text.setText(sms.getText());
            txt_Name.setText(sms.getName());
        }
    }
}
