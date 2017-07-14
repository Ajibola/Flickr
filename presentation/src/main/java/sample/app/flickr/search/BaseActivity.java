package sample.app.flickr.search;

import android.app.Dialog;

import sample.app.flickr.R;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Toast;

/**
 * Created by hp on 7/14/2017.
 */

public class BaseActivity extends AppCompatActivity {

    private LoadingDialog loadingDialog;

    public BaseActivity() {
        super();
    }

    public void showLoading() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }

        loadingDialog.show();
    }

    public void hideLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

class LoadingDialog extends Dialog {

    public LoadingDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.loading_dialog);
        setTitle(" ");
        Window window = getWindow();
        if (window != null) { window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT)); }
    }
}