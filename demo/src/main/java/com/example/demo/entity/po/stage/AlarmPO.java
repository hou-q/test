package com.example.demo.entity.po.stage;



import com.example.demo.pojo.bo.ConverterBO;
import com.example.demo.pojo.bo.po.BasePO;
import io.swagger.annotations.*;
import java.util.Date;

/**
 * ps_alarm 
 * @author 
 */
@ApiModel
public class AlarmPO extends BasePO implements ConverterBO {
    /** ID */
    @ApiModelProperty("ID")
    private String id;

    /** 警情编号 */
    @ApiModelProperty("警情编号")
    private String code;

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

    /** 关联当事人表ID */
    @ApiModelProperty("关联当事人表ID")
    private String partyId;

    /** 警情内容 */
    @ApiModelProperty("警情内容")
    private String content;

    /** 警情类型(涉黑，涉恶...) */
    @ApiModelProperty("警情类型(涉黑，涉恶...)")
    private String type;

    /** 报警时间 */
    @ApiModelProperty("报警时间")
    private Date time;

    /** 报警地址 */
    @ApiModelProperty("报警地址")
    private String address;

    /** 警情录入时间 */
    @ApiModelProperty("警情录入时间")
    private Date insertTime;

    /** 警情状态 */
    @ApiModelProperty("警情状态")
    private Integer state;

    /** 警情经度 */
    @ApiModelProperty("警情经度")
    private Double longitude;

    /** 警情纬度 */
    @ApiModelProperty("警情纬度")
    private Double latitude;

    /** 报警人电话 */
    @ApiModelProperty("报警人电话")
    private String telephone;

    /** 报警方式 */
    @ApiModelProperty("报警方式")
    private String way;

    /** 报警人姓名 */
    @ApiModelProperty("报警人姓名")
    private String name;

    /** 接警单位 */
    @ApiModelProperty("接警单位")
    private String company;

    /** 警情类型编码 */
    @ApiModelProperty("警情类型编码")
    private Integer typeCode;

    /** 接警单位编码 */
    @ApiModelProperty("接警单位编码")
    private String companyCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}