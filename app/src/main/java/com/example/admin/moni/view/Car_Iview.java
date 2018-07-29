package com.example.admin.moni.view;

import com.example.admin.moni.bean.CarBean;

/**
 * author:admin
 * Date:2018-7-28 16:13
 * Project：Moni
 */
public interface Car_Iview {
    void viewsuccess(CarBean carBean);

    void viewfail(int code);
}
