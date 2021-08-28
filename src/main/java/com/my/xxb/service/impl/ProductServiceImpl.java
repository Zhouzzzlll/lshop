package com.my.xxb.service.impl;

import com.my.xxb.dao.ProductDao;
import com.my.xxb.pojo.Order;
import com.my.xxb.pojo.Product;
import com.my.xxb.pojo.Shopcart;
import com.my.xxb.pojo.Userinfo;
import com.my.xxb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @authot: GSZ
 * @time: 2021/4/30 14:08
 **/


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> getAllselected() {
        System.out.println(productDao.getAllselected());
        return productDao.getAllselected();
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public List<Product> getBybrand(String pb) {
        List<Product> bybrand = productDao.getBybrand(pb);
        return bybrand;
    }

    @Override
    public int savecart(Shopcart shopcart) {
        return productDao.savecart(shopcart.getUsername(),shopcart.getProductnum(),shopcart.getProductprice(),shopcart.getProductimg(),shopcart.getProductbrand());
    }

    @Override
    public List<Shopcart> getAllcart(String username) {
        return productDao.getAllcart(username);
    }

    @Override
    public int deleteProduct(String productbrand) {
        return productDao.deleteProduct(productbrand);
    }

    @Override
    public int updateProduct(int pn, String pb) {
        return productDao.updateProduct(pn,pb);
    }

    @Override
    public int insertOrder(Order order) {
        int i = productDao.insertOrder(order.getProductbrand(), order.getUsername(), order.getState(), order.getProductprice(), order.getNum());
        return i;
    }

    @Override
    public int deletefromshop(Order order) {
        return productDao.deletefromshop(order.getUsername(),order.getProductbrand());
    }

    @Override
    public Map<String,String> pay(String username) {
        Map<String, String> pay = productDao.pay(username);
        return pay;
    }

    @Override
    public Map<String, String> payone(String username, String productbrand) {
        Map<String, String> payone = productDao.payone(username, productbrand);
        return payone;
    }

    @Override
    public Shopcart repeat(String us, String pb) {
        Shopcart repeat = productDao.repeat(us, pb);
        return repeat;
    }

    @Override
    public int userinfo(Userinfo u) {
        return productDao.userinfo(u.getUsername(),u.getSex(),u.getAddr(),u.getPhone());
    }

    @Override
    public Userinfo infoAll(String username) {
        Userinfo userinfo = productDao.infoAll(username);
        return userinfo;
    }

    @Override
    public int updateInfo(Userinfo us) {
        int i = productDao.updateInfo(us.getSex(), us.getAddr(), us.getPhone(), us.getUsername());
        return i;
    }

    @Override
    public int updatestate(String username) {
        int updatestate = productDao.updatestate(username);
        return updatestate;
    }

    @Override
    public int updatecollect(String c, String u) {
        int updatecollect = productDao.updatecollect(c, u);

        return updatecollect;
    }

    @Override
    public Order findOrder() {
        Order order = productDao.findOrder();
        return order;
    }

    @Override
    public List<Product> limitGetProduct(int curpage, int pagesize) {
        List<Product> products = productDao.limitGetProduct(curpage, pagesize);
        return products;
    }

    @Override
    public int count() {
        int count = productDao.count();
        return count;
    }

    @Override
    public List<Product> getAllByName(String name) {
        List<Product> allByName = productDao.getAllByName(name);
        return allByName;
    }

    @Override
    public Product getOneByName(String productbrand) {
        Product oneByName = productDao.getOneByName(productbrand);
        return oneByName;
    }

    @Override
    public int deleteByid(Integer id) {
        int i = productDao.deleteByid(id);
        return i;
    }

    @Override
    public int updatepb(String pp, String pr, String pl, Integer pi) {
        int updatepb = productDao.updatepb(pp, pr, pl,pi);
        return updatepb;
    }

    @Override
    public int addproduct(Product p) {
        int addproduct = productDao.addproduct(p.getProductname(), p.getProductprice(), p.getProductimg(), p.getProductdesc(),
                p.getProductbrand(), p.getProductremarks(), p.getProductlevel());
        return addproduct;
    }


}
