package nl.shell.arnoud.arnoudcustomerquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.VideoView;

public class QuestionTwoActivity extends AppCompatActivity {
    static final private String VIDEO_URL = "http://www.youtube.com/watch?v=8WXQNakgluM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);

        //VideoView vv = (VideoView) findViewById(R.id.videoView);
        //vv.setVideoPath(getString(R.string.question2videopath));
        //TODO get youtube video embedded
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question_two, menu);
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
        Intent intent = new Intent(this, QuestionThreeActivity.class);
        startActivity(intent);
    }

    public void openVideo(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(VIDEO_URL));
        startActivity(intent);
    }

}
