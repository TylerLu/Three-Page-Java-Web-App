package com.example.fabrikam.HotelCoupon.init;

import com.example.fabrikam.HotelCoupon.dao.CouponRepository;
import com.example.fabrikam.HotelCoupon.data.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//import sun.misc.BASE64Encoder;
import java.util.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

@Component
@Order(value=4)
public class InitCoupons implements CommandLineRunner {


    @Autowired
    private CouponRepository couponRepository;

    private Date[] getRandomFromTo(){
        int seed = 17;
        Random rand = new Random();
        int inDate = -1 * rand.nextInt(seed);
        int outDate = rand.nextInt(seed);
        Date dt = new Date();
        Date checkIn = calculateDate(dt,inDate);
        Date checkOut = calculateDate(dt,outDate);
        return new Date[]{checkIn,checkOut};
    }

    private Date calculateDate(Date dt,int diff){
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, diff);
        return c.getTime();
    }

    @Override
    public void run(String... args) throws Exception {
        for(String str : args){
            System.out.println("InitCoupons---------->"+str);
        }
        String[] addressLine1Array = new String[]{"1127 Eraad Lane","1720 Fogug Boulevard","830 Wapcig View","67 Wuhenu Street","512 Tadta Pass","1399 Hoca Key","1201 Botdip Court","750 Hafek Center"};
        String[] addressLine2Array = new String[]{"CRYSTAL LAKE, IL 60014","NEW BALTIMORE, MI 48047","WENATCHEE, WA 98801","PERTH AMBOY, NJ 08861","OSWEGO, NY 13126","PELHAM, AL 35124","DUBUQUE, IA 52001","ROCKY MOUNT, NC 27804"};
        String[] companyNameArray = new String[]{"Fourth Coffee","La Pepica","Scotts","Dim Sum","IKEA","GlenShee","Lily Vanilli","Lee"};
        String[] titleArray = new String[]{"Buy One Coffee, Get One Free","Buy Two Entrees, get $50 OFF","Unlimited Fries with every drink","25% OFF all baked goods","$200 OFF 3-night hotel stay","20% OFF Night Skiing passes","Buy One Dozen Cupcakes, Get 2 Free","50% OFF all sale merchandise"};


        String[] imageNameArray = new String[]{
                "shutterstock_261745823@2x.png","shutterstock_219202168@2x.png","shutterstock_273398612@2x.png","shutterstock_441814081@2x.png","shutterstock_560973166@2x.png","shutterstock_530971099@2x.png","shutterstock_410864815@2x.png","shutterstock_453427750@2x.png"
        };
        String qrCodeImgName = "QRcode@2x.png";

        for(int i = 0;i<8;i++){
            Coupon newCoupon = new Coupon();
            newCoupon.setAddressLine1(addressLine1Array[i]);
            newCoupon.setAddressLine2(addressLine2Array[i]);
            newCoupon.setCompanyName(companyNameArray[i]);
            newCoupon.setDescription("Lorem ipsum dolor sit amet, consectetur adpishing elit. Nam sed dignissim metus. Fusce aliquam odio et lectus accumsan, nec viverra ipsum tempor. In lorem massa, Lorem ipsum dolor sit amet.");
            Date[] fromTo = getRandomFromTo();
            newCoupon.setRedeemableFrom(fromTo[0]);
            newCoupon.setRedeemableTo(fromTo[1]);
            newCoupon.setImage(getBase64ImgString(imageNameArray[i]));
            newCoupon.setQrCodeImage(getBase64ImgString(qrCodeImgName));
            newCoupon.setTitle(titleArray[i]);

            if(couponRepository.findByTitle(titleArray[i]).isEmpty()) {
                couponRepository.save(newCoupon);
            }
        }
        System.out.println("Data is being initialized, init coupons............");
    }

    private String getBase64ImgString(String imageName)
    {
        String path = "/static/images/";
        String imgStr = "";
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource(path+imageName));
            imgStr = encodeToString(image,"png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgStr;
    }

    private String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            imageString = encryptBASE64(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    public static String encryptBASE64(byte[] data) {
        // BASE64Encoder encoder = new BASE64Encoder();
        // String encode = encoder.encode(data);
        Base64.Encoder encoder = Base64.getEncoder();
        String encode = encoder.encodeToString(data);
        return encode;
    }

}
