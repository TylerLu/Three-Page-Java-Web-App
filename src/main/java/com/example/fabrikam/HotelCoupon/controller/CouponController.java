package com.example.fabrikam.HotelCoupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CouponController {

    @RequestMapping("/coupon")
    public String index(Model model,String guestId) {
        System.out.println("guestId:"+guestId);
        return "coupon";
    }

}
