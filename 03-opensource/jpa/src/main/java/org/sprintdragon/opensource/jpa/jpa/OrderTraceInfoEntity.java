package org.sprintdragon.opensource.jpa.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by wangdi on 16-8-16.
 */
@Entity
@Table(name = "order_trace_info_mysql_bean")
public class OrderTraceInfoEntity {

    @Id
    private Long id;
    @Column(name = "order_id") private Long orderId;
    @Column(name = "vender_id") private Long venderId;
    @Column(name = "created")private Long created;
    @Column(name = "created_time")private String createdTime;
    @Column(name = "modified")private Long modified;
    @Column(name = "modified_time")private String modifiedTime;
    @Column(name = "type")private Integer type;//(广州1、卓志2，宁波3，杭州4)
    @Column(name = "status")private Integer status;// (-1失败,0执行中，1成功,5截停中)
    @Column(name = "msg")private String msg;
    @Column(name = "order_create_date")private Long orderCreateDate;
    @Column(name = "order_create_time")private String orderCreateTime;
    @Column(name = "storage_and_ship_status")private Integer storageAndShipStatus; //出库发货状态
    @Column(name = "storage_and_ship_msg")private String storageAndShipMsg; //出库发货信息
    @Column(name = "customs_id")private String customsId;   //海关
    @Column(name = "customs_model")private String customsModel;  //模式
    //支付单号
    @Column(name = "payment_no")private String paymentNo;
    // 支付平台类型名称(京东网银在线、财付通、其它)
    @Column(name = "pay_platform_type")private String payPlatformType;
    @Column(name = "pay_enum_no")private String payEnumNo;

    //订单分发到各支付平台状态
    @Column(name = "fen_fa_status")private Integer fenFaStatus;
    @Column(name = "fen_fa_remark")private String fenFaRemark;
    @Column(name = "process_status")private Integer processStatus;
    @Column(name = "process_status_msg")private String processStatusMsg;

    @Column(name = "clearance_time")private Long clearanceTime; //清关结果回调时间
    @Column(name = "vender_type")private String venderType;//自营 Or Pop
    @Column(name = "store_id")private Long storeId;   //库房id
    @Column(name = "merchant_id")private String merchantId;  //服务商id
    @Column(name = "pay_time")private String payTime;
    // 支付平台类型码(1:京东网银在线 2:财付通 3:其它)
    @Column(name = "pay_platform_type_code")private String payPlatformTypeCode;
    @Column(name = "error_code")private Integer errorCode;

    @Override
    public String toString() {
        return "OrderTraceInfoMysqlBean{" +
                "orderId=" + orderId +
                ", venderId=" + venderId +
                ", created=" + created +
                ", createdTime='" + createdTime + '\'' +
                ", modified=" + modified +
                ", modifiedTime='" + modifiedTime + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                ", orderCreateDate=" + orderCreateDate +
                ", orderCreateTime='" + orderCreateTime + '\'' +
                ", storageAndShipStatus=" + storageAndShipStatus +
                ", storageAndShipMsg='" + storageAndShipMsg + '\'' +
                ", customsId='" + customsId + '\'' +
                ", customsModel='" + customsModel + '\'' +
                ", paymentNo='" + paymentNo + '\'' +
                ", payPlatformType='" + payPlatformType + '\'' +
                ", payEnumNo='" + payEnumNo + '\'' +
                ", fenFaStatus=" + fenFaStatus +
                ", fenFaRemark='" + fenFaRemark + '\'' +
                ", processStatus=" + processStatus +
                ", processStatusMsg='" + processStatusMsg + '\'' +
                ", clearanceTime=" + clearanceTime +
                ", venderType='" + venderType + '\'' +
                ", storeId=" + storeId +
                ", merchantId='" + merchantId + '\'' +
                ", payTime='" + payTime + '\'' +
                ", payPlatformTypeCode='" + payPlatformTypeCode + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getVenderId() {
        return venderId;
    }

    public void setVenderId(Long venderId) {
        this.venderId = venderId;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public Long getModified() {
        return modified;
    }

    public void setModified(Long modified) {
        this.modified = modified;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(Long orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public String getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(String orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Integer getStorageAndShipStatus() {
        return storageAndShipStatus;
    }

    public void setStorageAndShipStatus(Integer storageAndShipStatus) {
        this.storageAndShipStatus = storageAndShipStatus;
    }

    public String getStorageAndShipMsg() {
        return storageAndShipMsg;
    }

    public void setStorageAndShipMsg(String storageAndShipMsg) {
        this.storageAndShipMsg = storageAndShipMsg;
    }

    public String getCustomsId() {
        return customsId;
    }

    public void setCustomsId(String customsId) {
        this.customsId = customsId;
    }

    public String getCustomsModel() {
        return customsModel;
    }

    public void setCustomsModel(String customsModel) {
        this.customsModel = customsModel;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getPayPlatformType() {
        return payPlatformType;
    }

    public void setPayPlatformType(String payPlatformType) {
        this.payPlatformType = payPlatformType;
    }

    public String getPayEnumNo() {
        return payEnumNo;
    }

    public void setPayEnumNo(String payEnumNo) {
        this.payEnumNo = payEnumNo;
    }

    public Integer getFenFaStatus() {
        return fenFaStatus;
    }

    public void setFenFaStatus(Integer fenFaStatus) {
        this.fenFaStatus = fenFaStatus;
    }

    public String getFenFaRemark() {
        return fenFaRemark;
    }

    public void setFenFaRemark(String fenFaRemark) {
        this.fenFaRemark = fenFaRemark;
    }

    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    public String getProcessStatusMsg() {
        return processStatusMsg;
    }

    public void setProcessStatusMsg(String processStatusMsg) {
        this.processStatusMsg = processStatusMsg;
    }

    public Long getClearanceTime() {
        return clearanceTime;
    }

    public void setClearanceTime(Long clearanceTime) {
        this.clearanceTime = clearanceTime;
    }

    public String getVenderType() {
        return venderType;
    }

    public void setVenderType(String venderType) {
        this.venderType = venderType;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPayPlatformTypeCode() {
        return payPlatformTypeCode;
    }

    public void setPayPlatformTypeCode(String payPlatformTypeCode) {
        this.payPlatformTypeCode = payPlatformTypeCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
