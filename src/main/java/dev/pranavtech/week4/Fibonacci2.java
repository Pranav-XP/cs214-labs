package dev.pranavtech.week4;

import com.mathworks.engine.MatlabEngine;

import java.util.ArrayList;

public class Fibonacci2 {

    public static void main(String[] args) {
        runFib();
    }

    static void runFib(){
        int[] expN = new int[50];

        for (int i = 0; i < expN.length; i++) {
            expN[i] = i + 1;
        }

        ArrayList<Long> operationsRecursive = new ArrayList<>();
        ArrayList<Long> operationsIterative = new ArrayList<>();

        for(int i=0;i<expN.length;i++){
            long[] operationCounter = new long[1]; // Array to hold operation count

            fibRec(expN[i], operationCounter);
            operationsRecursive.add(operationCounter[0]);

            operationCounter[0] = 0; // Reset counter
            fibIter(expN[i], operationCounter);
            operationsIterative.add(operationCounter[0]);

            System.out.println(i+" [Rn="+expN[i]+" Recursive Ops:"+operationsRecursive.get(i)
                    +" Iterative Ops:"+operationsIterative.get(i)+"]");
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
        for (int i = 0; i < operationsRecursive.size(); i++) {
            yRecursiveBuilder.append(operationsRecursive.get(i));
            if (i < operationsRecursive.size() - 1) {
                yRecursiveBuilder.append(" ");
            }
        }
        yRecursiveBuilder.append("]");

        // Building the yIterative string
        yIterativeBuilder.append("yIterative=[");
        for (int i = 0; i < operationsIterative.size(); i++) {
            yIterativeBuilder.append(operationsIterative.get(i));
            if (i < operationsIterative.size() - 1) {
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
            eng.eval("ylabel('Number of Operations');");
            eng.eval("title('Recursive vs Iterative Operation Count Analysis');");
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

    public static long fibRec(long n, long[] operationCounter){
        operationCounter[0]++; // Count the operation
        if(n<=1){
            return n;
        }else {
            return fibRec(n-1, operationCounter) + fibRec(n-2, operationCounter);
        }
    }

    public static long fibIter(long n, long[] operationCounter){
        if(n<=1){
            operationCounter[0]++; // Count the operation
            return n;
        }
        long fib =  1;
        long prevFib = 1;

        for(int i = 2; i < n; i++){
            operationCounter[0]++; // Count the operation
            long temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }
}
