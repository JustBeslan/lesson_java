package com.company.task1;

import org.jetbrains.annotations.NotNull;

public class WorkVectors {
    @NotNull
    private static Vector_ operationVectors(Vector_ vector_1, Vector_ vector_2, char operation){
        Vector_ resVector = new Vector_();
        if (operation == '+') {
            resVector.setX(vector_1.getX() + vector_2.getX());
            resVector.setY(vector_1.getY() + vector_2.getY());
            resVector.setZ(vector_1.getZ() + vector_2.getZ());
        }
        if (operation == '-') {
            resVector.setX(vector_1.getX() - vector_2.getX());
            resVector.setY(vector_1.getY() - vector_2.getY());
            resVector.setZ(vector_1.getZ() - vector_2.getZ());
        }
        return (resVector);
    }
    private static double multiVectors(@NotNull Vector_ vector_1, @NotNull Vector_ vector_2){
        return (vector_1.getX()*vector_2.getX() +
                vector_1.getY()*vector_2.getY() +
                vector_1.getZ()*vector_2.getZ());
    }
    public static void main(String[] args) {
        Vector_ vector_1 = new Vector_();
        Vector_ vector_2 = new Vector_();
        vector_1.setX(17); vector_1.setY(-5); vector_1.setZ(34);
        vector_2.setX(-47); vector_2.setY(-5); vector_2.setZ(3);
//        vector_1.setX(17); vector_1.setY(0); vector_1.setZ(0);
//        vector_2.setX(0); vector_2.setY(0); vector_2.setZ(3);

        Vector_ sumVectors = operationVectors(vector_1,vector_2,'+');
        System.out.println("Сумма векторов : ( " +
                sumVectors.getX() + ", " +
                sumVectors.getY() + ", " +
                sumVectors.getZ() + " )");

        Vector_ subVectors = operationVectors(vector_1,vector_2,'-');
        System.out.println("Разность векторов : ( " +
                subVectors.getX() + ", " +
                subVectors.getY() + ", " +
                subVectors.getZ() + " )");

        double scalMultyVectors = multiVectors(vector_1,vector_2);
        System.out.println("Скалярное произведение векторов : " + scalMultyVectors);

        System.out.println("Косинус угла между векторами в радианах : " +
                scalMultyVectors/(vector_1.lengthVector() * vector_2.lengthVector()));

        System.out.println("Угол между векторами в градусах : " +
                Math.acos(scalMultyVectors/(vector_1.lengthVector() * vector_2.lengthVector()))*(180/Math.PI));
    }
}
