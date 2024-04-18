import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PictureList {
    private Picture[] pictures;
    private int pictureCount;
    private String[] results;
    private int resultCount;
    private String[][] temporaryStuffInfo; // temp Stuff 정보를 저장하는 배열임

    public PictureList() {
        this.pictures = new Picture[10]; // int 사이즈를 10으로 설정함
        this.pictureCount = 0;
        this.results = new String[10]; // 결과를 save하기 위한 초기 사이즈 설정
        this.resultCount = 0;
        this.temporaryStuffInfo = new String[100][0]; // temp Stuff 정보 배열 초기화
    }

    public void saveResult(String result) {
        if (resultCount >= results.length) {
            results = Arrays.copyOf(results, results.length * 2);
        }
        results[resultCount++] = result;
    }

    public void print() {
        System.out.println("Picture List:");
        for (int i = 0; i < pictureCount; i++) {
            Picture picture = pictures[i];
            System.out.println("ID: " + picture.getId());
            System.out.println("Timestamp: " + picture.getTimestamp());
            System.out.println("Image File Name: " + picture.getImageFileName());
            System.out.println("Tags: " + picture.getTags());
            System.out.println("------TEST");
        }
    }

    public void printResults() {
        System.out.println("Results:");
        for (int i = 0; i < resultCount; i++) {
            System.out.println(results[i]);
        }
    }

    public PictureList(String infoFileName) {
        this();
        try (BufferedReader br = new BufferedReader(new FileReader(infoFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("//") && !line.trim().isEmpty()) {
                    Picture pic = parsePictureInfo(line);
                    if (pic != null) {
                        add(pic);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Unknown Picture Info File");
        }
    }

    private Picture parsePictureInfo(String line) {
        String[] infoFields = line.replace(" ", "").split(">");
        for (int i = 0; i < infoFields.length; i++) {
            infoFields[i] = infoFields[i].replaceFirst("<", "");
        }
        // 임시 Stuff 정보를 저장
        if (infoFields.length >= 4) {
            String[] stuffInfo = infoFields[3].trim().split(" ");
            temporaryStuffInfo[pictureCount] = stuffInfo; // 배열의 인덱스를 활용하여 정보 저장
        }
        return new Picture(infoFields);
    }

    public String[][] getTemporaryStuffInfo() {
        return temporaryStuffInfo;
    }

    public void add(Picture pic) {
        if (pictureCount >= pictures.length) {
            pictures = Arrays.copyOf(pictures, pictures.length * 2);
        }
        pictures[pictureCount++] = pic;
    }

    public Picture get(int i) {
        return pictures[i];
    }

    public int size() {
        return pictureCount;
    }

    public void sortByDate() {
        Arrays.sort(pictures, 0, pictureCount, (pic1, pic2) -> pic1.getTimestamp().compareTo(pic2.getTimestamp()));
    }
}
