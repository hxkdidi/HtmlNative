package com.mozz.htmlnative.attrs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebView;

import com.mozz.htmlnative.AttrApplyException;

/**
 * @author Yang Tao, 17/3/6.
 */

public class WebViewAttr extends Attr {
    @Override
    public void apply(Context context, java.lang.String tag, View v, @NonNull java.lang.String
            params, @NonNull final Object value, String innerElement) throws AttrApplyException {
        final WebView webView = (WebView) v;

        if (params.equals("src")) {
            webView.loadUrl(value.toString());
        }
    }
}