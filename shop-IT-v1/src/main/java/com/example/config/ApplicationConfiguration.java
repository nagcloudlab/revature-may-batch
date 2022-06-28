package com.example.config;

import com.example.billing.Billing;
import com.example.billing.OnlineBilling;
import com.example.pricematrix.PriceMatrix;
import com.example.pricematrix.PriceMatrix_v1;
import com.example.pricematrix.PriceMatrix_v2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.example"})
public class ApplicationConfiguration {

//    @Bean
//    public PriceMatrix priceMatrixV1(){
//        return new PriceMatrix_v1();
//    }
//
//    @Bean
//    public PriceMatrix priceMatrixV2(){
//        return new PriceMatrix_v2();
//    }
//
//    @Bean
//    public Billing onlineBilling(){
//        return new OnlineBilling(priceMatrixV1());
//    }

}
