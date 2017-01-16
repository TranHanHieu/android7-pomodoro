package com.example.hieuit.commonviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString() ;
    private ImageView imageView;
    private Spinner spinner;
    private EditText editText;
    private Button button;
    private CheckBox checkBox;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RatingBar ratingBar;
    private SeekBar seekBar;
    private TextView textViewSB;
    private SearchView svSimple;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReferences();
        setupUI();
        addListeners();
    }

    private void addListeners() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG,String.format("%s,%d","spiner.onItemSelected",i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(TAG,String.format("editText.beforeTextChanged %s,start %s,count %s,after %s",charSequence,i,i1,i2));

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(TAG,String.format("editText.onTextChanged %s,start %s,count %s,after %s",charSequence,i,i1,i2));
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d(TAG,String.format("editText.afterTextChanged %s",editable));
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d(TAG,String.format("SeeBar :OnSeekBarChangeListener: %s,%s",i,b));
                textViewSB.setText(String.format("%s/%s",i,seekBar.getMax()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(TAG,"onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG,"onStopTrackingTouch");
                //textViewSB.setText(seekBar.getProgress());
            }
        });

        svSimple.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d(TAG,String.format("SearchView : onQueryTextSubmit :%s ",query));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d(TAG,String.format("SearchView : onQueryTextChange :%s ",newText));
                return true;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Log.d(TAG,String.format("%s:%s",checkBox.getId(),checkBox.isChecked()));
                //
                checkBox.setChecked(!checkBox.isChecked());
                //
                Log.d(TAG,radioButton1.isChecked()?"Male":radioButton2.isChecked()?"Female":"Undefened");

                Log.d(TAG,String.format("Rating %s",ratingBar.getRating()));

                Log.d(TAG,String.format("SeeBar : %s",seekBar.getProgress()));

                seekBar.setProgress(seekBar.getProgress()+5);

                progressBar.setProgress(progressBar.getProgress()+5);

                svSimple.clearFocus();

                svSimple.setQuery("",false);

                svSimple.setIconified(true);
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d(TAG,String.format("CheckBox : %s",b));
            }
        });
    }

    private void setupUI() {

        imageView.setImageResource(R.drawable.image590);
        checkBox.setChecked(true);

        String [] flower = new String[]{
                "Hoa Hồng",
                "Hoa Cúc",
                "Hoa Huệ"
        };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                flower
        );

        spinner.setAdapter(arrayAdapter);
        radioButton1.setChecked(true);

    }

    private void getReferences() {

        imageView = (ImageView) findViewById(R.id.imageView);
        spinner = (Spinner) findViewById(R.id.spinner);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        checkBox = (CheckBox) findViewById(R.id.check);
        radioButton1 = (RadioButton) findViewById(R.id.male);
        radioButton2 = (RadioButton) findViewById(R.id.female);
        radioButton3 = (RadioButton) findViewById(R.id.undefened);
        ratingBar = (RatingBar) findViewById(R.id.ratingbar);
        seekBar = (SeekBar) findViewById(R.id.seeBar);
        textViewSB = (TextView) findViewById(R.id.textviewSB);
        svSimple = (SearchView) findViewById(R.id.searchview);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }
}
