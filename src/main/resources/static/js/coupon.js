;
HotelCoupon = window.HotelCoupon || {};
HotelCoupon.CouponFn= function(){
    var coupon = this;
    coupon.$printPopupTriggerSel = ".print-btn.popup,.coupon-item";
    coupon.$printPopupSel = ".coupon-item-detail.modal";
    coupon.$printPopupAttr = "value";
    coupon.popupDetail = function($couponPopup){
        if($couponPopup.is(":visible")){
            $couponPopup.hide();
        }else{
            $couponPopup.show()
        }
    };
    coupon.init = function(){
        $(coupon.$printPopupTriggerSel).click(function(){
            var couponId = $(this).attr(coupon.$printPopupAttr);
            var $targetCouponPopup = $(coupon.$printPopupSel).filter(function(){
                return $(this).attr(coupon.$printPopupAttr)===couponId;
            });
            coupon.popupDetail($targetCouponPopup);
            return false;
        });
    };
};
$(function(){
    var coupon = new HotelCoupon.CouponFn();
    coupon.init();
});