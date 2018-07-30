package com.example.admin.moni.model;

import com.example.admin.moni.bean.CarBean;

public interface Car_Imodel {
    void modelsuccess(CarBean carBean);

    void modelfail(int code);
}
