package com.example.calllogsprovider;

import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by mamorky on 9/02/18.
 */

public class CallLogAdapter extends CursorAdapter {
    public CallLogAdapter(Context context){
        super(context,null,FLAG_REGISTER_CONTENT_OBSERVER);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View root = LayoutInflater.from(context).inflate(R.layout.item_call,parent,false);

        CallLogHolder holder = new CallLogHolder();

        holder.txvNumber = root.findViewById(R.id.txvNumber);
        holder.txvDate = root.findViewById(R.id.txvDate);
        holder.txvDuration = root.findViewById(R.id.txvDuration);
        holder.txvType = root.findViewById(R.id.txvType);

        root.setTag(holder);

        return root;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        CallLogHolder holder = (CallLogHolder) view.getTag();

        String number = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
        String fecha = cursor.getString(cursor.getColumnIndex(CallLog.Calls.DATE));
        String duracion = cursor.getString(cursor.getColumnIndex(CallLog.Calls.DURATION));
        String tipo = cursor.getString(cursor.getColumnIndex(CallLog.Calls.TYPE));

        holder.txvNumber.setText(number);
        holder.txvDate.setText(new Date(Long.valueOf(fecha)).toString());
        holder.txvDuration.setText(duracion);
        holder.txvType.setText(tipo);
    }

    private class CallLogHolder{
        TextView txvNumber;
        TextView txvDate;
        TextView txvDuration;
        TextView txvType;
    }
}
