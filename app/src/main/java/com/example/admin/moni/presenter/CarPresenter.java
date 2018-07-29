package com.example.admin.moni.presenter;

import com.example.admin.moni.bean.CarBean;
import com.example.admin.moni.bean.Shoping;
import com.example.admin.moni.model.CarModel;
import com.example.admin.moni.model.Car_Imodel;
import com.example.admin.moni.model.ShopingModel;
import com.example.admin.moni.model.Shoping_Imodel;
import com.example.admin.moni.view.Car_Iview;
import com.example.admin.moni.view.Shoping_Iview;

/**
 * author:admin
 * Date:2018-7-28 16:14
 * Project：Moni
 */
public class CarPresenter implements Shoping_Ipresenter {
    private Car_Iview mCar_iview;
    private CarModel mCarModel;

    public CarPresenter(Car_Iview car_iview) {
        mCar_iview = car_iview;
        mCarModel = new CarModel();
    }

    public void getDatas(){
        mCarModel.getData(new Car_Imodel() {
            @Override
            public void modelsuccess(CarBean carBean) {
                mCar_iview.viewsuccess(carBean);
            }

            @Override
            public void modelfail(int code) {
                mCar_iview.viewfail(code);
            }
        });
    }
    @Override
    public void presenterDestroys() {
        if (mCar_iview != null){
            mCar_iview = null;
        }
    }
}
