package com.example.demo.entity.bo.stage;



import com.example.demo.pojo.bo.BaseBO;
import com.example.demo.pojo.bo.po.ConverterPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AlarmBO extends BaseBO implements ConverterPO {
    /** 警情编号 */
    @ApiModelProperty("警情编号")
    private String code;

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
    private java.util.Date time;

    /** 报警地址 */
    @ApiModelProperty("报警地址")
    private String address;

    /** 警情录入时间 */
    @ApiModelProperty("警情录入时间")
    private java.util.Date insertTime;

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

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setTime(java.util.Date time) {
        this.time = time;
    }

    public java.util.Date getTime() {
        return this.time;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setInsertTime(java.util.Date insertTime) {
        this.insertTime = insertTime;
    }

    public java.util.Date getInsertTime() {
        return this.insertTime;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return this.state;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getWay() {
        return this.way;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return this.company;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public Integer getTypeCode() {
        return this.typeCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return this.companyCode;
    }
}