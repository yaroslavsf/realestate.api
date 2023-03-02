package ch.noseryoung.realestate.core.exception.errors;

public enum ErrorCode {
    ERROR_00000("ERROR_00000", "errormessage.general.unexpected.error"),
    ERROR_10000("ERROR_10000", "errormessage.your.mom.is.fat"),
    ;
    private final String errorCode;
    private final String localizationKey;
    ErrorCode(String errorCode, String localizationKey) {
        this.errorCode = errorCode;
        this.localizationKey = localizationKey;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getLocalizationKey() {
        return localizationKey;
    }
}
