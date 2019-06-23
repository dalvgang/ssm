package com.bo.test;

import com.bo.dao.CustomerDao;
import com.bo.dao.LinkManDao;
import com.bo.domain.Customer;
import com.bo.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import sun.java2d.pipe.SpanClipRenderer;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ObjectQueryTest {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;
    @Test
    @Transactional // 解决在java代码中的no session问题
    public void  testQuery1() {
        Customer one = customerDao.getOne ( 1l );
        Set<LinkMan> linkMans = one.getLinkMans ();
        for (LinkMan linkMan : linkMans) {
            System.out.println (linkMan);

        }

    }
    @Test
    @Transactional // 解决在java代码中的no session问题
    public void  testQuery2() {
        //查询id为1的客户
        Customer customer = customerDao.findOne(1l);
        //对象导航查询，此客户下的所有联系人
        Set<LinkMan> linkMans = customer.getLinkMans();

            System.out.println(linkMans.size());
    }
    @Test
    public void testFind() {
        Specification<LinkMan> spam=new Specification<LinkMan> () {
            public Predicate toPredicate ( Root<LinkMan> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder ) {
                Join<Object, Object> customer = root.join ( "customer", JoinType.INNER );
                return criteriaBuilder.like(customer.get("custName").as(String.class),"传智播客1") ;

            }
        };
        List<LinkMan> list = linkManDao.findAll(spam);
        for (LinkMan linkMan : list) {
            System.out.println(linkMan);
        }
    }

}
