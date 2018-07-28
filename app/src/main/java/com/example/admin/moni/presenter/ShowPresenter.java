package com.example.admin.moni.presenter;

import com.example.admin.moni.bean.GoodBean;
import com.example.admin.moni.model.ShowModel;
import com.example.admin.moni.model.Show_Imodel;
import com.example.admin.moni.view.Show_Iview;

/**
 * author:admin
 * Date:2018-7-28 9:59
 * Project：Moni
 */
public class ShowPresenter implements Show_Ipresenter{
    private Show_Iview mShow_iview;
    private ShowModel mShowModel;

    public ShowPresenter(Show_Iview show_iview) {
        mShow_iview = show_iview;
        mShowModel = new ShowModel();
    }

    public void getDatas(String keywords, int page, int sort){
        mShowModel.getdata(new Show_Imodel() {
            @Override
            public void modelsuccess(GoodBean goodBean) {
                mShow_iview.viewsuccess(goodBean);
            }

            @Override
            public void modelfail(int code) {
                mShow_iview.viewfail(code);
            }
        },keywords, page, sort);
    }

    @Override
    public void presenterDestroys() {
        if (mShow_iview != null){
            mShowModel = null;
        }
    }
}
