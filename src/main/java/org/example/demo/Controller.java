package org.example.demo;

import java.util.Set;

public class Controller {
    org.example.demo.ui.ErrorUI errorUI = new org.example.demo.ui.ErrorUI();

    public boolean stringToIntData(String input, Set<String> set) {
        if (input.length() == 5 && input.matches("[01]+")) {
            int a1 = Character.getNumericValue(input.charAt(0));
            int b1 = Character.getNumericValue(input.charAt(1));
            int pPrev = Character.getNumericValue(input.charAt(2));
            int a2 = Character.getNumericValue(input.charAt(3));
            int b2 = Character.getNumericValue(input.charAt(4));
            calculateOutPut(a1, b1, pPrev, a2, b2, set);
        } else {
            errorUI.showErrorDialog("Incorrect input.");
            return false;
        }
        return true;
    }

    private void calculateOutPut(int a1, int b1, int pPrev, int a2, int b2, Set<String> set) {

        for (int i = 1; i <= 39; i++) {
            for (int j = 0; j <= 1; j++) {
                int point1 = (i == 1) ? j : a1;
                int point2 = (i == 2) ? j : b1;
                int point3 = (i == 3) ? j : pPrev;
                int point21 = (i == 21) ? j : a2;
                int point22 = (i == 22) ? j : b2;

                int point4 = (i == 4) ? j : point1;
                int point5 = (i == 5) ? j : point2;
                int point6 = (i == 6) ? j : point3;
                int point7 = (i == 7) ? j : (point4 ^ point5 ^ point6);

                int point8 = (i == 8) ? j : point1;
                int point9 = (i == 9) ? j : point2;
                int point10 = (i == 10) ? j : point3;

                int point11 = (i == 11) ? j : point9;
                int point12 = (i == 12) ? j : point8;
                int point17 = (i == 17) ? j : (point11 & point12);

                int point13 = (i == 13) ? j : point8;
                int point14 = (i == 14) ? j : point10;
                int point15 = (i == 15) ? j : point9;
                int point16 = (i == 16) ? j : point10;
                int point18 = (i == 18) ? j : (point13 & point14);
                int point19 = (i == 19) ? j : (point15 & point16);
                int point20 = (i == 20) ? j : (point17 | point18 | point19);

                int point23 = (i == 23) ? j : point21;
                int point24 = (i == 24) ? j : point22;
                int point25 = (i == 25) ? j : point20;
                int point26 = (i == 26) ? j : (point23 ^ point24 ^ point25);

                int point27 = (i == 27) ? j : point21;
                int point28 = (i == 28) ? j : point22;
                int point29 = (i == 29) ? j : point20;

                int point30 = (i == 30) ? j : point28;
                int point31 = (i == 31) ? j : point27;
                int point36 = (i == 36) ? j : (point30 & point31);
                int point32 = (i == 32) ? j : point27;
                int point33 = (i == 33) ? j : point29;
                int point37 = (i == 37) ? j : (point32 ^ point33);

                int point34 = (i == 34) ? j : point28;
                int point35 = (i == 35) ? j : point29;
                int point38 = (i == 38) ? j : (point35 ^ point34);

                int point39 = (i == 39) ? j : (point36 ^ point37 ^ point38);

                Output output = new Output();
                Output outputCorrectly = calculateOutPutCorrectly(a1, b1, pPrev, a2, b2);

                output.setS1(point7);
                output.setS2(point26);
                output.setP2(point39);

                if (!output.equals(outputCorrectly)) {
                    set.add(String.format("%d(%d)", i, j));
                }
            }
        }
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
