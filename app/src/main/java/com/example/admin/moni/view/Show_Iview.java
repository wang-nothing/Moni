package com.example.admin.moni.view;

import com.example.admin.moni.bean.GoodBean;

/**
 * author:admin
 * Date:2018-7-28 9:59
 * Project：Moni
 */
public interface Show_Iview {
    void viewsuccess(GoodBean goodBean);

    void viewfail(int code);
}
