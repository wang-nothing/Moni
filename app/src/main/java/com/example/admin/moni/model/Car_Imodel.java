package com.example.admin.moni.model;

import com.example.admin.moni.bean.CarBean;

/**
 * author:admin
 * Date:2018-7-28 16:13
 * Project：Moni
 */
public interface Car_Imodel {
    void modelsuccess(CarBean carBean);

    void modelfail(int code);
}
