package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    private EditText text1;
    private EditText text2;
    private Button navigateToSecondaryActivityButton;
    private Button display_info;
    private TextView display_info_text;
    private CheckBox checkBox1;
    private CheckBox checkBox2;

    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        navigateToSecondaryActivityButton = findViewById(R.id.navigate_button);
        display_info = findViewById(R.id.display_button);
        display_info_text = findViewById(R.id.display_text);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("text1")) {
                text1.setText(savedInstanceState.getString("text1"));
            }
            if (savedInstanceState.containsKey("text2")) {
                text2.setText(savedInstanceState.getString("text2"));
            }
        }

        display_info.setOnClickListener(view -> {
            String text1Value = text1.getText().toString();
            String text2Value = text2.getText().toString();
            String displayText = "";
            if (checkBox1.isChecked() && text1Value.isEmpty()) {
                Toast.makeText(this, "Text1 is empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (checkBox2.isChecked() && text2Value.isEmpty()) {
                Toast.makeText(this, "Text2 is empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (checkBox1.isChecked()) {
                displayText += text1Value;
            }
            if (checkBox2.isChecked()) {
                displayText += text2Value;
            }
            display_info_text.setText(displayText);
        });

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Toast.makeText(this, "The activity returned ok", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "The activity returned with cancel", Toast.LENGTH_LONG).show();
            }
        });

        navigateToSecondaryActivityButton.setOnClickListener(view -> {
            String text1Value = text1.getText().toString();
            String text2Value = text2.getText().toString();
            if (!text1Value.isEmpty() && !text2Value.isEmpty()) {
                Intent intent = new Intent(this, PracticalTest01Var04SecondaryActivity.class);
                intent.putExtra("text1", text1Value);
                intent.putExtra("text2", text2Value);
                activityResultLauncher.launch(intent);
            } else {
                Toast.makeText(this, "Text1 and Text2 must not be empty", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("text1", text1.getText().toString());
        savedInstanceState.putString("text2", text2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("text1")) {
            text1.setText(savedInstanceState.getString("text1"));
        }
        if (savedInstanceState.containsKey("text2")) {
            text2.setText(savedInstanceState.getString("text2"));
        }
    }
}