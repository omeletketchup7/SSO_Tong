package sso.test.tong.model;

public class Res {
    private String responseCode;
    private String responseMessage;
    private ResData responseData;


    public Res(){
    }

    public Res(String responseCode,String responseMessage,ResData responseData){
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseData = responseData;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ResData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResData responseData) {
        this.responseData = responseData;
    }
}
