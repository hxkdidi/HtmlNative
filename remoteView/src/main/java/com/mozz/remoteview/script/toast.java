package com.mozz.remoteview.script;

import android.content.Context;
import android.widget.Toast;

import com.mozz.remoteview.common.MainHandler;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

import java.lang.ref.WeakReference;

/**
 * @author Yang Tao, 17/2/27.
 */
public class toast extends OneArgFunction {
    private WeakReference<Context> mContext;

    public toast(Context context) {
        mContext = new WeakReference<Context>(context);
    }

    @Override
    public LuaValue call(final LuaValue luaValue) {
        MainHandler.instance().post(new Runnable() {
            @Override
            public void run() {
                Context context = mContext.get();
                if (context != null) {
                    String msg = luaValue.tojstring();
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });


        return LuaValue.NIL;
    }
}