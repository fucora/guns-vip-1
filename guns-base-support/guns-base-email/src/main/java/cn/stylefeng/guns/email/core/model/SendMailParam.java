package cn.stylefeng.guns.email.core.model;

import lombok.Data;

/**
 * 发送邮件的请求参数
 *
 * @author fengshuonan
 * @date 2018-07-05 21:19
 */
@Data
public class SendMailParam {

    /**
     * 发送给某人的邮箱
     */
    private String to;

    /**
     * 邮件标题
     */
    private String title;

    /**
     * 邮件内容（经过base64编码后的）
     */
    private String content;
}
