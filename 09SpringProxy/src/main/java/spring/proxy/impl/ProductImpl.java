package spring.proxy.impl;

import spring.proxy.Product;

public class ProductImpl implements Product {

    @Override
    public void saleProduct(float money) {
        System.out.println("销售产品并拿到钱"+money);
    }

    @Override
    public void afterService(float money) {
        System.out.println("完成售后服务并拿到钱"+money);
    }
}
