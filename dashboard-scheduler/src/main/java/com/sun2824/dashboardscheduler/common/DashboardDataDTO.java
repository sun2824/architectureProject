package com.sun2824.dashboardscheduler.common;

import com.sun2824.dashboardscheduler.domain.common.DashboardData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDataDTO extends DashboardData {

    /*offset limit*/
    long offset;
    long limit;

    /*화면 표출*/
    String userAuthNm;

    /*FootPrint*/
    String scrnCd;
    String bhvrCd;
    String pageUrl;
    String historyYn;

    /*payloadForData*/
    List<String> userAuths;
    List<String> userIds;
    List<String> useYns;

    /*Authentication*/
    String refreshToken;

    /*비밀번호 초기화 체크*/
    String resetPwdChk;
}
