import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Picture {
    private String id;
    private LocalDateTime timestamp;
    private String imageFileName;
    private String[] stuff;
    private String[] tags;
    private String comment;

    public Picture(String[] infoFields) {
        if (infoFields.length < 2) {
            System.out.println("No time stamp in the input : " + "<  > " + infoFields[2] + " < " + infoFields[3] + " > " + infoFields[4] + " < " + infoFields[5] + " > " + infoFields[6]);
            return;
        }

        this.id = infoFields[0].trim();//사진 ID
        try {
            this.timestamp = LocalDateTime.parse(infoFields[1].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss:SSS")); //타임스템프
        } catch (DateTimeParseException e) {
            System.out.println("Wrong DateTime Format : " + infoFields[1]);
            return;
        }

        if (infoFields.length >= 3) {
            String[] imageInfo = infoFields[2].trim().split(";");
            this.imageFileName = imageInfo.length > 1 ? imageInfo[1].trim() : "";
        }
        if (infoFields.length >= 4) {
            String[] stuffInfo = infoFields[3].trim().split(";");
            this.stuff = new String[stuffInfo.length];
            for (int i = 0; i < stuffInfo.length; i++) {
                this.stuff[i] = stuffInfo[i].trim();
                /*g
                for (String s: stuff) {
            		System.out.println("DEBUG: "+ s);
            	} //debug only */
            }
            
            StuffList.add(new Stuff(this.stuff));
        }
        if (infoFields.length >= 5) {
            String[] tagInfo = infoFields[4].trim().split(" ");
            this.tags = new String[tagInfo.length];
            for (int i = 0; i < tagInfo.length; i++) {
                this.tags[i] = tagInfo[i].trim();
            }
        }
        if (infoFields.length >= 6) {
            this.comment = infoFields[5].trim();
        }
    }

    public void appendStuff(String[] newStuff) {
        if (stuff == null) {
            stuff = newStuff;
        } else {
            // 기존의 stuff 배열과 새로운 newStuff 배열을 합친 새로운 배열 생성
            String[] combinedStuff = new String[stuff.length + newStuff.length];
            System.arraycopy(stuff, 0, combinedStuff, 0, stuff.length);
            System.arraycopy(newStuff, 0, combinedStuff, stuff.length, newStuff.length);
            stuff = combinedStuff;
        }
    }

    public void print() {
        System.out.print("< " + id + " > ");
        System.out.print(timestamp != null ? "< " + timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss:SSS")) + " > " : "<  > ");
        System.out.print("< " + (imageFileName != null ? imageFileName : "") + " > ");
        System.out.print("< " + formatArray(stuff) + " > ");
        System.out.print("< " + formatArray(tags) + " > ");
        System.out.println("< " + (comment != null ? comment : "") + " >");
    }

    private String formatArray(String[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public String getTimestamp() {
        if (timestamp != null) {
            return timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss:SSS"));
        } else {
            return null;
        }
    }

    public String getId() {
        return id;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public String[] getTags() {
        return tags;
    }

    public String getComment() {
        return comment;
    }

    public String[] getStuff() {
        return stuff;
    }
}
