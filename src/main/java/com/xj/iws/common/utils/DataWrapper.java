package com.xj.iws.common.utils;


import com.xj.iws.common.enums.CallStatusEnum;
import com.xj.iws.common.enums.ErrorCodeEnum;

public class DataWrapper<T>  {
    private CallStatusEnum callStatus;
    private ErrorCodeEnum errorCode;
    private String errorLabel;
    private T data;
    private String token;

    // 用于分页结果
    private int numberPerPage;
    private int currentPage;
    private int totalNumber;
    private int totalPage;

    public DataWrapper() {
        setCallStatus(CallStatusEnum.SUCCEED);
        setErrorCode(ErrorCodeEnum.No_Error);
    }

    public CallStatusEnum getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(CallStatusEnum callStatus) {
        this.callStatus = callStatus;
    }

    public ErrorCodeEnum getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCodeEnum errorCode) {
        this.errorCode = errorCode;
        if (!errorCode.equals(ErrorCodeEnum.No_Error)) {
            this.callStatus = CallStatusEnum.FAILED;
        }
        this.errorLabel = errorCode.getLabel();
    }

    public String getErrorLabel() {
        return errorLabel;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getNumberPerPage() {
        return numberPerPage;
    }

    public void setNumberPerPage(int numberPerPage) {
        this.numberPerPage = numberPerPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setPage(Page page, int totalNumber){
        this.totalNumber = totalNumber;
        this.currentPage = page.getCurrentPage();
        this.numberPerPage = page.getNumberPerPage();
        if(numberPerPage != 0){
            this.totalPage = (int)Math.ceil((double) totalNumber/(double) numberPerPage);
        }else {
            this.totalPage = 1;
        }
    }

    @Override
    public String toString() {
        return	"Code:" + this.callStatus + "\n" +
                "Error Code:" + this.errorCode+ "\n" +
                "Page :" + this.currentPage + "\n" +
                "Total Page :" + this.totalPage + "\n" +
                "Num per Page:" + this.numberPerPage + "\n" +
                "Total Num:" + this.totalNumber + "\n" ;
    }
}
