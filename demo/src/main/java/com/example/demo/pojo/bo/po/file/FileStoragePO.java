package com.example.demo.pojo.bo.po.file;



import com.example.demo.pojo.bo.ConverterBO;
import com.example.demo.pojo.bo.po.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * file_storage 
 * @author 
 */
@ApiModel
public class FileStoragePO extends BasePO implements ConverterBO {
    /** ID */
    @ApiModelProperty("ID")
    private String id;

    /** 名称 */
    @ApiModelProperty("名称")
    private String name;

    /** 原名称 */
    @ApiModelProperty("原名称")
    private String originalName;

    /** 文件后缀名 */
    @ApiModelProperty("文件后缀名")
    private String suffixType;

    /** 路径 */
    @ApiModelProperty("路径")
    private String path;

    /** 绝对路径 */
    @ApiModelProperty("绝对路径")
    private String absolutePath;

    /** 文件大小,bytes */
    @ApiModelProperty("文件大小,bytes")
    private Long fileSize;

    /** 文件类型 */
    @ApiModelProperty("文件类型")
    private String fileType;

    /** 文件MD5值 */
    @ApiModelProperty("文件MD5值")
    private String md5;

    /** 文件所属对象Id */
    @ApiModelProperty("文件所属对象Id")
    private String belongId;

    /** 文件所属模块类型 */
    @ApiModelProperty("文件所属模块类型")
    private String belongType;

    /** 创建时间 */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /** 创建用户名 */
    @ApiModelProperty("创建用户名")
    private String createUser;

    /** 更新时间 */
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /** 更新用户名 */
    @ApiModelProperty("更新用户名")
    private String updateUser;

    /** 备注或翻译 */
    @ApiModelProperty("备注或翻译")
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getSuffixType() {
        return suffixType;
    }

    public void setSuffixType(String suffixType) {
        this.suffixType = suffixType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getBelongId() {
        return belongId;
    }

    public void setBelongId(String belongId) {
        this.belongId = belongId;
    }

    public String getBelongType() {
        return belongType;
    }

    public void setBelongType(String belongType) {
        this.belongType = belongType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}