package singletonDesign.com.sglp;

public enum EnumSingleton {
    INSTANCE;
    public void someMethod(String param) {
    	System.out.println(param + "EnumSingleton instance created");
    }
}