package utils.VkApiUtils;

import static utils.Managers.DataManager.*;

public class VkApiRequestBuilder {
    private String request;

    public VkApiRequestBuilder createNewRequest(){
        request = getVkApiUrl();
        return this;
    }

    public VkApiRequestBuilder addMethod(String key){
        request += String.format("%s?", key);
        return this;
    }

    public VkApiRequestBuilder addParam(String key, String value){
        request += String.format("%s=%s&", key, value);
        return this;
    }

    public VkApiRequestBuilder addToken(String value){
        request += String.format("%s=%s&",getParamKeyAccessToken(), value);
        return this;
    }

    public VkApiRequestBuilder addVersion(String value){
        request += String.format("%s=%s", getParamKeyVersion(), value);
        return this;
    }

    public String toString(){
        return request;
    }
}
