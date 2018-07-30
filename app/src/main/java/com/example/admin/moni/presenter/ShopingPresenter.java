package com.example.admin.moni.presenter;

import com.example.admin.moni.bean.Shoping;
import com.example.admin.moni.model.ShopingModel;
import com.example.admin.moni.model.Shoping_Imodel;
import com.example.admin.moni.view.Shoping_Iview;

public class ShopingPresenter implements Shoping_Ipresenter {
    private Shoping_Iview mShoping_iview;
    private ShopingModel mShopingModel;

    public ShopingPresenter(Shoping_Iview shoping_iview) {
        mShoping_iview = shoping_iview;
        mShopingModel = new ShopingModel();
    }
    public void getDatas(int pid){
        mShopingModel.getData(new Shoping_Imodel() {
            @Override
            public void modelsuccess(Shoping shoping) {
                mShoping_iview.viewsuccess(shoping);
            }

            @Override
            public void modelfail(int code) {
                mShoping_iview.viewfail(code);
            }
        }, pid);
    }
    @Override
    public void presenterDestroys() {
        if (mShoping_iview != null){
            mShoping_iview = null;
        }
    }
}
