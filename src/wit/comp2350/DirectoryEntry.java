package wit.comp2350;

public class DirectoryEntry {
    private String fileName;
    private int fileSize;
    private long dateTime;

    DirectoryEntry(String fileName, int fileSize, long dateTime) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.dateTime = dateTime;
    }

    public String getFileName() {
        return fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public long getDateTime() {
        return dateTime;
    }
}
