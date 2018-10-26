;
HotelCoupon = window.HotelCoupon || {};
HotelCoupon.LoginFn = function(){
    var login = this;
    login.$formSel = "form";
    login.$submitBtnSel = "form .submit";
    login.submitLogin = function(){
        $(login.$formSel).submit();
    };
    login.init = function(){
        $(login.$submitBtnSel).click(function(){
            login.submitLogin();
        });
    };
};
$(function(){
    var login = new HotelCoupon.LoginFn();
    login.init();
});