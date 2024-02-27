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

        TextView idTextView = findViewById(R.id.idTextView);
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView phoneTextView = findViewById(R.id.phoneTextView);
        TextView webSiteTextView = findViewById(R.id.webSiteTextView);
        TextView companyNameTextView = findViewById(R.id.companyDetailTextView);
        TextView addressTextView = findViewById(R.id.addressTextView);

       final Employee employee = (Employee) getIntent().getSerializableExtra("employee");

        Company company = employee.getCompany();
        Address address = employee.getAddress();


        assert employee != null;
        idTextView.setText("Employee Id: " +employee.getId());
        nameTextView.setText("Name: " +employee.getName());
        emailTextView.setText("Email: " +employee.getEmail().toLowerCase());
        phoneTextView.setText("Phone Number: " +employee.getPhone());
        webSiteTextView.setText(" Website: "+employee.getWebsite());
        companyNameTextView.setText(" Company Name: "+company.getCompanyName());
        addressTextView.setText(" "+address.getSuite()+", "+ address.getStreet()+", "+" \n"+" "+address.getCity()+"-"+address.getZipcode());


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