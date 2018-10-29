package com.example.fabrikam.HotelCoupon.model;

import com.example.fabrikam.HotelCoupon.data.Coupon;

import javax.validation.Valid;
import java.util.ArrayList;

public class CouponListViewModel {
    @Valid
    private ArrayList<Coupon> couponList = new ArrayList<Coupon>();

    public CouponListViewModel() {}

    public CouponListViewModel(ArrayList<Coupon> couponList) {
        this.couponList = couponList;
    }

    public ArrayList<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(ArrayList<Coupon> couponList) {
        this.couponList = couponList;
    }
}
