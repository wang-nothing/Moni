package com.example.admin.moni.model;

import com.example.admin.moni.bean.GoodBean;

/**
 * author:admin
 * Date:2018-7-28 9:59
 * Project：Moni
 */
public interface Show_Imodel {
    void modelsuccess(GoodBean goodBean);

    void modelfail(int code);
}
