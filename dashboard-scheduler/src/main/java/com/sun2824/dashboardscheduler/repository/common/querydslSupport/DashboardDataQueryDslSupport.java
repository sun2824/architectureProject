package com.sun2824.dashboardscheduler.repository.common;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sun2824.dashboardscheduler.domain.common.QCustomerInfo;
import com.sun2824.dashboardscheduler.domain.common.QPurchaseTable;
import com.sun2824.dashboardscheduler.model.dto.CustomerInfoDTO;
import com.sun2824.dashboardscheduler.model.dto.PurchaseTableDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DashboardDataQueryDslSupport {
    private EntityManager em;
    private JPAQueryFactory queryFactory;

    QCustomerInfo qCustomerInfo = QCustomerInfo.customerInfo;

    QPurchaseTable qPurchaseTable = QPurchaseTable.purchaseTable;

    @PersistenceContext(unitName = "common")
    public void setEntityManager(EntityManager entityManager) {
        em = entityManager;
        this.queryFactory = new JPAQueryFactory(em);
    }

    public JsonObject weekCustomerInfo() {

        JsonObject customerInfoMap = new JsonObject();

        for (int i = 2; i <= 5; i++) {
            JsonArray customerInfoList = new JsonArray();
            for (int j = 6; j > -1; j--) {

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.DATE, -j);
                String firstDate = format.format(calendar.getTime());
                calendar.add(Calendar.DATE, -1);
                String secondDate = format.format(calendar.getTime());

                long customerCnt = queryFactory.select(
                        qCustomerInfo.customerId
                )
                        .from(qCustomerInfo)
                        .where(
                                Expressions.stringTemplate("DATE_FORMAT({0}, {1})", qCustomerInfo.createdAt, ConstantImpl.create("%Y-%m-%d")).between(
                                        secondDate,
                                        firstDate),
                                Expressions.stringTemplate("FLOOR({0}/10) * 10", qCustomerInfo.age).eq(Expressions.stringTemplate("FLOOR({0}/10) * 10", i*10))
                        )
                        /*.groupBy(Expressions.stringTemplate("FLOOR({0}/10) * 10", qCustomerInfo.age).eq(Expressions.stringTemplate("FLOOR({0}/10) * 10", i)))*/
                        .fetchCount();

                JsonObject jsonObject = new JsonObject();

                jsonObject.addProperty(firstDate, customerCnt);

                customerInfoList.add(jsonObject);
            }
            customerInfoMap.add(String.format("%d", i * 10), customerInfoList);
        }

        return customerInfoMap;
    }

    public JsonArray dailyCustomerGrade() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        JsonArray jsonArray = new JsonArray();
        for (CustomerInfoDTO customerInfoDTO : queryFactory
                .select(Projections.bean(CustomerInfoDTO.class,
                        qCustomerInfo.grade,
                        qCustomerInfo.count().as("cnt")
                ))
                .from(qCustomerInfo)
                .where(Expressions.stringTemplate("DATE_FORMAT({0}, {1})", qCustomerInfo.createdAt, ConstantImpl.create("%Y-%m-%d")).eq(format.format(new Date())))
                .groupBy(qCustomerInfo.grade)
                .fetch()) {
            JsonObject jsonObject = new JsonObject();

            jsonObject.addProperty("grade", customerInfoDTO.getGrade());
            jsonObject.addProperty("cnt", customerInfoDTO.getCnt());

            jsonArray.add(jsonObject);
        }

        return jsonArray;
    }

    public JsonArray dailyGradePurchasePrice() {
        String[] strList = {"Bronze", "Silver", "Gold", "Platinum", "Diamond"};

        JsonArray jsonArrayTotal = new JsonArray();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String now = format.format(new Date());

        for (String str : strList) {

            JsonObject jsonObject = new JsonObject();

            JsonArray jsonArray = new JsonArray();

            List<PurchaseTableDTO> purchaseTableDTOList =
                    queryFactory
                            .select(Projections.bean(PurchaseTableDTO.class,
                                    new CaseBuilder()
                                            .when(
                                                    qPurchaseTable.price.between(1000000, 2000000)
                                            ).then("1")
                                            .when(
                                                    qPurchaseTable.price.between(2000001, 3000000)
                                            ).then("2")
                                            .when(
                                                    qPurchaseTable.price.between(3000001, 5000000)
                                            ).then("3")
                                            .when(
                                                    qPurchaseTable.price.between(5000001, 7000000)
                                            ).then("4")
                                            .when(
                                                    qPurchaseTable.price.gt(9999999)
                                            ).then("5")
                                            .otherwise("0").as("priceGroup"),
                                    qPurchaseTable.customerId,
                                    qCustomerInfo.grade,
                                    qPurchaseTable.uuid,
                                    qPurchaseTable.count().as("cnt")
                            ))
                            .from(qPurchaseTable)
                            .innerJoin(qCustomerInfo).on(qCustomerInfo.customerId.eq(qPurchaseTable.customerId))
                            .where(
                                    Expressions.stringTemplate("DATE_FORMAT({0}, {1})", qCustomerInfo.createdAt, ConstantImpl.create("%Y-%m-%d")).eq(now),
                                    qCustomerInfo.grade.eq(str)
                            )
                            .groupBy(new CaseBuilder()
                                    .when(
                                            qPurchaseTable.price.between(1000000, 2000000)
                                    ).then("1")
                                    .when(
                                            qPurchaseTable.price.between(2000001, 3000000)
                                    ).then("2")
                                    .when(
                                            qPurchaseTable.price.between(3000001, 5000000)
                                    ).then("3")
                                    .when(
                                            qPurchaseTable.price.between(5000001, 7000000)
                                    ).then("4")
                                    .when(
                                            qPurchaseTable.price.gt(9999999)
                                    ).then("5")
                                    .otherwise("0"))
                            .fetch();

            for (PurchaseTableDTO purchaseTableDTO : purchaseTableDTOList) {
                JsonObject jsonObjectTemp = new JsonObject();

                jsonObjectTemp.addProperty("cnt", purchaseTableDTO.getCnt());
                jsonObjectTemp.addProperty("priceGroup", purchaseTableDTO.getPriceGroup());

                jsonArray.add(jsonObjectTemp);
            }

            jsonObject.add(str, jsonArray);

            jsonArrayTotal.add(jsonObject);
        }

        return jsonArrayTotal;
    }
}
