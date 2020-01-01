package cn.itcast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;



@Controller
public class Test {

	@Autowired
    private MongoTemplate mt; //自动注入MongoTemplate
	@RequestMapping("/index")
	public String showIndex() {
		System.out.println("@");
		DBCollection db = mt.getCollection("user"); //获取test数据库里面的user这个collection

        DBCursor dc = db.find();

        while (dc.hasNext()) {
            DBObject obj = dc.next();

            System.out.println(obj);
        }
        System.out.println("!!");
		return "index";
	}

}
