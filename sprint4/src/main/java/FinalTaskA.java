import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FinalTaskA {

    private static final int LIMIT = 5;

    public static class InputData {
        public String[] documents;
        public String[] requests;

        public InputData(String[] documents, String[] requests) {
            this.documents = documents;
            this.requests = requests;
        }
    }

    public static void main(String[] args) throws IOException {
        InputData input = read();

        Map<String, Map<Integer, Integer>> documents = convertDocuments(input.documents);

        List<Set<String>> requests = convertRequests(input.requests);

        List<List<Integer>> results = new ArrayList<>();

        for (Set<String> request: requests) {

            List<Integer> requestRelevance = new ArrayList<>(input.documents.length);
            for (int i = 0; i < input.documents.length; i++)
                requestRelevance.add(0);


            for (String word : request) {

                Map<Integer, Integer> relevance = documents.get(word);
                if (relevance != null) {
                    for (int docNumber : relevance.keySet()) {
                        int documentRelevance = requestRelevance.get(docNumber);

                        requestRelevance.set(docNumber, documentRelevance + relevance.get(docNumber));
                    }
                }
            }

            results.add(getMaxByValueIndexes(requestRelevance, LIMIT));
        }

        write(results);
    }

    private static Map<String, Map<Integer, Integer>> convertDocuments(String[] rawDocuments) {

        Map<String, Map<Integer, Integer>> documents = new HashMap<>();

        for (int docNumber = 0; docNumber < rawDocuments.length; docNumber++) {

            for (String word : rawDocuments[docNumber].split(" ")) {

                if(!documents.containsKey(word)) {

                    Map<Integer, Integer> relevance = new HashMap<>();
                    relevance.put(docNumber, 1);
                    documents.put(word, relevance);

                } else {
                    Map<Integer, Integer> relevance = documents.get(word);
                    if (!relevance.containsKey(docNumber)) {
                        relevance.put(docNumber, 1);
                    } else {
                        Integer frequency = relevance.get(docNumber);
                        relevance.put(docNumber, frequency + 1);
                    }
                }
            }
        }

        return documents;
    }

    private static List<Set<String>> convertRequests(String[] rawRequests) {

        List<Set<String>> requests = new ArrayList<>(rawRequests.length);

        for(String request : rawRequests) {
            Set<String> uniqWords = new HashSet<>();
            for(String word : request.split(" ")) {
                uniqWords.add(word);
            }
            requests.add(uniqWords);
        }

        return requests;
    }

    private static List<Integer> getMaxByValueIndexes(List<Integer> list, int limit) {

        List<Integer> result = new ArrayList<>();
        int length = Math.min(limit, list.size());

        for (int i = 0; i < length; i++) {

            int maxIndex = 0;
            int maxValue = 0;

            for (int j = 0; j < list.size(); j++) {
                if(maxValue < list.get(j)) {
                    maxValue = list.get(j);
                    maxIndex = j;
                }
            }

            if(maxValue == 0)
                break;

            list.set(maxIndex, 0);
            result.add(maxIndex);
        }

        return result;
    }

    private static InputData read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] documents  = new String[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < documents.length; i++) {
            documents[i] = reader.readLine();
        }
        String[] requests  = new String[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < requests.length; i++) {
            requests[i] = reader.readLine();
        }
        return new InputData(documents, requests);
    }

    private static void write(List<List<Integer>> relevanceByRequest) {
        StringBuilder out = new StringBuilder();

        for(List<Integer> relevance : relevanceByRequest) {
            for (int i : relevance)
                out.append(i+1).append(" ");
            out.append(System.lineSeparator());
        }
        System.out.println(out);
    }

}
