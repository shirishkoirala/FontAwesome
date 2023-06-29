package com.shirishkoirala.fontawesome.sample.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.shirishkoirala.fontawesome.IconTextView;
import com.shirishkoirala.fontawesome.IconView;
import com.shirishkoirala.fontawesome.data.Icons;
import com.shirishkoirala.fontawesome.sample.R;

public class JavaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        IconView iconView = findViewById(R.id.icon_view);
        IconTextView iconTextView = findViewById(R.id.icon_text_view);

        iconView.setIconData(Icons.Companion.getAnkh_solid());

        iconTextView.setText(R.string.ic_unicode_gears_solid);
    }
}
