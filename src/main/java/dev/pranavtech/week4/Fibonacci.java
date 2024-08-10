package dev.pranavtech.week4;

import com.mathworks.engine.MatlabEngine;

import java.util.ArrayList;

public class Fibonacci {

    public static void main(String[] args) {
        runFib();
    }

    static void runFib(){
        long startTime,endTime, timeDifference;
        int[] expN = new int[50];

        for (int i = 0; i < expN.length; i++) {
            expN[i] = i + 1;
        }
        long answer;
        ArrayList<Long> resultsRecursive = new ArrayList<>();
        ArrayList<Long> resultsIterative = new ArrayList<>();

        for(int i=0;i<expN.length;i++){
            startTime = System.nanoTime();
            answer = fibRec(expN[i]);
            endTime = System.nanoTime();
            timeDifference = endTime - startTime;
            resultsRecursive.add(timeDifference);

            System.out.println(i+" [Rn="+expN[i]+":"+answer+" Time:"+timeDifference+"ns]");

            startTime = System.nanoTime();
            answer = fibIter(expN[i]);
            endTime = System.nanoTime();
            timeDifference = endTime - startTime;
            resultsIterative.add(timeDifference);

            System.out.println(i+" [Rn="+expN[i]+":"+answer+" Time:"+timeDifference+"ns]");
        }

        // StringBuilder for each output string
        StringBuilder xBuilder = new StringBuilder();
        StringBuilder yRecursiveBuilder = new StringBuilder();
        StringBuilder yIterativeBuilder = new StringBuilder();

        // Building the x string
        xBuilder.append("x=[");
        for (int i = 0; i < expN.length; i++) {
            xBuilder.append(expN[i]);
            if (i < expN.length - 1) {
                xBuilder.append(" ");
            }
        }
        xBuilder.append("]");

        // Building the yRecursive string
        yRecursiveBuilder.append("yRecursive=[");
        for (int i = 0; i < resultsRecursive.size(); i++) {
            yRecursiveBuilder.append(resultsRecursive.get(i));
            if (i < resultsRecursive.size() - 1) {
                yRecursiveBuilder.append(" ");
            }
        }
        yRecursiveBuilder.append("]");

        // Building the yIterative string
        yIterativeBuilder.append("yIterative=[");
        for (int i = 0; i < resultsIterative.size(); i++) {
            yIterativeBuilder.append(resultsIterative.get(i));
            if (i < resultsIterative.size() - 1) {
                yIterativeBuilder.append(" ");
            }
        }
        yIterativeBuilder.append("]");

        // Convert StringBuilder objects to strings
        String xString = xBuilder.toString();
        String yRecursiveString = yRecursiveBuilder.toString();
        String yIterativeString = yIterativeBuilder.toString();

        // Print to console (Optional)
        System.out.println(xString);
        System.out.println(yRecursiveString);
        System.out.println(yIterativeString);

        try {
            // Start MATLAB engine
            MatlabEngine eng = MatlabEngine.startMatlab();

            // Define the data arrays

            // Send the data to MATLAB
            eng.eval(xString);
            eng.eval(yRecursiveString);
            eng.eval(yIterativeString);

            // Create the line plot
            eng.eval("figure;");
            eng.eval("plot(x, yRecursive, '-r', 'LineWidth', 2);");
            eng.eval("hold on;");
            eng.eval("plot(x, yIterative, '-b', 'LineWidth', 2);");
            eng.eval("hold off;");

            // Set labels and title
            eng.eval("xlabel('Input Size');");
            eng.eval("ylabel('Execution Time');");
            eng.eval("title('Recursive vs Iterative Time Analysis');");
            eng.eval("legend('Recursive', 'Iterative');");

            // Show the plot
            eng.eval("grid on;");

            // Keep MATLAB session open
            eng.eval("pause;");

            // Close MATLAB engine
            eng.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long fibRec(long n){
        if(n<=1){
            return n;
        }else {
            return fibRec(n-1) + fibRec(n-2);
        }
    }

    public static long fibIter(long n){
        if(n<=1){
            return n;
        }
        long fib =  1;
        long prevFib = 1;

        for(int i = 2; i < n; i++){
            long temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }

}
