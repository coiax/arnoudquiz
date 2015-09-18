package nl.shell.arnoud.arnoudcustomerquiz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void continueButton(View view) {
        TextView editName = (TextView) findViewById(R.id.editName);
        TextView editEmail = (TextView) findViewById(R.id.editEmail);
        CheckBox tosCheck = (CheckBox) findViewById(R.id.TOSCheckBox);

        boolean isChecked = tosCheck.isChecked();

        if (!isChecked) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage(R.string.untickedtos_dialog_message)
                    .setTitle(R.string.untickedtos_dialog_title);

            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        // store name and email for later submission
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_preferences),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        //editor.putInt(getString(R.string.saved_high_score), newHighScore);
        editor.putString(getString(R.string.saved_name), editName.getText().toString());
        editor.putString(getString(R.string.saved_email), editEmail.getText().toString());
        editor.apply();

        Intent intent = new Intent(this, MainFunctionsQuestionActivity.class);
        startActivity(intent);
    }
}
