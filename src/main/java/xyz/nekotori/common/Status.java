package xyz.nekotori.common;

public enum Status {
    NORMAL(200,"OK"),
    ERROR(100,"ERROR")
    ;

    private final Integer code;
    private final String name;

    private Status(Integer code,String name){
        this.code = code;
        this.name =name;
    }

    public static Status of(String name){
        for(Status status:Status.values()){
            if(status.name.equals(name)){
                return status;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return String.valueOf(code);
    }
}
