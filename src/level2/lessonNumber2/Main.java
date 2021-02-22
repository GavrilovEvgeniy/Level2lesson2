package level2.lessonNumber2;

public class Main {

static class MyArraySizeException extends Exception {
    MyArraySizeException(String message) {
        super(message);
    }
}

    static class MyArrayDataException extends Exception {
        MyArrayDataException(String message) {
            super(message);
        }
    }

static void throwException1(String[][] MyArray) throws MyArraySizeException {
    if ((MyArray.length != 4) | (MyArray[0].length != 4))
        throw new MyArraySizeException("Размер массива равен " + MyArray.length + "*" + MyArray[0].length + ", а должен быть 4*4 !");

}

static int throwException2(String[][] MyArray) throws MyArrayDataException {
        int Sum = 0;
        for (byte i = 0; i < MyArray.length; i++) {
            for (byte j = 0; j < MyArray[0].length; j++) {
                try {
                    int val = Integer.parseInt(MyArray[j][i]);
                    Sum += val;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке " + j + " " + i + " неверные данные.");
                }
            }
        }
        return Sum;

}

static void getSum(String[][] Array) {
    try {
        throwException1(Array);
        try {
            int Sigma = throwException2(Array);
            System.out.println("Сумма элементов массива = " + Sigma);
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    } catch (MyArraySizeException e) {
        System.out.println(e.getMessage());
    }
}

public static void main(String[] args) {
        String[][] Array1 = {{"57", "22", "13", "8"}, {"54", "9", "19", "49"}, {"33", "9", "87", "17"}, {"65", "39", "51", "30"}};
        getSum(Array1);
        String[][] Array2 = Array1;
        Array2[3][2] = "ff";
        getSum(Array2);
        String[][] Array3 = {{"57", "22", "13", "8"}, {"54", "9", "19", "49"}, {"33", "9", "87", "17"}};
        getSum(Array3);
    }
}
