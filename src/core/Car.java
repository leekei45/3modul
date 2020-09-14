package core;

public class Car {
    public String number;
    public int height; // Переменная типа int - целые числа
    public double weight;  //    Переменная типа double - дробные числа
    public boolean isSpecial;  //    Переменная типа boolean  - верное или не верное значение
    public boolean hasVehicle; //    Переменная типа boolean  - верное или не верное значение

    public String toString() {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
    public void setNumber (String number){
        this.number = number;
    }
    public String getNumber (){
        return number;
    }
    public void setHeight (int height){
        this.height = height;
    }
    public int getHeight (){
        return height;
    }
    public void setWeight (double weight){
        this.weight = weight;
    }
    public double getWeight (){
        return weight;
    }
    public void setIsSpecial (boolean isSpecial){
        this.isSpecial = isSpecial;
    }
    public boolean getIsSpecial(boolean b){
        return isSpecial;
    }
    public void setHasVehicle (boolean hasVehicle){
        this.hasVehicle = hasVehicle;
    }
    public boolean getHasVehicle(boolean b){
        return hasVehicle;
    }
}