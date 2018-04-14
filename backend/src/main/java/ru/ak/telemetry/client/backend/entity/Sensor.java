package ru.ak.telemetry.client.backend.entity;

/**
 * @author a.kakushin
 */
public class Sensor {

    private String name;

    private float lowValue;
    private float upperValue;
    private float topValue;
    private TypeValue lowType;
    private TypeValue upperType;

    /**
     * Конструктор по умолчанию
     */
    public Sensor() {
    }


    public Sensor(String name) {
        this.name = name;
    }

    public Sensor(String name, float lowValue, float upperValue) {
        this.name = name;
        this.lowValue = lowValue;
        this.upperValue = upperValue;
    }

    /**
     * Конструктор с указанием всех полей класса
     * @param name Имя датичка
     * @param lowValue Нижнее значение
     * @param upperValue Верхнее значение
     * @param lowType Тип нижнего значения
     * @param upperType Тип верхнего значения
     */
    public Sensor(String name, float lowValue, float upperValue, TypeValue lowType, TypeValue upperType) {
        this.name = name;
        this.lowValue = lowValue;
        this.upperValue = upperValue;
        this.lowType = lowType;
        this.upperType = upperType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLowValue() {
        return lowValue;
    }

    public void setLowValue(float lowValue) {
        this.lowValue = lowValue;
    }

    public float getUpperValue() {
        return upperValue;
    }

    public void setUpperValue(float upperValue) {
        this.upperValue = upperValue;
    }

    public TypeValue getLowType() {
        return lowType;
    }

    public void setLowType(TypeValue lowType) {
        this.lowType = lowType;
    }

    public TypeValue getUpperType() {
        return upperType;
    }

    public void setUpperType(TypeValue upperType) {
        this.upperType = upperType;
    }

    public float getTopValue() {
        return topValue;
    }

    public void setTopValue(float topValue) {
        this.topValue = topValue;
    }

    /**
     * Перечисление для указания типов нижнего и верхнего значений датчка
     */
    public enum TypeValue {
        HIGH, CRIT, MIN, MAX, EMERG, HYST;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

}
