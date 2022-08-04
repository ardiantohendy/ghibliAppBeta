package com.example.ghibli;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ghibli.model.People;

public class CharInfoActivity extends AppCompatActivity {

    private People characterObjectFromMain, characterObject;
    private TextView nameH1, nameH2, genderTxt, ageTxt, eyeColorTxt, hairColorTxt;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_info);

        nameH1 = findViewById(R.id.nameH1);
        nameH2 = findViewById(R.id.nameH2);
        genderTxt = findViewById(R.id.genderTxt);
        ageTxt = findViewById(R.id.ageTxt);
        eyeColorTxt = findViewById(R.id.eyeColorTxt);
        hairColorTxt = findViewById(R.id.hairColorTxt);

        characterObject = (People) getIntent().getSerializableExtra("character_object");

        characterObjectFromMain = (People) getIntent().getSerializableExtra("person_object");

        if(characterObject == null) {
            fetchCharData(characterObjectFromMain);
        } else {
            fetchCharData(characterObject);
        }




    }

    @SuppressLint("SetTextI18n")
    public void fetchCharData (People data) {
        nameH1.setText(data.getName());
        nameH2.setText(nameH2.getText() + data.getName());
        genderTxt.setText(genderTxt.getText() + data.getGender());
        ageTxt.setText(ageTxt.getText() + data.getAge());
        eyeColorTxt.setText(eyeColorTxt.getText() + data.getEye_color());
        hairColorTxt.setText(hairColorTxt.getText() + data.getHair_color());
    }
}