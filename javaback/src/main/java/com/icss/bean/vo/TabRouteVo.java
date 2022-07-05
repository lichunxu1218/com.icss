package com.icss.bean.vo;

import com.icss.bean.TabRoute;
import com.icss.bean.TabRouteImg;
import com.icss.bean.TabSeller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TabRouteVo {
    private TabRoute tabRoute;

    private List<TabRouteImg> imgList;

    private TabSeller tabSeller;
}
