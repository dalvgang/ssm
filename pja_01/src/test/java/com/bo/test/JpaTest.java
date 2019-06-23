package com.bo.test;

import com.bo.domain.Customer;
import com.bo.utlis.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaTest {
    @Test
    public void testSave() {
        EntityManager entityManager = JpaUtils.getEntityManager ();
        EntityTransaction transaction = entityManager.getTransaction ();
transaction.begin ();

        Customer customer = new Customer();
        customer.setCustName("1吕博文");
        customer.setCustIndustry("亚亚");
        //保存，
        entityManager.persist(customer); //保存操作
        //5.提交事务
        transaction.commit();
        //6.释放资源
        entityManager.close();


    }

    @Test
    public void testFind() {
        EntityManager entityManager = JpaUtils.getEntityManager ();

        EntityTransaction transaction = entityManager.getTransaction ();

        transaction.begin ();

        Customer customer = entityManager.find ( Customer.class, 1l );

        System.out.println (customer);
        //5.提交事务
        transaction.commit();
        //6.释放资源
        entityManager.close();


    }
    @Test
    public void testReference() {
        EntityManager entityManager = JpaUtils.getEntityManager ();

        EntityTransaction transaction = entityManager.getTransaction ();

        transaction.begin ();

        Customer customer = entityManager.getReference( Customer.class, 1l );

        System.out.println (customer);
        //5.提交事务
        transaction.commit();
        //6.释放资源
        entityManager.close();


    }

    @Test
    public void testRemove() {
        EntityManager entityManager = JpaUtils.getEntityManager ();

        EntityTransaction transaction = entityManager.getTransaction ();

        transaction.begin ();

        Customer customer = entityManager.find ( Customer.class, 2l );


        System.out.println (customer);
        entityManager.remove ( customer );
        //5.提交事务
        transaction.commit();
        //6.释放资源
        entityManager.close();


    }
    @Test
    public void testUpdate() {
        EntityManager entityManager = JpaUtils.getEntityManager ();

        EntityTransaction transaction = entityManager.getTransaction ();

        transaction.begin ();

        Customer customer = entityManager.find ( Customer.class, 4l );


        System.out.println (customer);
        customer.setCustName ("张");
        entityManager.merge ( customer );
        //5.提交事务
        transaction.commit();
        //6.释放资源
        entityManager.close();


    }

}
