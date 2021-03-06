/** 
 * Copyright (c) 2012-2015 Wonders Information Co.,Ltd. All Rights Reserved.
 * 5/F 1600 Nanjing RD(W), Shanghai 200040, P.R.C 
 *
 * This software is the confidential and proprietary information of Wonders Group.
 * (Public Service Division / Research & Development Center). You shall not disclose such
 * Confidential Information and shall use it only in accordance with 
 * the terms of the license agreement you entered into with Wonders Group. 
 *
 * Distributable under GNU LGPL license by gun.org
 */
package com.wondersgroup.roa.annotation;

import com.wondersgroup.roa.context.ServiceMethodDefinition;

import java.lang.annotation.*;

/**
 * 使用该注解对服务方法进行标注，这些方法必须是Spring的Service:既打了@Service的注解。
 * 
 * @author Jacky.Li
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceMethod {

    /**
     * 服务的方法名，即由method参数指定的服务方法名
     *
     * @return
     */
    public String method() default "";

    /**
     * 所属的服务分组
     *
     * @return
     */
    public String group() default ServiceMethodDefinition.DEFAULT_GROUP;

    /**
     * 所属的服务分组的标识
     *
     * @return
     */
    public String groupTitle() default ServiceMethodDefinition.DEFAULT_GROUP_TITLE;

    /**
     * 标签，可以打上多个标签
     *
     * @return
     */
    public String[] tags() default {};

    /**
     * 服务的中文名称
     *
     * @return
     */
    public String title() default "";

    /**
     * 访问过期时间，单位为毫秒，即大于这个过期时间的链接会结束并返回错误报文，如果
     * 为0或负数则表示不进行过期限制
     *
     * @return
     */
    public int timeout() default -1;

    /**
     * 请求方法，默认不限制
     *
     * @return
     */
    public HttpAction[] httpAction() default {};

    /**
     * 该方法所对应的版本号，对应version请求参数的值，版本为空，表示不进行版本限定
     *
     * @return
     */
    public String version() default "";

    /**
     * 服务方法需要需求会话检查，默认要检查
     *
     * @return
     */
    public NeedInSessionType needInSession() default NeedInSessionType.DEFAULT;

    /**
     * 是否忽略签名检查，默认不忽略
     *
     * @return
     */
    public IgnoreSignType ignoreSign() default IgnoreSignType.DEFAULT;

    /**
     * 服务方法是否已经过期，默认不过期
     * 
     * @return
     */
    public ObsoletedType obsoleted() default  ObsoletedType.DEFAULT;
}
