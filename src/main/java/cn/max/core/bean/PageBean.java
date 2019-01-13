package cn.max.core.bean;


import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
    private List<T> pageData;
    private Integer currentPage = Integer.valueOf(1);
    private Integer pageSize;
    private Integer totalCount;

    public PageBean(List<T> pageData, int totalCount, int pageSize) {
        this.pageData = pageData;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
    }

    public int getPageCount(){
        if (this.totalCount.intValue() % this.pageSize.intValue() == 0) {
            return this.totalCount.intValue() / this.pageSize.intValue();
        }
        return this.totalCount.intValue() / this.pageSize.intValue() + 1;
    }

    public PageBean() {}

    public boolean isFirst()
    {
        return (this.currentPage.intValue() == 1) || (this.totalCount.intValue() == 0);
    }

    public boolean isLast() {
        return (this.totalCount.intValue() == 0) || (this.currentPage.intValue() >= getPageCount());
    }

    public boolean isHasNext()
    {
        return this.currentPage.intValue() < getPageCount();
    }

    public boolean isHasPrev() {
        return this.currentPage.intValue() > 1;
    }
    public Integer getNextPage()
    {
        if (this.currentPage.intValue() >= getPageCount()) {
            return Integer.valueOf(getPageCount());
        }
        return Integer.valueOf(this.currentPage.intValue() + 1);
    }

    public Integer getPrevPage() {
        if (this.currentPage.intValue() <= 1) {
            return Integer.valueOf(1);
        }
        return Integer.valueOf(this.currentPage.intValue() - 1);
    }

    public List<T> getPageData() {
        return this.pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public Integer getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public static int calculateCurrentPageNum(Integer pageNo) {
        return (pageNo-1)/5;
    }

    public List<String> getPageView() {
        return pageView;
    }

    private List<String> pageView;
    public void pageView(String url, String parameter) {
        pageView = new ArrayList<>();
        pageView.add("<font size=2>首页</font>");
        pageView.add("<font size=2>上一页</font>");

        int pageCount = totalCount/pageSize;
        for (int i = 1; i <= pageCount; i++) {
            if (currentPage == i) {
                pageView.add("<strong>"+currentPage+"</strong>");
            } else {
                pageView.add("<a href="+url+"?"+parameter+"&amp;pageNo="+i+">"+i+"</a>");
            }
        }
        pageView.add("共<var>"+pageCount+"</var>页 到第<input type=\"text\" size=\"3\" id=\"PAGENO\"/>页 <input type=\"button\" onclick=\"javascript:window.location.href ='" + url + "?" + parameter + "&amp;pageNo=' + $('#PAGENO').val() \" value=\"确定\" class=\"hand btn60x20\" id=\"skip\"/>");
    }
}
/*
pageView:
<font size="2">首页</font>

		<font size="2">上一页</font>

		<strong>1</strong>

		<a href="/brand/list.do?&amp;isShow=0&amp;pageNo=2">2</a>

		<a href="/brand/list.do?&amp;isShow=0&amp;pageNo=3">3</a>

		<a href="/brand/list.do?&amp;isShow=0&amp;pageNo=4">4</a>

		<a href="/brand/list.do?&amp;isShow=0&amp;pageNo=5">5</a>

		<a href="/brand/list.do?&amp;isShow=0&amp;pageNo=2"><font size="2">下一页</font></a>

		<a href="/brand/list.do?&amp;isShow=0&amp;pageNo=5"><font size="2">尾页</font></a>

		共<var>5</var>页 到第<input type="text" size="3" id="PAGENO"/>页 <input type="button" onclick="javascript:window.location.href = '/brand/list.do?&amp;isShow=0&amp;pageNo=' + $('#PAGENO').val() " value="确定" class="hand btn60x20" id="skip"/>
 */
