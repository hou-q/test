package com.example.demo.pojo.bo.file;



import com.example.demo.pojo.bo.BaseBO;
import com.example.demo.pojo.bo.po.ConverterPO;
import com.example.demo.pojo.bo.vo.ConverterVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Description: 文件信息实体
 */
@ApiModel
public class FileStorageBO extends BaseBO implements ConverterPO, ConverterVO {

	/** 名称 */
	@NotEmpty(message = "名称不能为空")
	@ApiModelProperty("名称")
	private String name;
	/** 原名称 */
	@NotEmpty(message = "原名称不能为空")
	@ApiModelProperty("原名")
	private String originalName;
	/** 文件后缀名 */
	@NotEmpty(message = "文件后缀名不能为空")
	@ApiModelProperty("文件后缀名")
	private String suffixType;
	/** 相对路径 */
	@NotEmpty(message = "相对路径不能为空")
	@ApiModelProperty("相对路径")
	private String path;
	/** 绝对路径 */
	@JsonIgnore(true)
	@ApiModelProperty("绝对路径")
	private String absolutePath;
	/** 文件大小 */
	@NotNull(message = "文件大小不能为空")
	@ApiModelProperty("文件大小")
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

	/**
	 * 缩略图80*80
	 */
	@ApiModelProperty("缩略图80*80")
	private String path80;

	/**
	 * 缩略图 头像
	 */
	@ApiModelProperty("缩略图 头像")
	private String path25;

	@ApiModelProperty("备注或翻译")
	private String remark;

	/**
	 * 空构造文件信息业务对象实例
	 */
	public FileStorageBO() {
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

	public String getPath80() {
		return path80;
	}

	public void setPath80(String path80) {
		this.path80 = path80;
	}

	public String getPath25() {
		return path25;
	}

	public void setPath25(String path25) {
		this.path25 = path25;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
