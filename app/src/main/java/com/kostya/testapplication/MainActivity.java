package com.kostya.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.kostya.greeter.exposed.Greeter;
import com.kostya.greeter.exposed.GreeterSDK;
import com.kostya.greeter.exposed.GreetingsFormatter;
import com.kostya.greeter.exposed.Language;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private final static GreetingsFormatter TEST_FORMATTER = new TestGreetingsFormatter();

    private final static String SIMPLE_FORMAT = "Simple format";
    private final static String DETAILED_FORMAT = "Detailed format";
    private final static String TEST_FORMAT = "Test format";

    private Spinner mLanguageSpinner;
    private Spinner mFormatSpinner;
    private ListView mGreetingsList;

    private GreetingsFormatter mCurrentFormatter = TEST_FORMATTER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLanguageSpinner = findViewById(R.id.spnr_languages);
        mFormatSpinner   = findViewById(R.id.spnr_formats);
        mGreetingsList   = findViewById(R.id.lv_greetings);

        ArrayAdapter<String> languagesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Language.names());
        mLanguageSpinner.setAdapter(languagesAdapter);
        mLanguageSpinner.setSelection(languagesAdapter.getPosition(GreeterSDK.getLanguage().name()));
        mLanguageSpinner.setOnItemSelectedListener(this);

        String[] formats = new String[] { SIMPLE_FORMAT, DETAILED_FORMAT, TEST_FORMAT };
        ArrayAdapter<String> formatAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, formats);
        mFormatSpinner.setAdapter(formatAdapter);
        mFormatSpinner.setSelection(formatAdapter.getPosition(TEST_FORMAT));
        mFormatSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> greetingsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, new ArrayList<>(Arrays.asList(this.getCurrentGreetings())));
        mGreetingsList.setAdapter(greetingsAdapter);
    }

    private void fillGreetingsList() {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) mGreetingsList.getAdapter();
        adapter.clear();

        String[] greetings = this.getCurrentGreetings();
        adapter.addAll(greetings);
        adapter.notifyDataSetChanged();
    }

    private String[] getCurrentGreetings() {
        Greeter greeter = GreeterSDK.getGreeter("Kostya", "Hagit");
        greeter.setFormatter(mCurrentFormatter);
        return new String[] {
                greeter.formatFormalGreeting(),
                greeter.formatFriendlylGreeting(),
                greeter.formatEvilGreeting(),
                greeter.formatExcitedGreeting(),
                greeter.formatLazyGreeting()
        };
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spnr_languages:

                String languageName = (String) parent.getItemAtPosition(position);

                Language language = Language.fromName(languageName);
                if (language != null && language != GreeterSDK.getLanguage()) {
                    GreeterSDK.setLanguage(language);
                    this.fillGreetingsList();
                }

                break;
            case R.id.spnr_formats:

                String formatName = (String) parent.getItemAtPosition(position);

                GreetingsFormatter formatter = null;
                switch (formatName) {
                    case SIMPLE_FORMAT:
                        formatter = GreeterSDK.SIMPLE_FORMATTER;
                        break;
                    case DETAILED_FORMAT:
                        formatter = GreeterSDK.DETAILED_FORMATTER;
                        break;
                    case TEST_FORMAT:
                        formatter = TEST_FORMATTER;
                        break;
                }

                if (formatter != null && formatter != mCurrentFormatter) {
                    mCurrentFormatter = formatter;
                    this.fillGreetingsList();
                }

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
