package com.my.xxb.controller;

import com.my.xxb.pojo.*;
import com.my.xxb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @description:
 * @authot: GSZ
 * @time: 2021/4/29 22:49
 **/

@CrossOrigin
@RestController
@RequestMapping("product")
public class productController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productListselected")
    public List<Product> getAllselected(){
        List<Product> products = productService.getAllselected();
        return products;
    }

    @GetMapping("/productList")
    public List<Product> getAll(){
        List<Product> products = productService.getAll();
        return products;
    }

    @GetMapping("/productBybrand")
    public List<Product> getBybrand(@RequestParam("productbrand") String productbrand){
        List<Product> bybrand = productService.getBybrand(productbrand);
        return bybrand;
    }
    @PostMapping("/shopcartList")
    public int saveCart(@RequestBody Shopcart s){
        int i = productService.savecart(s);
        return i;
    }

    @GetMapping("/getshopcart/{username}")
    public List<Shopcart> getAllcart(@PathVariable("username") String username){
        List<Shopcart> allcart = productService.getAllcart(username);
        return allcart;
    }

    @GetMapping("/deleteproduct/{productbrand}")
    public int deleteproduct(@PathVariable("productbrand") String productbrand){
        System.out.println(productbrand);
        int i = productService.deleteProduct(productbrand);
        return i;
    }

    @PostMapping("/updateproduct")
    public int updateproduct(@RequestBody Shopcart s){
        int i = productService.updateProduct(s.getProductnum(),s.getProductbrand());
        return i;
    }

    @PostMapping("/insertorder")
    public int insertorder(@RequestBody Order order){
        int i = productService.insertOrder(order);
        return i;
    }
    @PostMapping("/deletefromshop")
    public int deletefromshop(@RequestBody Order order){
        int deletefromshop = productService.deletefromshop(order);
        return deletefromshop;
    }

    @GetMapping("/pay/{username}")
    public Map pay(@PathVariable("username") String username){
        Map<String, String> pay = productService.pay(username);
        return  pay;
    }

    @GetMapping("/pay/{username}/{productbrand}")
    public Map pay(@PathVariable("username") String username,
                   @PathVariable("productbrand") String productbrand){
        Map<String, String> pay = productService.payone(username,productbrand);
        return  pay;
    }
    @GetMapping("/repeat/{username}/{productbrand}")
    public Shopcart repeat(@PathVariable("username") String username,
                           @PathVariable("productbrand") String productbrand){
        Shopcart repeat = productService.repeat(username, productbrand);
        return repeat;
    }

    @PostMapping("/userinfo")
    public int userinfo(@RequestBody Userinfo userinfo){
        int info = productService.userinfo(userinfo);
        return info;
    }

    @PostMapping("/infoAll")
    public Userinfo infoAll(@RequestBody Userinfo us){
        Userinfo userinfo = productService.infoAll(us.getUsername());
        return userinfo;
    }
    @GetMapping("/infoAll")
    public Userinfo infoAll1(@RequestParam("username")String username){
        System.out.println(username);
        Userinfo userinfo = productService.infoAll(username);
        return userinfo;
    }

    @PostMapping("/updateinfo")
    public int updateInfo(@RequestBody Userinfo us){
        int i = productService.updateInfo(us);
        return i;
    }

    @GetMapping("/updatestate")
    public int updatestate(@RequestParam("username")String username){
        int updatestate = productService.updatestate(username);
        return updatestate;
    }

    @GetMapping("/updatecollect")
    public int updatecollect(@RequestParam("collect")String c,@RequestParam("username") String u){
        int updatecollect = productService.updatecollect(c, u);
        return updatecollect;
    }

    @GetMapping("/findOrder")
    public Order findOrder(){
        Order order = productService.findOrder();
        return order;
    }

    @ResponseBody
    @GetMapping("/limitProduct")
    public List<Product> limitAll(@RequestParam("curpage")int curpage, @RequestParam("pagesize") int pagesize){
        List<Product> a = productService.limitGetProduct((curpage-1)*pagesize,pagesize);
        return a;
    }

    @ResponseBody
    @GetMapping("/count")
    public int count(){
        int count = productService.count();
        return count;
    }

    @ResponseBody
    @PostMapping("/bypb")
    public List<Product> getAllByName(@RequestBody Product pb){
        System.out.println(pb);
        List<Product> allByName = productService.getAllByName(pb.getProductbrand());
        return allByName;
    }

    @ResponseBody
    @PostMapping("/byone")
    public Product getOneByName(@RequestBody Product pb){
        Product oneByName = productService.getOneByName(pb.getProductbrand());
        return oneByName;
    }

    @ResponseBody
    @GetMapping("/deleteByid")
    public int deleteByid(@RequestParam("productid") int productid){
        int i = productService.deleteByid(productid);
        return i;
    }

    @ResponseBody
    @PostMapping("updatepb")
    public int updatepb(@RequestBody Product pt){
        int updatepb = productService.updatepb(pt.getProductprice(), pt.getProductremarks(), pt.getProductlevel(), pt.getProductid());
        return updatepb;
    }

    @ResponseBody
    @PostMapping("uploadSp")
    public FileDto uploadSp(MultipartFile file, HttpServletRequest httpServletRequest){
        FileDto f = new FileDto();
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        if(suffixName.equals(".jpg")||suffixName.equals(".png")){
            String uuid = UUID.randomUUID().toString().replace("-","");
            String newFileName = uuid + suffixName;
            File file1 = new File("D:\\vscode\\vue_shop\\src\\assets",newFileName);
            if(file1.exists()){
                f.setMsg("该文件名被占用");
            }else{
                try {
                    file.transferTo(file1);
                    f.setMsg("上传成功");
                    f.setFilename(newFileName);
                } catch (IOException e) {
                    f.setMsg("文件上传失败");
                }
            }
        }else {
            f.setMsg("格式错误");
        }
        return f;
    }

    @ResponseBody
    @PostMapping("/addproduct")
    public int addproduct(@RequestBody Product p){
        int addproduct = productService.addproduct(p);
        return addproduct;
    }
}
