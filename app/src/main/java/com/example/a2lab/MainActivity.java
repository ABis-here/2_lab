package com.example.a2lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a2lab.utils.TextCounter;

public class MainActivity extends AppCompatActivity {

    private EditText edUserInput;
    private TextView tvResult;
    private Spinner spSelectionOptions;
    private Button btnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUserInput = findViewById(R.id.edUserInput);
        tvResult = findViewById(R.id.tvCountResult);
        spSelectionOptions = findViewById(R.id.spSelectionOptions);
        btnCount = findViewById(R.id.btnCount);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSelectionOptions.setAdapter(adapter);

        btnCount.setOnClickListener(this::onBtnCountClick);
    }

    public void onBtnCountClick(View v) {
        String text = edUserInput.getText().toString();

        if (text.trim().isEmpty()) {
            Toast.makeText(this, getString(R.string.err_empty_input), Toast.LENGTH_SHORT).show();
            return;
        }

        int pos = spSelectionOptions.getSelectedItemPosition();
        int result;

        switch (pos) {
            case 0: // Sakiniai
                result = TextCounter.getSentencesCount(text);
                break;
            case 1: // Zodziai
                result = TextCounter.getWordsCount(text);
                break;
            case 2: // Rasybos zenklai
                result = TextCounter.getPunctuationCount(text);
                break;
            case 3: // Skaiciai
                result = TextCounter.getNumbersCount(text);
                break;
            default:
                result = 0;
        }

        tvResult.setText(String.valueOf(result));
    }
}
