package ro.pub.cs.systems.eim.practicaltest01var04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
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


    }
}