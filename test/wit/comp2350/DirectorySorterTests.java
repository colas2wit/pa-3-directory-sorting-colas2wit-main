package wit.comp2350;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DirectorySorterTests {

    private DirectoryEntry[] generateEntries() {
        DirectoryEntry[] entries = {
                new DirectoryEntry("file1", 8192, 20221231045722L),
                new DirectoryEntry("AnOtHaFiLe", 10000, 20190533123100L),
                new DirectoryEntry("oldF1l3", 2, 19710710001267L)
        };
        return entries;
    }

    @Test
    public void testFileNameSort() {
        DirectoryEntry[] entries = generateEntries();
        DirectorySorter.sortByFileName(entries);

        // Extract just the fileNames
        String[] directorySorterArray = new String[entries.length];
        String[] systemSorterArray = new String[entries.length];
        for (int i = 0; i < entries.length; i++) {
            String fileName = entries[i].getFileName();
            directorySorterArray[i] = fileName;
            systemSorterArray[i] = fileName;
        }

        // Compare to system sort
        Arrays.sort(systemSorterArray);
        Assert.assertArrayEquals(systemSorterArray, directorySorterArray);
    }

    @Test
    public void testFileSizeSort() {
        DirectoryEntry[] entries = generateEntries();
        DirectorySorter.sortByFileSize(entries);

        // Extract just the fileSizes
        int[] directorySorterArray = new int[entries.length];
        int[] systemSorterArray = new int[entries.length];
        for (int i = 0; i < entries.length; i++) {
            int fileSize = entries[i].getFileSize();
            directorySorterArray[i] = fileSize;
            systemSorterArray[i] = fileSize;
        }

        // Compare to system sort
        Arrays.sort(systemSorterArray);
        Assert.assertArrayEquals(systemSorterArray, directorySorterArray);
    }

    @Test
    public void testDateTimeSort() {
        DirectoryEntry[] entries = generateEntries();
        DirectorySorter.sortByDateTime(entries);

        // Extract just the dateTimes
        long[] directorySorterArray = new long[entries.length];
        long[] systemSorterArray = new long[entries.length];
        for (int i = 0; i < entries.length; i++) {
            long dateTime = entries[i].getDateTime();
            directorySorterArray[i] = dateTime;
            systemSorterArray[i] = dateTime;
        }

        // Compare to system sort
        Arrays.sort(systemSorterArray);
        Assert.assertArrayEquals(systemSorterArray, directorySorterArray);
    }

}
