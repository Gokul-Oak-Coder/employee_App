package com.example.employeeapp;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeService {
    @GET("users")
    Call<List<Employee>> getEmployees();

}
