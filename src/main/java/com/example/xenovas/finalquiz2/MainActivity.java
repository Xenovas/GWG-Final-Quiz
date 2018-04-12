package com.example.xenovas.finalquiz2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /** This method is called when the submit button is pressed.  It calls each individual method
     * to grade each question individually.
     * @param view was created to make the application function, without it it crashes and I'm
     *             not sure why.
     * @param score is set to 0 each time it is called so the test can be regraded for changes.
     */
    public void submitTest(View view) {
        this.view = view;
        score = 0;
        questionOne();
        Log.wtf("Quiz Score A", "value = " + score);
        questionTwo();
        Log.wtf("Quiz Score B", "value = " + score);
        questionThree();
        Log.wtf("Quiz Score C", "value = " + score);
        questionFour();
        Log.wtf("Quiz Score D", "value = " + score);

        if (score == 4) {
            Toast.makeText(this, "Perfect Score! 100%", Toast.LENGTH_LONG).show();
        } else if (score == 3) {
            Toast.makeText(this, "Pretty Good! 75%", Toast.LENGTH_LONG).show();
        } else if (score == 2) {
            Toast.makeText(this, "Not bad. 50%", Toast.LENGTH_LONG).show();
        } else if (score == 1) {
            Toast.makeText(this, "You need to study more. 25%", Toast.LENGTH_LONG).show();
        } else if (score == 0) {
            Toast.makeText(this, "Were you trying to fail?! 0%", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * This method pulls all the states of the 4 check boxes of question one and evaluates that the
     * correct ones are checked.  If the wrong answer is checked it doesn't modify the score.
     */
    private void questionOne() {
        boolean q1a1 = ((CheckBox) findViewById(R.id.q1a1)).isChecked();
        boolean q1a2 = ((CheckBox) findViewById(R.id.q1a2)).isChecked();
        boolean q1a3 = ((CheckBox) findViewById(R.id.q1a3)).isChecked();
        boolean q1a4 = ((CheckBox) findViewById(R.id.q1a4)).isChecked();

        if (q1a1 && q1a2 && q1a3 && !q1a4) {
            score = score + 1;
        }
        return;
    }

    /**
     * This method pulls the state of only the correct radio button and give credit if it is checked.
     * Any other checked box is not read.
     */
    private void questionTwo() {
        boolean q2a4 = ((RadioButton) findViewById(R.id.q2a4)).isChecked();

        if (q2a4) {
            score = score + 1;
        }
        return;
    }

    /**
     * This method pulls the text entered into the box for question 3 and converts it to a
     * string and uppercase to test against the correct answer.
     */
    private void questionThree(){
        EditText editq3a = findViewById(R.id.q3a);
        String q3a = editq3a.getText().toString();
        q3a = q3a.toUpperCase();
        Log.wtf("Question Three", q3a);
        if (q3a.equals("ANTENNA")) {
            score = score + 1;
            Log.wtf("Quiz Score 3", "value = " + score);
        }
        return;
    }

    /**
     * This method pulls the text entered into the box for question 4 and converts it to a string
     * and uppercase to test against the correct answer.
     */
    private void questionFour(){
        EditText editq4a = findViewById(R.id.q4a);
        String q4a = editq4a.getText().toString();
        q4a = q4a.toUpperCase();
        Log.wtf("Question Four", q4a);
        if(q4a.equals("SUN")) {
            score = score + 1;
            Log.wtf("Quiz Score 4", "value = " + score);
        }
        return;
    }

}
