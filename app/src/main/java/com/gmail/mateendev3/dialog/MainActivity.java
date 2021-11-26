package com.gmail.mateendev3.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowDialog = findViewById(R.id.btnShowDialog);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_layout);

                EditText etUserName = dialog.findViewById(R.id.etUserName);
                EditText etPassword = dialog.findViewById(R.id.etPassword);
                Button btnLogin = dialog.findViewById(R.id.btnLogin);
                Button btnCancel = dialog.findViewById(R.id.btnCancel);

                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (TextUtils.isEmpty(etUserName.getText().toString()) && TextUtils.isEmpty(etPassword.getText().toString()))
                            Toast.makeText(MainActivity.this, "Empty", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "Likha", Toast.LENGTH_SHORT).show();
                    }
                });

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:03467560225"));
                        if (intent.resolveActivity(getPackageManager()) != null)
                            startActivity(intent);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}