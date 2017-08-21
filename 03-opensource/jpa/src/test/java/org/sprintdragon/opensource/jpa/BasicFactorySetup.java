package org.sprintdragon.opensource.jpa;///*
// * Copyright 2013-2014 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package org.sprintdragon.wong.web;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
//import org.sprintdragon.wong.jpa.OrderTraceInfoJpaRepository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
///**
// * @author Oliver Gierke
// */
//public class BasicFactorySetup {
//
//    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa.database");
//
//    private OrderTraceInfoJpaRepository repository;
//    private EntityManager em;
//
//    /**
//     * @throws Exception
//     */
//    @Before
//    public void setUp() {
//
//        em = factory.createEntityManager();
//
//        repository = new JpaRepositoryFactory(em).getRepository(OrderTraceInfoJpaRepository.class);
//
//        em.getTransaction().begin();
//
//
//    }
//
//    /**
//     * Rollback transaction.
//     */
//    @After
//    public void tearDown() {
//
//        em.getTransaction().rollback();
//    }
//
//    /**
//     * Showing invocation of finder method.
//     */
//    @Test
//    public void executingFinders() {
//        System.out.println("##" + repository.findOne(766200478559182848l));
//    }
//}
