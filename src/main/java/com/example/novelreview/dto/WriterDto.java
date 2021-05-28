package com.example.novelreview.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class WriterDto {

    @NotNull
    @Size(min = 6, max = 100, message = "Name must between the length of 6 characters and 100 characters")
    private String name;

    @NotNull
    @Pattern(regexp = "^(\\+?6?01)[0-46-9]-*[0-9]{7,8}$", message="Phone number is not valid")
    private String phone;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",
                message = "Email Address is not valid")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
