package com.yootk.drp.vo;

import java.sql.Date;

/**
 * 用户沟通记录
 */
public class CustomerRecord {
    private Long crid ; //客户联系记录的id
    private String cmid ; //客户的用户id（member 表的 mid）
    private Date cdate ; //客户联系日期
    private Long criid ; //联系类型
    private String note ; //信息记录
    private Long cuid ; //客户的编号（customer 表的 cuid）
}
