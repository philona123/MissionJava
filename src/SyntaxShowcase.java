public class SyntaxShowcase {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    public static void main(String[] args) {
        int number = 10;
        double pi = 3.1415;
        char letter = 'A';
        boolean isJavaFun = true;
        String name = "Philona";

        String mood = isJavaFun ? "Excited" : "Boring";
        System.out.println("Current mood is " + mood);

        if(number > 0) {
            System.out.println("Number " + number + " is a positive number");
        } else {
            System.out.println("Number " + number + "is a negative number");
        }

        switch (letter) {
            case 'A':
                System.out.println("You got A grade");
                break;
            case 'B':
                System.out.println("You got B grade");
                break;
            default:
                System.out.println("You failed");
        }

        System.out.println("For loop");
        int[] numArr = {2,4,6,8,10};

        for(int i =0; i<numArr.length; i++) {
            System.out.println("The integer is: "+numArr[i]);
        }

        System.out.println("While loop");
        int countDown = 10;

        while(countDown > 0) {
            System.out.println("Rocket launch in " + countDown);
            countDown--;
        }

        int attempt = 0;
        do {
            int val = attempt+1;
            System.out.println("The attempt is: "+ val);
            attempt++;
        } while (attempt<1);

        int scores[] = {90,98,100,40};
        for(int score:scores) {
            System.out.println("The score is "+score);
        }

        int testNum = 4;

        System.out.println("Is the number "+testNum+" Even? Answer: " + isEven(testNum));

        String greeting = "Hello "+name;
        System.out.println(greeting);
    }
}
