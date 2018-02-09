package com.example.calllogsprovider;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;

/**
 * Created by mamorky on 9/02/18.
 */

public class CallLogsPresenter implements CallLogContract.Presenter, LoaderManager.LoaderCallbacks<Cursor> {

    private CallLogContract.View view;
    private static final int CALLLOG = 0;

    public CallLogsPresenter(CallLogContract.View view){
        this.view = view;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cursorLoader = null;

        switch (id){
            case CALLLOG:
                String strOrden = CallLog.Calls.DATE+ " DESC";
                String[] projection = new String[]{CallLog.Calls._ID,CallLog.Calls.NUMBER,CallLog.Calls.DATE,
                        CallLog.Calls.DURATION,CallLog.Calls.TYPE};
                cursorLoader = new CursorLoader(view.getContext(),Uri.parse("content://call_log/calls"),projection,null,null,strOrden);
                break;
        }

        return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        view.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        view.swapCursor(null);
    }

    @Override
    public void getCallLogs() {
        ((Activity)view.getContext()).getLoaderManager().restartLoader(CALLLOG,null,this);
    }
}
