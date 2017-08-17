package exam.nowcoderHuaWei;

import java.util.*;

/**
 * Created by ly on 2017/8/16.
 */
public class RecordError {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> fileName = new ArrayList<>();
        ArrayList<Integer> rowNumber = new ArrayList<>();
        ArrayList<Integer> num = new ArrayList<>();
        String path;
        int row;
        while (scanner.hasNext()) {
            /*String total = scanner.nextLine();
            String[] tt = total.split(" ");
            String path = tt[0];
            int row = Integer.parseInt(tt[1]);*/
            path = scanner.next();
            row = scanner.nextInt();
//            scanner.nextLine();

            String[] str = path.split("\\\\");
            String name = str[str.length-1];
            boolean isExists = false;
            for (int i = 0; i < fileName.size(); i++) {
                if(fileName.get(i).equals(name)) {
                    if(rowNumber.get(i) == row) {
                        num.set(i, num.get(i)+1);
                        isExists = true;
                        break;
                    }
                }
            }
            if(!isExists) {
                fileName.add(name);
                rowNumber.add(row);
                num.add(1);
            }
        }
        scanner.close();

        ArrayList<ResultError> result = new ArrayList<>();
        for (int i = 0; i < fileName.size(); i++) {
            int len = fileName.get(i).length();
            String s = fileName.get(i);
            if(len > 16) {
                s = s.substring(len-16);
            }
            ResultError resultError = new ResultError(s, rowNumber.get(i), num.get(i));
            result.add(resultError);
        }

        Collections.sort(result, new Comparator<ResultError>() {
            @Override
            public int compare(ResultError o1, ResultError o2) {
                return o2.num - o1.num;
            }
        });

        for (int i = 0; i < 8; i++) {
            ResultError error = result.get(i);
            error.print();
        }
    }
}

class ResultError{
    String name;
    int row;
    int num;

    public ResultError(String name, int row, int num) {
        this.name = name;
        this.num = num;
        this.row = row;
    }

    public void print() {
        System.out.println(name + " " + row + " " + num);
    }
}
