import java.util.*;

class Function {
    String name;
    List<String> paramTypes;
    String returnType;
    int serialNumber;

    Function(String name, List<String> paramTypes, String returnType, int serialNumber) {
        this.name = name;
        this.paramTypes = paramTypes;
        this.returnType = returnType;
        this.serialNumber = serialNumber;
    }
}

public class Main {
    static Map<String, List<Function>> functions = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 함수 선언을 읽습니다.
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equals("#")) break; // '#'를 만나면 함수 선언 읽기를 종료합니다.

            String[] parts = line.split(" ");
            String name = parts[0];
            int numParams = Integer.parseInt(parts[1]);
            List<String> paramTypes = new ArrayList<>();
            for (int i = 0; i < numParams; i++) {
                paramTypes.add(parts[2 + i]);
            }
            String returnType = parts[2 + numParams];

            if (!functions.containsKey(name)) {
                functions.put(name, new ArrayList<>());
            }
            int serialNumber = functions.get(name).size() + 1;
            functions.get(name).add(new Function(name, paramTypes, returnType, serialNumber));
        }

        // 함수 호출을 읽습니다.
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equals("#")) break; // '#'를 만나면 함수 호출 읽기를 종료합니다.

            // 각 함수 호출을 처리합니다.
            String result = processFunctionCall(line);
            System.out.println(result);
        }
        scanner.close();
    }

    private static String processFunctionCall(String call) {
        String[] parts = call.split(" ");
        String returnType = parts[0];
        String equalsSign = parts[1];
        String functionName = parts[2];
        int numParams = Integer.parseInt(parts[3]);

        List<String> paramTypes = new ArrayList<>();
        int idx = 4;
        for (int i = 0; i < numParams; i++) {
            if (Character.isUpperCase(parts[idx].charAt(0))) {
                paramTypes.add(parts[idx]);
            } else {
                StringBuilder nestedCall = new StringBuilder();
                int nestedCallEnd = findNestedCallEnd(parts, idx);
                for (int j = idx; j <= nestedCallEnd; j++) {
                    nestedCall.append(parts[j]).append(" ");
                }
                idx = nestedCallEnd + 1;
                String nestedResult = processFunctionCall(nestedCall.toString().trim());
                if (nestedResult.equals("impossible") || nestedResult.startsWith("ambiguous")) {
                    return nestedResult;
                }
                paramTypes.add(nestedResult.split(" ")[0]);
            }
            idx++;
        }

        List<Function> candidates = new ArrayList<>();
        if (functions.containsKey(functionName)) {
            for (Function function : functions.get(functionName)) {
                if (function.paramTypes.equals(paramTypes) && function.returnType.equals(returnType)) {
                    candidates.add(function);
                }
            }
        }

        if (candidates.isEmpty()) {
            return "impossible";
        } else if (candidates.size() == 1) {
            return returnType + " = " + buildFunctionCallString(functionName, numParams, paramTypes) + candidates.get(0).serialNumber;
        } else {
            if (candidates.size() > 1000) {
                return "ambiguous > 1000";
            } else {
                return "ambiguous " + candidates.size();
            }
        }
    }

    private static int findNestedCallEnd(String[] parts, int startIdx) {
        int balance = 1;
        int idx = startIdx + 1;
        while (balance > 0 && idx < parts.length) {
            if (Character.isUpperCase(parts[idx].charAt(0))) {
                balance--;
            } else {
                balance++;
            }
            idx++;
        }
        return balance == 0 ? idx - 1 : -1;
    }

    private static String buildFunctionCallString(String functionName, int numParams, List<String> paramTypes) {
        StringBuilder sb = new StringBuilder();
        sb.append(functionName).append(" ").append(numParams).append(" ");
        for (String param : paramTypes) {
            sb.append(param).append(" ");
        }
        return sb.toString().trim() + " ";
    }
}
