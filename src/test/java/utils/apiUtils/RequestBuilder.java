package utils.apiUtils;

import static utils.managers.ConfigManager.*;
import static utils.managers.ConfigManager.ConfigKeys.*;
import static utils.managers.DataManager.*;

public class RequestBuilder {
    private String request;

    public RequestBuilder createNewRequest(){
        request = String.format(getApiUrl(getConfigValue(MACHINE_ADDRESS),getConfigValue(PORT)));
        return this;
    }

    public RequestBuilder addMethod(String method){
        request += String.format("%s?", method);
        return this;
    }

    public RequestBuilder addParam(String param, String value){
        request += String.format("%s=%s&", param, value);
        return this;
    }

    public String toString(){
        if (request.substring(request.length()-1).equals("&"))
            return request.substring(0, request.length()-1);
        return request;
    }
}
