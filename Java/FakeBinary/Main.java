package FakeBinary;

public class Main {

    public static void main(String[] args){
        System.out.println(fakeBin("55141452104"));
    }

    public static String fakeBin(String numberString) {
        String finalString = "";
        for (int i = 0; i < numberString.length(); i++){
            if (numberString.charAt(i) >= '5'){
                finalString += "1";
            }
            else {
                finalString += "0";
            }
        }
        return finalString;
    }

}
