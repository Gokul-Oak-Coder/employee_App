package com.example.employeeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EmployeeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

       // TextView idTextView = findViewById(R.id.idTextView);
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView phoneTextView = findViewById(R.id.phoneTextView);
      //  TextView companyDetailTextView = findViewById(R.id.companyDetailTextView);

       final Employee employee = (Employee) getIntent().getSerializableExtra("employee");

        assert employee != null;
       // idTextView.setText(employee.getId());
        nameTextView.setText(employee.getName());
        emailTextView.setText(employee.getEmail().toLowerCase());
        phoneTextView.setText(employee.getPhone());
       // companyDetailTextView.setText(employee.getCompany());

        // Handle email click
        emailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + employee.getEmail()));
                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                }
            }
        });

        // Handle phone click
        phoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:" + employee.getPhone()));
                if (phoneIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(phoneIntent);
                }
            }
        });
    }
}