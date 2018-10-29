package com.example.fabrikam.HotelCoupon.controller;

import com.example.fabrikam.HotelCoupon.dao.CouponRepository;
import com.example.fabrikam.HotelCoupon.data.Coupon;
import com.example.fabrikam.HotelCoupon.model.CouponListViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CouponController {

    @Autowired
    private CouponRepository couponRepository;

    @RequestMapping("/coupon")
    public String index(Model model,String guestId) {
        ArrayList<Coupon> couponList = couponRepository.findAll();
        model.addAttribute("couponsModel", new CouponListViewModel(couponList));
        return "coupon";
    }

}
