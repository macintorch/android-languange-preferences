package ainor.com.my.languagepreferences;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    public void setLanguage(String language) {

       sharedPreferences = this.getSharedPreferences("package ainor.com.my.languagepreferences", Context.MODE_PRIVATE);

        sharedPreferences.edit().putString("language", language).apply();

        TextView textView = (TextView) findViewById(R.id.textView);

        textView.setText(language);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // to avoid alert popup if previously user did select a languange

        sharedPreferences = this.getSharedPreferences("package ainor.com.my.languagepreferences", Context.MODE_PRIVATE);

        String language = sharedPreferences.getString("language", "");

        if (language == "") {

            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_btn_speak_now)
                    .setTitle("Choose Language")
                    .setMessage("Which language would you like?")
                    .setPositiveButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            setLanguage("English");

                        }
                    })
                    .setNegativeButton("Spanish", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            setLanguage("Spanish");
                        }
                    })
                    .show();
        }
    }
}
