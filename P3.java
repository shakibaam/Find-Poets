import java.io.*;
import java.util.*;

public class P3 {
    double lambda1 = 0.05;
    double lambda2 = 0.9;
    double lambda3 = 0.05;
    double epsilon = 0.0001;
    int allmesra_hafez = 0;
    int allmesra_molavi = 0;
    int allmesra_ferdowsi = 0;



    public void makeDictionary_Hafez() {

        HashMap<String, Integer> temp = new HashMap<>();
        Scanner sc2 = null;
        try {
            sc2 = new Scanner(new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\hafez_train.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String s = s2.next();
                if (temp.containsKey(s)) {
                    int count = temp.get(s);
                    count++;
                    temp.put(s, count);
                } else {
                    temp.put(s, 1);
                }
//                System.out.println(s);
            }
        }


        Iterator iterator = temp.entrySet().iterator();
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\hafez_dictionary.txt", true);

            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator.next();
                int x = 1;
                if (!pair.getValue().equals(x)) {

                    String str = pair.getKey() + ":" + pair.getValue();
                    writer.write(String.valueOf(str));
                    writer.write("\r\n");   // write new line

                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void makeDictionary_molavi() {

        HashMap<String, Integer> temp = new HashMap<>();
        Scanner sc2 = null;
        try {
            sc2 = new Scanner(new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\molavi_train.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String s = s2.next();
                if (temp.containsKey(s)) {
                    int count = temp.get(s);
                    count++;
                    temp.put(s, count);
                } else {
                    temp.put(s, 1);
                }
//                System.out.println(s);
            }
        }


        Iterator iterator = temp.entrySet().iterator();
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\molavi_dictionary.txt", true);

            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator.next();
                int x = 1;
                if (!pair.getValue().equals(x)) {

                    String str = pair.getKey() + "=" + pair.getValue();
                    writer.write(String.valueOf(str));
                    writer.write("\r\n");   // write new line

                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void makeDictionary_ferdowsi() {

        HashMap<String, Integer> temp = new HashMap<>();
        Scanner sc2 = null;
        try {
            sc2 = new Scanner(new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\ferdowsi_train.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String s = s2.next();
                if (temp.containsKey(s)) {
                    int count = temp.get(s);
                    count++;
                    temp.put(s, count);
                } else {
                    temp.put(s, 1);
                }
//                System.out.println(s);
            }
        }


        Iterator iterator = temp.entrySet().iterator();
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\ferdowsi_dictionary.txt", true);

            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator.next();
                int x = 1;
                if (!pair.getValue().equals(x)) {

                    String str = pair.getKey() + ":" + pair.getValue();
                    writer.write(String.valueOf(str));
                    writer.write("\r\n");   // write new line

                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void HafezUnigram() {
        int allWord = 0;
        File file2 = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\hafez_train.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String mesra;
            while ((mesra = br.readLine()) != null) {
                // process the line.

                String[] splited = mesra.split("\\s+");
                for (int i = 0; i < splited.length; i++) {
                    allWord++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\hafez_unigram.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\hafez_dictionary.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splited = line.split(":");

                String word = splited[0];
                double count = Double.parseDouble(splited[1]);
                double prediction = (double) count / allWord;
                String str = word + ":" + prediction;
                writer.write(str);
                writer.write("\r\n");


            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void MolaviUnigram() {
        int allWord = 0;
        File file2 = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\molavi_train.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String mesra;
            while ((mesra = br.readLine()) != null) {
                // process the line.

                String[] splited = mesra.split("\\s+");
                for (int i = 0; i < splited.length; i++) {
                    allWord++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\molavi_unigram.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\molavi_dictionary.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splited = line.split("=");

                String word = splited[0];
//                System.out.println(splited[1]);
                double count = Double.parseDouble(splited[1]);
                double prediction = (double) count / allWord;
                String str = word + ":" + prediction;
                writer.write(str);
                writer.write("\r\n");


            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void FerdowsiUnigram() {
        int allWord = 0;
        File file2 = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\ferdowsi_train.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String mesra;
            while ((mesra = br.readLine()) != null) {
                // process the line.

                String[] splited = mesra.split("\\s+");
                for (int i = 0; i < splited.length; i++) {
                    allWord++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\ferdowsi_unigram.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\ferdowsi_dictionary.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splited = line.split(":");

                String word = splited[0];
                double count = Double.parseDouble(splited[1]);
                double prediction = (double) count / allWord;
                String str = word + ":" + prediction;
                writer.write(str);
                writer.write("\r\n");


            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void hafezBigram() {
        HashMap<String, Integer> hafezTrainCouples = new HashMap<>();
        HashMap<String, Integer> count_each_train_word_hafez = new HashMap<>();
        int allMesra = 0;
        FileWriter writer = null;
        try {
            writer = new FileWriter("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\hafez_bigram.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int y = 0;
        File file2 = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\hafez_train.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String mesra;
            while ((mesra = br.readLine()) != null) {
                // process the line.
                allMesra++;

                String[] splited = mesra.split("\\s+");

//                String start = splited[0] + "*";
//                String stop = splited[splited.length - 1] + "#";
//                if (!hafezTrainCouples.containsKey(start)) {
//                    hafezTrainCouples.put(start, 1);
//                }
//                if (hafezTrainCouples.containsKey(start)) {
//                    hafezTrainCouples.put(start, hafezTrainCouples.get(start) + 1);
//                }
//
//                if (!hafezTrainCouples.containsKey(stop)) {
//                    hafezTrainCouples.put(stop, 1);
//                }
//                if (hafezTrainCouples.containsKey(stop)) {
//                    hafezTrainCouples.put(stop, hafezTrainCouples.get(stop) + 1);
//                }
                int i = 0;
                boolean flag = true;


                while (flag) {
                    y++;
                    String couple = splited[i] + ";" + splited[i + 1];


                    if (hafezTrainCouples.containsKey(couple)) {
                        int x = hafezTrainCouples.get(couple);
                        hafezTrainCouples.put(couple, x + 1);
                    } else {
                        hafezTrainCouples.put(couple, 1);
                    }
                    if (i + 1 == splited.length - 1) {
                        flag = false;
                    } else {
                        i++;
                    }
                }


                for (int k = 0; k < splited.length; k++) {

                    if (count_each_train_word_hafez.containsKey(splited[k])) {
                        int x = count_each_train_word_hafez.get(splited[k]);
                        count_each_train_word_hafez.put(splited[k], x + 1);
                    } else {
                        count_each_train_word_hafez.put(splited[k], 1);
                    }
                }


            }
            allmesra_hafez = allMesra;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Iterator iterator = hafezTrainCouples.entrySet().iterator();
        int count = 0;


        while (iterator.hasNext()) {
            count++;
            Map.Entry pair = (Map.Entry) iterator.next();

            String couple = (String) pair.getKey();
            System.out.println(couple);
            int count_couple = (int) pair.getValue();
            String[] splited = couple.split(";");
            int count_first = count_each_train_word_hafez.get(splited[0]);
            double prediction = (double) count_couple / count_first;
            String str = couple + ":" + prediction;
            System.out.println(str);

            try {
                writer.write(str);
                writer.write("\r\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void molaviBigram() {
        HashMap<String, Integer> molaviTrainCouples = new HashMap<>();
        HashMap<String, Integer> count_each_train_word_molavi = new HashMap<>();
        int allMesra = 0;
        FileWriter writer = null;
        try {
            writer = new FileWriter("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\molavi_bigram.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int y = 0;
        File file2 = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\molavi_train.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String mesra;
            while ((mesra = br.readLine()) != null) {
                // process the line.
                allMesra++;

                String[] splited = mesra.split("\\s+");

//                String start = splited[0] + "*";
//                String stop = splited[splited.length - 1] + "#";
//                if (!hafezTrainCouples.containsKey(start)) {
//                    hafezTrainCouples.put(start, 1);
//                }
//                if (hafezTrainCouples.containsKey(start)) {
//                    hafezTrainCouples.put(start, hafezTrainCouples.get(start) + 1);
//                }
//
//                if (!hafezTrainCouples.containsKey(stop)) {
//                    hafezTrainCouples.put(stop, 1);
//                }
//                if (hafezTrainCouples.containsKey(stop)) {
//                    hafezTrainCouples.put(stop, hafezTrainCouples.get(stop) + 1);
//                }
                int i = 0;
                boolean flag = true;


                while (flag) {
                    y++;
                    String couple = splited[i] + ";" + splited[i + 1];


                    if (molaviTrainCouples.containsKey(couple)) {
                        int x = molaviTrainCouples.get(couple);
                        molaviTrainCouples.put(couple, x + 1);
                    } else {
                        molaviTrainCouples.put(couple, 1);
                    }
                    if (i + 1 == splited.length - 1) {
                        flag = false;
                    } else {
                        i++;
                    }
                }


                for (int k = 0; k < splited.length; k++) {

                    if (count_each_train_word_molavi.containsKey(splited[k])) {
                        int x = count_each_train_word_molavi.get(splited[k]);
                        count_each_train_word_molavi.put(splited[k], x + 1);
                    } else {
                        count_each_train_word_molavi.put(splited[k], 1);
                    }
                }


            }
            allmesra_molavi = allMesra;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Iterator iterator = molaviTrainCouples.entrySet().iterator();
        int count = 0;


        while (iterator.hasNext()) {
            count++;
            Map.Entry pair = (Map.Entry) iterator.next();

            String couple = (String) pair.getKey();

            int count_couple = (int) pair.getValue();
            String[] splited = couple.split(";");
            int count_first = count_each_train_word_molavi.get(splited[0]);
            double prediction = (double) count_couple / count_first;
            String str = couple + "=" + prediction;
//            System.out.println(str);

            try {
                writer.write(str);
                writer.write("\r\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void ferdowsiBigram() {
        HashMap<String, Integer> ferdowsiTrainCouples = new HashMap<>();
        HashMap<String, Integer> count_each_train_word_ferdowsi = new HashMap<>();
        int allMesra = 0;
        FileWriter writer = null;
        try {
            writer = new FileWriter("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\ferdowsi_bigram.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int y = 0;
        File file2 = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\ferdowsi_train.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String mesra;
            while ((mesra = br.readLine()) != null) {
                // process the line.
                allMesra++;

                String[] splited = mesra.split("\\s+");

//                String start = splited[0] + "*";
//                String stop = splited[splited.length - 1] + "#";
//                if (!hafezTrainCouples.containsKey(start)) {
//                    hafezTrainCouples.put(start, 1);
//                }
//                if (hafezTrainCouples.containsKey(start)) {
//                    hafezTrainCouples.put(start, hafezTrainCouples.get(start) + 1);
//                }
//
//                if (!hafezTrainCouples.containsKey(stop)) {
//                    hafezTrainCouples.put(stop, 1);
//                }
//                if (hafezTrainCouples.containsKey(stop)) {
//                    hafezTrainCouples.put(stop, hafezTrainCouples.get(stop) + 1);
//                }
                int i = 0;
                boolean flag = true;


                while (flag) {
                    y++;
                    String couple = splited[i] + ";" + splited[i + 1];


                    if (ferdowsiTrainCouples.containsKey(couple)) {
                        int x = ferdowsiTrainCouples.get(couple);
                        ferdowsiTrainCouples.put(couple, x + 1);
                    } else {
                        ferdowsiTrainCouples.put(couple, 1);
                    }
                    if (i + 1 == splited.length - 1) {
                        flag = false;
                    } else {
                        i++;
                    }
                }


                for (int k = 0; k < splited.length; k++) {

                    if (count_each_train_word_ferdowsi.containsKey(splited[k])) {
                        int x = count_each_train_word_ferdowsi.get(splited[k]);
                        count_each_train_word_ferdowsi.put(splited[k], x + 1);
                    } else {
                        count_each_train_word_ferdowsi.put(splited[k], 1);
                    }
                }


            }
            allmesra_ferdowsi = allMesra;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Iterator iterator = ferdowsiTrainCouples.entrySet().iterator();
        int count = 0;


        while (iterator.hasNext()) {
            count++;
            Map.Entry pair = (Map.Entry) iterator.next();

            String couple = (String) pair.getKey();

            int count_couple = (int) pair.getValue();
            String[] splited = couple.split(";");
            int count_first = count_each_train_word_ferdowsi.get(splited[0]);
            double prediction = (double) count_couple / count_first;
            String str = couple + ":" + prediction;
//            System.out.println(str);

            try {
                writer.write(str);
                writer.write("\r\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public double backOff( double bigram,String str, String poet) {
        double backOff = 0;
        boolean contain = false;
        switch (poet) {
            case "hafez":
                String ci_hafez = str;
//                File f1 = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\hafez_unigram.txt"); //Creation of File Descriptor for input file


                File file_hafez = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\hafez_unigram.txt");
                try (BufferedReader br = new BufferedReader(new FileReader(file_hafez))) {
                    String line;
                    while ((line = br.readLine()) != null) {
//                        System.out.println(line);
                        String[] splited = line.split(":");
                        if (splited[0].equals(ci_hafez)) {
                            contain = true;
                            double pCi = Double.parseDouble(splited[1]);
                            backOff = (pCi * lambda2) + (lambda1 * epsilon);

                        }
                    }
                    if (contain == false) {
                        backOff = (lambda1 * epsilon);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                backOff=backOff+(lambda3*bigram);
                break;
            case "molavi":
                String ci_molavi = str;
//                File f1 = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\hafez_unigram.txt"); //Creation of File Descriptor for input file


                File file_molavi = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\molavi_unigram.txt");
                try (BufferedReader br = new BufferedReader(new FileReader(file_molavi))) {
                    String line;
                    while ((line = br.readLine()) != null) {
//                        System.out.println(line);
                        String[] splited = line.split(":");
                        if (splited[0].equals(ci_molavi)) {
                            contain = true;
                            double pCi = Double.parseDouble(splited[1]);
                            backOff = (pCi * lambda2) + (lambda1 * epsilon);

                        }
                    }
                    if (contain == false) {
                        backOff = (lambda1 * epsilon);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                backOff=backOff+(lambda3*bigram);
                break;

            case "ferdowsi":
                String ci_ferdowsi = str;
//                File f1 = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\hafez_unigram.txt"); //Creation of File Descriptor for input file


                File file_ferdowsi = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\ferdowsi_unigram.txt");
                try (BufferedReader br = new BufferedReader(new FileReader(file_ferdowsi))) {
                    String line;
                    while ((line = br.readLine()) != null) {
//                        System.out.println(line);
                        String[] splited = line.split(":");
                        if (splited[0].equals(ci_ferdowsi)) {
                            contain = true;
                            double pCi = Double.parseDouble(splited[1]);
                            backOff = (pCi * lambda2) + (lambda1 * epsilon);

                        }
                    }
                    if (contain == false) {
                        backOff = (lambda1 * epsilon);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                backOff=backOff+(lambda3*bigram);
                break;


        }


        return backOff;
    }

    public double calculatePrediction_hafez(String str) {

        String[] splited = str.split("\\s+");
        int i = 0;
        boolean flag = true;
        ArrayList<String> bigram = new ArrayList<>();
        ArrayList<Double> predictions = new ArrayList<>();


        while (flag) {

            String couple = splited[i] + ";" + splited[i + 1];
            bigram.add(couple);
            if (i + 1 == splited.length - 1) {
                flag = false;
            } else {
                i++;
            }

        }
        for (int j = 0; j < bigram.size(); j++) {
            String temp = bigram.get(j);

            boolean find = false;
            double bigram_prediction=0;

            File file = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\hafez_bigram.txt");
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // process the line.
                    String[] splited2 = line.split(":");
                    String couple2 = splited2[0];
                    if (couple2.equals(temp)) {


                        bigram_prediction = Double.parseDouble(splited2[1]);

//                        predictions.add(predicteon);
//                        find = true;
                    }


                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

//            if (find == false) {
                String[] words = temp.split(";");
                double backoff = backOff(bigram_prediction,words[1], "hafez");

                predictions.add(backoff);
//            }

        }




        double mul=1;
        for (int j = 0; j <predictions.size() ; j++) {

            mul*=predictions.get(j);
        }


        return mul;


    }
//
public double calculatePrediction_molavi(String str) {

    String[] splited = str.split("\\s+");
    int i = 0;
    boolean flag = true;
    ArrayList<String> bigram = new ArrayList<>();
    ArrayList<Double> predictions = new ArrayList<>();


    while (flag) {

        String couple = splited[i] + ";" + splited[i + 1];
        bigram.add(couple);
        if (i + 1 == splited.length - 1) {
            flag = false;
        } else {
            i++;
        }

    }
    for (int j = 0; j < bigram.size(); j++) {
        String temp = bigram.get(j);

        boolean find = false;
        double bigram_prediction=0;

        File file = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\molavi_bigram.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                String[] splited2 = line.split(":");
                String couple2 = splited2[0];
                if (couple2.equals(temp)) {


                    bigram_prediction = Double.parseDouble(splited2[1]);

//                        predictions.add(predicteon);
//                        find = true;
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//            if (find == false) {
        String[] words = temp.split(";");
        double backoff = backOff(bigram_prediction,words[1], "molavi");

        predictions.add(backoff);
//            }

    }




    double mul=1;
    for (int j = 0; j <predictions.size() ; j++) {

        mul*=predictions.get(j);
    }


    return mul;


}
    public double calculatePrediction_ferdowsi(String str) {

        String[] splited = str.split("\\s+");
        int i = 0;
        boolean flag = true;
        ArrayList<String> bigram = new ArrayList<>();
        ArrayList<Double> predictions = new ArrayList<>();


        while (flag) {

            String couple = splited[i] + ";" + splited[i + 1];
            bigram.add(couple);
            if (i + 1 == splited.length - 1) {
                flag = false;
            } else {
                i++;
            }

        }
        for (int j = 0; j < bigram.size(); j++) {
            String temp = bigram.get(j);

            boolean find = false;
            double bigram_prediction=0;

            File file = new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\ferdowsi_bigram.txt");
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // process the line.
                    String[] splited2 = line.split(":");
                    String couple2 = splited2[0];
                    if (couple2.equals(temp)) {


                        bigram_prediction = Double.parseDouble(splited2[1]);

//                        predictions.add(predicteon);
//                        find = true;
                    }


                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

//            if (find == false) {
            String[] words = temp.split(";");
            double backoff = backOff(bigram_prediction,words[1], "ferdowsi");

            predictions.add(backoff);
//            }

        }




        double mul=1;
        for (int j = 0; j <predictions.size() ; j++) {

            mul*=predictions.get(j);
        }


        return mul;


    }

    public void TestPhase(){

        int find_true=0;
        int all=0;
        File file=new File("C:\\Users\\Asus\\workspace\\AI-p3\\src\\Files\\test_file.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {

                // process the line.
                String[] splited= line.split("\t");
                double hafez_prediction=calculatePrediction_hafez(splited[1]);
                double molavi_prediction=calculatePrediction_molavi(splited[1]);
                double ferdowsi_prediction=calculatePrediction_ferdowsi(splited[1]);
                double max=Math.max(Math.max(hafez_prediction,molavi_prediction),ferdowsi_prediction);
                System.out.println(splited[1]);

                int index= Integer.parseInt(splited[0]);
                if (max==hafez_prediction){
                    System.out.println("poet is hafez");
                    if (index==2){
                        find_true++;
                        System.out.println("you find true");
                    }
                    else {
                        System.out.println("you make mistake");
                    }
                }

                if (max==molavi_prediction){
                    System.out.println("poet is molavi");
                    if (index==3){
                        find_true++;
                        System.out.println("you find true");
                    }
                    else {
                        System.out.println("you make mistake");
                    }
                }

                if (max==ferdowsi_prediction){
                    System.out.println("poet is ferdowsi");
                    if (index==1){
                        find_true++;
                        System.out.println("you find true");
                    }
                    else {
                        System.out.println("you make mistake");
                    }
                }

                System.out.println("--------------");
                all++;



            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        double precision=(double) find_true/all;
        System.out.println(precision*100);
    }




    public static void main(String[] args) {
        P3 p3 = new P3();
//        p3.ferdowsiBigram();
//        p3.molaviBigram();
//        p3.FerdowsiUnigram();
//        p3.MolaviUnigram();
//        p3.makeDictionary_ferdowsi();
//        p3.makeDictionary_molavi();
//        p3.hafezBigram();
//        p3.makeDictionary_Hafez();
//        p3.HafezUnigram();
//        p3.calculatePrediction_hafez("این قصه عجب شنو از بخت واژگون");
//          p3.calculatePrediction_molavi("ز انکه تقوی آب سوی نار برد");
//        p3.calculatePrediction_ferdowsi("همی خواند بر شهریار آفرین");
        p3.TestPhase();

    }
}
