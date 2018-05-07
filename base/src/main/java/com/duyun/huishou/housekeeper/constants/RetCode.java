package com.duyun.huishou.housekeeper.constants;

/**
 * @author haoshijing
 * @version 2018年01月09日 17:20
 **/
public final  class RetCode {

    /**
     * 服务器处理请求并返回成功
     */
    public  static final int OK = 200;

    /**
     * 服务器内部严重错误，无法完成服务是返回
     */
    public  static final int SERVICE_ERROR = 500;

    /**
     * 拒绝像客户端提供服务，请求有误时返回
     */
    public static final int REQUEST_ERROR = 406;

    /**
     * not found
     */
    public static final int NOT_FOUND = 404;

    public static final int ERROR_BIZ_PARAM = 410;

    /**
     * TOKEN无效
     */
    public static final int TOKEN_VALID = 511;

    /**
     * 黑名单
     */
    public static final int BLOCKED = 510;

    /**
     * 未登录
     */
    public static final int REQUEST_LOGIN = 401;

    /**
     * 参数错误
     */
    public static final int ERROR_PARAMS = 400;
}
