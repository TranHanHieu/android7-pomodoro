package io.realm;


public interface TaskRealmProxyInterface {
    public String realmGet$name();
    public void realmSet$name(String value);
    public String realmGet$color();
    public void realmSet$color(String value);
    public float realmGet$paymentPerHour();
    public void realmSet$paymentPerHour(float value);
    public boolean realmGet$isDone();
    public void realmSet$isDone(boolean value);
    public String realmGet$localId();
    public void realmSet$localId(String value);
}
