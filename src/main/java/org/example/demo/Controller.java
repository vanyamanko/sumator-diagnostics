package org.example.demo;

public class Controller {
    ErrorUI errorUI = new ErrorUI();

    public void stringToIntData(String input) {
        if (input.length() == 5 && input.matches("[01]+")) {
            int a1 = Character.getNumericValue(input.charAt(0));
            int b1 = Character.getNumericValue(input.charAt(1));
            int pPrev = Character.getNumericValue(input.charAt(2));
            int a2 = Character.getNumericValue(input.charAt(3));
            int b2 = Character.getNumericValue(input.charAt(4));
            calculateOutPut(a1, b1, pPrev, a2, b2);
            System.out.println("a1: " + a1 + ", b1: " + b1 + ", pPrev: " + pPrev + ", a2: " + a2 + ", b2: " + b2);
        } else {
            errorUI.showErrorDialog("Incorrect input.");
        }
    }

    private void calculateOutPut(int point1, int point2, int point3, int point21, int point22) {
        int point4 = point1;
        int point5 = point2;
        int point6 = point3;
        int point7 = point4 ^ point5 ^ point6;


        int point8 = point1;
        int point9 = point2;
        int point10 = point3;

        int point11 = point9;
        int point12 = point8;
        int point17 = point11 & point12;

        int point13 = point8;
        int point14 = point10;
        int point15 = point9;
        int point16 = point10;
        int point18 = point13 & point14;
        int point19 = point15 & point16;
        int point20 = point17 | point18 | point19;

        int point23 = point21;
        int point24 = point22;
        int point25 = point20;
        int point26 = point23 ^ point24 ^ point25;

        int point27 = point21;
        int point28 = point22;
        int point29 = point20;

        int point30 = point28;
        int point31 = point27;
        int point36 = point30 & point31;
        int point32 = point27;
        int point33 = point29;
        int point37 = point32 ^ point33;

        int point34 = point28;
        int point35 = point29;
        int point38 = point35 ^ point34;

        int point39 = point36 ^ point37 ^ point38;
    }


    private Output calculateOutPutCorrectly(int a1, int b1, int pPrev, int a2, int b2) {
        int s1 = a1 ^ b1 ^ pPrev;

        int point17 = a1 & b1;
        int point18 = a1 & pPrev;
        int point19 = b1 & pPrev;
        int p = point17 | point18 | point19;

        int s2 = a2 ^ b2 ^ p;

        int point36 = b2 & a2;
        int point37 = a2 ^ p;
        int point38 = b2 ^ p;
        int p2 = point36 ^ point37 ^ point38;
        Output output = new Output();
        output.setS1(s1);
        output.setS2(s2);
        output.setP2(p2);

        return output;
    }

}
