package com.zwj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 政策表
 * </p>
 *
 * @author zwj
 * @since 2021-11-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("dpp_policy")
@ApiModel(value = "Policy对象", description = "政策表")
public class Policy implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("政策id")
    @TableId(type = IdType.ASSIGN_UUID)
    private String uuid;

    @ApiModelProperty("政策对应的政策主题id")
    private String themeId;

    @ApiModelProperty("政策标题")
    private String title;

    @ApiModelProperty("政策索引号")
    private String policyIndex;

    @ApiModelProperty("发文机关")
    private String publicUnit;

    @ApiModelProperty("发文字号")
    private String issuedNumber;

    @ApiModelProperty("发布日期")
    private LocalDate publicTime;

    @ApiModelProperty("成文日期")
    private LocalDate completeTime;

    @ApiModelProperty("政策内容")
    private String content;

    @ApiModelProperty("资料url")
    private String url;

    @ApiModelProperty("政策来源")
    private String source;

    @ApiModelProperty("省份")
    private String province;

}
