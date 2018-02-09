package com.example.calllogsprovider;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by mamorky on 9/02/18.
 */

public interface CallLogContract {
    interface View{
        void setCursor();
        Context getContext();

        void swapCursor(Cursor cursor);
    }
    interface Presenter{
        void getCallLogs();
    };
}
