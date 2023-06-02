package com.example.demo.ui.uiModelResponse;

public enum ErrorMessages {
    
    MISSING_REQUIRED_FIELD("Missing required field"),
    RECORD_ALREADY_EXISTS("Record already exists");

    private String errorMessage;

    ErrorMessages(String errorMessage){
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage(){
        return errorMessage;
    }

    /**
     * @param errorMessage the errormessage to set
     */
    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

}
