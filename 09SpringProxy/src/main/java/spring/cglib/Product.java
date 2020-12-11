package spring.cglib;

public class Product {

    public void saleProduct(float money) {
        System.out.println("销售产品并拿到钱"+money);
    }

    public void afterService(float money) {
        System.out.println("完成售后服务并拿到钱"+money);
    }
}
