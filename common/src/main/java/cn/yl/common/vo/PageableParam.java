package cn.yl.common.vo;
import org.springframework.data.domain.Sort;

public class PageableParam {
    /**
     * 第几页
     */
    private int page;
    /**
     * 每页几条记录
     */
    private int size;
    /**
     * 排序
     */
    private Sort sort;

    private int offset;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
