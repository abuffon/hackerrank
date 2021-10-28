package hackerrank;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

class ResultFindRunningMedian {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	
    public static List<Double> runningMedian(List<Integer> a) {
    	List<Double> result = new ArrayList<Double>();
    	
    	a.forEach(n -> {
    		if (maxHeap.isEmpty()) {
    			maxHeap.add(n);
    		} else if (maxHeap.size() == minHeap.size()) {
    			if (n < minHeap.peek()) {
    				maxHeap.add(n);
    			} else {
    				maxHeap.add(minHeap.remove());
    				minHeap.add(n);
    			}
    		} else {
    			if (n < maxHeap.peek()) {
    				minHeap.add(maxHeap.remove());
    				maxHeap.add(n);
    			} else {
    				minHeap.add(n);
    			}
    		}

//    		System.out.println("maxHeap " + maxHeap);
//    		System.out.println("minHeap " + minHeap);
    		if (maxHeap.size() == minHeap.size()) {
//    			System.out.println("value " + (maxHeap.peek() + minHeap.peek()) / 2.0);
    			result.add((maxHeap.peek() + minHeap.peek()) / 2.0);
    		} else {
//    			System.out.println("value " + maxHeap.peek().doubleValue());
    			result.add(maxHeap.peek().doubleValue());
    		}
    	});
    	
    	return result;
    }
//    public static List<Double> runningMedian(List<Integer> a) {
//    	List<Double> result = new ArrayList<Double>();
//    	List<Integer> a2 = new ArrayList<Integer>();
//    	
//    	a.forEach(i -> {
//    		a2.add(i);
//    		List<Integer> collect = a2.stream().sorted().collect(Collectors.toList());
//    		if (collect.size()%2==0) {
//    			int index = (int)Math.floor(collect.size()/2.0);
//    			result.add((collect.get(index) + collect.get(index - 1)) / 2.0);
//    		} else {
//    			int index = (int)Math.floor(collect.size()/2.0);
//    			result.add(collect.get(index).doubleValue());
//    		}
//    	});
//    	
//    	return result;
//    }

}

public class SolutionFindRunningMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Double> result = ResultFindRunningMedian.runningMedian(a);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}