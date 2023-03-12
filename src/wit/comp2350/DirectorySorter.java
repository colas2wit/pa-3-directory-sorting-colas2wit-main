package wit.comp2350;

public class DirectorySorter {

    public static void sortByFileName(DirectoryEntry[] entries) {
        // DONE: Implement
        radixSort(entries);

    }

    private static void radixSort(DirectoryEntry[] entries) {
        int slength = 2147483647;
        int a = 0;
        while (a < entries.length) {
            if (slength > entries[a].getFileName().length()) {
                slength = entries[a].getFileName().length();
            }
            a++;
        }
        for (int c = slength - 1; c >= 0; c--) {
            for (int j = 0; j <= entries.length - 1; j++) {
                DirectoryEntry key = entries[j];
                int i = j - 1;
                while (i >= 0 && (int) (entries[i].getFileName().charAt(c)) > (int) (key.getFileName().charAt(c))) {
                    entries[i + 1] = entries[i];
                    i = i - 1;
                    entries[i + 1] = key;

                }
            }

        }
    }

    public static void sortByFileSize(DirectoryEntry[] entries)
        {
        // DONE: Implement
            mergeSort(entries, 0, entries.length, false);



        }

    public static void sortByDateTime(DirectoryEntry[] entries) {
        // DONE: Implement
       mergeSort(entries,0, entries.length, true);
    }


    private static void mergeSort(DirectoryEntry[] A, int p, int r, boolean t) {


        if (p < r) {
            int q = ((p + r) / 2);

            mergeSort(A, p, q,t);
            mergeSort(A, q + 1, r, t);
            Merge(A, p, q, r,t);
        }


    }

    /*

    @param A array that is being sorted
    @param p starting position of the array
    @parma r Length of the array that is being sorted
    @param t tells us if we're sorting the array by date or file size
     */
    private static void Merge(DirectoryEntry[] A, int p, int q, int r, boolean t) {
        int n1 = q - p + 1;

        int n2 = r - q;


        DirectoryEntry[] L = new DirectoryEntry[n1 + 1];

        DirectoryEntry [] R = new DirectoryEntry[n2 + 1];

        for (int i = 0; i < n1; i++) {

            L[i] = A[p + i];

        }

        for (int j = 1; j < n2; j++) {

            R[j] = A[q + j ];


        }
        L[n1] = new DirectoryEntry("temp_value", Integer.MAX_VALUE, Integer.MAX_VALUE );
        R[n2] = new DirectoryEntry("temp_value", Integer.MAX_VALUE, Integer.MAX_VALUE );

        int i = 0;

        int j = 1;
        if(t) {
            for (int k = p; k < r; k++) {

                if (L[i].getDateTime() <= R[j].getDateTime()) {
                    A[k] = L[i];
                    i++;
                } else {
                    A[k] = R[j];
                    j++;
                }
            }
        }
        if (!t )
            {
                for (int k = p; k < r; k++) {

                    if (L[i].getFileSize() <= R[j].getFileSize())
                        {
                            A[k] = L[i];
                            i++;
                        }
                    else
                        {
                            A[k] = R[j];
                            j++;
                        }
            }

        }


    }

}
