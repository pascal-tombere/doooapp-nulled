package com.dooo.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Spannable;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import net.nightwhistler.htmlspanner.HtmlSpanner;

public class TermsAndConditions extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        textView = findViewById(R.id.textView);
        loadConfig();
    }

    private void loadConfig() {
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences", MODE_PRIVATE);
        String config = sharedPreferences.getString("Config", null);

        JsonObject jsonObject = new Gson().fromJson(config, JsonObject.class);
        String termsAndConditions = jsonObject.get("TermsAndConditions").getAsString();
        Spannable html = new HtmlSpanner().fromHtml(termsAndConditions);
        textView.setText(html);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}