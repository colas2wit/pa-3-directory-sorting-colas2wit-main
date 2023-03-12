package wit.comp2350;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String inputFile = "input.txt";
        String sortedByFileName = "sort-by-file-name.txt";
        String sortedByFileSize = "sort-by-file-size.txt";
        String sortedByDateTime = "sort-by-date-time.txt";

        try {
            // Timers
            long startTime;
            long endTime;

            // Directory entries
            ArrayList<DirectoryEntry> entries = new ArrayList<>();

            // Create reader
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            // Read lines from file
            String line = reader.readLine();
            while (line != null) {
                // Parse
                String[] tokens = line.split(" ");
                String fileName = tokens[0];
                int fileSize = Integer.parseInt(tokens[1]);
                long dateTime = Long.parseLong(tokens[2]);

                // Create directory entry
                DirectoryEntry entry = new DirectoryEntry(fileName, fileSize, dateTime);

                // Add to list of entries
                entries.add(entry);

                // Read next line
                line = reader.readLine();
            }
            reader.close();

            // Copy the entries into arrays for each sorting field
            DirectoryEntry[] arrayFileName = entries.toArray(new DirectoryEntry[entries.size()]);
            DirectoryEntry[] arrayFileSize = entries.toArray(new DirectoryEntry[entries.size()]);
            DirectoryEntry[] arrayDateTime = entries.toArray(new DirectoryEntry[entries.size()]);

            // Sort by file name
            startTime = System.nanoTime();
            DirectorySorter.sortByFileName(arrayFileName);
            endTime = System.nanoTime();
            long durationFileName = (endTime - startTime);
            writeArrayToFile(arrayFileName, sortedByFileName);

            // Sort by file size
            startTime = System.nanoTime();
            DirectorySorter.sortByFileSize(arrayFileSize);
            endTime = System.nanoTime();
            long durationFileSize = (endTime - startTime);
            writeArrayToFile(arrayFileSize, sortedByFileSize);

            // Sort by date time
            startTime = System.nanoTime();
            DirectorySorter.sortByDateTime(arrayDateTime);
            endTime = System.nanoTime();
            long durationDateTime = (endTime - startTime);
            writeArrayToFile(arrayDateTime, sortedByDateTime);

            // Report timing results
            String results = "Sorting Results:\n"
                    + "  File Name Sort = " + (double)durationFileName/1e6 + " ms = " + (double)durationFileName/1e9 + " s\n"
                    + "  File Size Sort = " + (double)durationFileSize/1e6 + " ms = " + (double)durationFileSize/1e9 + " s\n"
                    + "  Date Time Sort = " + (double)durationDateTime/1e6 + " ms = " + (double)durationDateTime/1e9 + " s\n";
            System.out.println(results);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Writes array of directory entries to file
     * @param entries    Array of directory entries
     * @param outputFile Name of output file
     * @throws IOException
     */
    private static void writeArrayToFile(DirectoryEntry[] entries, String outputFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        for (int i = 0; i < entries.length; i++) {
            DirectoryEntry e = entries[i];
            String line = e.getFileName() + " "
                    + e.getFileSize() + " "
                    + e.getDateTime();
            if (i != entries.length - 1) {
                line += "\n";
            }
            writer.write(line);
        }
        writer.close();
    }
}
