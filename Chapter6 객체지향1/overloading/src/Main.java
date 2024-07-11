import java.util.*;

// Function 클래스는 함수의 이름, 매개변수 타입 목록, 반환 타입, 시리얼 넘버를 저장합니다.
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
    // 함수 이름을 키로 하고 해당 함수들의 리스트를 값으로 가지는 해시맵입니다.
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

            // 함수 이름에 해당하는 리스트가 없으면 새로 생성합니다.
            if (!functions.containsKey(name)) {
                functions.put(name, new ArrayList<>());
            }
            // 시리얼 넘버를 부여하고 함수를 리스트에 추가합니다.
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

    // 함수 호출을 처리하는 메서드입니다.
    private static String processFunctionCall(String call) {
        String[] parts = call.split(" ");
        String returnType = parts[0];
        String functionName = parts[2];
        int numParams = Integer.parseInt(parts[3]);

        List<String> paramTypes = new ArrayList<>();
        int idx = 4;
        for (int i = 0; i < numParams; i++) {
            if (Character.isUpperCase(parts[idx].charAt(0))) {
                paramTypes.add(parts[idx]);
                idx++;
            } else {
                // 중첩된 함수 호출을 처리합니다.
                StringBuilder nestedCall = new StringBuilder();
                nestedCall.append(parts[idx++]);
                while (idx < parts.length && (Character.isLowerCase(parts[idx].charAt(0)) || Character.isDigit(parts[idx].charAt(0)))) {
                    nestedCall.append(" ").append(parts[idx++]);
                }
                while (idx < parts.length && Character.isUpperCase(parts[idx].charAt(0))) {
                    nestedCall.append(" ").append(parts[idx++]);
                }
                String nestedResult = processFunctionCall(nestedCall.toString().trim());
                if (nestedResult.equals("impossible") || nestedResult.startsWith("ambiguous")) {
                    return nestedResult;
                }
                paramTypes.add(nestedResult.split(" ")[0]); // return type을 가져옵니다.
            }
        }

        // 후보 함수 목록을 찾습니다.
        List<Function> candidates = new ArrayList<>();
        if (functions.containsKey(functionName)) {
            for (Function function : functions.get(functionName)) {
                if (function.paramTypes.equals(paramTypes) && function.returnType.equals(returnType)) {
                    candidates.add(function);
                }
            }
        }

        // 후보 함수가 없으면 "impossible"을 반환합니다.
        if (candidates.isEmpty()) {
            return "impossible";
        } else if (candidates.size() == 1) {
            // 유일한 후보 함수가 있으면 시리얼 넘버를 붙여 반환합니다.
            return buildFunctionCallString(returnType, functionName, numParams, paramTypes, candidates.get(0).serialNumber);
        } else {
            // 후보 함수가 여러 개이면 "ambiguous"를 반환합니다.
            if (candidates.size() > 1000) {
                return "ambiguous > 1000";
            } else {
                return "ambiguous " + candidates.size();
            }
        }
    }

    // 함수 호출 문자열을 빌드하는 메서드입니다.
    private static String buildFunctionCallString(String returnType, String functionName, int numParams, List<String> paramTypes, int serialNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(returnType).append(" = ").append(functionName).append(serialNumber).append(" ").append(numParams).append(" ");
        for (String param : paramTypes) {
            sb.append(param).append(" ");
        }
        return sb.toString().trim();
    }
}
