package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    private TextView text1;
    private TextView text2;
    private Button okButton;
    private Button cancelButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        text1 = findViewById(R.id.textView);
        text2 = findViewById(R.id.textView2);
        okButton = findViewById(R.id.ok_button);
        cancelButton = findViewById(R.id.cancel_button);

        okButton.setOnClickListener(view -> {
            setResult(RESULT_OK);
            finish();
        });

        cancelButton.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("text1")) {
            text1.setText(intent.getStringExtra("text1"));
        }
        if (intent != null && intent.getExtras().containsKey("text2")) {
            text2.setText(intent.getStringExtra("text2"));
        }

    }
}