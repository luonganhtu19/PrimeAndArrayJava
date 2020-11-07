import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        String mess = "";
        while(true) {
            System.out.println("Menu: ");
            System.out.println("1. Check odd number");
            System.out.println("2. Check prime number");
            System.out.println("3. Display amount price");
            System.out.println("4. Input element array");
            System.out.println("0. Exit");

            System.out.println("Choice: ");
            mess = " choice menu ";
            int choice = checkInputNumber(mess);
            mess = "input number";
            switch (choice) {
                case 1:
                    inputOddNumber(mess);
                case 2:
                    mess = "input number";
                    System.out.println("Please input Number");
                    int number = checkInputNumber(mess);
                    boolean check = checkPrimeNumber(number);
                    if (check) System.out.println("number is prime");
                    else System.out.println("number no prime");
                case 3:
                    System.out.println("Please amount price want display");
                    mess = "input amount price";
                    int amountPrice = checkInputNumber(mess);
                    int count = 0;
                    int priceNumber = 2;
                    while (count < amountPrice) {
                        if (checkPrimeNumber(priceNumber)) {
                            System.out.print(priceNumber + " ");
                            count++;
                        }
                        priceNumber++;
                    }
                case 4:
                    workArray();
                case 0:
                    return;
                default:
                    System.out.println("Please choice value menu");
            }
        }
    }

    public static int checkInputNumber(String mess) {
        boolean check = true;
        int number = 0;
        Scanner inputNumber = new Scanner(System.in);
        while (check) {
            try {
                number = Integer.parseInt(inputNumber.nextLine());
                check = false;
            } catch (Exception ignore) {
                System.out.println("Please try again " + mess);
            }
        }
        return number;
    }

    public static void inputOddNumber(String mess) {
        do {
            System.out.println("Please Odd Number ");
            int oddNumber = checkInputNumber(mess);
            if (oddNumber > 0 && oddNumber % 2 == 1) {
                System.out.println("Input odd number " + oddNumber);
                break;
            } else {
                System.out.println("Please input odd number");
            }
            ;
        } while (true);
    }

    public static boolean checkPrimeNumber(int number) {
        boolean isPrime = true;
        if (number < 2) isPrime = false;
        if (number == 2 || number == 3) return isPrime;
        if (number % 2 == 0 || number % 3 == 0) isPrime = false;
        for (int i = 5; i * i < number; i = i + 6) {
            if (number % i == 0 || number % (i + 2) == 0) isPrime = false;
        }
        return isPrime;
    }

    public static void workArray() {
        Scanner input = new Scanner(System.in);
        String mess = "";
        int[] arrNumber;

        System.out.println("Create array");
        System.out.println("Size arrays ");
        mess = ": value input size of array is number ";
        int size = checkInputNumber(mess);
        arrNumber = new int[size];
        while (true) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Menu of working list with arrays: ");
            System.out.println("1. Add element ");
            System.out.println("2. Display array number");
            System.out.println("3. Display price in array number");
            System.out.println("4. Check number is exits in array");
            System.out.println("5. Delete element in arrays");
            System.out.println("6. Sort element ");
            System.out.println("7. Add and sort element");

            System.out.println("0. Exit");
            mess = " choice value in menu";

            int choice = checkInputNumber(mess);
            switch (choice) {
                case 0:
                    return;
                case 1:
                    addArray(size, arrNumber);
                    break;
                case 2:
                    displayArray(arrNumber);
                    break;
                case 3:
                    displayPriceOfArray(arrNumber);
                    break;
                case 4:
                    isExitElementArrays(arrNumber);
                    break;
                case 5:
                    deleteElement(arrNumber);
                    break;
                case 6:
                    sortElement(arrNumber);
                    break;
                case 7:
                    addSortElement(arrNumber);
                default:
                    System.out.println("Please choice menu");
            }
        }

    }

    public static void addArray(int size, int[] arrNumber) {
        String mess = " value element is number";
        for (int i = 0; i < size; i++) {
            System.out.print("The element in place " + (i + 1) + " of array ");
            arrNumber[i] = checkInputNumber(mess);
        }
        System.out.println("");
    }

    public static void displayArray(int[] arrNumber) {
        System.out.println("Array Number: ");
        for (int i = 0; i < arrNumber.length; i++) {
            System.out.print(arrNumber[i] + " ");
        }
        System.out.println("");
    }

    public static void displayPriceOfArray(int[] arrNumber) {
        System.out.println(" Price has array number: ");
        for (int i = 0; i < arrNumber.length; i++) {
            if (checkPrimeNumber(arrNumber[i])) {
                System.out.print(arrNumber[i] + " ");
            }
        }
        System.out.println("");
    }

    public static void isExitElementArrays(int[] arrNumber) {
        String mess = " value input is number ";
        boolean checkExits = true;

        System.out.println("Please input number find in array");
        int findNumber = checkInputNumber(mess);
        for (int i = 0; i < arrNumber.length; i++) {
            if (arrNumber[i] == findNumber) {
                System.out.println("Element has value " + findNumber + " is position:" + (i + 1));
                checkExits = false;
            }
        }
        if (checkExits) System.out.println("Element has value " + findNumber + " not exits arrays");
    }

    public static void deleteElement(int[] arrNumber) {
        while (true) {
            System.out.println("Menu delete element by :");
            System.out.println("1. Value of element");
            System.out.println("2. Index of element");
            System.out.println("0. Exit");
            System.out.print("Please choice: ");

            String mess = " choice menu";
            int choice = checkInputNumber(mess);

            switch (choice) {
                case 0:
                    return;
                case 1:
                    deleteElementValue(arrNumber);
                    break;
                case 2:
                    deleteElementIndex(arrNumber);
                    break;
                default:
                    System.out.println("Please choice menu");
            }
        }
    }

    public static void deleteElementValue(int[] arrNumber) {
        String mess = " value element to delete";
        System.out.println("Please input value of element delete");
        int valueElement = checkInputNumber(mess);
        boolean isExits = true;
        for (int i = 0; i < arrNumber.length; i++) {
            if (arrNumber[i] == valueElement) {
                for (int j = i; j < arrNumber.length - 1; j++) {
                    arrNumber[j] = arrNumber[j + 1];
                }
                arrNumber[arrNumber.length - 1] = 0;
                i--;
                isExits = false;
            }
        }
        if (isExits) {
            System.out.println("Value of element no exits in arrays");
        } else {
            System.out.println("Current, arrays: ");
            displayArray(arrNumber);
        }
    }

    public static void deleteElementIndex(int[] arrNumber) {
        String mess = " index of element need delete";
        System.out.println("Please index do you want delete element");
        int index = checkInputNumber(mess) - 1;
        if (index < 0 || index > arrNumber.length) {
            System.out.println("Please index less than length of Array and greater than 1 ");
            return;
        }
        for (int i = index; i < arrNumber.length - 1; i++) {
            arrNumber[i] = arrNumber[i + 1];
        }
        arrNumber[arrNumber.length - 1] = 0;
        System.out.println("Current, arrays: ");
        displayArray(arrNumber);
    }

    public static void sortElement(int[] arrNumber) {
        int temp = 0;
        for (int i = 0; i < arrNumber.length; i++) {
            for (int j = i + 1; j < arrNumber.length; j++) {
                if (arrNumber[i] > arrNumber[j]) {
                    temp = arrNumber[i];
                    arrNumber[i] = arrNumber[j];
                    arrNumber[j] = temp;
                }
            }
        }
        displayArray(arrNumber);
    }

    public static void addSortElement(int[] arrNumber) {
        String mess = "";
        System.out.println("Value element adding array");
        mess = " Input value element";
        int valueElement = checkInputNumber(mess);

        System.out.println("Position you add element (it less than " + arrNumber.length + " and greater than 1");
        mess = " The value must satisfy the condition";
        int indexElement = checkInputNumber(mess);

        arrNumber[indexElement-1] = valueElement;
        sortElement(arrNumber);
    }

}
